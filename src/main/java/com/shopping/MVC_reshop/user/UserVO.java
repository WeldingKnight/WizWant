package com.shopping.MVC_reshop.user;

public class UserVO {

	private String id; // ���̵�
	private String password; // ��й�ȣ
	private String name; // �̸�
	private String email;// �̸���
	private String tel; // ��ȭ��ȣ
	private String sex; // ����
	private String birth; // �������
	private String address; // �ּ�
	private String role; // ȸ����� ����(0:������,1:����,2:�Ǹ���)

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
		return "�α��� ����: id= " + id + " �̸�: " + name + " password:  " + password;
	}

	@Override
	public String toString() {
		return "UserVO [id=" + id + ", password=" + password + ", name=" + name + ", email=" + email + ", tel=" + tel
				+ ", sex=" + sex + ", birth=" + birth + ", address=" + address + ", role=" + role + "]";
	}



	
	
}
