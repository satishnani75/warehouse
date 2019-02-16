package com.app.model;

import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="user_tab")
public class User {
	
	@Id
	@GeneratedValue(generator="usergen")
	@GenericGenerator(name="usergen",strategy="increment")
	@Column(name="uid")
	private Integer uid;
	
	@Column(name="uname")
	private String uname;
	
	@Column(name="email")
	private String email;
	
	@Column(name="pwd")
	private String pwd;
	
	@Column(name="mbno")
	private String mno;
	 

	@ElementCollection(fetch=FetchType.EAGER)
	@CollectionTable(name="userrole_tab", joinColumns=@JoinColumn(name="uid"))
	//@OrderColumn(name="positon")
	@Column(name="data")
	private Set<String> roles;


	public Integer getUid() {
		return uid;
	}


	public void setUid(Integer uid) {
		this.uid = uid;
	}


	public String getUname() {
		return uname;
	}


	public void setUname(String uname) {
		this.uname = uname;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPwd() {
		return pwd;
	}


	public void setPwd(String pwd) {
		this.pwd = pwd;
	}


	public String getMno() {
		return mno;
	}


	public void setMno(String mno) {
		this.mno = mno;
	}


	public Set<String> getRoles() {
		return roles;
	}


	public void setRoles(Set<String> roles) {
		this.roles = roles;
	}


	public User(Integer uid) {
		super();
		this.uid = uid;
	}


	public User() {
		// TODO Auto-generated constructor stub
	}


	


	@Override
	public String toString() {
		return "User [uid=" + uid + ", uname=" + uname + ", email=" + email + ", pwd=" + pwd + ", mno=" + mno
				+ ", roles=" + roles + "]";
	}



	
	
	
	
	
	
	
	
}
