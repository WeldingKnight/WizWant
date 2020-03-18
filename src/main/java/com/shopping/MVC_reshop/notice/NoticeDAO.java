package com.shopping.MVC_reshop.notice;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.shopping.MVC_reshop.notice.NoticeVO;
import com.shopping.MVC_reshop.qna.QnaVO;
import com.shopping.MVC_reshop.common.JDBCUtil;

public class NoticeDAO {
	//JDBC 관련변수
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	//SQL 명령어들
	private final String NOTICE_INSERT="insert into notice_board(notice_id, notice_title,notice_content) values(notice_seq.nextval,?,?)";
	private final String NOTICE_UPDATE ="update NOTICE_BOARD set notice_title=?,notice_content=? where notice_id=?";
	private final String NOTICE_DELETE ="delete NOTICE_BOARD where notice_id=?";
	private final String NOTICE_GET = "select * from NOTICE_BOARD where notice_id=?";
	//private final String QNA_LIST = "select * from board order by qna_id desc";
	
	//글 수정
	public void updateNotice(NoticeVO vo) {
		System.out.println("===> JDBC로 updateNotice() 기능 처리");
		
		try {
			conn = JDBCUtil.getConnection();
			pstmt = conn.prepareStatement(NOTICE_UPDATE);
			
			pstmt.setString(1,  vo.getNotice_title());
			pstmt.setString(2,  vo.getNotice_content());
			pstmt.setInt(3,  vo.getNotice_id());
			pstmt.executeUpdate();
		}catch(Exception e) {
			System.out.println("updateNot()"+e);
		}finally {
			JDBCUtil.close(pstmt, conn);
		}
	}
	//글 삭제
	public void deleteNotice(NoticeVO vo) {
		System.out.println("===> JDBC로 deleteNotice() 기능 처리");
		
		try {
			conn = JDBCUtil.getConnection();
			pstmt = conn.prepareStatement(NOTICE_DELETE);
			pstmt.setInt(1,  vo.getNotice_id());
			pstmt.executeUpdate();
		}catch(Exception e) {
			System.out.println("deleteNOTICE()"+e);
		}finally {
			JDBCUtil.close(pstmt, conn);
		}
	}
	
	//글 상세 조회
	public NoticeVO getNotice(NoticeVO vo) {
		System.out.println("===> JDBC로 getNotice() 기능 처리");
		NoticeVO notice = null;
		
		try {
			conn = JDBCUtil.getConnection();
		
			//글 상세 가져오기
			pstmt = conn.prepareStatement(NOTICE_GET);
			pstmt.setInt(1, vo.getNotice_id());
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				notice = new NoticeVO();
				notice.setNotice_id(rs.getInt("notice_id"));
				notice.setNotice_title(rs.getString("notice_title"));
				notice.setNotice_content(rs.getString("notice_content"));
				notice.setNotice_timestamp(rs.getDate("notice_timestamp"));
			}
		}catch(Exception e) {
			System.out.println("getNot() : "+e);
		}finally {
			JDBCUtil.close(rs, pstmt, conn);
		}
		return notice;
	}
	
	//글 수정페이지 이동
	public NoticeVO getUpdateNotice(NoticeVO vo) {
		System.out.println("===> JDBC로 getUpdateNot() 기능 처리");
		NoticeVO notice = null;
		
		try {
			conn = JDBCUtil.getConnection();
			
			pstmt = conn.prepareStatement(NOTICE_GET);
			pstmt.setInt(1, vo.getNotice_id());
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				notice = new NoticeVO();
				notice.setNotice_id(rs.getInt("notice_id"));
				notice.setNotice_title(rs.getString("notice_title"));
				notice.setNotice_content(rs.getString("notice_content"));
				notice.setNotice_timestamp(rs.getDate("notice_timestamp"));
			}
		}catch(Exception e) {
			System.out.println("updateNot() : "+e);
		}finally {
			JDBCUtil.close(rs, pstmt, conn);
		}
		return notice;
	}
	
	// 글등록
	public void insertNotice(NoticeVO vo){
		System.out.println("===> JDBC로 insertNotice() 기능 처리");

		try {
			conn = JDBCUtil.getConnection();
			pstmt = conn.prepareStatement(NOTICE_INSERT);
//			pstmt.setInt(1,vo.getNotice_id());
			pstmt.setString(1,vo.getNotice_title());
			pstmt.setString(2, vo.getNotice_content());
			pstmt.executeUpdate();
			System.out.println("asd");
		}catch(Exception e) {
			System.out.println("insertNot() : "+e);
		}finally {
			JDBCUtil.close(pstmt, conn);
		}
	}
	
	
	//전체 게시글 불러오기
	public List<NoticeVO> getNoticeList(String searchField, String searchText){
		System.out.println("===> JDBC로 getNoticeList() 기능 처리");
		
		List<NoticeVO> noticeList = new ArrayList<NoticeVO>(); // 가변 배열 객체 생성
		
		try {
			conn = JDBCUtil.getConnection();
			System.out.println("1");
			//핵심 부분] = > 전체 목록 가져오기 & 검색 조건에 맞는 것만 가져오기
			String where = ""; // 문자열 where 변수 선언(문자검색용 스트링 쿼리용)
			String NOTICE_GET_LIST=""; //쿼리 변수
			if(!searchField.equals("") && !searchText.equals("")) {
				where = "where "+searchField+" like '%" + searchText + "%'";
				NOTICE_GET_LIST = "select * from notice_board "+where+" order by notice_id desc";
				System.out.println(NOTICE_GET_LIST);
				System.out.println("2");
				pstmt = conn.prepareStatement(NOTICE_GET_LIST);
			}else {
			//조건이 들어오지 않을 시 where가 없으므로, 전체 불러오기가 됩니다.
				NOTICE_GET_LIST="select * from notice_board order by notice_id desc";
				pstmt = conn.prepareStatement(NOTICE_GET_LIST);
				System.out.println(NOTICE_GET_LIST);
				System.out.println("3");
			}
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				System.out.println("4");
				NoticeVO notice = new NoticeVO();
				notice.setNotice_id(rs.getInt("notice_id"));
				notice.setNotice_title(rs.getString("notice_title"));
				notice.setNotice_timestamp(rs.getDate("notice_timestamp"));
				notice.setNotice_content(rs.getString("notice_content"));
				noticeList.add(notice);

				System.out.println("title : "+notice.getNotice_title());
				System.out.println("5");
			}
		}catch(Exception e) {
			System.out.println("getNotList() : "+e);
		}finally {
			JDBCUtil.close(rs, pstmt, conn);
		}
		return noticeList;

	}
//	public Object getUpdateNotice(NoticeVO vo) {
//		System.out.println("===> JDBC로 getUpdateNotice() 기능 처리");
//		NoticeVO notice = null;
//		
//		try {
//			conn = JDBCUtil.getConnection();
//			
//			pstmt = conn.prepareStatement(NOTICE_GET);
//			pstmt.setInt(1, vo.getNotice_id());
//			rs=pstmt.executeQuery();
//			
//			if(rs.next()) {
//				notice = new NoticeVO();
//				notice.setNotice_id(rs.getInt("notice_id"));
//				notice.setNotice_title(rs.getString("notice_title"));
//				notice.setNotice_content(rs.getString("notice_content"));
//				notice.setNotice_timestamp(rs.getDate("notice_timestamp"));
//			}
//		}catch(Exception e) {
//			System.out.println("updateNotice() : "+e);
//		}finally {
//			JDBCUtil.close(rs, pstmt, conn);
//		}
//		return notice;
//	}

}