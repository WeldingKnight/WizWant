package com.shopping.view.main;


import javax.servlet.http.HttpSession;


import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;

import com.shopping.MVC_reshop.user.UserDAO;
import com.shopping.MVC_reshop.user.UserVO;


/**
 * Handles requests for the application home page.
 */
@Controller
public class MainController { //���� ������ ��Ʈ�ѷ�
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping("/wiz_want.do")
	public String main(UserVO vo, UserDAO userdao, HttpSession session) {
		
		System.out.println("������������ �̵�");
		
		
		//���� ������ �̵� �� ���� �α��� ���� üũ �Ͽ� �α��� ���� �� ��� ȸ������ ��ư ��� x
//		UserVO user  = userdao.getUser(vo);
//		
//		if(user != null) {
//			session.setAttribute("userName", user.getName());
//			System.out.println("�α��μ���");
//			return "/getBoardList.do";
//		}else {
//			System.out.println("�α��ν���");
//			return "login.jsp";
//		}
		
		
		return "/views/main/wiz_want_main.jsp";
	}
	
}
