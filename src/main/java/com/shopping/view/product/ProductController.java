package com.shopping.view.product;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProductController {

	@RequestMapping("/product.do" )
	public String product(HttpServletRequest request,HttpSession session) {
		
		String Classification = request.getParameter("Classification");
		System.out.println(Classification);
		
		System.out.println("��ǰ�������� �̵�");
		return "/views/product/product.jsp";
	}

	@RequestMapping("/product_detail.do")
	public String product_detail() {

		System.out.println("��ǰ �� �������� �̵�");
		return "/views/product/product_detail.jsp";
	}
}
