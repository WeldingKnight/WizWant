package com.shopping.view.reply;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shopping.MVC_reshop.reply.ReplyDAO;
import com.shopping.MVC_reshop.reply.ReplyVO;
import com.shopping.MVC_reshop.user.UserVO;

@Controller
public class ReplyController {
	String url="";
	
	@RequestMapping("/insertReply.do")
	public String insertReply(HttpSession session, ReplyDAO reply, ReplyVO vo, HttpServletRequest request) {
		System.out.println("�� ����");//�ܼ� Ȯ�ο�
		url = "redirect:/login.do";
		
		int qnaId = Integer.parseInt(request.getParameter("qna_id"));
		System.out.println("qna_id = "+qnaId);
		
		UserVO user = (UserVO)session.getAttribute("loginuser");
		if(user == null) {
			System.out.println("���� ��: "+session.getAttribute("loginuser"));
			System.out.println(url);
		}else {
			
			String role = user.getName();
			if(role.equals("admin")) {
				url ="redirect:/getQna.do?qna_id="+qnaId;
			}
			
			System.out.println(url);
			//�����ֱⰡ �ƴ� ���� ���ุ �ϸ� �ǹǷ� �� ��ü�� ���ʿ���.
			reply.insertReply(vo, qnaId);
		}	
		return url; //������ ����Ʈ�� �̵�
	}
}
