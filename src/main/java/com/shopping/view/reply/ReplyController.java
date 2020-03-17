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
		System.out.println("글 수정");//콘솔 확인용
		url = "redirect:/login.do";
		
		int qnaId = Integer.parseInt(request.getParameter("qna_id"));
		System.out.println("qna_id = "+qnaId);
		
		UserVO user = (UserVO)session.getAttribute("loginuser");
		if(user == null) {
			System.out.println("세션 값: "+session.getAttribute("loginuser"));
			System.out.println(url);
		}else {
			
			String role = user.getName();
			if(role.equals("admin")) {
				url ="redirect:/getQna.do?qna_id="+qnaId;
			}
			
			System.out.println(url);
			//보여주기가 아닌 쿼리 실행만 하면 되므로 모델 객체가 불필요함.
			reply.insertReply(vo, qnaId);
		}	
		return url; //실행후 리스트로 이동
	}
}
