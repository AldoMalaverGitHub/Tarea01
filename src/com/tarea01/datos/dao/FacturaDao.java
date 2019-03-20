package com.tarea01.datos.dao;

import java.util.List;

import com.tarea01.datos.entidades.Factura;

public interface FacturaDao {
	
	int guardarFactura(Factura factura);
	
	List<Factura> listarFacturas();
	
	List<Factura> listarFacturasPorCliente(int idCliente);

}
