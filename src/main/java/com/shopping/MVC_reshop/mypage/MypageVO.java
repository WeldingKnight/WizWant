package com.shopping.MVC_reshop.mypage;

public class MypageVO {

	private int goods_id; // ��ǰ ��ȣ
	private String goods_name;// ��ǰ ��ȣ
	private String goods_detail;// ��ǰ ����
	private int goods_price;// ��ǰ ����
	private String seller_id; // �Ǹ��� id
	private int bookmark_id; // �ϸ�ũ ��ȣ
	private String user_id;// ���� ���̵�

	public int getGoods_id() {
		return goods_id;
	}

	public void setGoods_id(int goods_id) {
		this.goods_id = goods_id;
	}

	public String getGoods_name() {
		return goods_name;
	}

	public void setGoods_name(String goods_name) {
		this.goods_name = goods_name;
	}

	public String getGoods_detail() {
		return goods_detail;
	}

	public void setGoods_detail(String goods_detail) {
		this.goods_detail = goods_detail;
	}

	public int getGoods_price() {
		return goods_price;
	}

	public void setGoods_price(int goods_price) {
		this.goods_price = goods_price;
	}

	public String getSeller_id() {
		return seller_id;
	}

	public void setSeller_id(String seller_id) {
		this.seller_id = seller_id;
	}

	public int getBookmark_id() {
		return bookmark_id;
	}

	public void setBookmark_id(int bookmark_id) {
		this.bookmark_id = bookmark_id;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String toString() {
		return "MypageVO [goods_id=" + goods_id + ", goods_name=" + goods_name + ", goods_detail=" + goods_detail
				+ ", goods_price=" + goods_price + ", seller_id=" + seller_id + ", bookmark_id=" + bookmark_id
				+ ", user_id=" + user_id + "]";
	}

}
