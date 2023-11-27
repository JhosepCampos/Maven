package com.sanmiguel.minimarket.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sanmiguel.minimarket.modelo.Producto;
import com.sanmiguel.minimarket.modelo.TipoProducto;
import com.sanmiguel.minimarket.modelo.TipoUsuario;
import com.sanmiguel.minimarket.modelo.Usuario;
import com.sanmiguel.minimarket.service.TipoUsuarioService;
import com.sanmiguel.minimarket.service.UsuarioService;

@Controller
@SessionAttributes({ "user", "carrito", "countCarrito" })
public class RegistroControlador {

	@Autowired
	UsuarioService us;
	
	@Autowired
	TipoUsuarioService tipoUsuarioServicio;

	@GetMapping("/registro")
	public String registro(Model model) {
		
		List<TipoUsuario> tiposUsuario = tipoUsuarioServicio.listarTipoUsuarios();
		model.addAttribute("tiposUsuario", tiposUsuario);
		
		return "registro";
	}

	@PostMapping("/registro/guardar")
	public String registro(@ModelAttribute("nuevoUsuario") Usuario nuevoUsuario, Model model,
			RedirectAttributes redirectAttributes) {

		try {
			us.guardarUsuario(nuevoUsuario);
			redirectAttributes.addFlashAttribute("mensaje", "Registro con éxito");
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("mensaje", "Error al guardar: " + e.getMessage());
		}

		return "redirect:/registro";
	}

}
