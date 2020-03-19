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


import com.shopping.MVC_reshop.HomeController;
import com.shopping.MVC_reshop.user.UserDAO;
import com.shopping.MVC_reshop.user.UserVO;


@Controller
public class LoginOutController {

	@RequestMapping(value = "/login.do",method = RequestMethod.GET)
	public String login_page() {

		System.out.println("로그인 페이지로 이동");
		return "/views/login&insert/login.jsp";
	}


	@RequestMapping(value ="/login.do",method = RequestMethod.POST)
	public String login(UserVO vo, UserDAO userdao, HttpSession session) {
		
		// session: 내가 클라이언트에서 접속하고 있는 동안 개인한테 제공하는 메모리공간이다.(예수님 가라사대)
		UserVO user = userdao.getUser(vo);
		

		if (user != null) {
			
			session.setAttribute("loginuser", user); //로그인 정보
			session.setAttribute("role", user.getRole()); //해당 회원의 등급필요

			System.out.println(user.toString());
			
			System.out.println("로그인성공");
			
			return "redirect:wiz_want.do";
		} else {
			System.out.println("로그인실패");
			return "/views/login&insert/login_fail.jsp";
		
		}
	}

	@RequestMapping(value = "/logout.do",method = RequestMethod.GET)
	public String logout(HttpSession session) {

		System.out.println("로그아웃 실행");
		
		if (session!=null) {
			session.invalidate(); // 세션의 기능을 중단시키고무효화 시키는것
		}
		return "redirect:wiz_want.do";
	}
}
