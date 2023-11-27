package com.sanmiguel.minimarket.repositorio;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sanmiguel.minimarket.modelo.DetFactura;

@Repository
public interface DetFacturaRepositorio extends CrudRepository<DetFactura, Integer> {
}
