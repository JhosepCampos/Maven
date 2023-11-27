package com.sanmiguel.minimarket.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sanmiguel.minimarket.modelo.Producto;

@Repository
public interface ProductoRepositorio extends JpaRepository<Producto, Integer> {
	@Query("SELECT p FROM Producto p WHERE p.cantidad <= 40")
	List<Producto> listaProductosTop();

	List<Producto> findByNombreContaining(String nombre);
}
