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
		
		System.out.println("ȸ������ �������� �̵�");
		return "/views/login&insert/insert.jsp";
	}
	
	@RequestMapping("/login.do")
	public String login(UserVO vo, UserDAO userdao, HttpSession session) {
	
		//session: ���� Ŭ���̾�Ʈ���� �����ϰ� �ִ� ���� �������� �����ϴ� �޸𸮰����̴�.(������ ������)
		UserVO user = userdao.getUser(vo);
		
		if(user != null) {
			session.setAttribute("userName", user.getName());
			System.out.println("�α��μ���");
			return "/views/main/wiz_want_main.jsp";
		}else {
			System.out.println("�α��ν���");
			return "/views/login&insert/login.jsp";
		}
	}
}
