package com.shopping.view.mypage;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class MypageController {
	
	
	@RequestMapping("/mypage.do")
	public String mypage() {
		
		System.out.println("������������ �̵�");
		return "/views/mypage/mypage_main.jsp";
	}

}
