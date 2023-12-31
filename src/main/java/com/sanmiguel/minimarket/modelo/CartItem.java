package com.sanmiguel.minimarket.modelo;

public class CartItem {
	private Producto producto;
    private Integer cantidad;
    
	public CartItem() {
	}

	public CartItem(Producto producto, Integer cantidad) {
		super();
		this.producto = producto;
		this.cantidad = cantidad;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
}
