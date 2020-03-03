package com.shopping.MVC_reshop;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class MainController { //메인 페이지 컨트롤러
	
	private static final Logger logger = LoggerFactory.getLogger(MainController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/wiz_want", method = RequestMethod.GET)
	public String home() {

		System.out.println("메인페이지로 이동");
		return "/main/wiz_want_main";
	}
	
}
