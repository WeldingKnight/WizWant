package com.shopping.view.product;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProductController {

	@RequestMapping("/product.do")
	public String product() {

		System.out.println("상품페이지로 이동");
		return "/views/product/product.jsp";
	}

	@RequestMapping("/product_detail.do")
	public String product_detail() {

		System.out.println("제품 상세 페이지로 이동");
		return "/views/product/product_detail.jsp";
	}
}
