package com.shopping.MVC_reshop.chat;

public class ChatMessageVO {
	private int id;
	private String writer;
	private String body;
	
	public ChatMessageVO(int id, String writer, String body) {
		this.id = id;
		this.writer = writer;
		this.body = body;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	} 
}
