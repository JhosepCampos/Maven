package com.sanmiguel.minimarket.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sanmiguel.minimarket.modelo.TipoProducto;
import com.sanmiguel.minimarket.service.TipoProductoService;

@Controller
@SessionAttributes({ "user", "carrito", "countCarrito" })
public class TipoProductoControlador {
	
	@Autowired
	TipoProductoService tps;

	@GetMapping("/registro/tipoProducto")
	public String registroTipoProducto(Model model) {
		model.addAttribute("nuevoTipoProducto", new TipoProducto());
		return "registrarTipoProducto";
	}

	@PostMapping("/registro/tipoProducto/guardar")
	public String guardarTipoProducto(@ModelAttribute("nuevoTipoProducto") TipoProducto nuevoTipoProducto,
			Model model, RedirectAttributes redirectAttributes) {
		
		try {
			tps.guardarTipoProducto(nuevoTipoProducto);
			redirectAttributes.addFlashAttribute("mensaje", "Guardado con éxito");
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("mensaje", "Error al guardar: " + e.getMessage());
		}
		
		return "redirect:/gestion-productos";
	}
}
