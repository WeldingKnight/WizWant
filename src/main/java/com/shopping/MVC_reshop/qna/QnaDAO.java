package com.shopping.MVC_reshop.qna;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.shopping.MVC_reshop.qna.QnaVO;
import com.shopping.MVC_reshop.common.JDBCUtil;

public class QnaDAO {
	//JDBC ���ú���
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	//SQL ��ɾ��
	private final String QNA_INSERT="insert into qna_board(user_id, qna_title, qna_content,qna_kind,qna_id) values(?,?,?,?,qna_seq.nextval)";
	private final String QNA_UPDATE ="update QNA_BOARD set user_id=?, qna_title=?, qna_kind=?,qna_content=? where qna_id=?";
	private final String QNA_DELETE ="delete from QNA_BOARD where qna_id=?";
	private final String QNA_GET = "select * from QNA_BOARD where qna_id=?";
	//private final String QNA_GET_SORT="select * from qna_board where qna_kind=? order by qna_id desc";
	//private final String QNA_LIST = "select * from board order by qna_id desc";
	
	//�� ����
	public void updateQna(QnaVO vo) {
		System.out.println("===> JDBC�� updateQna() ��� ó��");
		
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
	//�� ����
	public void deleteQna(QnaVO vo) {
		System.out.println("===> JDBC�� deleteQna() ��� ó��");
		
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
	
	//�� �� ��ȸ
	public QnaVO getQna(QnaVO vo) {
		System.out.println("===> JDBC�� getQna() ��� ó��");
		QnaVO qna = null;
		
		try {
			conn = JDBCUtil.getConnection();
			//�ش� �Խñ� ��ȸ��(qna_views)�� +1 update ó��
			String UPDATE_VIEWS = "update qna_board set qna_views=qna_views+1 where qna_id=?";
			pstmt = conn.prepareStatement(UPDATE_VIEWS);
			pstmt.setInt(1, vo.getQna_id());
			pstmt.executeUpdate();
			System.out.println("UPDATE_VIEWS : "+UPDATE_VIEWS);
			
			//�� �� ��������
			pstmt = conn.prepareStatement(QNA_GET);
			pstmt.setInt(1, vo.getQna_id());
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				qna = new QnaVO();
				qna.setQna_id(rs.getInt("qna_id"));
				qna.setQna_title(rs.getString("qna_title"));
				qna.setUser_id(rs.getString("user_id"));
				qna.setQna_content(rs.getString("qna_content"));
				qna.setQna_timestamp(rs.getDate("qna_timestamp"));
				qna.setQna_kind(rs.getString("qna_kind"));
				qna.setQna_views(rs.getInt("qna_views"));
			}
		}catch(Exception e) {
			System.out.println("getQna() : "+e);
		}finally {
			JDBCUtil.close(rs, pstmt, conn);
		}
		return qna;
	}
	
	//�� ���������� �̵�
	public QnaVO getUpdateQna(QnaVO vo) {
		System.out.println("===> JDBC�� getUpdateQna() ��� ó��");
		QnaVO qna = null;
		
		try {
			conn = JDBCUtil.getConnection();
			
			pstmt = conn.prepareStatement(QNA_GET);
			pstmt.setInt(1, vo.getQna_id());
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				qna = new QnaVO();
				qna.setQna_id(rs.getInt("qna_id"));
				qna.setQna_title(rs.getString("qna_title"));
				qna.setUser_id(rs.getString("user_id"));
				qna.setQna_content(rs.getString("qna_content"));
				qna.setQna_timestamp(rs.getDate("qna_timestamp"));
				qna.setQna_kind(rs.getString("qna_kind"));				
				qna.setQna_views(rs.getInt("qna_views"));
			}
		}catch(Exception e) {
			System.out.println("updateQna() : "+e);
		}finally {
			JDBCUtil.close(rs, pstmt, conn);
		}
		return qna;
	}
	
	// �۵��
	public void insertQna(QnaVO vo){
		System.out.println("===> JDBC�� insertQna() ��� ó��");

		try {
			conn = JDBCUtil.getConnection();
			pstmt = conn.prepareStatement(QNA_INSERT);
			pstmt.setString(1,vo.getUser_id());
			pstmt.setString(2,vo.getQna_title());
			pstmt.setString(3, vo.getQna_content());
			pstmt.setString(4, vo.getQna_kind());
			pstmt.executeUpdate();
			
		}catch(Exception e) {
			System.out.println("insertQna() : "+e);
		}finally {
			JDBCUtil.close(pstmt, conn);
		}
	}
	
	
	//��ü �Խñ� �ҷ�����
	public List<QnaVO> getQnaList(String searchField, String searchText){
		System.out.println("===> JDBC�� getQnaList() ��� ó��");
		
		List<QnaVO> qnaList = new ArrayList<QnaVO>(); // ���� �迭 ��ü ����
		try {
			conn = JDBCUtil.getConnection();
			System.out.println("1");
			//�ٽ� �κ�] = > ��ü ��� �������� & �˻� ���ǿ� �´� �͸� ��������
			String where = ""; // ���ڿ� where ���� ����(���ڰ˻��� ��Ʈ�� ������)
			String QNA_GET_LIST="";
			if(!searchField.equals("") && !searchText.equals("")) {
				where = "where "+searchField+" like '%" + searchText + "%'";

				System.out.println("where : "+where);
				System.out.println("2");
			}
			
			QNA_GET_LIST="select * from qna_board "+where+" order by qna_id desc"; //���� ����

			pstmt = conn.prepareStatement(QNA_GET_LIST);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				System.out.println("4");
				QnaVO qna = new QnaVO();
				qna.setUser_id(rs.getString("user_id"));
				qna.setQna_title(rs.getString("qna_title"));
				qna.setQna_timestamp(rs.getDate("qna_timestamp"));
				qna.setQna_id(rs.getInt("qna_id"));
				qna.setQna_views(rs.getInt("qna_views"));
				qna.setQna_kind(rs.getString("qna_kind"));
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
	
	//Sorting List Call
	public List<QnaVO> getSortList(String sort) {
		// TODO Auto-generated method stub
		
		List<QnaVO> sortList = new ArrayList<QnaVO>(); // ���� �迭 ��ü ����
		String QNA_GET_SORT = "";
		try {
			conn = JDBCUtil.getConnection();
			System.out.println("1");			
			

			QNA_GET_SORT = "select * from qna_board where qna_kind=? order by qna_id desc";//���� ����

			pstmt = conn.prepareStatement(QNA_GET_SORT);
			
			System.out.println(QNA_GET_SORT);
			System.out.println("3 :"+sort);
			
			pstmt.setString(1, sort);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				System.out.println("4");
				QnaVO vo = new QnaVO();
				vo.setUser_id(rs.getString("user_id"));
				vo.setQna_title(rs.getString("qna_title"));
				vo.setQna_timestamp(rs.getDate("qna_timestamp"));
				vo.setQna_id(rs.getInt("qna_id"));
				vo.setQna_views(rs.getInt("qna_views"));
				vo.setQna_kind(rs.getString("qna_kind"));
				sortList.add(vo);

				System.out.println("QNA_KIND : "+vo.getQna_kind());
				System.out.println("5");
			}
		}catch(Exception e) {
			System.out.println("getSortList() : "+e);
		}finally {
			JDBCUtil.close(rs, pstmt, conn);
		}
		return sortList;
	}

}