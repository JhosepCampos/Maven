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

import com.sanmiguel.minimarket.modelo.Proveedor;
import com.sanmiguel.minimarket.modelo.Usuario;
import com.sanmiguel.minimarket.repositorio.ProveedorRepositorio;
import com.sanmiguel.minimarket.repositorio.UsuarioRepositorio;
import com.sanmiguel.minimarket.service.ProveedorService;

@Controller
@SessionAttributes({ "user", "carrito", "countCarrito" })
public class ProveedorControlador {
	@Autowired
	ProveedorRepositorio ur;
	
	@Autowired
	ProveedorService ps;
	
	@GetMapping("/gestion-proveedores")
	public String listarProveedores(@RequestParam(name="pagina",defaultValue = "1") int pagina,Model model) {
		PageRequest pr = PageRequest.of(pagina-1, 3);
		Page<Proveedor> pc = ur.findAll(pr);
		List<Proveedor> proveedores = pc.getContent();
		int totalPaginas = pc.getTotalPages();
		List<Integer> paginas = new ArrayList<Integer>();
		for (int i=1;i<=totalPaginas;i++)
			paginas.add(i);

		model.addAttribute("proveedores", proveedores);
		model.addAttribute("nuevoProveedor", new Proveedor());
		
		model.addAttribute("paginas", paginas);
		return "gestionProveedores";
	}

	@PostMapping("/gestion-proveedores/guardar")
	public String guardarProveedor(@ModelAttribute Proveedor nuevoProveedor, Model model,
			RedirectAttributes redirectAttributes) {

		try {
			ps.guardarProveedor(nuevoProveedor);
			redirectAttributes.addFlashAttribute("mensaje", "Guardado con éxito");
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("mensaje", "Error al guardar: " + e.getMessage());
		}
		return "redirect:/gestion-proveedores";
	}

	@GetMapping("/gestion-proveedores/editar/{idProveedor}")
	public String editarProveedor(@PathVariable Integer idProveedor, Model model) {
		Proveedor proveedor = ps.obtenerProveedorPorId(idProveedor);
		model.addAttribute("nuevoProveedor", proveedor);
		List<Proveedor> proveedores = ps.listarProveedores();
		model.addAttribute("proveedores", proveedores);
		return "gestionProveedores";
	}

	@GetMapping("/gestion-proveedores/eliminar/{idProveedor}")
	public String eliminarProveedor(@PathVariable Integer idProveedor, Model model,
			RedirectAttributes redirectAttributes) {

		try {
			ps.eliminarProveedorPorId(idProveedor);
			redirectAttributes.addFlashAttribute("mensaje", "Proveedor Eliminado con exito");
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("mensaje", "Error al Eliminar proveedor: " + e.getMessage());
		}

		return "redirect:/gestion-proveedores";
	}
	
}
