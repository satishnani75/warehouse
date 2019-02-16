package com.app.model;

import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name="documents_tab")
public class Documents {

	@Id
	@GeneratedValue
	@Column(name="id")
	private Integer fid;
	
	@Column(name="filename")
	private String fname;
	
	@Column(name="data")
	@Lob
	private byte[] fdata;

	public Documents() {
		super();
	}

	public Integer getFid() {
		return fid;
	}

	public void setFid(Integer fid) {
		this.fid = fid;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public byte[] getFdata() {
		return fdata;
	}

	public void setFdata(byte[] fdata) {
		this.fdata = fdata;
	}

	@Override
	public String toString() {
		return "Documents [fid=" + fid + ", fname=" + fname + ", fdata=" + Arrays.toString(fdata) + "]";
	}

	
	
	
}
