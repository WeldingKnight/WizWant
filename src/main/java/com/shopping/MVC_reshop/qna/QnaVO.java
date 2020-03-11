package com.shopping.MVC_reshop.qna;

import java.sql.Date;

public class QnaVO {
	private String user_id;
	private String qna_title;
	private String qna_content;
	private int reply_id;
	private Date qna_timestamp;
	private int qna_id;
	
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
	
}
