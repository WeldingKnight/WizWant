package com.shopping.view.notice;


import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shopping.MVC_reshop.notice.NoticeDAO;
import com.shopping.MVC_reshop.notice.NoticeVO;


@Controller
public class NoticeController {
	String url="";

	//��ü �Խñ�
	@RequestMapping("/getNoticeList.do")
	public String getQnaList(NoticeDAO notice, NoticeVO vo, Model model, String searchField, String searchText) {//DAO,VO,Model, String��ü(�� �˻���) �ΰ��� �Ű������� �Ѱ��ֱ�
		System.out.println("������������ �̵�");//�ܼ� Ȯ�ο�
		model.addAttribute("noticeList", notice.getNoticeList(searchField, searchText));
		// �� ��ü�� �ֵ��Ʈ���� �޼ҵ�� Ű���� ����� �־��ش�. ����� ��ü�Խ��� �޼ҵ尡 ����
		return "/views/notice/getNoticeList.jsp";
	}
	
	//�� �󼼺���
	@RequestMapping("/getNotice.do")
	public String getNotice(NoticeDAO notice, NoticeVO vo, Model model) {//DAO,VO,Model �Ű������� �Ѱ��ֱ�
		System.out.println("�� �󼼺���"); // �ܼ� Ȯ�ο�
		model.addAttribute("notice",notice.getNotice(vo));
		//�� ��ü�� Ű��('qna'), �����('qna.getQna(vo)') �����Ͽ� �Ѱ��ش�.
		return "/views/notice/getNotice.jsp";
	}
	
	//���� ��� �̵�
	@RequestMapping("/getInsertNotice.do")
	public String getInsertNotice(NoticeDAO notice, NoticeVO vo, HttpSession session) {//DAO,VO,Model �Ű������� �Ѱ��ֱ�
		System.out.println("�� ��������� �̵�"); //�ܼ�Ȯ��
		if(session.getAttribute("loginuser") == null) {
			url = "redirect:/login.do";
			System.out.println("���� ��: "+session.getAttribute("loginuser"));
			System.out.println(url);
		}else {
			url ="/views/notice/insertNotice.jsp";
			System.out.println(url);
		}
		return url;
	}
		
	//���� ��� ����
	@RequestMapping("/insertNotice.do")
	public String insertNotice(NoticeDAO notice, NoticeVO vo, HttpSession session) {//DAO,VO �Ű������� �Ѱ��ֱ�, ���Է��� ������ ������X, �𵨰�ü ���ʿ�.
		System.out.println("���� �Է�"); // �ܼ� Ȯ�ο�
		if(session.getAttribute("loginuser")==null) {
			url = "redirect:/login.do";
			System.out.println("���� ��: "+session.getAttribute("loginuser"));
			System.out.println(url);
		}else {
			url ="redirect:/getNoticeList.do";
			System.out.println(url);
			//�Է� �޼ҵ�� �����Ͱ� �Է�
			System.out.println(vo.toString());
			notice.insertNotice(vo);
		}
		return url; //���� �� ����Ʈ�� �̵�
	}
}