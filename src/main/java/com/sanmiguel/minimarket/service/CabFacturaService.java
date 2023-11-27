package com.sanmiguel.minimarket.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sanmiguel.minimarket.modelo.CabFactura;
import com.sanmiguel.minimarket.repositorio.CabFacturaRepositorio;

@Service
public class CabFacturaService {

	@Autowired
	CabFacturaRepositorio cfr;
	
	public void guardarCabFactura(CabFactura cab) {
		cfr.save(cab);
	}
	
}
