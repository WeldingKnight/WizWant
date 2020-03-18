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
	
	//답글 입력
	@RequestMapping("/insertReply.do")
	public String insertReply(HttpSession session, ReplyDAO reply, ReplyVO vo, HttpServletRequest request) {
		System.out.println("답글 입력");//콘솔 확인용
		url = "redirect:/login.do";
		
		//jsp 페이지에서 넘겨받은 qna_id 값을 리퀘스트 객체에서 불러워서 변수에 담아서 매겨변수로 활용한다.
		int qnaId = Integer.parseInt(request.getParameter("qna_id"));
		System.out.println("qna_id = "+qnaId);
		
		//세션의 로그인한 유저값을 받아서 체크해준다.
		UserVO user = (UserVO)session.getAttribute("loginuser");
		if(user == null) {
			System.out.println("세션 값: "+session.getAttribute("loginuser"));
			System.out.println(url);
		}else {
			
			String role = user.getName();
			if(role.equals("admin")) {
				//qnaId = 리퀘스트에 담은 넘겨받은 QNA글 아이디값.
				//상세페이지의 번호값을 통해서 본래 넘겨받은 페이지로 다시 보내준다. 
				url ="redirect:/getQna.do?qna_id="+qnaId;
			}
			
			System.out.println(url);
			//보여주기가 아닌 쿼리 실행만 하면 되므로 모델 객체가 불필요함.
			reply.insertReply(vo, qnaId);
		}	
		return url; //실행후 리스트로 이동
	}
	
	//답글 삭제
	@RequestMapping("/deleteReply.do")
	public String deleteQna(HttpSession session, ReplyDAO reply, ReplyVO vo, HttpServletRequest request) {
		System.out.println("삭제");
		url = "redirect:/login.do";
		
		//jsp 페이지에서 넘겨받은 qna_id 값을 리퀘스트 객체에서 불러워서 변수에 담아서 매겨변수로 활용한다.

		System.out.println(vo.getQna_id());
		
		//세션의 로그인한 유저값을 받아서 체크해준다.
		UserVO user = (UserVO)session.getAttribute("loginuser");
		if(user == null) {
			System.out.println("세션 값: "+session.getAttribute("loginuser"));
			System.out.println(url);
		}else {
			
			String role = user.getName();
			if(role.equals("admin")) {
				//qnaId = 리퀘스트에 담은 넘겨받은 QNA글 아이디값.
				//상세페이지의 번호값을 통해서 본래 넘겨받은 페이지로 다시 보내준다. 
				url ="redirect:/getQna.do?qna_id="+vo.getQna_id();
				reply.deleteReply(vo);
			}
		}
		return url;
	}
}