package com.shopping.view.customer;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CustomerController {
	
	@RequestMapping("customer.do")
	public String Customer() {
		System.out.println("�����ͷ� �̵�");
		return "/views/customer/customer.jsp";
	}
}
