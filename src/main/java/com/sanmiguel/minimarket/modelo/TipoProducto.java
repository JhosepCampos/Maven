package com.sanmiguel.minimarket.modelo;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class TipoProducto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idTipoProducto;
	private String nombreTipoProducto;
	@OneToMany(mappedBy = "tipoProd")
	private List<Producto> listaProductos;
	
	public TipoProducto() {
	}

	public TipoProducto(int idTipoProducto, String nombreTipoProducto, List<Producto> listaProductos) {
		this.idTipoProducto = idTipoProducto;
		this.nombreTipoProducto = nombreTipoProducto;
		this.listaProductos = listaProductos;
	}

	public int getIdTipoProducto() {
		return idTipoProducto;
	}

	public void setIdTipoProducto(int idTipoProducto) {
		this.idTipoProducto = idTipoProducto;
	}

	public String getNombreTipoProducto() {
		return nombreTipoProducto;
	}

	public void setNombreTipoProducto(String nombreTipoProducto) {
		this.nombreTipoProducto = nombreTipoProducto;
	}

	public List<Producto> getListaProductos() {
		return listaProductos;
	}

	public void setListaProductos(List<Producto> listaProductos) {
		this.listaProductos = listaProductos;
	}
}
