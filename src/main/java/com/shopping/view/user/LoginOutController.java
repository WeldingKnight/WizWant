package com.shopping.view.user;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.web.bind.annotation.RequestMapping;


import com.shopping.MVC_reshop.MainController;

public class LoginOutController {
	
private static final Logger logger = LoggerFactory.getLogger(MainController.class);
	
	
	@RequestMapping("/insert.do")
	public String insert() {
		
		System.out.println("ȸ������ �������� �̵�");
		return "/login&insert/insert.jsp";
	}

}
