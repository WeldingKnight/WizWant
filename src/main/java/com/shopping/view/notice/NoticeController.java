package com.shopping.view.notice;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class NoticeController {
	
	@RequestMapping("/notice.do")
	public String Customer() {
		System.out.println("공지사항으로 이동");
		return "/views/customer/notice.jsp";
	}
}
