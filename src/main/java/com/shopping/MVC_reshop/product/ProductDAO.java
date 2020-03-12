package com.shopping.MVC_reshop.product;

import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.shopping.MVC_reshop.common.JDBCUtil;

public class ProductDAO {
	//JDBC ����
	private Connection conn = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;
	
	//SQL ��ɾ�
	private final String BOARD_INSERT = "insert into goods(seller_id, goods_name, goods_detail, goods_quantity,goods_price,goods_id,goods_image,goods_validate) values(?,?,?,?,?,goods_seq.nextval,?,'N')";
	private final String BOARD_UPDATE = "update goods set goods_name=?, goods_detail=?, goods_quantity=?, goods_price=?, goods_image=?, goods_validate=?  where goods_id=?";	
	private final String BOARD_DELETE = "delete goods where goods_id=?";	
	private final String BOARD_GET = "select * from goods where seq=?";
	private final String BOARD_LIST = "select * from goods order by seq desc";
	
	//��ǰ ���
	public void insertProduct(ProductVO vo) {
		System.out.println("===> JDBC�� insertProduct() ���ó��");
		
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(BOARD_INSERT);
			stmt.setString(1, vo.getSeller_id());
			stmt.setString(2, vo.getGoods_name());
			stmt.setString(3, vo.getGoods_detail());
			stmt.setInt(4, vo.getGoods_quantity());
			stmt.setInt(5, vo.getGoods_price());
			stmt.setString(6, vo.getGoods_image());	
			stmt.executeUpdate();
			
			System.out.println("��ǰ��� ���� Ȯ��: "+vo.toString());
			File fileupload =new File("D:\\Kangheesoo\\WizWant\\src\\main\\webapp\\img\\product_img"+vo.getGoods_image());
		}catch(Exception e) {
			System.out.println("insertProduct()"+e);
		}finally {
			JDBCUtil.close(stmt, conn);
		}
	}
	
	//�� ����
	public void deleteProduct(ProductVO vo) {
		System.out.println("===> JDBC�� deleteProduct() ���ó��");
		
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
	
	//�� ����
	
	public void updateProduct(ProductVO vo) {
		System.out.println("===> JDBC�� updateProduct() ���ó��");
		
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
		// TODO Auto-generated method stub
		return null;
	}
	
}
