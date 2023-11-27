package com.sanmiguel.minimarket.controlador;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sanmiguel.minimarket.modelo.Producto;
import com.sanmiguel.minimarket.modelo.TipoProducto;
import com.sanmiguel.minimarket.modelo.TipoUsuario;
import com.sanmiguel.minimarket.modelo.Usuario;
import com.sanmiguel.minimarket.repositorio.UsuarioRepositorio;
import com.sanmiguel.minimarket.service.TipoUsuarioService;
import com.sanmiguel.minimarket.service.UsuarioService;

import jakarta.servlet.http.HttpServletRequest;

@Controller
@SessionAttributes({ "user", "carrito", "countCarrito" })
public class UsuarioControlador {

	@Autowired
	UsuarioService us;

	@Autowired
	UsuarioRepositorio ur;

	@Autowired
	TipoUsuarioService tus;

	@GetMapping("/ingreso")
	public String getLogin() {
		return "login";
	}

	@PostMapping("/login")
	public String login(@RequestParam("txtUser") String usuario, @RequestParam("txtPassword") String clave,
			Model model) {
		Usuario u = ur.validarUsuario(usuario, clave);

		if (u != null) {
			model.addAttribute("user", u);
			model.addAttribute("message", "Credenciales válidas");
			return "redirect:/";
		} else {
			model.addAttribute("message", "Credenciales inválidas");
			return "login";
		}
	}

	@GetMapping("/logout")
	public String logout(HttpServletRequest request, Model model) {
		model.asMap().remove("user");
		request.getSession().invalidate();

		return "redirect:/";
	}

	@GetMapping("/gestion-usuarios")
	public String listarUsuarios(@RequestParam(name="pagina",defaultValue = "1") int pagina,Model model) {
		PageRequest pr = PageRequest.of(pagina-1, 3);
		Page<Usuario> pc = ur.findAll(pr);
		List<Usuario> usuarios = pc.getContent();
		int totalPaginas = pc.getTotalPages();
		List<Integer> paginas = new ArrayList<Integer>();
		for (int i=1;i<=totalPaginas;i++)
			paginas.add(i);
		
		List<TipoUsuario> tiposUsuario = tus.listarTipoUsuarios();
		model.addAttribute("tiposUsuario", tiposUsuario);
		
		model.addAttribute("usuarios", usuarios);
		model.addAttribute("nuevoUsuario", new Usuario());
		
		

		
		
		model.addAttribute("paginas", paginas);
		return "gestionUsuarios";
	}

	@PostMapping("/gestion-usuarios/guardar")
	public String guardarUsuario(@ModelAttribute Usuario nuevoUsuario, Model model,
			RedirectAttributes redirectAttributes) {
		try {
			us.guardarUsuario(nuevoUsuario);
			redirectAttributes.addFlashAttribute("mensaje", "Guardado con éxito");
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("mensaje", "Error al guardar: " + e.getMessage());
		}
		return "redirect:/gestion-usuarios";
	}

	@GetMapping("/gestion-usuarios/editar/{cod_usuario}")
	public String editarUsuario(@PathVariable Integer cod_usuario, Model model) {
		Usuario usuario = us.obtenerUsuarioPorId(cod_usuario);

		List<TipoUsuario> tiposUsuario = tus.listarTipoUsuarios();
		model.addAttribute("tiposUsuario", tiposUsuario);
		model.addAttribute("nuevoUsuario", usuario);
		List<Usuario> usuarios = us.listarUsuarios();
		model.addAttribute("usuarios", usuarios);
		return "gestionUsuarios";
	}

	@GetMapping("/gestion-usuarios/eliminar/{cod_usuario}")
	public String eliminarUsuario(@PathVariable Integer cod_usuario, Model model,
			RedirectAttributes redirectAttributes) {

		try {
			us.eliminarUsuarioPorId(cod_usuario);
			redirectAttributes.addFlashAttribute("mensaje", "Usuario Eliminado con exito");
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("mensaje", "Error al Eliminar producto: " + e.getMessage());
		}

		return "redirect:/gestion-usuarios";
	}

	@GetMapping("/administrador/registro")
	public String admin(Model model) {
		model.addAttribute("nuevoUsuarioAdmin", new Usuario());
		return "registroAdmin";
	}
	
	@PostMapping("/administrador/registro/nuevo")
	public String adminRegistroNuvo(@ModelAttribute("nuevoUsuarioAdmin") Usuario nuevoUsuarioAdmin,
			RedirectAttributes redirectAttributes, Model model) {
		try {
			TipoUsuario tipoUser = new TipoUsuario();
			tipoUser.setId(1);
			nuevoUsuarioAdmin.setTipoUsuario(tipoUser);
			us.guardarUsuario(nuevoUsuarioAdmin);
			redirectAttributes.addFlashAttribute("mensaje", "Guardado con éxito");
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("mensaje", "Error al guardar: " + e.getMessage());
		}
		return "redirect:/ingreso";
	}

	@GetMapping("/administrador/registro/tipousuario")
	public String adminTipoUsuario(Model model) {
		model.addAttribute("nuevoTipoUsuario", new TipoUsuario());
		return "registroTipoUsuario";
	}

	@PostMapping("/administrador/registro/tipousuario/nuevo")
	public String adminTipoUsuarioRegistro(@ModelAttribute("nuevoTipoUsuario") TipoUsuario nuevoTipoUsuario,
			RedirectAttributes redirectAttributes) {
		try {
			tus.guardarTipoUsuario(nuevoTipoUsuario);
			redirectAttributes.addFlashAttribute("mensaje", "Guardado con éxito");
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("mensaje", "Error al guardar: " + e.getMessage());
		}
		return "redirect:/administrador/registro/tipousuario";
	}

}
