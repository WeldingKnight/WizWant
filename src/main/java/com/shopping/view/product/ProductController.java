package com.shopping.view.product;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shopping.MVC_reshop.product.ProductDAO;
import com.shopping.MVC_reshop.product.ProductVO;

@Controller
public class ProductController {
	
	
	//상품 리스트 출력
	@RequestMapping(value="/listProduct.do",method = RequestMethod.GET)
	@ResponseBody
	public void listProduct( ProductDAO dao, ProductVO vo, @RequestParam("goods") String goods, Model model) {
		int idx = goods.indexOf("=");
		String goodsval = goods.substring(idx+1);
		System.out.println("리스트 받을 카테고리 name : " +goodsval);
		List<ProductVO> product = dao.listProduct(goodsval);
		
		model.addAttribute("product",product);
		System.out.println(product.size());
		for(int i=1; i<=product.size(); i++) {
			System.out.println(product);
		}
	}
	
	
	//상푸 페이지 이동
	@RequestMapping("/product.do" )
	public String product(HttpServletRequest request,HttpSession session,ProductVO vo, ProductDAO productDAO) {
		String Classification = request.getParameter("Classification");
		String userId = request.getParameter("userId");
		
		System.out.println(Classification);
		
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
	public String insertProduct(ProductVO vo, ProductDAO productDAO, HttpServletRequest request) {
		System.out.println(vo.toString());
		
		String area = request.getParameter("seller_area");
//		System.out.println(area);
		productDAO.insertProduct(vo);
		productDAO.sellerProduct(vo,area);
		
		String fileuploadurl="D:\\Kangheesoo\\WizWant\\src\\main\\webapp\\img\\product_img";
		File fileupload= new File(fileuploadurl+vo.getGoods_image());
//		System.out.println(productDAO.getProduct(vo));
		System.out.println("판매 등록 후 메인페이지로 이동");
		return "redirect:/wiz_want.do";
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
