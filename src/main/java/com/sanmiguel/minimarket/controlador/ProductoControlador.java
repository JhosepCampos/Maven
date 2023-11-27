package com.sanmiguel.minimarket.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sanmiguel.minimarket.modelo.Producto;
import com.sanmiguel.minimarket.modelo.Proveedor;
import com.sanmiguel.minimarket.modelo.TipoProducto;
import com.sanmiguel.minimarket.repositorio.ProductoRepositorio;
import com.sanmiguel.minimarket.service.ProductoService;
import com.sanmiguel.minimarket.service.ProveedorService;
import com.sanmiguel.minimarket.service.TipoProductoService;

import java.util.ArrayList;
import java.util.List;

@Controller
@SessionAttributes({ "user", "carrito", "countCarrito" })
public class ProductoControlador {

	@Autowired
	ProductoRepositorio cr;
	
	@Autowired
	ProductoService productoServicio;

	@Autowired
	TipoProductoService tipoProductoServicio;
	
	@Autowired
	ProveedorService ps;

	@GetMapping("/gestion-productos")
	public String listarProductos(@RequestParam(name="pagina",defaultValue = "1") int pagina,Model model) {
		PageRequest pr = PageRequest.of(pagina-1, 3);
		Page<Producto> pc = cr.findAll(pr);
		List<Producto> productos = pc.getContent();
		int totalPaginas = pc.getTotalPages();
		List<Integer> paginas = new ArrayList<Integer>();
		for (int i=1;i<=totalPaginas;i++)
			paginas.add(i);
		
		model.addAttribute("productos", productos);
		model.addAttribute("nuevoProducto", new Producto());
		
		List<TipoProducto> tiposProducto = tipoProductoServicio.listarTipoProductos();
		model.addAttribute("tiposProducto", tiposProducto);
		
		List<Proveedor> proveedores = ps.listarProveedores();
		model.addAttribute("proveedores", proveedores);
		
		model.addAttribute("paginas", paginas);

		return "gestionProductos";
	}

	@PostMapping("/gestion-productos/guardar")
	public String guardarProducto(@ModelAttribute("nuevoProducto") Producto nuevoProducto, Model model,
			RedirectAttributes redirectAttributes) {

		try {
			productoServicio.guardarProducto(nuevoProducto);
			redirectAttributes.addFlashAttribute("mensaje", "Guardado con éxito");
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("mensaje", "Error al guardar: " + e.getMessage());
		}

		return "redirect:/gestion-productos";
	}

	@GetMapping("/gestion-productos/editar/{idProducto}")
	public String editarProducto(@PathVariable Integer idProducto, Model model) {
		Producto producto = productoServicio.obtenerProductoPorId(idProducto);
		model.addAttribute("nuevoProducto", producto);
		List<Producto> productos = productoServicio.listarProductos();
		model.addAttribute("productos", productos);
		List<TipoProducto> tiposProducto = tipoProductoServicio.listarTipoProductos();
		model.addAttribute("tiposProducto", tiposProducto);
		List<Proveedor> proveedores = ps.listarProveedores();
		model.addAttribute("proveedores", proveedores);
		return "gestionProductos";
	}

	@GetMapping("/gestion-productos/eliminar/{idProducto}")
	public String eliminarProducto(@PathVariable Integer idProducto) {
		productoServicio.eliminarProductoPorId(idProducto);
		return "redirect:/gestion-productos";
	}

}