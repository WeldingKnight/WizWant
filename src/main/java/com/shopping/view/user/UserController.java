package com.shopping.view.user;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.shopping.MVC_reshop.user.UserDAO;
import com.shopping.MVC_reshop.user.UserVO;

@Controller
public class UserController {

	@RequestMapping(value = "/insert.do", method = RequestMethod.GET)
	public String insert() {

		System.out.println("회원가입 페이지로 이동");
		return "/views/login&insert/insert.jsp";
	}

	@RequestMapping(value = "/insert.do", method = RequestMethod.POST)
	public String insert(UserDAO dao, UserVO vo, HttpServletRequest request) throws ServletException,IOException{
		request.setCharacterEncoding("UTF-8");
		
		System.out.println("이름: "+vo.getName());
		
		
		dao.insertUser(vo);
		
		System.out.println("회원가입 완료 후 main페이지로 이동");
		
		return "redirect:/wiz_want.do";

	}
}
