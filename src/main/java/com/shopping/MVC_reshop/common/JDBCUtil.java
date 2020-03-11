package com.shopping.MVC_reshop.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class JDBCUtil {

public static Connection getConnection() throws Exception{
		
		try {
			System.out.println("DB�������");
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "scott", "tiger");
			System.out.println("DB���Ἲ��");
			
			return con;
		} catch (Exception e) {
			
			System.out.println("DB������� �����߻�");
			
			e.printStackTrace();
			
		}
		
		
		return null;
		
	}
	
	//close() �޼ҵ�: �޼ҵ� �����ε� ����
	public static void close(PreparedStatement stmt, Connection conn) {  //insert, update, delete �� ȣ��
		
		if (stmt!=null) {
			
			try {
				if (!stmt.isClosed()) {
					stmt.close();
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				stmt = null;
			}
		}
		
		if (conn!=null) {
			
			try {
				if (!conn.isClosed()) {
					conn.close();
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				conn = null;
			}
			
		}
		
		
		
	}
	
	public static void close(ResultSet rs, PreparedStatement stmt, Connection conn) {
		
		
		if (rs!=null) {
			
			try {
				if (!rs.isClosed()) {
					stmt.close();
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				rs = null;
			}
		}
		
		if (stmt!=null) {
			
			try {
				if (!stmt.isClosed()) {
					stmt.close();
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				stmt = null;
			}
		}
		
		if (conn!=null) {
			
			try {
				if (!conn.isClosed()) {
					conn.close();
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				conn = null;
			}
			
		}

	}

}
