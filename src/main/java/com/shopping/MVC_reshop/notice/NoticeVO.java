package com.shopping.MVC_reshop.notice;

import java.sql.Date;

public class NoticeVO {
	private int notice_id; // id(번호) FK
	private String notice_title; // 제목
	private String notice_content; // 내용
<<<<<<< HEAD
	private Date notice_timestamp;  // 시간
	
=======
	private Date notice_timestamp; // 시간

>>>>>>> branch 'master' of https://github.com/WeldingKnight/WizWant.git
	public int getNotice_id() {
		return notice_id;
	}

	public void setNotice_id(int notice_id) {
		this.notice_id = notice_id;
	}

	public String getNotice_title() {
		return notice_title;
	}

	public void setNotice_title(String notice_title) {
		this.notice_title = notice_title;
	}

	public String getNotice_content() {
		return notice_content;
	}

	public void setNotice_content(String notice_content) {
		this.notice_content = notice_content;
	}

	public Date getNotice_timestamp() {
		return notice_timestamp;
	}

	public void setNotice_timestamp(Date notice_timestamp) {
		this.notice_timestamp = notice_timestamp;
	}

	@Override
	public String toString() {
		return "NoticeVO [notice_id=" + notice_id + ", notice_title=" + notice_title + ", notice_content="
				+ notice_content + ", notice_timestamp=" + notice_timestamp + "]";
	}

<<<<<<< HEAD
	
	
	
	
	
}	
=======
}
>>>>>>> branch 'master' of https://github.com/WeldingKnight/WizWant.git
