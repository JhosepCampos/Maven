package com.sanmiguel.minimarket.repositorio;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sanmiguel.minimarket.modelo.TipoUsuario;

@Repository
public interface TipoUsuarioRepositorio extends CrudRepository<TipoUsuario, Integer> {
}
