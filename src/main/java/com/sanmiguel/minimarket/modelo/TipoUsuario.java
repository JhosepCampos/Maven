package com.sanmiguel.minimarket.modelo;

import java.util.LinkedList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class TipoUsuario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nombre;
	@OneToMany(mappedBy = "tipoUsuario")
	private List<Usuario> listaUsuarios;
	
	public TipoUsuario() {
		super();
	}

	public TipoUsuario(int id, String nombre, LinkedList<Usuario> listaUsuarios) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.listaUsuarios = listaUsuarios;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Usuario> getListaUsuarios() {
		return listaUsuarios;
	}

	public void setListaUsuarios(LinkedList<Usuario> listaUsuarios) {
		this.listaUsuarios = listaUsuarios;
	}
}
