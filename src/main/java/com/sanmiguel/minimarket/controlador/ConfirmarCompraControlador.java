package com.sanmiguel.minimarket.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttributes;


@Controller
@SessionAttributes({ "user", "carrito", "countCarrito" })
public class ConfirmarCompraControlador {
	
	@GetMapping("/confirmarCompra")
	public String mostrarConfirmacion(Model model) {
		return "confirmarCompra";
	}
}
