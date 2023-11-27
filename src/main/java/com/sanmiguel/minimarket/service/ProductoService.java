package com.sanmiguel.minimarket.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sanmiguel.minimarket.modelo.Producto;
import com.sanmiguel.minimarket.repositorio.ProductoRepositorio;

@Service
public class ProductoService {

	@Autowired
	ProductoRepositorio pr;

	public List<Producto> listarProductos() {
		return (List<Producto>) pr.findAll();
	}

	public void guardarProducto(Producto producto) {
		pr.save(producto);
	}

	public Producto obtenerProductoPorId(Integer id) {
		return pr.findById(id).orElse(null);
	}

	public void eliminarProductoPorId(Integer id) {
		Producto productoDel = pr.findById(id).orElse(null);
		pr.delete(productoDel);
	}

	public List<Producto> obtenerProductosTop() {
		List<Producto> todosLosProductos = pr.listaProductosTop();
		List<Producto> productosTop = todosLosProductos.stream().limit(6).collect(Collectors.toList());
		return productosTop;
	}
}
