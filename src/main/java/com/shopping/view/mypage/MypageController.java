package com.shopping.view.mypage;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MypageController {

	@RequestMapping("/mypage.do")
	public String mypage() {

		System.out.println("마이페이지로 이동");
		return "/views/mypage/mypage_main.jsp";
	}

	@RequestMapping("/update.do")
	public String update() {

		System.out.println("개인정보수정 페이지로 이동");
		return "/views/mypage/update.jsp";
	}

	@RequestMapping("/bookmark.do")
	public String bookmark() {

		System.out.println("찜목록 페이지로 이동");
		return "/views/mypage/bookmark.jsp";
	}

	@RequestMapping("/orders.do")
	public String orders() {

		System.out.println("주문내역 페이지로 이동");
		return "/views/mypage/orders.jsp";
	}

}
