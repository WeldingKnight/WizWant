package com.shopping.MVC_reshop.mypage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.shopping.MVC_reshop.common.JDBCUtil;
import com.shopping.MVC_reshop.product.ProductVO;
import com.shopping.MVC_reshop.user.UserVO;

public class MypageDAO {

	private Connection conn = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;

	private final String BOOKMARK = "select * from bookmark_view where user_id=?";
	private final String ORDERS = "select * from orders_view where id=?";
	private final String INSERT_BOOKMARK = "INSERT INTO bookmark (goods_id,bookmark_id,user_id) VALUES (?,bookmark_seq.NEXTVAL,?)";
	private final String DELET_BOOKMARK = "DELETE FROM bookmark WHERE goods_id = ? AND user_id = ?";
	private final String INSERT_CART = "INSERT INTO cart goods_id, cart_quantity, user_id) VALUES (?,?,?)";
	private final String CART = "select * from cart_view where id=?";

	public List<MypageVO> getBookmark(UserVO vo) { // 북마크
		// TODO Auto-generated method stub
		System.out.println("===> JDBC로 listbook() 기능처리");
		List<MypageVO> book = new ArrayList<MypageVO>();
		MypageVO bookmark = null;

		try {
			System.out.println("===> JDBC로 getBookmark() 기능처리");
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(BOOKMARK);

			stmt.setString(1, vo.getId());

			rs = stmt.executeQuery();

			while (rs.next()) {
				bookmark = new MypageVO();
				bookmark.setGoods_id(rs.getInt("goods_id"));
				bookmark.setGoods_name(rs.getString("goods_name"));
				bookmark.setGoods_detail(rs.getString("goods_detail"));
				bookmark.setGoods_price(rs.getInt("goods_price"));
				bookmark.setSeller_id(rs.getString("Seller_id"));
				bookmark.setBookmark_id(rs.getInt("bookmark_id"));
				bookmark.setUser_id(rs.getString("user_id"));
				book.add(bookmark);
			}

		} catch (Exception e) {

		} finally {

			JDBCUtil.close(rs, stmt, conn);
		}
		return book;
	}

	public List<MypageVO> getOders(UserVO vo) { // 주문 내역
		// TODO Auto-generated method stub
		System.out.println("===> JDBC로 listOrder() 기능처리");
		List<MypageVO> order = new ArrayList<MypageVO>();
		MypageVO orders = null;

		try {
			System.out.println("===> JDBC로 getOrder() 기능처리");
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(ORDERS);

			stmt.setString(1, vo.getId());

			rs = stmt.executeQuery();

			while (rs.next()) {
				orders = new MypageVO();
				orders.setGoods_id(rs.getInt("goods_id"));
				orders.setGoods_name(rs.getString("goods_name"));
				orders.setGoods_detail(rs.getString("goods_detail"));
				orders.setGoods_price(rs.getInt("goods_price"));
				orders.setSeller_id(rs.getString("Seller_id"));
				orders.setGoods_image(rs.getString("goods_image"));
				orders.setId(rs.getString("id"));
				order.add(orders);
			}

		} catch (Exception e) {

		} finally {

			JDBCUtil.close(rs, stmt, conn);
		}
		return order;
	}

	public void insertBookmark(UserVO vo, String goods_id) {
		// TODO Auto-generated method stub
		System.out.println("===> JDBC로 InsertBookmark() 기능처리");

		try {
			conn = JDBCUtil.getConnection();
			PreparedStatement pstmt = null;
			pstmt = conn.prepareStatement(INSERT_BOOKMARK);
			pstmt.setString(1, goods_id);
			pstmt.setString(2, vo.getId());
			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			goods_id = null;
			JDBCUtil.close(stmt, conn);
		}

	}

	public void deleteBookmark(UserVO vo, String delete_id) {
		// TODO Auto-generated method stub
		System.out.println("===> JDBC로 deleteBookmark() 기능처리");

		try {
			conn = JDBCUtil.getConnection();
			PreparedStatement pstmt = null;
			pstmt = conn.prepareStatement(DELET_BOOKMARK);
			pstmt.setString(1, delete_id);
			pstmt.setString(2, vo.getId());
			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			delete_id = null;
			JDBCUtil.close(stmt, conn);
		}

	}
	
	public void insertCart(UserVO vo, String goods_id, String goods_quantity) {
		// TODO Auto-generated method stub
		System.out.println("===> JDBC로 InsertCart() 기능처리");

		try {
			conn = JDBCUtil.getConnection();
			PreparedStatement pstmt = null;
			pstmt = conn.prepareStatement(INSERT_CART);
			pstmt.setString(1, goods_id);
			pstmt.setString(2, goods_quantity);
			pstmt.setString(3, vo.getId());
			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			goods_id = null;
			JDBCUtil.close(stmt, conn);
		}

	}

	public Object getCart(UserVO vo) {
		System.out.println("===> JDBC로 listCart() 기능처리");
		List<MypageVO> cartlist = new ArrayList<MypageVO>();
		MypageVO cart = null;

		try {
			System.out.println("===> JDBC로 getCart() 기능처리");
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(CART);

			stmt.setString(1, vo.getId());

			rs = stmt.executeQuery();

			while (rs.next()) {
				cart = new MypageVO();
				cart.setGoods_id(rs.getInt("goods_id"));
				cart.setGoods_name(rs.getString("goods_name"));
				cart.setGoods_detail(rs.getString("goods_detail"));
				cart.setGoods_price(rs.getInt("goods_price"));
				cart.setSeller_id(rs.getString("Seller_id"));
				cart.setBookmark_id(rs.getInt("bookmark_id"));
				cart.setUser_id(rs.getString("user_id"));
				cartlist.add(cart);
			}

		} catch (Exception e) {

		} finally {

			JDBCUtil.close(rs, stmt, conn);
		}
		return cartlist;
	}

	public void deleteCart(UserVO vo, String delete_id) {
		// TODO Auto-generated method stub
		
	}
}
