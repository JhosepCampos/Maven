package com.sanmiguel.minimarket.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sanmiguel.minimarket.modelo.Proveedor;
import com.sanmiguel.minimarket.repositorio.ProveedorRepositorio;

@Service
public class ProveedorService {

	@Autowired
	ProveedorRepositorio pr;
	
	public List<Proveedor> listarProveedores() {
		return (List<Proveedor>) pr.findAll();
	}
	
	public void guardarProveedor(Proveedor prove) {
		pr.save(prove);
	}

	public Proveedor obtenerProveedorPorId(Integer id) {
		return pr.findById(id).orElse(null);
	}

	public void eliminarProveedorPorId(Integer id) {
		Proveedor ProveedorDel = pr.findById(id).orElse(null);
		pr.delete(ProveedorDel);
	}
	
}
