package com.sanmiguel.minimarket.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.sanmiguel.minimarket.modelo.Producto;
import com.sanmiguel.minimarket.service.ProductoService;

@Controller
@SessionAttributes({ "user", "carrito", "countCarrito" })
public class MainController {

	@Autowired
	ProductoService ps;

	@GetMapping("/")
	public String index(Model model) {
		List<Producto> listaTop = ps.obtenerProductosTop();
		model.addAttribute("prodTop", listaTop);
		return "index";
	}
	
	@ModelAttribute("countCarrito")
	public Integer countCarrito() {
		return 0;
	}
}
