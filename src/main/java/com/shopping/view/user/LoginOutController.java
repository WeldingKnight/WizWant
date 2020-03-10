package com.shopping.view.user;



import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//import com.company.AnnotationMVC.user.UserDAO;
//import com.company.AnnotationMVC.user.UserVO;
import com.shopping.MVC_reshop.HomeController;
import com.shopping.MVC_reshop.user.UserDAO;
import com.shopping.MVC_reshop.user.UserVO;
@Controller
public class LoginOutController {
	
private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	
	@RequestMapping("/insert.do")
	public String insert() {
		
		System.out.println("회원가입 페이지로 이동");
		return "/views/login&insert/insert.jsp";
	}
	
	@RequestMapping("/login.do")
	public String login(UserVO vo, UserDAO userdao, HttpSession session) {
	
		//session: 내가 클라이언트에서 접속하고 있는 동안 개인한테 제공하는 메모리공간이다.(예수님 가라사대)
		UserVO user = userdao.getUser(vo);
		
		if(user != null) {
			session.setAttribute("userName", user.getName());
			System.out.println("로그인성공");
			return "/views/main/wiz_want_main.jsp";
		}else {
			System.out.println("로그인실패");
			return "/views/login&insert/login.jsp";
		}
	}
}
