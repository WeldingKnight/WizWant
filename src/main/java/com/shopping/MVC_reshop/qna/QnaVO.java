package com.shopping.MVC_reshop.qna;

import java.sql.Date;

public class QnaVO {
	private String user_id;   //id FK
	private String qna_title; // 제목
	private String qna_content; // 내용
	private int reply_id; // 관리자 답변 id fk
	private Date qna_timestamp;  // 시간
	private int qna_id; // 글 번호
	private int qna_views; // 조회수
	private String qna_kind;  //qna 종류
	
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getQna_title() {
		return qna_title;
	}
	public void setQna_title(String qna_title) {
		this.qna_title = qna_title;
	}
	public String getQna_content() {
		return qna_content;
	}
	public void setQna_content(String qna_content) {
		this.qna_content = qna_content;
	}
	public int getReply_id() {
		return reply_id;
	}
	public void setReply_id(int reply_id) {
		this.reply_id = reply_id;
	}
	public Date getQna_timestamp() {
		return qna_timestamp;
	}
	public void setQna_timestamp(Date qna_timestamp) {
		this.qna_timestamp = qna_timestamp;
	}
	public int getQna_id() {
		return qna_id;
	}
	public void setQna_id(int qna_id) {
		this.qna_id = qna_id;
	}
	public int getQna_views() {
		return qna_views;
	}
	public void setQna_views(int qna_views) {
		this.qna_views = qna_views;
	}
	public String getQna_kind() {
		return qna_kind;
	}
	public void setQna_kind(String qna_kind) {
		this.qna_kind = qna_kind;
	}
	@Override
	public String toString() {
		return "QnaVO [user_id=" + user_id + ", qna_title=" + qna_title + ", qna_content=" + qna_content + ", reply_id="
				+ reply_id + ", qna_timestamp=" + qna_timestamp + ", qna_id=" + qna_id + ", qna_views=" + qna_views
				+ ", qna_kind=" + qna_kind + "]";
	}
	
	
}
