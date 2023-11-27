package com.sanmiguel.minimarket.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sanmiguel.minimarket.modelo.Usuario;

@Repository
public interface UsuarioRepositorio extends JpaRepository<Usuario, Integer> {
	@Query("SELECT u FROM Usuario u WHERE u.nomUsuario = :nombreUsuario AND u.clave = :clave")
    public Usuario validarUsuario(@Param("nombreUsuario") String nombreUsuario, @Param("clave") String clave);
}
