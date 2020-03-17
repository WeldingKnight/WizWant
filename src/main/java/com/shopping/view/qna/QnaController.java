package com.shopping.view.qna;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shopping.MVC_reshop.qna.QnaDAO;
import com.shopping.MVC_reshop.qna.QnaVO;
import com.shopping.MVC_reshop.reply.ReplyDAO;


@Controller
public class QnaController {
	String url="";

	//��ü �Խñ�
	@RequestMapping("/getQnaList.do")
	public String getQnaList(QnaDAO qna, QnaVO vo, Model model, HttpServletRequest request, String searchField, String searchText) {//DAO,VO,Model, String��ü(�� �˻���) �ΰ��� �Ű������� �Ѱ��ֱ�
		System.out.println("�����ͷ� �̵�");//�ܼ� Ȯ�ο�
		model.addAttribute("qnaList", qna.getQnaList(searchField, searchText));
		// �� ��ü�� �ֵ��Ʈ���� �޼ҵ�� Ű���� ����� �־��ش�. ����� ��ü�Խ��� �޼ҵ尡 ����
		return "/views/qna/getQnaList.jsp";
	}
	
	//�з��� �Խñ�
	@RequestMapping("/getSortList.do")
	public String getSortList(QnaDAO qna, Model model, HttpServletRequest request) {//DAO,VO,Model, String��ü(�� �˻���) �ΰ��� �Ű������� �Ѱ��ֱ�
		System.out.println("��������Ʈ�� �̵�");//�ܼ� Ȯ�ο�
		String sort = request.getParameter("sort");
		System.out.println("sort : "+sort);
		String url = "";
		if(sort.equals("�ֹ�����")) {
			url = "/views/qna/getOrderQna.jsp";
		}else if(sort.equals("��۹���")) {
			url = "/views/qna/getDeliveryQna.jsp";
		}else if(sort.equals("��ǰȯ��")) {
			url = "/views/qna/getRefundQna.jsp";
		}else if(sort.equals("��ǰ����")) {
			url = "/views/qna/getProductQna.jsp";			
		}else{
			url="/views/qna/getQnaList.jsp";
		}
		model.addAttribute("sortList", qna.getSortList(sort));	
		System.out.println(url);
		// �� ��ü�� �ֵ��Ʈ���� �޼ҵ�� Ű���� ����� �־��ش�. ����� ��ü�Խ��� �޼ҵ尡 ����
		return url;
	}
	
	//�� �󼼺���
	@RequestMapping("/getQna.do")
	public String getQna(QnaDAO qna, QnaVO vo, ReplyDAO rep, Model model) {//DAO,VO,Model �Ű������� �Ѱ��ֱ�
		System.out.println("�� �󼼺���"); // �ܼ� Ȯ�ο�
		model.addAttribute("qna",qna.getQna(vo));
		System.out.println(vo.getQna_id());
		model.addAttribute("rep", rep.getReply(vo.getQna_id()));
	
		//�� ��ü�� Ű��('qna'), �����('qna.getQna(vo)') �����Ͽ� �Ѱ��ش�.
		return "/views/qna/getQna.jsp";
	}

	//�� ���� �̵�
	@RequestMapping("/getUpdateQna.do")
	public String getUpdateQna(QnaDAO qna, QnaVO vo, Model model, HttpSession session) {//DAO,VO,Model �Ű������� �Ѱ��ֱ�
		System.out.println("�� ���������� �̵�"); //�ܼ�Ȯ��
		if(session.getAttribute("loginuser") == null) {
			url = "redirect:/login.do";
			System.out.println("���� ��: "+session.getAttribute("loginuser"));
			System.out.println(url);
		}else {
			url ="/views/qna/updateQna.jsp";
			System.out.println(url);
			model.addAttribute("qna", qna.getUpdateQna(vo));
			//�� ��ü�� ���� �������� ������ �ѷ��ֱ� ���� �޼ҵ�
		}
		return url;
	}
	
	//�� ���� ����
	@RequestMapping("/updateQna.do")
	public String updateQna(QnaDAO qna, QnaVO vo, HttpSession session) {//DB ���� ��ü, �� ������ ���尴ü �Ѱ��ֱ�
		System.out.println("�� ����");//�ܼ� Ȯ�ο�

		if(session.getAttribute("loginuser")==null) {
			url = "redirect:/login.do";
			System.out.println("���� ��: "+session.getAttribute("loginuser"));
			System.out.println(url);
		}else {
			url ="redirect:/getQnaList.do";
			System.out.println(url);
			//�����ֱⰡ �ƴ� ���� ���ุ �ϸ� �ǹǷ� �� ��ü�� ���ʿ���.
			qna.updateQna(vo);
		}	
		return url; //������ ����Ʈ�� �̵�
	}
	
	
	//���� ��� �̵�
	@RequestMapping("/getInsertQna.do")
	public String getInsertQna(QnaDAO qna, QnaVO vo, HttpSession session) {//DAO,VO,Model �Ű������� �Ѱ��ֱ�
		System.out.println("�� ��������� �̵�"); //�ܼ�Ȯ��
		if(session.getAttribute("loginuser") == null) {
			url = "redirect:/login.do";
			System.out.println("���� ��: "+session.getAttribute("loginuser"));
			System.out.println(url);
		}else {
			url ="/views/qna/insertQna.jsp";
			System.out.println(url);
		}
		return url;
	}
		
	//���� ��� ����
	@RequestMapping("/insertQna.do")
	public String insertQna(QnaDAO qna, QnaVO vo, HttpSession session) {//DAO,VO �Ű������� �Ѱ��ֱ�, ���Է��� ������ ������X, �𵨰�ü ���ʿ�.
		System.out.println("���� �Է�"); // �ܼ� Ȯ�ο�
		if(session.getAttribute("loginuser") == null) {
			url = "redirect:/login.do";
			System.out.println("���� ��: "+session.getAttribute("loginuser"));
			System.out.println(url);
		}else {
			url ="redirect:/getQnaList.do";
			System.out.println(url);
			//�Է� �޼ҵ�� �����Ͱ� �Է�
			System.out.println(vo.toString());
			qna.insertQna(vo);
		}
		return url; //���� �� ����Ʈ�� �̵�
	}
	
	//����
	@RequestMapping("/deleteQna.do")
	public String deleteQna(QnaDAO qna, QnaVO vo, HttpSession session) {
		System.out.println("����");
		if(session.getAttribute("loginuser") != null) {
			url ="redirect:/getQnaList.do";
			System.out.println(url);
			//�Է� �޼ҵ�� �����Ͱ� �Է�
			System.out.println(vo.toString());
			qna.deleteQna(vo);
		}else {
			url="redirect:/login.do";
			System.out.println("���� ��: "+session.getAttribute("loginuser"));
			System.out.println(url);
		}
		return url;
	}
	
}