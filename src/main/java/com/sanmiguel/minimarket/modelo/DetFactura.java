package com.sanmiguel.minimarket.modelo;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class DetFactura {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
    private CabFactura cabFactura;
	
	@ManyToOne
	private Producto idProducto;
	
	private int cantidad;
	private double precioProducto;
	
	public DetFactura() {
	}

	public DetFactura(CabFactura cabFactura, Producto idProducto, int cantidad, double precioProducto) {
		super();
		this.cabFactura = cabFactura;
		this.idProducto = idProducto;
		this.cantidad = cantidad;
		this.precioProducto = precioProducto;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public CabFactura getCabFactura() {
		return cabFactura;
	}

	public void setCabFactura(CabFactura cabFactura) {
		this.cabFactura = cabFactura;
	}

	public Producto getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(Producto idProducto) {
		this.idProducto = idProducto;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public double getPrecioProducto() {
		return precioProducto;
	}

	public void setPrecioProducto(double precioProducto) {
		this.precioProducto = precioProducto;
	}
}
