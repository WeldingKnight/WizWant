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
public class MainController { //메인 페이지 컨트롤러
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping("/wiz_want.do")
	public String main(UserVO vo, UserDAO userdao, HttpSession session) {
		
		System.out.println("메인페이지로 이동");
		
		
		//메인 페이지 이동 시 현재 로그인 상태 체크 하여 로그인 상태 인 경우 회원가입 버튼 출력 x
//		UserVO user  = userdao.getUser(vo);
//		
//		if(user != null) {
//			session.setAttribute("userName", user.getName());
//			System.out.println("로그인성공");
//			return "/getBoardList.do";
//		}else {
//			System.out.println("로그인실패");
//			return "login.jsp";
//		}
		
		
		return "/views/main/wiz_want_main.jsp";
	}
	
}
