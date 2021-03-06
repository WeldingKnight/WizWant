package com.shopping.view.mypage;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.shopping.MVC_reshop.mypage.MypageDAO;
import com.shopping.MVC_reshop.mypage.MypageVO;
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

	// 찜목록 이동
	@RequestMapping(value = "/bookmark.do", method = RequestMethod.GET)
	public String bookmark(@RequestParam(value = "delete_id", required = false) String delete_id,
			@RequestParam(value = "goods_id", required = false) String goods_id, MypageVO mypagevo, UserVO vo,
			UserDAO dao, MypageDAO mypagedao, HttpSession session, HttpServletRequest request, Model model)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		session.getAttribute("loginuser");
		vo = (UserVO) session.getAttribute("loginuser");

		if (vo != null) {
			System.out.println("bookmark test : " + vo);
			System.out.println("받을 아이디 : " + goods_id);
			System.out.println("삭제 아이디 : " + delete_id);

			// 북마크 추가
			if (goods_id != null) {
				System.out.println("받을 아이디 : " + goods_id);
				mypagedao.insertBookmark(vo, goods_id);
				System.out.println("찜목록 추가 실행");
				return "redirect:/product_detail.do?goods_id=" + goods_id;
			}

			if (delete_id != null) {
				System.out.println("삭제 아이디 : " + delete_id);
				mypagedao.deleteBookmark(vo, delete_id);
				System.out.println("찜목록 삭제");
			}

			// 모델 사용
			model.addAttribute("bookmarkList", mypagedao.getBookmark(vo));

			System.out.println(mypagedao.getBookmark(vo).toString());
			System.out.println("찜목록");

			return "/views/mypage/bookmark.jsp";
		} else {
			System.out.println("로그인이 필요합니다.");
			return "/views/login&insert/login.jsp";
		}

	}

	@RequestMapping(value = "/orders.do", method = RequestMethod.GET)
	public String orders(@RequestParam(value = "orders", required = false) String goods_id, MypageVO mypagevo,
			UserVO vo, UserDAO dao, MypageDAO mypagedao, HttpSession session, Model model) {

		vo = (UserVO) session.getAttribute("loginuser");
		if (vo != null) {
			if (goods_id != null) {
				List<String> chkboxList = Arrays.asList(goods_id.split(","));
				mypagedao.insertOrder(vo, chkboxList);
			}

			System.out.println("order test : " + vo);
			// 모델 사용
			model.addAttribute("orderList", mypagedao.getOders(vo));

			System.out.println("주문내역");

			return "/views/mypage/orders.jsp";
		} else {
			System.out.println("로그인이 필요합니다.");
			return "/views/login&insert/login.jsp";
		}
	}

	// 장바구니 추가
	@RequestMapping(value = "/cart.do", method = RequestMethod.GET)
	public String cart(@RequestParam(value = "delete_id", required = false) String delete_id,
			@RequestParam(value = "goods_id", required = false) String goods_id, MypageVO mypagevo, UserVO vo,
			UserDAO dao, MypageDAO mypagedao, HttpSession session, Model model) {

		vo = (UserVO) session.getAttribute("loginuser");

		if (vo != null) {

			System.out.println("cart test : " + vo);

			System.out.println("받을 아이디 : " + goods_id);
			System.out.println("삭제 아이디 : " + delete_id);

			// 장바구니 초가
			if (goods_id != null) {
				System.out.println("받을 아이디 : " + goods_id);
				mypagedao.insertCart(vo, goods_id);
				System.out.println("장바구니 추가");
				return "redirect:/product_detail.do?goods_id=" + goods_id;
			}
			if (delete_id != null) {
				System.out.println("삭제 아이디 : " + delete_id);
				mypagedao.deleteCart(vo, delete_id);
				System.out.println("장바구니 삭제");
			}
			// 모델 사용
			model.addAttribute("cartList", mypagedao.getCart(vo));

			System.out.println(mypagedao.getCart(vo).toString());
			System.out.println("장바구니");

			return "/views/mypage/cart.jsp";
		} else {
			System.out.println("로그인이 필요합니다.");
			return "/views/login&insert/login.jsp";

		}

	}

}
