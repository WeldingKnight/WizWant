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

		System.out.println("ȸ������ �������� �̵�");
		return "/views/login&insert/insert.jsp";
	}

	@RequestMapping(value = "/insert.do", method = RequestMethod.POST)
	public String insert(UserDAO dao, UserVO vo, HttpServletRequest request) throws ServletException,IOException{
		request.setCharacterEncoding("UTF-8");
		
		System.out.println("�̸�: "+vo.getName());
		
		
		dao.insertUser(vo);
		
		System.out.println("ȸ������ �Ϸ� �� main�������� �̵�");
		
		return "redirect:/wiz_want.do";

	}
	
	@RequestMapping(value="/insertidchk.do",method = RequestMethod.GET)
	@ResponseBody
	public String idchk( UserDAO dao, UserVO vo, @RequestParam("insertId") String insert_id) {
		
		UserVO user = dao.isnertIdchk(insert_id);
		System.out.println(user);

		if (user != null) {

			return "1"; //�ߺ��� ���̵��� ���
		} else {
		
			return "0"; //�ߺ����� ���� ���̵� �ϰ�� 
		
		}
	}
	
	@RequestMapping(value = "/delete.do", method = RequestMethod.GET)
	public String delete(HttpSession session) {
		
	
		Object obj = session.getAttribute("loginuser");
		System.out.println(obj);
		String objtest = (String)obj.toString();
		if(objtest==null) {
			
			System.out.println("session�� �� Ȯ��:"+objtest);
			System.out.println("��α��λ���");
			
			return "redirect:/wiz_want.do";
		
		}else {
			
			System.out.println("session�� �� Ȯ��:"+objtest);
			System.out.println("ȸ��Ż�� �������� �̵�");
			return "/views/login&insert/delete.jsp";
		}
	
	
	}
	
	@RequestMapping(value = "/delete.do", method = RequestMethod.POST)
	public String delete(UserDAO dao, UserVO vo, HttpServletRequest request,HttpSession session) throws ServletException,IOException{
		request.setCharacterEncoding("UTF-8");
		
		session.invalidate();
		dao.deleteUser(vo);
		System.out.println("ȸ��Ż�� �� main�������� �̵�");
	
		
		return "redirect:/wiz_want.do";

	}
	
	
}
