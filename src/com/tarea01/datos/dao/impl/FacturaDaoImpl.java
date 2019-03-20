package com.tarea01.datos.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.tarea01.datos.dao.FacturaDao;
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Factura> listarFacturasPorCliente(int idCliente) {
		// TODO Auto-generated method stub
		return null;
	}

}
