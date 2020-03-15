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
	
	//SQL문 정리
	private final String USER_GET = "select * from members where id=? and pwd =?"; //로그인
	private final String USER_insert= "insert into members (NAME,id,pwd,mail,address,birth,sex,tel) values(?,?,?,?,?,?,?,?)"; //회원가입
	private final String USER_update ="update members set name=? pwd=? where id=?";  //회원정보수정
	private final String USER_insertid_chk ="select * from members where id=?";//아이디 중복체그
	
	public UserVO getUser(UserVO vo) {  //로그인메서드
		UserVO user = null;
		
		try {
			System.out.println("===> JDBC로 getUser() 기능처리");
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(USER_GET);
			
			
			System.out.println(vo.loginString()); //로그인 정보 확인
			
			stmt.setString(1, vo.getId());
			stmt.setString(2, vo.getPassword());
			rs = stmt.executeQuery();
			
			if(rs.next()) {
				user = new UserVO();
				user.setId(rs.getString("ID"));
				user.setPassword(rs.getString("pwd"));
				user.setName(rs.getString("name"));
				user.setEmail(rs.getString("mail"));
				user.setSex(rs.getString("sex"));
				user.setBirth(rs.getString("birth"));
				user.setAddress(rs.getString("address"));
				user.setRole(rs.getString("role"));
				user.setTel(rs.getString("tel"));
			}
			
	
		} catch (Exception e) {

		}finally {
			
			JDBCUtil.close(rs, stmt, conn);
		}
		
		return user;	
	}
	
	public void insertUser(UserVO vo) {
			
			
			try {
				
				System.out.println("===> JDBC로 inserttUser() 기능처리");
				conn = JDBCUtil.getConnection();
				PreparedStatement pstmt =null; 
				pstmt = conn.prepareStatement(USER_insert);
				pstmt.setString(1, vo.getName());
				pstmt.setString(2, vo.getId());
				pstmt.setString(3, vo.getPassword());
				
				if( vo.getEmail()!=null) {
					pstmt.setString(4, vo.getEmail());
				}else {
					pstmt.setString(4, null);
				}
				
				if(vo.getAddress()!=null) {
					pstmt.setString(5, vo.getAddress());
				}else {
					pstmt.setString(5,null);
				}
				
				if(vo.getBirth()!=null) {
					pstmt.setString(6, vo.getBirth());
				}else {
					pstmt.setString(6, null);
				}
				pstmt.setString(7, vo.getSex());
				
				if( vo.getTel() !=null) {
					pstmt.setString(8, vo.getTel());
				}else {
					pstmt.setString(8, null);
				}
				pstmt.executeUpdate();
				
				System.out.println("UserDAO 회원가입 데이터 내용확인: "+vo.toString());
				

			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				
				JDBCUtil.close(stmt, conn);
			}
	
		}
	
	public UserVO isnertIdchk(String insertid) {  //아이디 중복체크 메서드
		UserVO user = null;
		System.out.println("중복체크할 ID: "+insertid);
		
		try {
			
			System.out.println("===> JDBC로isnertIdchkr() 기능처리");
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(USER_insertid_chk);
			

			stmt.setString(1, insertid);
			rs = stmt.executeQuery();
			
			if(rs.next()) {
				user = new UserVO();
				user.setId(rs.getString("ID"));
			}
		} catch (Exception e) {

		}finally {
			
			JDBCUtil.close(rs, stmt, conn);
		}
		
		return user;	
	}
}
