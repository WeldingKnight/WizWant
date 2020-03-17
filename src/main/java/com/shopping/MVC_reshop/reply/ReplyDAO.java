package com.shopping.MVC_reshop.reply;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.shopping.MVC_reshop.common.JDBCUtil;

public class ReplyDAO {
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;

	
	//SQL 명령어들
	private final String REPLY_INSERT="insert into reply(qna_id, reply_content, reply_id) values(?,?,reply_seq.nextval)";
	private final String REPLY_ID_UPDATE="update qna_board set reply_id=? where qna_id=?";
	private final String REPLY_GET = "select * from REPLY where qna_id=?";

	
	public void insertReply(ReplyVO vo, int qnaId) {
		// TODO Auto-generated method stub
		System.out.println("===> JDBC로 insertReply() 기능 처리");

		try {
			conn = JDBCUtil.getConnection();
			pstmt = conn.prepareStatement(REPLY_INSERT);
			System.out.println(REPLY_INSERT);
			System.out.println("qnaId ======"+qnaId);
			pstmt.setInt(1, qnaId);
			pstmt.setString(2, vo.getReply_content());
			pstmt.executeUpdate();
			
			pstmt = conn.prepareStatement(REPLY_ID_UPDATE);
			System.out.println("qna보드 코멘트번호 입력==="+REPLY_ID_UPDATE);
			pstmt.setInt(1, vo.getReply_id());
			pstmt.setInt(2, qnaId);
			pstmt.executeUpdate();
			
		}catch(Exception e) {
			System.out.println("insertReply() : "+e);
		}finally {
			JDBCUtil.close(pstmt, conn);
		}	
	}


	public ReplyVO getReply(int qnaId) {
		// TODO Auto-generated method stub
		System.out.println("===> JDBC로 getReply() 기능 처리");
		ReplyVO revo = null;
		
		try {
			conn = JDBCUtil.getConnection();			
			//글 상세 가져오기
			pstmt = conn.prepareStatement(REPLY_GET);
			pstmt.setInt(1, qnaId);
			rs=pstmt.executeQuery();
			System.out.println("REPLY_GET ======="+REPLY_GET);
			
			if(rs.next()) {
				revo = new ReplyVO();
				revo.setQna_id(rs.getInt("qna_id"));
				revo.setReply_content(rs.getString("reply_content"));
				revo.setReply_user(rs.getString("reply_user"));
				revo.setReply_id(rs.getInt("reply_id"));

			}
		}catch(Exception e) {
			System.out.println("getQna() : "+e);
		}finally {
			JDBCUtil.close(rs, pstmt, conn);
		}
		return revo;
	}


}
