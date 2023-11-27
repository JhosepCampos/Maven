package com.sanmiguel.minimarket.modelo;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Proveedor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idprove;
	private String nombre;
	private String correo;
	private String direccion;
	private String distrito;
	private String telefono;
	@OneToMany(mappedBy = "proveedor")
	private List<Producto> productos;
	
	public Proveedor() {
		super();
	}

	public Proveedor(int idprove, String nombre, String correo, String direccion, String distrito, String telefono,
			List<Producto> productos) {
		super();
		this.idprove = idprove;
		this.nombre = nombre;
		this.correo = correo;
		this.direccion = direccion;
		this.distrito = distrito;
		this.telefono = telefono;
		this.productos = productos;
	}

	public int getIdprove() {
		return idprove;
	}

	public void setIdprove(int idprove) {
		this.idprove = idprove;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getDistrito() {
		return distrito;
	}

	public void setDistrito(String distrito) {
		this.distrito = distrito;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public List<Producto> getProductos() {
		return productos;
	}

	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}
}
