package com.shopping.MVC_reshop.reply;

public class ReplyVO {
	private int qna_id;          //NUMBER(10),
	private String reply_content;   //VARCHAR2(255),
    private String reply_user;      //VARCHAR2(10),
    private int reply_id;        //NUMBER(10) PRIMARY KEY NOT NULL,
    

	public int getQna_id() {
		return qna_id;
	}
	public void setQna_id(int qna_id) {
		this.qna_id = qna_id;
	}
	public String getReply_content() {
		return reply_content;
	}
	public void setReply_content(String reply_content) {
		this.reply_content = reply_content;
	}
	public String getReply_user() {
		return reply_user;
	}
	public void setReply_user(String reply_user) {
		this.reply_user = reply_user;
	}
	public int getReply_id() {
		return reply_id;
	}
	public void setReply_id(int reply_id) {
		this.reply_id = reply_id;
	}

	
	@Override
	public String toString() {
		return "ReplyVO [qna_id=" + qna_id + ", reply_content=" + reply_content + ", reply_user=" + reply_user
				+ ", reply_id=" + reply_id + ", getQna_id()=" + getQna_id()
				+ ", getReply_content()=" + getReply_content() + ", getReply_user()=" + getReply_user()
				+ ", getReply_id()=" + getReply_id() + "]";
	}
}
