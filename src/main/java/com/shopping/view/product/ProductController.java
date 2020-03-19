package com.shopping.view.product;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.shopping.MVC_reshop.product.ProductDAO;
import com.shopping.MVC_reshop.product.ProductVO;
import com.shopping.MVC_reshop.user.UserVO;

@Controller
public class ProductController {
	//상품 리스트 출력
	@RequestMapping(value="/listProduct.do", method=RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<String> nextPage(ProductDAO dao, ProductVO vo, @RequestParam("goods") String goods) throws Exception {
		HttpHeaders responseHeaders = new HttpHeaders();  //헤더객체를 만들어서 
		responseHeaders.add("Content-Type", "text/html; charset=utf-8"); //헤더정보 추가
		List<ProductVO> product = dao.listProduct(goods);
		
		System.out.println("리스트 받을 카테고리 name : " +goods);
		System.out.println("등록된 상품 갯수 : "+product.size());
		
		String result = new Gson().toJson(product);	//  상품을 json 형식으로 변환
		return new ResponseEntity<String>(result, responseHeaders, HttpStatus.CREATED);
	}
	
	
	//상품 페이지 이동
	@RequestMapping("/product.do" )
	public String product(HttpServletRequest request,ProductVO vo, ProductDAO productDAO) {
		String Classification = request.getParameter("Classification");
		System.out.println(Classification);
		
		System.out.println("상품페이지로 이동");
		return "/views/product/product.jsp";
	}
	
	
	//글 상세 보기
	@RequestMapping("/product_detail.do")
	public String getProduct(ProductVO vo, ProductDAO productDAO, Model model,HttpSession session,HttpServletRequest request) {
		
		productDAO.updatecount(vo);  //조회수 증가
		model.addAttribute("product",productDAO.getProduct(vo));
		System.out.println(productDAO.getProduct(vo));
		UserVO user = null;
		String userId = null;
		if(session.getAttribute("loginuser") != null) {
			user = (UserVO)session.getAttribute("loginuser");
			userId = user.getId();
			session.setAttribute("userId", userId);
		}

		System.out.println("유저 아이디 : "+ userId);
		System.out.println("제품 상세 페이지로 이동");
		return "/views/product/product_detail.jsp";	
		
	}
	
	//상품 등록 페이지로 이동
	@RequestMapping(value ="/product_sale.do",method = RequestMethod.GET)
	public String insertProduct() {
		
		
		System.out.println("판매 등록 페이지로 이동");
		return "/views/product/product_sale.jsp";
	}
	
	//상품 등록 후 product 페이지로 이동
	@RequestMapping(value ="/product_sale.do",method = RequestMethod.POST)
	public String insertProduct(ProductVO vo, ProductDAO productDAO, HttpServletRequest request){
		System.out.println(vo.toString());
		
		String area = request.getParameter("seller_area");
		System.out.println(area);
		productDAO.insertProduct(vo);
		productDAO.sellerProduct(vo,area);
		
		System.out.println("판매 등록 후 사진등록 페이지로 이동");
		return "/fileupload.jsp";
	}
	
	//글 수정
	//글 수정페이지로 이동
	@RequestMapping(value ="/updateProduct.do",method = RequestMethod.GET)
	public String updateGoods(ProductVO vo, ProductDAO productDAO, Model model) {
		
		model.addAttribute("product",productDAO.getProduct(vo));
		System.out.println("제품 업데이트페이지로 이동");
		return "/views/product/product_update.jsp";
	}
	
	//글 수정 후 메인 페이지 이동
	@RequestMapping(value ="/updateProduct.do",method = RequestMethod.POST)
	public String updateProduct(ProductVO vo, ProductDAO productDAO) {
		productDAO.updateProduct(vo);
	
		System.out.println(vo.toString());
		System.out.println("메인 페이지로 이동");
		return "redirect:/wiz_want.do";
	}
	
	//글 삭제
	@RequestMapping("/deleteProduct.do")
	public String deleteProduct(ProductVO vo, ProductDAO productDAO) {
		productDAO.deleteProduct(vo);
		
		System.out.println(vo.toString());
		System.out.println("제품 삭제후 메인으로 이동");
		return "redirect:/wiz_want.do";
	}
}