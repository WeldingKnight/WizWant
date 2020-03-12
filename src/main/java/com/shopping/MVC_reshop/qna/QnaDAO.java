package com.shopping.MVC_reshop.qna;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.shopping.MVC_reshop.qna.QnaVO;
import com.shopping.MVC_reshop.common.JDBCUtil;

public class QnaDAO {
	//JDBC 관련변수
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	//SQL 명령어들
	private final String QNA_INSERT="insert into QNA_BOARD(user_id, qna_title, qna_content,qna_timestamp,qna_id) values(?,?,?,sysdate,qna_seq.nextval);";
	private final String QNA_UPDATE ="update QNA_BOARD set user_id=?, qna_title=?, qna_kind=?,qna_content=? where qna_id=?";
	private final String QNA_DELETE ="delete QNA_BOARD where qna_id=?";
	private final String QNA_GET = "select * from QNA_BOARD where qna_id=?";
	//private final String QNA_LIST = "select * from board order by qna_id desc";
	
	//글 수정
	public void updateQna(QnaVO vo) {
		System.out.println("===> JDBC로 updateQna() 기능 처리");
		
		try {
			conn = JDBCUtil.getConnection();
			pstmt = conn.prepareStatement(QNA_UPDATE);
			pstmt.setString(1,  vo.getUser_id());
			pstmt.setString(2,  vo.getQna_title());
			pstmt.setString(3, vo.getQna_kind());
			pstmt.setString(4,  vo.getQna_content());
			pstmt.setInt(5, vo.getQna_id());
			pstmt.executeUpdate();
		}catch(Exception e) {
			System.out.println("updateQna()"+e);
		}finally {
			JDBCUtil.close(pstmt, conn);
		}
	}
	//글 삭제
	public void deleteQna(QnaVO vo) {
		System.out.println("===> JDBC로 deleteQna() 기능 처리");
		
		try {
			conn = JDBCUtil.getConnection();
			pstmt = conn.prepareStatement(QNA_DELETE);
			pstmt.setInt(1,  vo.getQna_id());
			pstmt.executeUpdate();
		}catch(Exception e) {
			System.out.println("deleteQna()"+e);
		}finally {
			JDBCUtil.close(pstmt, conn);
		}
	}
	
	//글 상세 조회
	public QnaVO getQna(QnaVO vo) {
		System.out.println("===> JDBC로 getQna() 기능 처리");
		QnaVO qna = null;
		
		try {
			conn = JDBCUtil.getConnection();
			//해당 게시글 조회수(cnt)에 +1 update 처리
			String UPDATE_CNT = "update qna_board set qna_views=qna_views+1 where qna_id=?";
			pstmt = conn.prepareStatement(UPDATE_CNT);
			pstmt.setInt(1, vo.getQna_id());
			pstmt.executeUpdate();
			
			//글 상세 가져오기
			pstmt = conn.prepareStatement(QNA_GET);
			pstmt.setInt(1, vo.getQna_id());
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				qna = new QnaVO();
				qna.setQna_id(rs.getInt("QNA_ID"));
				qna.setQna_title(rs.getString("QNA_TITLE"));
				qna.setUser_id(rs.getString("USER_ID"));
				qna.setQna_content(rs.getString("QNA_CONTENT"));
				qna.setQna_timestamp(rs.getDate("QNA_TIMESTAMP"));
				qna.setQna_kind(rs.getString("QNA_KIND"));
				qna.setQna_views(rs.getInt("QNA_VIEWS"));
			}
		}catch(Exception e) {
			System.out.println("getQna() : "+e);
		}finally {
			JDBCUtil.close(rs, pstmt, conn);
		}
		return qna;
	}
	
	//글 수정페이지 이동
	public QnaVO getUpdateQna(QnaVO vo) {
		System.out.println("===> JDBC로 getUpdateQna() 기능 처리");
		QnaVO qna = null;
		
		try {
			conn = JDBCUtil.getConnection();
			
			pstmt = conn.prepareStatement(QNA_GET);
			pstmt.setInt(1, vo.getQna_id());
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				qna = new QnaVO();
				qna.setQna_id(rs.getInt("QNA_ID"));
				qna.setQna_title(rs.getString("QNA_TITLE"));
				qna.setUser_id(rs.getString("USER_ID"));
				qna.setQna_content(rs.getString("QNA_CONTENT"));
				qna.setQna_timestamp(rs.getDate("QNA_TIMESTAMP"));
				qna.setQna_kind(rs.getString("QNA_KIND"));				
				qna.setQna_views(rs.getInt("QNA_VIEWS"));
			}
		}catch(Exception e) {
			System.out.println("getQna() : "+e);
		}finally {
			JDBCUtil.close(rs, pstmt, conn);
		}
		return qna;
	}
	
	// 글등록
	public void insertQna(QnaVO vo){
		System.out.println("===> JDBC로 insertQnaList() 기능 처리");

		try {
			conn = JDBCUtil.getConnection();
			pstmt = conn.prepareStatement(QNA_INSERT);
			pstmt.setString(1,vo.getUser_id());
			pstmt.setString(2,vo.getQna_title());
			pstmt.setString(3, vo.getQna_content());
			pstmt.executeUpdate();
			
		}catch(Exception e) {
			System.out.println("insertQna()"+e);
		}finally {
			JDBCUtil.close(pstmt, conn);
		}
	}
	
	
	//전체 게시글 불러오기
	public List<QnaVO> getQnaList(String searchField, String searchText){
		System.out.println("===> JDBC로 getQnaList() 기능 처리");
		
		List<QnaVO> qnaList = new ArrayList<QnaVO>(); // 가변 배열 객체 생성
		
		try {
			conn = JDBCUtil.getConnection();
			System.out.println("1");
			//핵심 부분] = > 전체 목록 가져오기 & 검색 조건에 맞는 것만 가져오기
			String where = ""; // 문자열 where 변수 선언(문자검색용 스트링 쿼리용)
			String QNA_GET_LIST=""; //쿼리 변수
			if(!searchField.equals("") && !searchText.equals("")) {
				where = "where "+searchField+" like '%" + searchText + "%'";
				QNA_GET_LIST = "select * from qna_board "+where+" order by qna_id desc";
				System.out.println(QNA_GET_LIST);
				System.out.println("2");
				pstmt = conn.prepareStatement(QNA_GET_LIST);
			}else {
			//조건이 들어오지 않을 시 where가 없으므로, 전체 불러오기가 됩니다.
				QNA_GET_LIST="select * from board order by qna_id desc";
				pstmt = conn.prepareStatement(QNA_GET_LIST);
				System.out.println(QNA_GET_LIST);
				System.out.println("3");
			}
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				System.out.println("4");
				QnaVO qna = new QnaVO();
				System.out.println("2");
				qna.setUser_id(rs.getString("USER_ID"));
				qna.setQna_title(rs.getString("QNA_TITLE"));
				qna.setQna_timestamp(rs.getDate("QNA_TIMESTAMP"));
				qna.setQna_id(rs.getInt("QNA_ID"));
				qna.setQna_views(rs.getInt("QNA_VIEWS"));
				qna.setQna_kind(rs.getString("QNA_KIND"));
				qnaList.add(qna);

				System.out.println("title : "+qna.getQna_title());
				System.out.println("5");
			}
		}catch(Exception e) {
			System.out.println("getQnaList() : "+e);
		}finally {
			JDBCUtil.close(rs, pstmt, conn);
		}
		return qnaList;

	}

}