package com.shopping.view.qna;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shopping.MVC_reshop.qna.QnaDAO;
import com.shopping.MVC_reshop.qna.QnaVO;
import com.shopping.MVC_reshop.user.UserDAO;
import com.shopping.MVC_reshop.user.UserVO;

@Controller
public class QnaController {
	
	//��ü �Խñ�
	@RequestMapping("/getQnaList.do")
	public String getQnaList(QnaDAO qna, QnaVO vo, Model model, String searchField, String searchText) {
		System.out.println("�����ͷ� �̵�");
		model.addAttribute("qnaList", qna.getQnaList(searchField, searchText));
		return "/views/qna/getQnaList.jsp";
	}
	
	//�� �󼼺���
	@RequestMapping("/getQna.do")
	public String getQna(QnaDAO qna, QnaVO vo, Model model) {
		System.out.println("�� �󼼺���");
		model.addAttribute("qna",qna.getQna(vo));
		return "/views/qna/getQna.jsp";
	}
	
	//�� �Է�
	@RequestMapping("/insertQna.do")
	public String insertQna(QnaDAO qna, QnaVO vo) {
		System.out.println("���� �Է�");
		qna.insertQna(vo);
		return "/views/qna/insertQna.jsp";
	}
}