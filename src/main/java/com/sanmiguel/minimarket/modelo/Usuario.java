package com.sanmiguel.minimarket.modelo;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cod_usuario;
	private String nombre;
	private String apellido;
	private String nomUsuario;
	private String clave;
	private String genero;
	@ManyToOne
	private TipoUsuario tipoUsuario;
	@OneToMany(mappedBy = "idUsu")
	private List<CabFactura> facturas;
	
	public Usuario() {
	}

	public Usuario(String nombre, String apellido, String nomUsuario, String clave, String genero,
			TipoUsuario tipoUsuario) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.nomUsuario = nomUsuario;
		this.clave = clave;
		this.genero = genero;
		this.tipoUsuario = tipoUsuario;
	}

	public int getCod_usuario() {
		return cod_usuario;
	}

	public void setCod_usuario(int cod_usuario) {
		this.cod_usuario = cod_usuario;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getNomUsuario() {
		return nomUsuario;
	}

	public void setNomUsuario(String nomUsuario) {
		this.nomUsuario = nomUsuario;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public TipoUsuario getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(TipoUsuario tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

	public List<CabFactura> getFacturas() {
		return facturas;
	}

	public void setFacturas(List<CabFactura> facturas) {
		this.facturas = facturas;
	}
}
