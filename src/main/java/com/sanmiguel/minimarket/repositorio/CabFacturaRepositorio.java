package com.sanmiguel.minimarket.repositorio;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sanmiguel.minimarket.modelo.CabFactura;

@Repository
public interface CabFacturaRepositorio extends CrudRepository<CabFactura, Integer> {
}
