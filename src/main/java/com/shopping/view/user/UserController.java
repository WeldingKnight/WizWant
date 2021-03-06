package com.shopping.view.user;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
	
	@RequestMapping(value="/insertidchk.do",method = RequestMethod.GET)
	@ResponseBody
	public String idchk( UserDAO dao, UserVO vo, @RequestParam("insertId") String insert_id) {
		
		UserVO user = dao.isnertIdchk(insert_id);
		System.out.println(user);

		if (user != null) {

			return "1"; //중복된 아이디일 경우
		} else {
		
			return "0"; //중복되지 않은 아이디 일경우 
		
		}
	}
	
	@RequestMapping(value = "/delete.do", method = RequestMethod.GET)
	public String delete(HttpSession session) {
		
	
		Object obj = session.getAttribute("loginuser");
		System.out.println(obj);
		String objtest = (String)obj.toString();
		if(objtest==null) {
			
			System.out.println("session의 값 확인:"+objtest);
			System.out.println("비로그인상태");
			
			return "redirect:/wiz_want.do";
		
		}else {
			
			System.out.println("session의 값 확인:"+objtest);
			System.out.println("회원탈퇴 페이지로 이동");
			return "/views/login&insert/delete.jsp";
		}
	
	
	}
	
	@RequestMapping(value = "/delete.do", method = RequestMethod.POST)
	public String delete(UserDAO dao, UserVO vo, HttpServletRequest request,HttpSession session) throws ServletException,IOException{
		request.setCharacterEncoding("UTF-8");
		
		session.invalidate();
		dao.deleteUser(vo);
		System.out.println("회원탈퇴 후 main페이지로 이동");
	
		
		return "redirect:/wiz_want.do";

	}
	
	
}
