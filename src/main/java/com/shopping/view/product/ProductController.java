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
	
	
	//��ǰ ����Ʈ ���
	@RequestMapping(value="/listProduct.do",method = RequestMethod.GET)
	@ResponseBody
	public void listProduct( ProductDAO dao, ProductVO vo, @RequestParam("goods") String goods, Model model) {
		int idx = goods.indexOf("=");
		String goodsval = goods.substring(idx+1);
		System.out.println("����Ʈ ���� ī�װ� name : " +goodsval);
		List<ProductVO> product = dao.listProduct(goodsval);
		
		model.addAttribute("product",product);
		System.out.println(product.size());
		for(int i=1; i<=product.size(); i++) {
			System.out.println(product);
		}
	}
	
	
	//��Ǫ ������ �̵�
	@RequestMapping("/product.do" )
	public String product(HttpServletRequest request,HttpSession session,ProductVO vo, ProductDAO productDAO) {
		String Classification = request.getParameter("Classification");
		String userId = request.getParameter("userId");
		
		System.out.println(Classification);
		
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
	public String insertProduct(ProductVO vo, ProductDAO productDAO, HttpServletRequest request) {
		System.out.println(vo.toString());
		
		String area = request.getParameter("seller_area");
//		System.out.println(area);
		productDAO.insertProduct(vo);
		productDAO.sellerProduct(vo,area);
		
		String fileuploadurl="D:\\Kangheesoo\\WizWant\\src\\main\\webapp\\img\\product_img";
		File fileupload= new File(fileuploadurl+vo.getGoods_image());
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
	public String deleteProduct(ProductVO vo, ProductDAO productDAO) {
		productDAO.deleteProduct(vo);
		
		System.out.println("��ǰ ����");
		return "/views/product/product.jsp";
	}
}
