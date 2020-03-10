package com.shopping.view.product;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shopping.MVC_reshop.product.ProductDAO;
import com.shopping.MVC_reshop.product.ProductVO;

@Controller
public class ProductController {

	@RequestMapping("/product.do" )
	public String product(HttpServletRequest request,HttpSession session) {
		
		String Classification = request.getParameter("Classification");
		String userId = request.getParameter("userId");
		System.out.println(Classification);
		System.out.println(userId);
		
		System.out.println("상품페이지로 이동");
		return "/views/product/product.jsp";
	}
	
	@RequestMapping("/product.do" )
	public String getProduct(ProductVO vo, ProductDAO productDAO, Model model) {
		model.addAttribute("productList",productDAO.getProduct(vo));
		return "getBoardList.jsp";
	}

	@RequestMapping("/product_detail.do")
	public String product_detail() {

		System.out.println("제품 상세 페이지로 이동");
		return "/views/product/product_detail.jsp";
	}
	@RequestMapping("/product_sale.do")
	public String product_sale() {

		System.out.println("판매 등록 페이지로 이동");
		return "/views/product/product_sale.jsp";
	}
	
	//글 상세 보기
	@RequestMapping("/product_detail.do")
	public String getProdcut_detail(ProductVO vo, ProductDAO productDAO, Model model) {
		model.addAttribute("product",productDAO.getProduct(vo));
		return "getBoard_detail.jsp";
	}
	
	//글 등록
	@RequestMapping("/insertProduct.do")
	public String insertProduct(ProductVO vo, ProductDAO productDAO) {
		productDAO.insertProduct(vo);
		return "product.do";
	}
	
	//글 수정
	@RequestMapping("/updateProduct.do")
	public String updateProduct(ProductVO vo, ProductDAO productDAO) {
		productDAO.updateProduct(vo);
		return "product.jsp";
	}
	
	//글 삭제
	@RequestMapping("/deleteProduct.do")
	public String deleteProduct(ProductVO vo, ProductDAO productDAO) {
		productDAO.deleteProduct(vo);
		return "product.jsp";
	}
}
