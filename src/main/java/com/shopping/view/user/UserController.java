package com.shopping.view.user;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

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
}
