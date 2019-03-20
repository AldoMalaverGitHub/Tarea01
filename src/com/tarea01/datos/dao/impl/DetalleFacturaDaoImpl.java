package com.tarea01.datos.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.tarea01.datos.dao.DetalleFacturaDao;
import com.tarea01.datos.entidades.DetalleFactura;
import com.tarea01.datos.util.Conexion;

public class DetalleFacturaDaoImpl implements DetalleFacturaDao {

	@Override
	public int guardarDetalleFactura(DetalleFactura detalleFactura) {
		
		Conexion conexion = new Conexion();
		Connection conn = conexion.getConnection();
		PreparedStatement pstmt = null;		
		String sql = "Insert into DetalleFactura(nombreProducto, cantidad, precio, total, idFactura) "
				+ "values(?,?,?,?,?)";
		int resultado = 0;
		
		try{
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, detalleFactura.getNombreProducto());
			pstmt.setInt(2, detalleFactura.getCantidad());
			pstmt.setDouble(3, detalleFactura.getPrecio());
			pstmt.setDouble(4, detalleFactura.getTotal());
			pstmt.setInt(5, detalleFactura.getFactura().getId());
			
			resultado = pstmt.executeUpdate();			
			
		}catch(SQLException ex){
			
		}finally{
			
			try{
			if(pstmt != null)
				pstmt.close();		
			
			if(conn != null)
				conn.close();
			
			}catch(SQLException ex){
				
			}
		}
		
		return resultado;
	}

}
