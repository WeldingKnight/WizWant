package com.shopping.MVC_reshop.user;

public class UserVO {
	
	private String id; // ���̵�
	private String password; // ��й�ȣ
	private String name; // �̸�
	private String email;//�̸���
	private String sex; //����
	private String birth; //�������
	private String adress; //�ּ�
	
	
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
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
	
	
	@Override
	public String toString() {
		return "UserVO [id=" + id + ", password=" + password + ", name=" + name + ", email=" + email + ", sex=" + sex
				+ ", birth=" + birth + ", adress=" + adress + "]";
	}
	
}
