package com.shopping.view.notice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.shopping.MVC_reshop.notice.NoticeDAO;
import com.shopping.MVC_reshop.notice.NoticeVO;
import com.shopping.MVC_reshop.qna.QnaDAO;
import com.shopping.MVC_reshop.qna.QnaVO;


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
	
	//���� ��� �̵�
	@RequestMapping("/getUpdateNotice.do")
	public String getUpdateNotice(NoticeDAO notice, NoticeVO vo, Model model, HttpSession session) {//DAO,VO �Ű������� �Ѱ��ֱ�, ���Է��� ������ ������X, �𵨰�ü ���ʿ�.
		System.out.println("������������ �̵�"); // �ܼ� Ȯ�ο�
		if(session.getAttribute("loginuser")==null) {
			url = "redirect:/login.do";
			System.out.println("���� ��: "+session.getAttribute("loginuser"));
			System.out.println(url);
		}else {
			url ="/views/notice/updateNotice.jsp";
			System.out.println("url============================"+url);
			//�Է� �޼ҵ�� �����Ͱ� �Է�
			System.out.println("������ �Խñ� ����===============" +notice.getUpdateNotice(vo));
			model.addAttribute("notice", notice.getUpdateNotice(vo));
		}
		return url; //���� �� ����Ʈ�� �̵�
	}
	
	//���� �Ϸ� ����
	@RequestMapping("/updateNotice.do")
	public String updateNotice(NoticeDAO notice, NoticeVO vo, HttpSession session, HttpServletRequest request) {//DAO,VO �Ű������� �Ѱ��ֱ�, ���Է��� ������ ������X, �𵨰�ü ���ʿ�.
		System.out.println("�����Ϸ� �� ���� �޼���===================="); // �ܼ� Ȯ�ο�
		String id = request.getParameter("notice_content");
		System.out.println(request.getParameter("notice_title"));
		System.out.println("===================���� ����Ȯ��!!!!================="+id);
		
		
		if(session.getAttribute("loginuser")==null) {
			url = "redirect:/login.do";
			System.out.println("���� ��: "+session.getAttribute("loginuser"));
			System.out.println(url);
		}else {
			
			notice.updateNotice(vo);
			url ="redirect:/getNoticeList.do";
			System.out.println("�������� ���� url: "+url);
			//�Է� �޼ҵ�� �����Ͱ� �Է�
			System.out.println("������ ����(��������):=============="+notice.getUpdateNotice(vo));
		
		}
		return url; //���� �� ����Ʈ�� �̵�
	}
	//����
	@RequestMapping("/deleteNotice.do")
	public String deleteNotice(NoticeDAO notice, NoticeVO vo, HttpSession session) {
		System.out.println("����");
		if(session.getAttribute("loginuser") != null) {
			url ="redirect:/getNoticeList.do";
			System.out.println(url);
			//�Է� �޼ҵ�� �����Ͱ� �Է�
			System.out.println(vo.toString());
			notice.deleteNotice(vo);
		}else {
			url="redirect:/login.do";
			System.out.println("���� ��: "+session.getAttribute("loginuser"));
			System.out.println(url);
		}
		return url;
	}
}