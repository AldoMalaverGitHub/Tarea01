package com.tarea01;

import com.tarea01.datos.dao.ClienteDao;
import com.tarea01.datos.dao.impl.ClienteDaoImpl;
import com.tarea01.datos.entidades.Cliente;

public class DaoMain {
	
	public static void main(String [] args){
		ClienteDao dao = new ClienteDaoImpl();
		Cliente cliente = new Cliente(); 
		cliente.setNombres("Cliente 01");
		cliente.setApellidos("App 01");
		cliente.setCodigoCliente("CL001");
		cliente.setEstado(1);
		System.out.println("id generado:::" + dao.guardarCliente(cliente));
	}

}
