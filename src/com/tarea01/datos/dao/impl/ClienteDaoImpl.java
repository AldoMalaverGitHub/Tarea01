package com.tarea01.datos.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.tarea01.datos.dao.ClienteDao;
import com.tarea01.datos.entidades.Cliente;
import com.tarea01.datos.util.Conexion;

public class ClienteDaoImpl implements ClienteDao {

	@Override
	public int guardarCliente(Cliente cliente) {
		Conexion conexion = new Conexion();
		Connection conn = conexion.getConnection();
		String sql = "Insert into Cliente(nombres, apellidos, codigoCliente, estado) values(?,?,?,?)";
		PreparedStatement pstmt = null;
		int id = 0;
		ResultSet rs = null;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, cliente.getNombres());
			pstmt.setString(2, cliente.getApellidos());
			pstmt.setString(3, cliente.getCodigoCliente());
			pstmt.setInt(4, cliente.getEstado());

			pstmt.executeUpdate();

			rs = pstmt.getGeneratedKeys();

			if (rs.next()) {
				id = rs.getInt(1);
			}

		} catch (SQLException sqlex) {
			sqlex.printStackTrace();
		} finally {

			try {
				if (conn != null)
					conn.close();

				if (pstmt != null)
					pstmt.close();

				if (rs != null)
					rs.close();
			} catch (Exception ex) {

			}
		}
		return id;
	}

	@Override
	public List<Cliente> listarClientes() {
		Conexion conexion = new Conexion();
		Connection conn = conexion.getConnection();
		String sql = "select id, nombres, apellidos, codigoCliente, estado from Cliente";
		PreparedStatement pstmt = null;
		List<Cliente> listaClientes = new ArrayList<>();
		ResultSet rs = null;

		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				Cliente cliente = new Cliente();
				cliente.setId(rs.getInt(1));
				cliente.setNombres(rs.getString(2));
				cliente.setApellidos(rs.getString(3));
				cliente.setCodigoCliente(rs.getString(4));
				cliente.setEstado(rs.getInt(5));
				listaClientes.add(cliente);

			}

		} catch (SQLException sqlex) {
			sqlex.printStackTrace();

		} finally {

			try {
				if (conn != null)
					conn.close();

				if (pstmt != null)
					pstmt.close();

				if (rs != null)
					rs.close();
			} catch (Exception ex) {

			}
		}
		return listaClientes;
	}

	@Override
	public int eliminarCliente(int id) {
		Conexion conexion = new Conexion();
		Connection conn = conexion.getConnection();
		String sql = "Delete from Cliente where id = ?";
		PreparedStatement pstmt = null;
		int resultado = 0;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);

			resultado = pstmt.executeUpdate();

		} catch (SQLException sqlex) {
			sqlex.printStackTrace();
		} finally {

			try {
				if (conn != null)
					conn.close();

				if (pstmt != null)
					pstmt.close();

			} catch (Exception ex) {

			}
		}

		return resultado;
	}

	@Override
	public int actualizarCliente(Cliente cliente) {
		Conexion conexion = new Conexion();
		Connection conn = conexion.getConnection();
		String sql = "Update Cliente set nombres = ?, apellidos = ?, codigoCliente = ? where id = ?";
		PreparedStatement pstmt = null;
		int resultado = 0;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, cliente.getNombres());
			pstmt.setString(2, cliente.getApellidos());
			pstmt.setString(3, cliente.getCodigoCliente());
			pstmt.setInt(4, cliente.getId());

			resultado = pstmt.executeUpdate();

		} catch (SQLException sqlex) {
			sqlex.printStackTrace();
		} finally {

			try {
				if (conn != null)
					conn.close();

				if (pstmt != null)
					pstmt.close();

			} catch (Exception ex) {

			}
		}

		return resultado;
	}

}
