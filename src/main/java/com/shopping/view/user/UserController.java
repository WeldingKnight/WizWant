package com.shopping.view.user;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.shopping.MVC_reshop.user.UserDAO;
import com.shopping.MVC_reshop.user.UserVO;

public class UserController {
	

	@RequestMapping(value="/insert.do",method = RequestMethod.GET)
	public String insert() {
		
		System.out.println("ȸ������ �������� �̵�");
		return "/views/login&insert/insert.jsp";
	}
	
	@RequestMapping(value="/insert.do",method = RequestMethod.POST)
	public String insert(UserDAO dao, UserVO vo) {
		
		System.out.println("ȸ������ �Ϸ� �� ������������ �̵�");
		return "/views/main/wiz_want_main.jsp";
	}


}
