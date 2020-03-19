package com.shopping.MVC_reshop.chat;

public class ChatMessageVO {
	private String writer;
	private String body;
	
	public ChatMessageVO() {
		
	}
	
	public ChatMessageVO(String writer, String body) {
		this.writer = writer;
		this.body = body;
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
