package com.shopping.view.mypage;

import java.io.IOException;

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

		System.out.println("������������ �̵�");
		return "/views/mypage/mypage_main.jsp";
	}

	@RequestMapping("/update.do")
	public String update() {

		System.out.println("������������ �������� �̵�");
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

		UserVO user = dao.getUser(vo);

		if (user != null) {

			System.out.println("��������");
			UserVO loginuser = (UserVO) session.getAttribute("loginuser");
			System.out.println("�̸�: " + vo.getName());

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

			System.out.println("ȸ������ ���� �Ϸ� �� main�������� �̵�");

			session.setAttribute("loginuser", vo);
			return "redirect:/wiz_want.do";
		} else {
			System.out.println("�α����� �ʿ��մϴ�.");
			return "/views/login&insert/login.jsp";

		}

	}

	// ���� �̵�
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
			System.out.println("���� ���̵� : " + goods_id);
			System.out.println("���� ���̵� : " + delete_id);

			// �ϸ�ũ �߰�
			if (goods_id != null) {
				System.out.println("���� ���̵� : " + goods_id);
				mypagedao.insertBookmark(vo, goods_id);
				System.out.println("���� �߰� ����");

			}

			if (delete_id != null) {
				System.out.println("���� ���̵� : " + delete_id);
				mypagedao.deleteBookmark(vo, delete_id);
				System.out.println("���� ����");
			}

			// �� ���
			model.addAttribute("bookmarkList", mypagedao.getBookmark(vo));

			System.out.println(mypagedao.getBookmark(vo).toString());
			System.out.println("����");

			return "/views/mypage/bookmark.jsp";
		} else {
			System.out.println("�α����� �ʿ��մϴ�.");
			return "/views/login&insert/login.jsp";
		}

	}

	@RequestMapping(value = "/orders.do", method = RequestMethod.GET)
	public String orders(MypageVO mypagevo, UserVO vo, UserDAO dao, MypageDAO mypagedao, HttpSession session,
			Model model) {

		vo = (UserVO) session.getAttribute("loginuser");
		if (vo != null) {
			System.out.println("order test : " + vo);

			// �� ���
			model.addAttribute("orderList", mypagedao.getOders(vo));

			System.out.println("�ֹ�����");

			return "/views/mypage/orders.jsp";
		} else {
			System.out.println("�α����� �ʿ��մϴ�.");
			return "/views/login&insert/login.jsp";

		}
	}

	// ��ٱ��� �߰�
	@RequestMapping(value = "/cart.do", method = RequestMethod.GET)
	public String cart(@RequestParam(value = "delete_id", required = false) String delete_id,
			@RequestParam(value = "goods_id", required = false) String goods_id, MypageVO mypagevo, UserVO vo,
			UserDAO dao, MypageDAO mypagedao, HttpSession session, Model model) {

		vo = (UserVO) session.getAttribute("loginuser");

		if (vo != null) {

			System.out.println("cart test : " + vo);

			System.out.println("���� ���̵� : " + goods_id);
			System.out.println("���� ���̵� : " + delete_id);

			// ��ٱ��� �ʰ�
			if (goods_id != null) {
				System.out.println("���� ���̵� : " + goods_id);
				mypagedao.insertCart(vo, goods_id);
				System.out.println("��ٱ��� �߰�");
			}

			if (delete_id != null) {
				System.out.println("���� ���̵� : " + delete_id);
				mypagedao.deleteCart(vo, delete_id);
				System.out.println("��ٱ��� ����");
			}

			// �� ���
			model.addAttribute("cartList", mypagedao.getCart(vo));

			System.out.println(mypagedao.getCart(vo).toString());
			System.out.println("��ٱ���");

			return "/views/mypage/cart.jsp";
		} else {
			System.out.println("�α����� �ʿ��մϴ�.");
			return "/views/login&insert/login.jsp";

		}

	}

}
