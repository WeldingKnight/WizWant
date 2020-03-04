package com.shopping.view.mypage;

import org.springframework.web.bind.annotation.RequestMapping;

public class MypageController {
	
	@RequestMapping("/mypage.do")
	public String mypage() {
		
		System.out.println("마이페이지로 이동");
		return "/views/mypage/mypage_main.jsp";
	}
}