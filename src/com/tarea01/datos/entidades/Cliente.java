package com.tarea01.datos.entidades;

public class Cliente {

	private int id;
	private String nombres;
	private String apellidos;
	private String codigoCliente;
	private int estado;
	private double montoTotal;
	private int nroFacturas;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getCodigoCliente() {
		return codigoCliente;
	}

	public void setCodigoCliente(String codigoCliente) {
		this.codigoCliente = codigoCliente;
	}

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	public double getMontoTotal() {
		return montoTotal;
	}

	public void setMontoTotal(double montoTotal) {
		this.montoTotal = montoTotal;
	}

	public int getNroFacturas() {
		return nroFacturas;
	}

	public void setNroFacturas(int nroFacturas) {
		this.nroFacturas = nroFacturas;
	}
	
	

}
