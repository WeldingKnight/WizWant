package com.shopping.MVC_reshop.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.shopping.MVC_reshop.common.JDBCUtil;

//import com.company.AnnotationMVC.common.JDBCUtil;
//import com.company.AnnotationMVC.user.UserVO;

public class UserDAO {
	
	private Connection conn = null;
	private PreparedStatement stmt =  null;
	private ResultSet rs = null;
	
	private final String USER_GET = "select * from member where id=? and pwd =?";
	
	public UserVO getUser(UserVO vo) {
		UserVO user = null;
		
		try {
			System.out.println("===> JDBC로 getUser() 기능처리");
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(USER_GET);
			
			System.out.println(vo.getId());
			System.out.println(vo.getPassword());
			
			stmt.setString(1, vo.getId());
			stmt.setString(2, vo.getPassword());
			rs = stmt.executeQuery();
			
			if(rs.next()) {
				user = new UserVO();
				user.setId(rs.getString("ID"));
				user.setPassword(rs.getString("PASSWORD"));
				user.setName(rs.getString("NAME"));
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			
			JDBCUtil.close(rs, stmt, conn);
		}
		
		return user;	
	}
	
	//SQL 명령어
	
	private final String USER_insert= "insert into member (NAME,id,pwd,email,address) values(?,?,?,?,?)";
		
	public void insertUser(UserVO vo) {
			
			
			try {
				
				System.out.println("===> JDBC로 inserttUser() 기능처리");
				conn = JDBCUtil.getConnection();
				PreparedStatement pstmt =null; 
				pstmt = conn.prepareStatement(USER_insert);
				pstmt.setString(1, vo.getName());
				pstmt.setString(2, vo.getId());
				pstmt.setString(3, vo.getPassword());
				pstmt.setString(4, vo.getEmail());
				pstmt.setString(5, vo.getAdress());
				pstmt.executeUpdate();
				
				System.out.println("UserDAO 회원메서드 내용확인: "+vo.toString());
				

			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				
				JDBCUtil.close(rs, stmt, conn);
			}
	
		}
}
