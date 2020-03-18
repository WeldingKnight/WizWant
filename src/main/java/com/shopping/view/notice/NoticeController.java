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

	//전체 게시글
	@RequestMapping("/getNoticeList.do")
	public String getQnaList(NoticeDAO notice, NoticeVO vo, Model model, String searchField, String searchText) {//DAO,VO,Model, String객체(글 검색용) 두개를 매개변수로 넘겨주기
		System.out.println("공지사항으로 이동");//콘솔 확인용
		model.addAttribute("noticeList", notice.getNoticeList(searchField, searchText));
		// 모델 객체에 애드어트리븃 메소드로 키값과 밸류를 넣어준다. 밸류엔 전체게시판 메소드가 주입
		return "/views/notice/getNoticeList.jsp";
	}
	
	//글 상세보기
	@RequestMapping("/getNotice.do")
	public String getNotice(NoticeDAO notice, NoticeVO vo, Model model) {//DAO,VO,Model 매개변수로 넘겨주기
		System.out.println("글 상세보기"); // 콘솔 확인용
		model.addAttribute("notice",notice.getNotice(vo));
		//모델 객체로 키값('qna'), 밸류값('qna.getQna(vo)') 지정하여 넘겨준다.
		return "/views/notice/getNotice.jsp";
	}
	
	//새글 등록 이동
	@RequestMapping("/getInsertNotice.do")
	public String getInsertNotice(NoticeDAO notice, NoticeVO vo, HttpSession session) {//DAO,VO,Model 매개변수로 넘겨주기
		System.out.println("글 등록페이지 이동"); //콘솔확인
		if(session.getAttribute("loginuser") == null) {
			url = "redirect:/login.do";
			System.out.println("세션 값: "+session.getAttribute("loginuser"));
			System.out.println(url);
		}else {
			url ="/views/notice/insertNotice.jsp";
			System.out.println(url);
		}
		return url;
	}
		
	//새글 등록 실행
	@RequestMapping("/insertNotice.do")
	public String insertNotice(NoticeDAO notice, NoticeVO vo, HttpSession session) {//DAO,VO 매개변수로 넘겨주기, 글입력은 보여줄 데이터X, 모델객체 불필요.
		System.out.println("새글 입력"); // 콘솔 확인용
		if(session.getAttribute("loginuser")==null) {
			url = "redirect:/login.do";
			System.out.println("세션 값: "+session.getAttribute("loginuser"));
			System.out.println(url);
		}else {
			url ="redirect:/getNoticeList.do";
			System.out.println(url);
			//입력 메소드로 데이터값 입력
			System.out.println(vo.toString());
			notice.insertNotice(vo);
		}
		return url; //실행 후 리스트로 이동
	}
}