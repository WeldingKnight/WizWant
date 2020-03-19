package com.shopping.view.main;


import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;


import com.shopping.MVC_reshop.product.ProductDAO;
import com.shopping.MVC_reshop.product.ProductVO;


/**
 * Handles requests for the application home page.
 */
@Controller
public class MainController { //메인 페이지 컨트롤러
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping("/wiz_want.do")
	public String main(HttpSession session, ProductDAO dao,HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		ArrayList<ProductVO> productviewslist = (ArrayList<ProductVO>) dao.Productlistviews(); //조회순으로 상품출력
		ArrayList<ProductVO> productdateslist = (ArrayList<ProductVO>) dao.Productlistdates(); //최신등록순으로 상품출력
		
		
		request.setAttribute("productviewslist", productviewslist);
		request.setAttribute("productdateslist", productdateslist);
		
//		ArrayList<ProductVO> productKindList = productDAO.listKindProduct(kind);
//		
//		request.setAttribute("productKindList", productKindList);
		
		System.out.println("메인페이지로 이동");
	
		return "/views/main/wiz_want_main.jsp";
	}
	
	
	
	
}
