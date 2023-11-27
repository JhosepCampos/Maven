package com.sanmiguel.minimarket.controlador;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.sanmiguel.minimarket.modelo.CabFactura;
import com.sanmiguel.minimarket.modelo.CartItem;
import com.sanmiguel.minimarket.modelo.DetFactura;
import com.sanmiguel.minimarket.modelo.Producto;
import com.sanmiguel.minimarket.modelo.Usuario;
import com.sanmiguel.minimarket.service.CabFacturaService;
import com.sanmiguel.minimarket.service.DetFacturaService;
import com.sanmiguel.minimarket.service.ProductoService;

@Controller
@SessionAttributes({ "user", "carrito", "countCarrito" })
public class CarritoControlador {

	@Autowired
	ProductoService ps;

	@Autowired
	CabFacturaService cfs;

	@Autowired
	DetFacturaService dfs;

	@ModelAttribute("carrito")
	public List<Producto> carrito() {
		return new ArrayList<>();
	}

	@GetMapping("/carrito")
	public String verCarrito(Model model, @ModelAttribute("carrito") List<CartItem> carrito) {
		double totalPagar = 0.0;

		for (CartItem item : carrito) {
			int cantidad = item.getCantidad();
			double precioUnitario = item.getProducto().getPrecio();
			double subtotal = cantidad * precioUnitario;
			totalPagar += subtotal;
		}

		model.addAttribute("totalPagar", totalPagar);
		model.addAttribute("carrito", carrito);

		return "carrito";
	}


	@PostMapping("/agregarAlCarro")
	public String agregarProductoAlCarrito(@RequestParam Integer idProducto, @RequestParam Integer cantidad,
			@ModelAttribute("carrito") List<CartItem> carrito, Model model) {
		try {
			Producto producto = ps.obtenerProductoPorId(idProducto);
			CartItem cartItem = new CartItem(producto, cantidad);
			carrito.add(cartItem);
			model.addAttribute("carrito", carrito);
			model.addAttribute("countCarrito", carrito.size());
			;
		} catch (Exception e) {
			return "redirect:/error";
		}
		return "redirect:/";
	}

	@PostMapping("/eliminarDelCarro")
	public String eliminarProductoDelCarrito(@RequestParam Integer idProducto,
			@ModelAttribute("carrito") List<CartItem> carrito, Model model) {
		
		Producto productoSeleccionado = ps.obtenerProductoPorId(idProducto);
		carrito.removeIf(item -> item.getProducto().getIdProducto() == productoSeleccionado.getIdProducto());
		
		model.addAttribute("carrito", carrito);
		model.addAttribute("countCarrito", carrito.size());

		return "redirect:/carrito";
	}

	@PostMapping("/realizarCompra")
	public String realizarCompra(@ModelAttribute("carrito") List<CartItem> carrito,
			@ModelAttribute("user") Usuario user, Model model) {

		try {
			CabFactura cabFactura = new CabFactura(LocalDate.now(), user);
			cfs.guardarCabFactura(cabFactura);

			for (CartItem item : carrito) {
				DetFactura detFactura = new DetFactura(cabFactura, item.getProducto(), item.getCantidad(),
						item.getProducto().getPrecio());
				dfs.guardarDetFactura(detFactura);

				Producto producto = item.getProducto();
				producto.setCantidad(producto.getCantidad() - item.getCantidad());
				ps.guardarProducto(producto);
			}

			carrito.clear();
			model.addAttribute("countCarrito", 0);

		} catch (Exception e) {
			return "redirect:/error";
		}

		return "confirmarCompra";

	}
}
