package com.sanmiguel.minimarket.repositorio;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sanmiguel.minimarket.modelo.TipoProducto;

@Repository
public interface TipoProductoRepositorio extends CrudRepository<TipoProducto, Integer> {
}
