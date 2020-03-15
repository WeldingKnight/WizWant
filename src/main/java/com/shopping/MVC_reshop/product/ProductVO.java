package com.shopping.MVC_reshop.product;

public class ProductVO {

	private String seller_id;		//ȸ�� ���̵�
	private String goods_name;		//��ǰ �̸�
	private String goods_detail;	//��ǰ ����
	private int goods_quantity;		//��ǰ ����
	private int goods_price;		//��ǰ ����
	private int goods_id;			//��ǰ ��ȣ
	private String goods_image;		//��ǰ �̹���
	private String goods_validate;	//��ǰ �Ǹſ���
	private int goods_views;		//��ǰ ��ȸ��
	private String goods_kind_b;	//��ǰ ūī�װ�
	private String goods_kind_s;	//��ǰ ����ī�װ�
	
	public String getSeller_id() {return seller_id;}
	public void setSeller_id(String seller_id) {this.seller_id = seller_id;}
	
	public String getGoods_name() {return goods_name;}
	public void setGoods_name(String goods_name) {this.goods_name = goods_name;}
	
	public String getGoods_detail() {return goods_detail;}
	public void setGoods_detail(String goods_detail) {this.goods_detail = goods_detail;}
	
	public int getGoods_quantity() {return goods_quantity;}
	public void setGoods_quantity(int goods_quantity) {this.goods_quantity = goods_quantity;}
	
	public int getGoods_price() {return goods_price;}
	public void setGoods_price(int goods_price) {this.goods_price = goods_price;}
	
	public int getGoods_id() {return goods_id;}
	public void setGoods_id(int goods_id) {this.goods_id = goods_id;}
	
	public String getGoods_image() {return goods_image;}
	public void setGoods_image(String goods_image) {this.goods_image = goods_image;}
	
	public String getGoods_validate() {return goods_validate;}
	public void setGoods_validate(String goods_validate) {this.goods_validate = goods_validate;}
	
	public int getGoods_views() {return goods_views;}
	public void setGoods_views(int goods_views) {this.goods_views = goods_views;}
	
	public String getGoods_kind_b() {return goods_kind_b;}
	public void setGoods_kind_b(String goods_kind_b) {this.goods_kind_b = goods_kind_b;}
	
	public String getGoods_kind_s() {return goods_kind_s;}
	public void setGoods_kind_s(String goods_kind_s) {this.goods_kind_s = goods_kind_s;}
	
	@Override
	public String toString() {
		return "ProductVO [seller_id=" + seller_id + ", goods_name=" + goods_name + ", goods_detail=" + goods_detail
				+ ", goods_quantity=" + goods_quantity + ", goods_price=" + goods_price + ", goods_id=" + goods_id
				+ ", goods_image=" + goods_image + ", goods_validate=" + goods_validate + ", goods_views=" + goods_views
				+ ", goods_kind_b=" + goods_kind_b + ", goods_kind_s=" + goods_kind_s + "]";
	}
	

	
	
	
}
