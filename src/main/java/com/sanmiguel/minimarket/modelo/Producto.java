package com.sanmiguel.minimarket.modelo;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Producto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idProducto;
	private String nombre;
	private int cantidad;
	private String marca;
	private double precio;
	private String image;
	private LocalDate fechaVenc;
	@ManyToOne
	private TipoProducto tipoProd;
	@ManyToOne
	private Proveedor proveedor;
	@OneToMany(mappedBy = "idProducto")
    private List<DetFactura> factura;
	
	public Producto() {
	}

	public Producto(int idProducto, String nombre, int cantidad, String marca, double precio, String image,
			LocalDate fechaVenc, TipoProducto tipoProd, Proveedor proveedor, List<DetFactura> factura) {
		super();
		this.idProducto = idProducto;
		this.nombre = nombre;
		this.cantidad = cantidad;
		this.marca = marca;
		this.precio = precio;
		this.image = image;
		this.fechaVenc = fechaVenc;
		this.tipoProd = tipoProd;
		this.proveedor = proveedor;
		this.factura = factura;
	}

	public int getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public LocalDate getFechaVenc() {
		return fechaVenc;
	}

	public void setFechaVenc(LocalDate fechaVenc) {
		this.fechaVenc = fechaVenc;
	}

	public TipoProducto getTipoProd() {
		return tipoProd;
	}

	public void setTipoProd(TipoProducto tipoProd) {
		this.tipoProd = tipoProd;
	}

	public Proveedor getProveedor() {
		return proveedor;
	}

	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}

	public List<DetFactura> getFactura() {
		return factura;
	}

	public void setFactura(List<DetFactura> factura) {
		this.factura = factura;
	}
}
