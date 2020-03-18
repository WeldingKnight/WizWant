package com.shopping.view.product;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shopping.MVC_reshop.product.ProductDAO;
import com.shopping.MVC_reshop.product.ProductVO;
import com.shopping.MVC_reshop.user.UserVO;

@Controller
public class ProductController {
	//��ǰ ����Ʈ ���
	@RequestMapping(value="/listProduct.do", method=RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<String> nextPage(ProductDAO dao, ProductVO vo, @RequestParam("goods") String goods) throws Exception {	
		ObjectMapper mapper = new ObjectMapper();
		HttpHeaders responseHeaders = new HttpHeaders();  //�����ü�� ���� 
		responseHeaders.add("Content-Type", "text/html; charset=utf-8"); //������� �߰�
		List<ProductVO> product = dao.listProduct(goods);
		
		System.out.println("����Ʈ ���� ī�װ� name : " +goods);
		System.out.println("��ϵ� ��ǰ ���� : "+product.size());
	      
		String returnString = mapper.writeValueAsString(product);  //  ��ǰ�� json �������� ��ȯ
		return new ResponseEntity<String>(returnString, responseHeaders, HttpStatus.CREATED);
	}
	
	
	//��ǰ ������ �̵�
	@RequestMapping("/product.do" )
	public String product(HttpServletRequest request,ProductVO vo, ProductDAO productDAO) {
		String Classification = request.getParameter("Classification");
		System.out.println(Classification);
		
		System.out.println("��ǰ�������� �̵�");
		return "/views/product/product.jsp";
	}
	
	
	//�� �� ����
	@RequestMapping("/product_detail.do")
	public String getProduct(ProductVO vo, ProductDAO productDAO, Model model,HttpSession session,HttpServletRequest request) {
		model.addAttribute("product",productDAO.getProduct(vo));
		UserVO user = null;
		String userId = null;
		if(session.getAttribute("loginuser") != null) {
			user = (UserVO)session.getAttribute("loginuser");
			userId = user.getId();
		}
		
		System.out.println("���� ���̵� : "+ userId);
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
	public String insertProduct(ProductVO vo, ProductDAO productDAO, HttpServletRequest request) {
		System.out.println(vo.toString());
		
		
		String area = request.getParameter("seller_area");
		System.out.println(area);
		productDAO.insertProduct(vo);
		productDAO.sellerProduct(vo,area);
		
		
		String fileName = vo.getGoods_image();
		
		String fileuploadurl="C:\\Users\\kosmo-05\\git\\WizWant\\src\\main\\webapp\\img\\product_img\\";
		
		File fileupload= new File(fileuploadurl+fileName);
		
		System.out.println(fileupload);
//		System.out.println(productDAO.getProduct(vo));
		System.out.println("�Ǹ� ��� �� ������������ �̵�");
		return "redirect:/wiz_want.do";
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
	public String deleteProduct(ProductVO vo, ProductDAO productDAO,HttpSession session) {
		productDAO.deleteProduct(vo);
		
		System.out.println("��ǰ ����");
		return "/views/product/product.jsp";
	}
}