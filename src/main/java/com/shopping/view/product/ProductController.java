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
		
		System.out.println("��ǰ�������� �̵�");
		return "/views/product/product.jsp";
	}
	
	//�� �� ����
	@RequestMapping("/product_detail.do")
	public String getproduct_detail(ProductVO vo, ProductDAO productDAO, Model model) {
		model.addAttribute("product",productDAO.getProduct(vo));
		
		System.out.println("��ǰ �� �������� �̵�");
		return "/views/product/product_detail.jsp";
	}
	
	//��ǰ ��� �������� �̵�
	@RequestMapping(value ="/product_sale.do",method = RequestMethod.GET)
	public String insertProduct() {

		System.out.println("�Ǹ� ��� �������� �̵�");
		return "/views/product/product_sale.jsp";
	}
	

	//��ǰ ��� �� product �������� �̵�
		@RequestMapping(value ="/product_sale.do",method = RequestMethod.POST)
		public String insertProduct(ProductVO vo, ProductDAO productDAO) {
			System.out.println(vo.toString());
			productDAO.insertProduct(vo);
			
			String fileuploadurl="D:\\Kangheesoo\\WizWant\\src\\main\\webapp\\img\\product_img";
			File fileupload= new File(fileuploadurl+vo.getGoods_image());
			System.out.println(productDAO.getProduct(vo));
			System.out.println("�Ǹ� ��� �� ��ǰ ��ü �������� �̵�");
			return "/views/product/product.jsp";
		}

	
	//�� ����
	@RequestMapping("/updateProduct.do")
	public String updateProduct(ProductVO vo, ProductDAO productDAO) {
		productDAO.updateProduct(vo);
		
		System.out.println("��ǰ ������Ʈ");
		return "/views/product/product.jsp";
	}
	
	//�� ����
	@RequestMapping("/deleteProduct.do")
	public String deleteProduct(ProductVO vo, ProductDAO productDAO) {
		productDAO.deleteProduct(vo);
		
		System.out.println("��ǰ ����");
		return "/views/product/product.jsp";
	}
}
