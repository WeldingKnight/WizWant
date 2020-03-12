package com.shopping.view.user;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.support.RequestContext;

//import com.company.AnnotationMVC.user.UserDAO;
//import com.company.AnnotationMVC.user.UserVO;
import com.shopping.MVC_reshop.HomeController;
import com.shopping.MVC_reshop.user.UserDAO;
import com.shopping.MVC_reshop.user.UserVO;


@Controller
public class LoginOutController {

	@RequestMapping(value = "/login.do",method = RequestMethod.GET)
	public String login_page() {

		System.out.println("�α��� �������� �̵�");
		return "/views/login&insert/login.jsp";
	}


	@RequestMapping(value ="/login.do",method = RequestMethod.POST)
	public String login(UserVO vo, UserDAO userdao, HttpSession session) {
		
		// session: ���� Ŭ���̾�Ʈ���� �����ϰ� �ִ� ���� �������� �����ϴ� �޸𸮰����̴�.(������ ������)
		UserVO user = userdao.getUser(vo);

		if (user != null) {
			
			session.setAttribute("loginuser", user);
//			session.setAttribute("userRole", user.getRole());
		
			System.out.println("�α��μ���");
			
			return "/wiz_want.do";
		} else {
			System.out.println("�α��ν���");
			return "/views/login&insert/login_fail.jsp";
		
		}
	}

	@RequestMapping(value = "/logout.do")
	public String logout(HttpSession session) {

		System.out.println("�α׾ƿ� ����");
		
		if (session!=null) {
			session.invalidate(); // ������ ����� �ߴܽ�Ű��ȿȭ ��Ű�°�
		}

		return "/views/main/wiz_want_main.jsp";

	}
	
}
