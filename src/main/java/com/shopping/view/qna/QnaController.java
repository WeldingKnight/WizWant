package com.shopping.view.qna;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class QnaController {
	
	@RequestMapping("/qna.do")
	public String Customer() {
		System.out.println("�����ͷ� �̵�");
		return "/views/qna/qna.jsp";
	}
}