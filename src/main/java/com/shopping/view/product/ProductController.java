package com.shopping.view.product;

import java.io.File;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
	
	//글 상세 보기
	@RequestMapping("/product_detail.do")
	public String getproduct_detail(ProductVO vo, ProductDAO productDAO, Model model) {
		model.addAttribute("product",productDAO.getProduct(vo));
		
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
		public String insertProduct(ProductVO vo, ProductDAO productDAO) {
			System.out.println(vo.toString());
			productDAO.insertProduct(vo);
			
			String fileuploadurl="D:\\Kangheesoo\\WizWant\\src\\main\\webapp\\img\\product_img";
			File fileupload= new File(fileuploadurl+vo.getGoods_image());
			System.out.println(productDAO.getProduct(vo));
			System.out.println("판매 등록 후 상품 전체 페이지로 이동");
			return "/views/product/product.jsp";
		}

	
	//글 수정
	@RequestMapping("/updateProduct.do")
	public String updateProduct(ProductVO vo, ProductDAO productDAO) {
		productDAO.updateProduct(vo);
		
		System.out.println("제품 업데이트");
		return "/views/product/product.jsp";
	}
	
	//글 삭제
	@RequestMapping("/deleteProduct.do")
	public String deleteProduct(ProductVO vo, ProductDAO productDAO) {
		productDAO.deleteProduct(vo);
		
		System.out.println("제품 삭제");
		return "/views/product/product.jsp";
	}
}
