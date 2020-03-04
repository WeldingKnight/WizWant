package com.shopping.MVC_reshop.product;

public class ProductVO {

	private String seller_id;		//회원 아이디
	private String goods_name;		//상품 이름
	private String goods_detail;	//상품 설명
	private Number goods_quantity;	//상품 수량
	private Number goods_price;		//상품 가격
	private Number goods_id;		//상품 번호
	private String goods_image;		//상품 이미지
	private String goods_validate;	//상품 판매여부
	
	public String getSeller_id() {return seller_id;}
	public void setSeller_id(String seller_id) {this.seller_id = seller_id;}
	
	public String getGoods_name() {return goods_name;}
	public void setGoods_name(String goods_name) {this.goods_name = goods_name;}
	
	public String getGoods_detail() {return goods_detail;}
	public void setGoods_detail(String goods_detail) {this.goods_detail = goods_detail;}
	
	public Number getGoods_quantity() {return goods_quantity;}
	public void setGoods_quantity(Number goods_quantity) {this.goods_quantity = goods_quantity;}
	
	public Number getGoods_price() {return goods_price;}
	public void setGoods_price(Number goods_price) {this.goods_price = goods_price;}
	
	public Number getGoods_id() {return goods_id;}
	public void setGoods_id(Number goods_id) {this.goods_id = goods_id;}
	
	public String getGoods_image() {return goods_image;}
	public void setGoods_image(String goods_image) {this.goods_image = goods_image;}
	
	public String getGoods_validate() {return goods_validate;}
	public void setGoods_validate(String goods_validate) {this.goods_validate = goods_validate;}
	
	@Override
	public String toString() {
		return "ProductVO [seller_id=" + seller_id + ", goods_name=" + goods_name + ", goods_detail=" + goods_detail
				+ ", goods_quantity=" + goods_quantity + ", goods_price=" + goods_price + ", goods_id=" + goods_id
				+ ", goods_image=" + goods_image + ", goods_validate=" + goods_validate + "]";
	}
	
	
	
}
