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

	public List<MypageVO> getBookmark(UserVO vo) { // �ϸ�ũ
		// TODO Auto-generated method stub
		System.out.println("===> JDBC�� listbook() ���ó��");
		List<MypageVO> book = new ArrayList<MypageVO>(); 
		MypageVO bookmark = null;

		try {
			System.out.println("===> JDBC�� getBookmark() ���ó��");
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(BOOKMARK);
			
			stmt.setString(1, vo.getId());

			rs = stmt.executeQuery();

			if (rs.next()) {
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
}
