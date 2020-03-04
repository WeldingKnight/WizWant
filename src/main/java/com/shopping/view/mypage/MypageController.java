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

	@RequestMapping("/update.do")
	public String update() {

		System.out.println("������������ �������� �̵�");
		return "/views/mypage/update.jsp";
	}

	@RequestMapping("/bookmark.do")
	public String bookmark() {

		System.out.println("���� �������� �̵�");
		return "/views/mypage/bookmark.jsp";
	}

	@RequestMapping("/orders.do")
	public String orders() {

		System.out.println("�ֹ����� �������� �̵�");
		return "/views/mypage/orders.jsp";
	}

}
