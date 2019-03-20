package com.tarea01;

import java.sql.Date;
import java.util.List;

import com.tarea01.datos.dao.ClienteDao;
import com.tarea01.datos.dao.FacturaDao;
import com.tarea01.datos.dao.impl.ClienteDaoImpl;
import com.tarea01.datos.dao.impl.FacturaDaoImpl;
import com.tarea01.datos.entidades.Cliente;
import com.tarea01.datos.entidades.Factura;

public class DaoMain {
	
	public static void main(String [] args){
		
		java.util.Date dat = new java.util.Date();
		Date date2 = new Date(dat.getTime());
		Date date1 = new Date(dat.getYear(), dat.getMonth(), dat.getDay());
				
		System.out.println(date2);
		
		/*ClienteDao dao = new ClienteDaoImpl();
		Cliente cliente = new Cliente(); 
		cliente.setNombres("Aldo");
		cliente.setApellidos("Malaver");
		cliente.setCodigoCliente("AM001");
		cliente.setEstado(1);
		System.out.println("id generado:::" + dao.guardarCliente(cliente));
		*/
		
		//buscar clientes
		ClienteDao dao = new ClienteDaoImpl();
		List<Cliente> clientes = dao.listarClientes();
		Cliente clienteEscogido = null;
		
		for(Cliente cliente: clientes){
			if(cliente.getId() == 3){
				clienteEscogido = cliente;
			}
		}
		
		FacturaDao facturaDao = new FacturaDaoImpl();
		Factura factura = new Factura();
		factura.setNroFactura("FA0001");
		factura.setFechaFactura(new java.util.Date());
		factura.setIgv(18);
		factura.setMontoTotal(100);
		factura.setCliente(clienteEscogido);
		
		int idFactura = facturaDao.guardarFactura(factura);
		System.out.println("Id Factura generado::" + idFactura);
		
	}

}
