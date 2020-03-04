package com.shopping.view.product;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProductController {

	@RequestMapping("/product.do")
	public String product() {

		System.out.println("��ǰ�������� �̵�");
		return "/views/product/product.jsp";
	}

	@RequestMapping("/product_detail.do")
	public String product_detail() {

		System.out.println("��ǰ �� �������� �̵�");
		return "/views/product/product_detail.jsp";
	}
}
