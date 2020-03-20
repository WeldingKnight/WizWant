<%@ page import= "java.io.File" %>
<%@ page import= "com.oreilly.servlet.multipart.DefaultFileRenamePolicy" %>
<%@ page import= "com.oreilly.servlet.MultipartRequest" %>
<%@ page import= "com.shopping.MVC_reshop.product.*" %>
<%@ page import= "com.shopping.view.product.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"

    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%;
		String directory = application.getRealPath("./img/product_img/");
	//	String directory = "C:\\Users\\kosmo-05\\git\\WizWant\\src\\main\\webapp\\img\\product_img\\";
		int maxSize = 1024*1024* 100;
		String encoding = "UTF-8";
		
		MultipartRequest multipartReauest
		= new MultipartRequest(request, directory, maxSize, encoding,
				new DefaultFileRenamePolicy());
		
		String fileName = multipartReauest.getOriginalFileName("file");
		String fileRealName = multipartReauest.getFilesystemName("file");
		
		ProductDAO dao = new ProductDAO();
		
		out.write("파일명 : "+ fileName + "<br>");
		out.write("실제 파일명 : "+ fileRealName + "<br>");
		System.out.println("파일 등록 후 메인 페이지로 이동");
		response.sendRedirect("wiz_want.do");
	%>
</body>
</html>