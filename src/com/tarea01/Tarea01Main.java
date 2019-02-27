package com.tarea01;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.tarea01.datos.entidades.Cliente;
import com.tarea01.datos.entidades.DetalleFactura;
import com.tarea01.datos.entidades.Factura;

public class Tarea01Main {

	public static void main(String[] args) {
		
		List<Cliente> listaClientes = new ArrayList<>();
		Cliente cliente = new Cliente();
		cliente.setId(1);
		cliente.setNombres("Cliente 01");
		cliente.setApellidos("App 01");
		cliente.setCodigoCliente("CL001");
		cliente.setEstado(1);
		listaClientes.add(cliente);
		
		cliente = new Cliente();
		cliente.setId(2);
		cliente.setNombres("Cliente 02");
		cliente.setApellidos("App 02");
		cliente.setCodigoCliente("CL002");
		cliente.setEstado(1);
		listaClientes.add(cliente);
		
		cliente = new Cliente();
		cliente.setId(3);
		cliente.setNombres("Cliente 03");
		cliente.setApellidos("App 03");
		cliente.setCodigoCliente("CL003");
		cliente.setEstado(1);
		listaClientes.add(cliente);
		
		List<Factura> listaFacturas = new ArrayList<>();
		Factura factura = new Factura();
		factura.setId(1);
		factura.setNroFactura("FACT0001");
		factura.setFechaFactura(new Date());
		factura.setIgv(10.62);
		factura.setMontoTotal(59);
		factura.setCliente(listaClientes.get(0));	
		
		List<DetalleFactura> listaDetalle = new ArrayList<>();
		DetalleFactura detalleFactura = new DetalleFactura();
		detalleFactura.setId(1);
		detalleFactura.setNombreProducto("Pizza");
		detalleFactura.setCantidad(2);
		detalleFactura.setPrecio(24.5);
		detalleFactura.setTotal(49);
		listaDetalle.add(detalleFactura);
		
		detalleFactura = new DetalleFactura();
		detalleFactura.setId(2);
		detalleFactura.setNombreProducto("Gaseosa");
		detalleFactura.setCantidad(1);
		detalleFactura.setPrecio(10);
		detalleFactura.setTotal(10);
		listaDetalle.add(detalleFactura);
		factura.setListaDetalleFactura(listaDetalle);
		listaFacturas.add(factura);
		
		factura = new Factura();
		factura.setId(2);
		factura.setNroFactura("FACT0002");
		factura.setFechaFactura(new Date());
		factura.setIgv(8.10);
		factura.setMontoTotal(45);
		factura.setCliente(listaClientes.get(1));
		
		listaDetalle = new ArrayList<>();
		detalleFactura = new DetalleFactura();
		detalleFactura.setId(3);
		detalleFactura.setNombreProducto("Dunking Donuts");
		detalleFactura.setCantidad(1);
		detalleFactura.setPrecio(20);
		detalleFactura.setTotal(20);
		listaDetalle.add(detalleFactura);
		
		detalleFactura = new DetalleFactura();
		detalleFactura.setId(4);
		detalleFactura.setNombreProducto("Cafe");
		detalleFactura.setCantidad(5);
		detalleFactura.setPrecio(5);
		detalleFactura.setTotal(25);
		listaDetalle.add(detalleFactura);
		factura.setListaDetalleFactura(listaDetalle);
		listaFacturas.add(factura);
		
		factura = new Factura();
		factura.setId(3);
		factura.setNroFactura("FACT0003");
		factura.setFechaFactura(new Date());
		factura.setIgv(17.1);
		factura.setMontoTotal(95);
		factura.setCliente(listaClientes.get(0));
		
		listaDetalle = new ArrayList<>();
		detalleFactura = new DetalleFactura();
		detalleFactura.setId(5);
		detalleFactura.setNombreProducto("Pollo a la brasa");
		detalleFactura.setCantidad(1);
		detalleFactura.setPrecio(55);
		detalleFactura.setTotal(55);
		listaDetalle.add(detalleFactura);
		
		detalleFactura = new DetalleFactura();
		detalleFactura.setId(6);
		detalleFactura.setNombreProducto("Anticuchos");
		detalleFactura.setCantidad(8);
		detalleFactura.setPrecio(5);
		detalleFactura.setTotal(40);
		listaDetalle.add(detalleFactura);
		factura.setListaDetalleFactura(listaDetalle);
		listaFacturas.add(factura);
		
		
		for(Factura factura1: listaFacturas){
			factura1.getCliente().setMontoTotal(
					factura1.getCliente().getMontoTotal() +
					factura1.getMontoTotal());
			
			factura1.getCliente().setNroFacturas(factura1.getCliente().getNroFacturas() + 1);
		}
		

		for(Cliente cliente1: listaClientes){
			System.out.println("cliente" + cliente1.getId() + " Monto total:"
					+ cliente1.getMontoTotal());
			
			System.out.println("cliente" + cliente1.getId() + " Nro Facturas:"
					+ cliente1.getNroFacturas());
		}
		
		
		
		
	}
}
