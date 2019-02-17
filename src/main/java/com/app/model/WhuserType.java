package com.app.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="wh_usertype_tab")
public class WhuserType {


	@Id
	@GeneratedValue(generator="whgen")
	@GenericGenerator(name="whgen", strategy="increment")
	@Column(name="uid")
	private Integer userId;

	@Column(name="usrtype")
	private String utype;

	@Column(name="ucode")
	private String ucode;

	@Column(name="ufor")
	private String userfor;

	@Column(name="email")
	private String email;

	@Column(name="contact")
	private String ucontact;

	@Column(name="idtype")
	private String idType;

	@Column(name="otrid")
	private String otherId;

	@Column(name="idno")
	private String idnumber;

	public WhuserType() {
		super();
	}

	public WhuserType(Integer userId) {
		super();
		this.userId = userId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}



	public String getUcode() {
		return ucode;
	}

	public void setUcode(String ucode) {
		this.ucode = ucode;
	}

	public String getUserfor() {
		return userfor;
	}

	public void setUserfor(String userfor) {
		this.userfor = userfor;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUcontact() {
		return ucontact;
	}

	public void setUcontact(String ucontact) {
		this.ucontact = ucontact;
	}

	public String getIdType() {
		return idType;
	}

	public void setIdType(String idType) {
		this.idType = idType;
	}

	public String getOtherId() {
		return otherId;
	}

	public void setOtherId(String otherId) {
		this.otherId = otherId;
	}

	public String getIdnumber() {
		return idnumber;
	}

	public void setIdnumber(String idnumber) {
		this.idnumber = idnumber;
	}

	public String getUtype() {
		return utype;
	}

	public void setUtype(String utype) {
		this.utype = utype;
	}

	@Override
	public String toString() {
		return "WhUserType [userId=" + userId + ", utype=" + utype + ", ucode=" + ucode + ", userfor=" + userfor
				+ ", email=" + email + ", ucontact=" + ucontact + ", idType=" + idType + ", otherId=" + otherId
				+ ", idnumber=" + idnumber + "]";
	}





}





