package com.shopping.view.qna;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shopping.MVC_reshop.qna.QnaDAO;
import com.shopping.MVC_reshop.qna.QnaVO;


@Controller
public class QnaController {
	
	//��ü �Խñ�
	@RequestMapping("/getQnaList.do")
	public String getQnaList(QnaDAO qna, QnaVO vo, Model model, String searchField, String searchText) {//DAO,VO,Model, String��ü(�� �˻���) �ΰ��� �Ű������� �Ѱ��ֱ�
		System.out.println("�������ͷ� �̵�");//�ܼ� Ȯ�ο�
		model.addAttribute("qnaList", qna.getQnaList(searchField, searchText));
		// �� ��ü�� �ֵ��Ʈ���� �޼ҵ�� Ű���� ����� �־��ش�. ����� ��ü�Խ��� �޼ҵ尡 ����
		return "/views/qna/getQnaList.jsp";
	}
	
	//�� �󼼺���
	@RequestMapping("/getQna.do")
	public String getQna(QnaDAO qna, QnaVO vo, Model model) {//DAO,VO,Model �Ű������� �Ѱ��ֱ�
		System.out.println("�� �󼼺���"); // �ܼ� Ȯ�ο�
		model.addAttribute("qna",qna.getQna(vo));
		//�� ��ü�� Ű��('qna'), �����('qna.getQna(vo)') �����Ͽ� �Ѱ��ش�.
		return "/views/qna/getQna.jsp";
	}
	
	//�� ���� �̵�
	@RequestMapping("/getUpdateQna.do")
	public String getUpdateQna(QnaDAO qna, QnaVO vo, Model model) {//DAO,VO,Model �Ű������� �Ѱ��ֱ�
		System.out.println("�� ���������� �̵�"); //�ܼ�Ȯ��
		model.addAttribute("qna", qna.getUpdateQna(vo));
		//�� ��ü�� ���� �������� ������ �ѷ��ֱ� ���� �޼ҵ�
		return "/views/qna/updateQna.jsp";
	}
	
	//�� ���� ����
	@RequestMapping("/updateQna.do")
	public String updateQna(QnaDAO qna, QnaVO vo) {//DB ���� ��ü, �� ������ ���尴ü �Ѱ��ֱ�
		System.out.println("�� ����");//�ܼ� Ȯ�ο�
		qna.updateQna(vo);
		//�����ֱⰡ �ƴ� ���� ���ุ �ϸ� �ǹǷ� �� ��ü�� ���ʿ���.
		return "/views/qna/getQnaList.jsp"; //������ ����Ʈ�� �̵�
	}
	
	//�� �Է�
	@RequestMapping("/insertQna.do")
	public String insertQna(QnaDAO qna, QnaVO vo) {//DAO,VO �Ű������� �Ѱ��ֱ�, ���Է��� ������ ������X, �𵨰�ü ���ʿ�.
		System.out.println("���� �Է�"); // �ܼ� Ȯ�ο�
		qna.insertQna(vo);
		//�Է� �޼ҵ�� �����Ͱ� �Է�
		return "/views/qna/getQnaList.jsp"; //������ ����Ʈ�� �̵�
	}
}