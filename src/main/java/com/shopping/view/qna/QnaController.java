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

	//전체 게시글
	@RequestMapping("/getQnaList.do")
	public String getQnaList(QnaDAO qna, QnaVO vo, Model model, HttpServletRequest request, String searchField, String searchText) {//DAO,VO,Model, String객체(글 검색용) 두개를 매개변수로 넘겨주기
		System.out.println("고객센터로 이동");//콘솔 확인용
		model.addAttribute("qnaList", qna.getQnaList(searchField, searchText));
		// 모델 객체에 애드어트리븃 메소드로 키값과 밸류를 넣어준다. 밸류엔 전체게시판 메소드가 주입
		return "/views/qna/getQnaList.jsp";
	}
	
	//분류별 게시글
	@RequestMapping("/getSortList.do")
	public String getSortList(QnaDAO qna, Model model, HttpServletRequest request) {//DAO,VO,Model, String객체(글 검색용) 두개를 매개변수로 넘겨주기
		System.out.println("종류리스트로 이동");//콘솔 확인용
		String sort = request.getParameter("sort");
		System.out.println("sort : "+sort);
		String url = "";
		if(sort.equals("주문결제")) {
			url = "/views/qna/getOrderQna.jsp";
		}else if(sort.equals("배송문의")) {
			url = "/views/qna/getDeliveryQna.jsp";
		}else if(sort.equals("반품환불")) {
			url = "/views/qna/getRefundQna.jsp";
		}else if(sort.equals("상품문의")) {
			url = "/views/qna/getProductQna.jsp";			
		}else{
			url="/views/qna/getQnaList.jsp";
		}
		model.addAttribute("sortList", qna.getSortList(sort));	
		System.out.println(url);
		// 모델 객체에 애드어트리븃 메소드로 키값과 밸류를 넣어준다. 밸류엔 전체게시판 메소드가 주입
		return url;
	}
	
	//글 상세보기
	@RequestMapping("/getQna.do")
	public String getQna(QnaDAO qna, QnaVO vo, ReplyDAO rep, Model model) {//DAO,VO,Model 매개변수로 넘겨주기
		System.out.println("글 상세보기"); // 콘솔 확인용
		model.addAttribute("qna",qna.getQna(vo));
		System.out.println(vo.getQna_id());
		model.addAttribute("rep", rep.getReply(vo.getQna_id()));
	
		//모델 객체로 키값('qna'), 밸류값('qna.getQna(vo)') 지정하여 넘겨준다.
		return "/views/qna/getQna.jsp";
	}

	//글 수정 이동
	@RequestMapping("/getUpdateQna.do")
	public String getUpdateQna(QnaDAO qna, QnaVO vo, Model model, HttpSession session) {//DAO,VO,Model 매개변수로 넘겨주기
		System.out.println("글 수정페이지 이동"); //콘솔확인
		if(session.getAttribute("loginuser") == null) {
			url = "redirect:/login.do";
			System.out.println("세션 값: "+session.getAttribute("loginuser"));
			System.out.println(url);
		}else {
			url ="/views/qna/updateQna.jsp";
			System.out.println(url);
			model.addAttribute("qna", qna.getUpdateQna(vo));
			//모델 객체로 수정 페이지에 정보를 뿌려주기 위한 메소드
		}
		return url;
	}
	
	//글 수정 실행
	@RequestMapping("/updateQna.do")
	public String updateQna(QnaDAO qna, QnaVO vo, HttpSession session) {//DB 연결 객체, 및 데이터 저장객체 넘겨주기
		System.out.println("글 수정");//콘솔 확인용

		if(session.getAttribute("loginuser")==null) {
			url = "redirect:/login.do";
			System.out.println("세션 값: "+session.getAttribute("loginuser"));
			System.out.println(url);
		}else {
			url ="redirect:/getQnaList.do";
			System.out.println(url);
			//보여주기가 아닌 쿼리 실행만 하면 되므로 모델 객체가 불필요함.
			qna.updateQna(vo);
		}	
		return url; //실행후 리스트로 이동
	}
	
	
	//새글 등록 이동
	@RequestMapping("/getInsertQna.do")
	public String getInsertQna(QnaDAO qna, QnaVO vo, HttpSession session) {//DAO,VO,Model 매개변수로 넘겨주기
		System.out.println("글 등록페이지 이동"); //콘솔확인
		if(session.getAttribute("loginuser") == null) {
			url = "redirect:/login.do";
			System.out.println("세션 값: "+session.getAttribute("loginuser"));
			System.out.println(url);
		}else {
			url ="/views/qna/insertQna.jsp";
			System.out.println(url);
		}
		return url;
	}
		
	//새글 등록 실행
	@RequestMapping("/insertQna.do")
	public String insertQna(QnaDAO qna, QnaVO vo, HttpSession session) {//DAO,VO 매개변수로 넘겨주기, 글입력은 보여줄 데이터X, 모델객체 불필요.
		System.out.println("새글 입력"); // 콘솔 확인용
		if(session.getAttribute("loginuser") == null) {
			url = "redirect:/login.do";
			System.out.println("세션 값: "+session.getAttribute("loginuser"));
			System.out.println(url);
		}else {
			url ="redirect:/getQnaList.do";
			System.out.println(url);
			//입력 메소드로 데이터값 입력
			System.out.println(vo.toString());
			qna.insertQna(vo);
		}
		return url; //실행 후 리스트로 이동
	}
	
	//삭제
	@RequestMapping("/deleteQna.do")
	public String deleteQna(QnaDAO qna, QnaVO vo, HttpSession session) {
		System.out.println("삭제");
		if(session.getAttribute("loginuser") != null) {
			url ="redirect:/getQnaList.do";
			System.out.println(url);
			//입력 메소드로 데이터값 입력
			System.out.println(vo.toString());
			qna.deleteQna(vo);
		}else {
			url="redirect:/login.do";
			System.out.println("세션 값: "+session.getAttribute("loginuser"));
			System.out.println(url);
		}
		return url;
	}
	
}