package com.sanmiguel.minimarket.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sanmiguel.minimarket.modelo.DetFactura;
import com.sanmiguel.minimarket.repositorio.DetFacturaRepositorio;

@Service
public class DetFacturaService {

	@Autowired
	DetFacturaRepositorio dfr;
	
	public void guardarDetFactura(DetFactura detFac) {
		dfr.save(detFac);
	}
	
}
