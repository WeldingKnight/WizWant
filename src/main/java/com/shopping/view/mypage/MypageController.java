package com.shopping.view.mypage;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shopping.MVC_reshop.mypage.MypageDAO;
import com.shopping.MVC_reshop.mypage.MypageVO;
import com.shopping.MVC_reshop.product.ProductDAO;
import com.shopping.MVC_reshop.product.ProductVO;
import com.shopping.MVC_reshop.user.UserDAO;
import com.shopping.MVC_reshop.user.UserVO;

@Controller
public class MypageController {

	@RequestMapping("/mypage.do")
	public String mypage() {

		System.out.println("마이페이지로 이동");
		return "/views/mypage/mypage_main.jsp";
	}

	@RequestMapping("/update.do")
	public String update() {

		System.out.println("개인정보수정 페이지로 이동");
		return "/views/mypage/update.jsp";
	}

	@RequestMapping(value = "/update.do", method = RequestMethod.POST)
	public String update(@RequestParam(value = "name") String name, @RequestParam(value = "password") String password,
			@RequestParam(value = "email") String email, @RequestParam(value = "address") String address,
			@RequestParam(value = "birth") String birth, @RequestParam(value = "sex") String sex,
			@RequestParam(value = "tel") String tel,

			UserDAO dao, UserVO vo, HttpSession session, HttpServletRequest request)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		System.out.println("수정실행");
		UserVO loginuser = (UserVO) session.getAttribute("loginuser");
		System.out.println("이름: " + vo.getName());

		String id = loginuser.getId();
		vo.setId(id);
		vo.setName(name);
		vo.setPassword(password);
		vo.setEmail(email);
		vo.setAddress(address);
		vo.setBirth(birth);
		vo.setSex(sex);
		vo.setTel(tel);
		dao.updateUser(vo);

		System.out.println("회원정보 수정 완료 후 main페이지로 이동");

		session.setAttribute("loginuser", vo);
		return "redirect:/wiz_want.do";

	}

//	@RequestMapping("/bookmark.do")
//	public String bookmark() {
//
//		System.out.println("찜목록 페이지로 이동");
//		return "/views/mypage/bookmark.jsp";
//	}

	@RequestMapping(value = "/bookmark.do", method = RequestMethod.GET)
	public String bookmark(MypageVO mypagevo, UserVO vo, MypageDAO mypagedao, HttpSession session, Model model) {
		
		vo = (UserVO) session.getAttribute("loginuser");
		System.out.println("bookmark test");
		
		//모델 사용
		model.addAttribute("bookmarkList",mypagedao.getBookmark(vo));
		
		System.out.println(mypagedao.getBookmark(vo).toString());
		System.out.println("북마크");

		return "/views/mypage/bookmark.jsp";

	}

}
