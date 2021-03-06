package com.shopping.MVC_reshop.product;

import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.shopping.MVC_reshop.common.JDBCUtil;

public class ProductDAO {
	// JDBC 관련
	private Connection conn = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;

	// SQL 명령어
	private final String BOARD_INSERT = "insert into goods(seller_id, goods_name, goods_detail, goods_quantity,goods_price,goods_id,goods_image,goods_validate,goods_views,goods_kind_b,goods_kind_s) values(?,?,?,?,?,goods_seq.nextval,?,'N',0,?,?)";
	private final String BOARD_UPDATE = "update goods set goods_name=?, goods_detail=?, goods_quantity=?, goods_price=?, goods_image=?, goods_kind_b=?, goods_kind_s=?  where goods_id=?";
	private final String BOARD_UPDATE_views = "update goods set goods_views=goods_views+1 where goods_id=?";
	private final String BOARD_DELETE = "delete goods where goods_id=?";
	private final String BOARD_GET = "select * from goods where goods_id=?";
	private final String BOARD_SELLER = "insert into seller (seller_id,seller_area) values(?,?)";
	private final String BOARD_SELLER_update = "update seller set seller_area =? where seller_id";
	private String BOARD_LIST = "select * from goods where goods_kind_b like '%'||?||'%' order by goods_id desc";
	private String BOARD_LIST_views = "select * from(select * from goods order by goods_views desc) where rownum<9 "; // 메인에서
																														// 게시글
																														// 조회수
																														// 순으로
																														// 출력
	private String BOARD_LIST_new = "select * from(select * from goods order by goods_date desc) where rownum<9 "; // 최신
																													// 등록
																													// 순으로
																													// 게시글
																													// 출력

	// seller 지역 등록
	public void sellerProduct(ProductVO vo, String area) {
		System.out.println("===> JDBC로 sellerProduct() 기능처리");
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(BOARD_SELLER);
			stmt.setString(1, vo.getSeller_id());
			stmt.setString(2, area);
			stmt.executeUpdate();

		} catch (Exception e) {
			System.out.println("sellerProduct()" + e);
		} finally {
			JDBCUtil.close(stmt, conn);
		}
	}

	// 상품 리스트 출력
	public List<ProductVO> listProduct(String goods) {

		System.out.println("===> JDBC로 listProduct() 기능처리");
		List<ProductVO> product = new ArrayList<ProductVO>();
		ProductVO vo = null;

		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(BOARD_LIST);
			stmt.setString(1, goods);
			rs = stmt.executeQuery();

			while (rs.next()) {
				vo = new ProductVO();
				vo.setGoods_id(rs.getInt("goods_id"));
				vo.setGoods_name(rs.getString("goods_name"));
				vo.setGoods_price(rs.getInt("goods_price"));
				vo.setGoods_image(rs.getString("goods_image"));
				vo.setSeller_id(rs.getString("seller_id"));
				vo.setGoods_views(rs.getInt("goods_views"));
				vo.setGoods_detail(rs.getString("goods_detail"));
				vo.setGoods_quantity(rs.getInt("goods_quantity"));
				product.add(vo);
			}

		} catch (Exception e) {
			System.out.println("listProduct() " + e);
		} finally {
			JDBCUtil.close(rs, stmt, conn);
		}
		return product;
	}

	// 상품 등록
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
			if (vo.getGoods_image().equals("")) {
				stmt.setString(6, "default.jpg");
			} else {
				stmt.setString(6, vo.getGoods_image());
			}

			stmt.setString(7, vo.getGoods_kind_b());
			stmt.setString(8, vo.getGoods_kind_s());
			stmt.executeUpdate();

			System.out.println("상품등록 내용 확인: " + vo.toString());
			File fileupload = new File(
					"D:\\Kangheesoo\\WizWant\\src\\main\\webapp\\img\\product_img" + vo.getGoods_image());

		} catch (Exception e) {
			System.out.println("insertProduct()" + e);
		} finally {
			JDBCUtil.close(stmt, conn);
		}
	}

	// 글 삭제
	public void deleteProduct(ProductVO vo) {
		System.out.println("===> JDBC로 deleteProduct() 기능처리");

		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(BOARD_DELETE);
			stmt.setInt(1, vo.getGoods_id());
			stmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("deleteProduct()" + e);
		} finally {
			JDBCUtil.close(stmt, conn);
		}
	}

	// 글 수정

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
			stmt.setString(6, vo.getGoods_kind_b());
			stmt.setString(7, vo.getGoods_kind_s());
			stmt.setInt(8, vo.getGoods_id());
			stmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("updateProduct()" + e);
		} finally {
			JDBCUtil.close(stmt, conn);
		}
	}

	// 제픔 상세보기
	public Object getProduct(ProductVO vo) {
		System.out.println("===> JDBC로 getProduct() 기능처리");
		ProductVO goods = null;

		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(BOARD_GET);
			stmt.setInt(1, vo.getGoods_id());
			rs = stmt.executeQuery();

			if (rs.next()) {
				goods = new ProductVO();
				goods.setGoods_id(rs.getInt("goods_id"));
				goods.setGoods_name(rs.getString("goods_name"));
				goods.setSeller_id(rs.getString("seller_id"));
				goods.setGoods_price(rs.getInt("goods_price"));
				goods.setGoods_image(rs.getString("goods_image"));
				goods.setGoods_detail(rs.getString("goods_detail"));
				goods.setGoods_quantity(rs.getInt("goods_quantity"));
				goods.setGoods_views(rs.getInt("goods_views"));

				System.out.println(goods.toString());

			}
		} catch (Exception e) {
			System.out.println("getProduct()" + e);
		} finally {
			JDBCUtil.close(rs, stmt, conn);
		}
		return goods;
	}

	// 상품 조회수 카운트
	public void updatecount(ProductVO vo) {
		System.out.println("===> JDBC로 updatecount() 기능처리");
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(BOARD_UPDATE_views);

			stmt.setInt(1, vo.getGoods_id());

			stmt.executeUpdate();

		} catch (Exception e) {
			System.out.println("updatecount()" + e);
		} finally {
			JDBCUtil.close(stmt, conn);
		}
	}

	// 상품 리스트 출력 (메인 조회수 순으로)
	public List<ProductVO> Productlistviews() {

		System.out.println("===> JDBC로 listProduct() 기능처리");
		List<ProductVO> product = new ArrayList<ProductVO>();
		ProductVO vo = null;

		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(BOARD_LIST_views);
			rs = stmt.executeQuery();

			while (rs.next()) {

				vo = new ProductVO();
				vo.setGoods_id(rs.getInt("goods_id"));
				vo.setGoods_name(rs.getString("goods_name"));
				vo.setGoods_price(rs.getInt("goods_price"));
				vo.setGoods_image(rs.getString("goods_image"));
				vo.setSeller_id(rs.getString("seller_id"));
				vo.setGoods_views(rs.getInt("goods_views"));
				vo.setGoods_detail(rs.getString("goods_detail"));
				product.add(vo);
				System.out.println("조회수테스트");

			}

		} catch (Exception e) {
			System.out.println("listProductviews() " + e);
		} finally {
			JDBCUtil.close(rs, stmt, conn);
		}
		return product;
	}

	public List<ProductVO> Productlistdates() {

		System.out.println("===> JDBC로 listProducnew() 기능처리");
		List<ProductVO> product = new ArrayList<ProductVO>();
		ProductVO vo = null;

		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(BOARD_LIST_new);
			rs = stmt.executeQuery();

			while (rs.next()) {

				vo = new ProductVO();
				vo.setGoods_id(rs.getInt("goods_id"));
				vo.setGoods_name(rs.getString("goods_name"));
				vo.setGoods_price(rs.getInt("goods_price"));
				vo.setGoods_image(rs.getString("goods_image"));
				vo.setSeller_id(rs.getString("seller_id"));
				vo.setGoods_views(rs.getInt("goods_views"));
				vo.setGoods_detail(rs.getString("goods_detail"));
				product.add(vo);
				System.out.println("최신등록순테스트");

			}

		} catch (Exception e) {
			System.out.println("listProductviews() " + e);
		} finally {
			JDBCUtil.close(rs, stmt, conn);
		}
		return product;
	}

}
