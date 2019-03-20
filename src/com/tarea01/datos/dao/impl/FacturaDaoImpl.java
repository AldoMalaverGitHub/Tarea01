package com.tarea01.datos.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.tarea01.datos.dao.FacturaDao;
import com.tarea01.datos.entidades.Cliente;
import com.tarea01.datos.entidades.Factura;
import com.tarea01.datos.util.Conexion;

public class FacturaDaoImpl implements FacturaDao {

	@Override
	public int guardarFactura(Factura factura) {
		Conexion conexion = new Conexion();
		Connection conn = conexion.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "Insert into Factura(nroFactura, fechaFactura, igv, montoTotal, idCliente) "
				+ "values(?,?,?,?,?)";
		int idFactura = 0;
		
		try{
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, factura.getNroFactura());
			pstmt.setDate(2, new Date(factura.getFechaFactura().getTime()));
			pstmt.setDouble(3, factura.getIgv());
			pstmt.setDouble(4, factura.getMontoTotal());
			pstmt.setInt(5, factura.getCliente().getId());
			
			pstmt.executeUpdate();
			
			rs = pstmt.getGeneratedKeys();
			
			if(rs.next()){
				idFactura = rs.getInt(1);
			}
			
		}catch(SQLException ex){
			
		}finally{
			
			try{
			if(pstmt != null)
				pstmt.close();
			
			if(rs != null)
				rs.close();
			
			if(conn != null)
				conn.close();
			
			}catch(SQLException ex){
				
			}
		}
		
		return idFactura;
	}

	@Override
	public List<Factura> listarFacturas() {
		Conexion conexion = new Conexion();
		Connection conn = conexion.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "Select id, nroFactura, fechaFactura, igv, montoTotal, idCliente "
				+ "from Factura";
		List<Factura> listaFacturas = new ArrayList<>();
		
		try{
			
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				Factura factura = new Factura();
				factura.setId(rs.getInt(1));
				factura.setNroFactura(rs.getString(2));
				factura.setFechaFactura(new java.util.Date(rs.getDate(3).getTime()));
				factura.setIgv(rs.getDouble(4));
				factura.setMontoTotal(rs.getDouble(5));
				Cliente cliente = new Cliente();
				cliente.setId(rs.getInt(6));
				factura.setCliente(cliente);
				listaFacturas.add(factura);
			}
			
		}catch(SQLException ex){
			
		}finally{
			
			try{
			if(pstmt != null)
				pstmt.close();
			
			if(rs != null)
				rs.close();
			
			if(conn != null)
				conn.close();
			
			}catch(SQLException ex){
				
			}
		}
		
		
		return listaFacturas;
	}

	@Override
	public List<Factura> listarFacturasPorCliente(int idCliente) {
		// TODO Auto-generated method stub
		return null;
	}

}
