package com.shopping.MVC_reshop.user;

public class UserVO {

	private String id; // 아이디
	private String password; // 비밀번호
	private String name; // 이름
	private String email;// 이메일
	private String tel; // 전화번호
	private String sex; // 성별
	private String birth; // 생년월일
	private String address; // 주소
	private String role; // 회원등급 구분(0:관리자,1:유저,2:판매자)

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String loginString() {
		return "로그인 정보: id= " + id + " 이름: " + name + " password:  " + password;
	}

	@Override
	public String toString() {
		return "UserVO [id=" + id + ", password=" + password + ", name=" + name + ", email=" + email + ", tel=" + tel
				+ ", sex=" + sex + ", birth=" + birth + ", address=" + address + ", role=" + role + "]";
	}



	
	
}
