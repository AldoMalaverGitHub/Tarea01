package com.tarea01.datos.entidades;

import java.util.Date;
import java.util.List;

public class Factura {

	private int id;
	private String nroFactura;
	private Date fechaFactura;
	private Cliente cliente;
	private double igv;
	private double montoTotal;
	private List<DetalleFactura> listaDetalleFactura;
	public static final double IGV = 0.18;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNroFactura() {
		return nroFactura;
	}

	public void setNroFactura(String nroFactura) {
		this.nroFactura = nroFactura;
	}

	public Date getFechaFactura() {
		return fechaFactura;
	}

	public void setFechaFactura(Date fechaFactura) {
		this.fechaFactura = fechaFactura;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public double getIgv() {
		return igv;
	}

	public void setIgv(double igv) {
		this.igv = igv;
	}

	public double getMontoTotal() {
		return montoTotal;
	}

	public void setMontoTotal(double montoTotal) {
		this.montoTotal = montoTotal;
	}

	public List<DetalleFactura> getListaDetalleFactura() {
		return listaDetalleFactura;
	}

	public void setListaDetalleFactura(List<DetalleFactura> listaDetalleFactura) {
		this.listaDetalleFactura = listaDetalleFactura;
	}

	
}
