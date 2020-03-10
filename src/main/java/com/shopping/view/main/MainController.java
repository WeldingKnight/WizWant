package com.shopping.view.main;


import javax.servlet.http.HttpSession;


import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.shopping.MVC_reshop.user.UserDAO;
import com.shopping.MVC_reshop.user.UserVO;


/**
 * Handles requests for the application home page.
 */
@Controller
public class MainController { //메인 페이지 컨트롤러
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping("/wiz_want.do")
	public String main(HttpSession session) {
		
		System.out.println("메인페이지로 이동");
	
		return "/views/main/wiz_want_main.jsp";
	}
	
	
	
	
}
