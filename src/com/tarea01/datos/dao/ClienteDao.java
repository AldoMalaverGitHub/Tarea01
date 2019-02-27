package com.tarea01.datos.dao;

import java.util.List;

import com.tarea01.datos.entidades.Cliente;

public interface ClienteDao {
	
	int guardarCliente(Cliente cliente);
	
	List<Cliente> listarClientes();
	
	int eliminarCliente(int id);
	
	int actualizarCliente(Cliente cliente);

}
