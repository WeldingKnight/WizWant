package com.shopping.MVC_reshop.product;

import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.shopping.MVC_reshop.common.JDBCUtil;

public class ProductDAO {
	//JDBC 관련
	private Connection conn = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;
	
	//SQL 명령어
	private final String BOARD_INSERT = "insert into goods(seller_id, goods_name, goods_detail, goods_quantity,goods_price,goods_id,goods_image,goods_validate,goods_views,goods_kind_b,goods_kind_s) values(?,?,?,?,?,goods_seq.nextval,?,'N',0,?,?)";
	private final String BOARD_UPDATE = "update goods set goods_name=?, goods_detail=?, goods_quantity=?, goods_price=?, goods_image=?, goods_validate=?  where goods_id=?";	
	private final String BOARD_DELETE = "delete goods where goods_id=?";	
	private final String BOARD_GET = "select * from goods where seq=?";
	private final String BOARD_LIST = "select * from goods order by goods_kind_b=? desc";
	
	
	//상품 리스트 출력
	public ProductVO listProduct(ProductVO vo) {
		System.out.println("===> JDBC로 listProduct() 기능처리");
		ProductVO product = null;
		
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(BOARD_LIST);
			stmt.setString(1, vo.getGoods_kind_b());
			stmt.executeUpdate();
			System.out.println("BOARD_LIST : "+BOARD_LIST);
			
			
			//글 상세 가져오기
			stmt = conn.prepareStatement(BOARD_LIST);
			stmt.setString(1, vo.getGoods_kind_b());
			rs= stmt.executeQuery();
			
			if(rs.next()) {
				product = new ProductVO();
				product.setGoods_id(rs.getInt("goods_id"));
				product.setGoods_name(rs.getString("goods_name"));
				product.setGoods_price(rs.getInt("goods_price"));
				product.setGoods_image(rs.getString("goods_price"));
				product.setSeller_id(rs.getString("seller_id"));
				product.setGoods_views(rs.getInt("goods_views"));
			}
			
		}catch(Exception e) {
			System.out.println("listProduct() "+e);
		}finally {
			JDBCUtil.close(rs, stmt, conn);
		}
		return product;
	}
	
	
	//상품 등록
	public void insertProduct(ProductVO vo) {
		System.out.println("===> JDBC로 insertProduct() 기능처리");
		
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(BOARD_INSERT);
			stmt.setString(1, vo.getSeller_id());
			stmt.setString(2, vo.getGoods_name());
			stmt.setString(3, vo.getGoods_detail());
			stmt.setInt(4, vo.getGoods_quantity());
			stmt.setInt(5, vo.getGoods_price());
			stmt.setString(6, vo.getGoods_image());
			stmt.setString(7, vo.getGoods_kind_b());
			stmt.setString(8, vo.getGoods_kind_s());
			stmt.executeUpdate();
			
			System.out.println("상품등록 내용 확인: "+vo.toString());
			File fileupload =new File("D:\\Kangheesoo\\WizWant\\src\\main\\webapp\\img\\product_img"+vo.getGoods_image());
		
		}catch(Exception e) {
			System.out.println("insertProduct()"+e);
		}finally {
			JDBCUtil.close(stmt, conn);
		}
	}
	
	//글 삭제
	public void deleteProduct(ProductVO vo) {
		System.out.println("===> JDBC로 deleteProduct() 기능처리");
		
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(BOARD_DELETE);
			stmt.setInt(1, vo.getGoods_id());
			stmt.executeUpdate();
			
		}catch(Exception e) {
			System.out.println("deleteProduct()"+e);
		}finally {
			JDBCUtil.close(stmt, conn);
		}
	}
	
	//글 수정
	
	public void updateProduct(ProductVO vo) {
		System.out.println("===> JDBC로 updateProduct() 기능처리");
		
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(BOARD_UPDATE);
			stmt.setString(1, vo.getGoods_name());
			stmt.setString(2, vo.getGoods_detail());
			stmt.setInt(3, vo.getGoods_quantity());
			stmt.setInt(4, vo.getGoods_price());
			stmt.setString(5, vo.getGoods_image());
			stmt.setString(6, vo.getGoods_validate());
			stmt.setInt(7, vo.getGoods_id());
			stmt.executeUpdate();
		}catch(Exception e) {
			System.out.println("updateProduct()"+e);
		}finally {
			JDBCUtil.close(stmt, conn);
		}
	}

	public Object getProduct(ProductVO vo) {
		System.out.println("getProduct()");
		// TODO Auto-generated method stub
		return null;
	}
	
}
