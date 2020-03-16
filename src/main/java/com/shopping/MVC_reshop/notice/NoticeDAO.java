package com.shopping.MVC_reshop.notice;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.shopping.MVC_reshop.qna.QnaVO;
import com.shopping.MVC_reshop.common.JDBCUtil;

public class NoticeDAO {
	//JDBC ���ú���
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	//SQL ��ɾ��
	private final String NOTICE_INSERT="insert into qna_board(user_id, qna_title, qna_content,qna_kind,qna_timestamp,qna_id) values(?,?,?,?,sysdate,qna_seq.nextval);";
	private final String NOTICE_UPDATE ="update QNA_BOARD set user_id=?, qna_title=?, qna_kind=?,qna_content=? where qna_id=?";
	private final String NOTICE_DELETE ="delete QNA_BOARD where qna_id=?";
	private final String NOTICE_GET = "select * from QNA_BOARD where qna_id=?";
	//private final String QNA_LIST = "select * from board order by qna_id desc";
	
	//�� ����
	public void updateNotice(NoticeVO vo) {
		System.out.println("===> JDBC�� updateQna() ��� ó��");
		
		try {
			conn = JDBCUtil.getConnection();
			pstmt = conn.prepareStatement(NOTICE_UPDATE);
			pstmt.setInt(1,  vo.getNotice_id());
			pstmt.setString(2,  vo.getNotice_title());
			pstmt.setString(4,  vo.getNotice_content());
			pstmt.executeUpdate();
		}catch(Exception e) {
			System.out.println("updateNot()"+e);
		}finally {
			JDBCUtil.close(pstmt, conn);
		}
	}
	//�� ����
	public void deleteNotice(NoticeVO vo) {
		System.out.println("===> JDBC�� deleteNotice() ��� ó��");
		
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
	
	//�� �� ��ȸ
	public NoticeVO getNotice(NoticeVO vo) {
		System.out.println("===> JDBC�� getNotice() ��� ó��");
		NoticeVO notice = null;
		
		try {
			conn = JDBCUtil.getConnection();
			//�ش� �Խñ� ��ȸ��(qna_views)�� +1 update ó��
			String UPDATE_VIEWS = "update not_board set not_views=not_views+1 where not_id=?";
			pstmt = conn.prepareStatement(UPDATE_VIEWS);
			pstmt.setInt(1, vo.getNotice_id());
			pstmt.executeUpdate();
			System.out.println("UPDATE_VIEWS : "+UPDATE_VIEWS);
			
			
			//�� �� ��������
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
	
	//�� ���������� �̵�
	public NoticeVO getUpdateNot(NoticeVO vo) {
		System.out.println("===> JDBC�� getUpdateNot() ��� ó��");
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
	
	// �۵��
	public void insertNotice(NoticeVO vo){
		System.out.println("===> JDBC�� insertNotice() ��� ó��");

		try {
			conn = JDBCUtil.getConnection();
			pstmt = conn.prepareStatement(NOTICE_INSERT);
			pstmt.setInt(1,vo.getNotice_id());
			pstmt.setString(2,vo.getNotice_title());
			pstmt.setString(3, vo.getNotice_content());
			pstmt.executeUpdate();
			
		}catch(Exception e) {
			System.out.println("insertNot() : "+e);
		}finally {
			JDBCUtil.close(pstmt, conn);
		}
	}
	
	
	//��ü �Խñ� �ҷ�����
	public List<NoticeVO> getNoticeList(String searchField, String searchText){
		System.out.println("===> JDBC�� getNoticeList() ��� ó��");
		
		List<NoticeVO> noticeList = new ArrayList<NoticeVO>(); // ���� �迭 ��ü ����
		
		try {
			conn = JDBCUtil.getConnection();
			System.out.println("1");
			//�ٽ� �κ�] = > ��ü ��� �������� & �˻� ���ǿ� �´� �͸� ��������
			String where = ""; // ���ڿ� where ���� ����(���ڰ˻��� ��Ʈ�� ������)
			String NOTICE_GET_LIST=""; //���� ����
			if(!searchField.equals("") && !searchText.equals("")) {
				where = "where "+searchField+" like '%" + searchText + "%'";
				NOTICE_GET_LIST = "select * from qna_board "+where+" order by qna_id desc";
				System.out.println(NOTICE_GET_LIST);
				System.out.println("2");
				pstmt = conn.prepareStatement(NOTICE_GET_LIST);
			}else {
			//������ ������ ���� �� where�� �����Ƿ�, ��ü �ҷ����Ⱑ �˴ϴ�.
				NOTICE_GET_LIST="select * from qna_board order by qna_id desc";
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

}