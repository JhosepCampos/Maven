package com.sanmiguel.minimarket.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sanmiguel.minimarket.modelo.TipoProducto;
import com.sanmiguel.minimarket.repositorio.TipoProductoRepositorio;

@Service
public class TipoProductoService {

	@Autowired
	TipoProductoRepositorio tpr;
	
	public List<TipoProducto> listarTipoProductos() {
		return (List<TipoProducto>) tpr.findAll();
	}
	
	public void guardarTipoProducto(TipoProducto tp) {
		tpr.save(tp);
	}
	
}
