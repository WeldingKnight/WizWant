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
	
	//전체 게시글
	@RequestMapping("/getQnaList.do")
	public String getQnaList(QnaDAO qna, QnaVO vo, Model model, String searchField, String searchText) {//DAO,VO,Model, String객체(글 검색용) 두개를 매개변수로 넘겨주기
		System.out.println("고객센터로 이동");//콘솔 확인용
		model.addAttribute("qnaList", qna.getQnaList(searchField, searchText));
		// 모델 객체에 애드어트리븃 메소드로 키값과 밸류를 넣어준다. 밸류엔 전체게시판 메소드가 주입
		return "/views/qna/getQnaList.jsp";
	}
	
	//글 상세보기
	@RequestMapping("/getQna.do")
	public String getQna(QnaDAO qna, QnaVO vo, Model model) {//DAO,VO,Model 매개변수로 넘겨주기
		System.out.println("글 상세보기"); // 콘솔 확인용
		model.addAttribute("qna",qna.getQna(vo));
		//모델 객체로 키값('qna'), 밸류값('qna.getQna(vo)') 지정하여 넘겨준다.
		return "/views/qna/getQna.jsp";
	}
	
	//글 입력
	@RequestMapping("/insertQna.do")
	public String insertQna(QnaDAO qna, QnaVO vo) {//DAO,VO 매개변수로 넘겨주기, 글입력은 보여줄 데이터X, 모델객체 불필요.
		System.out.println("새글 입력"); // 콘솔 확인용
		qna.insertQna(vo);
		//입력 메소드로 데이터값 입력
		return "/views/qna/insertQna.jsp";
	}
}