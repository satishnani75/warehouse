package com.app.model;

import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OrderColumn;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.ValueGenerationType;

@Entity
@Table(name="Ordmettab")
public class OrderMethod {

	
	
	@Id
	@GeneratedValue(generator="odrgen")
	@GenericGenerator(name="odrgen", strategy="increment")
	@Column(name="omid")
	private Integer oid;
	
	@Column(name="omode")
	private String orderMode;
	
	@Column(name="ocode")
	private String orderCode;
	
	@Column(name="etype")
	private String exeType;
	
	@Column(name="odsc")
	private String orderDesc;
	
	
	@ElementCollection(fetch=FetchType.EAGER)
	@CollectionTable(name="ordacpttab", joinColumns=@JoinColumn(name="oid"))
	@OrderColumn(name="pos")
	@Column(name="data")
	private List<String> orderAccept;


	public OrderMethod(Integer oid) {
		super();
		this.oid = oid;
	}


	public OrderMethod() {
		super();
	}


	
	
	
	
	
	
	public Integer getOid() {
		return oid;
	}


	public void setOid(Integer oid) {
		this.oid = oid;
	}


	public String getorderMode() {
		return orderMode;
	}


	public void setorderMode(String orderMode) {
		this.orderMode =orderMode;
	}


	public String getOrderCode() {
		return orderCode;
	}


	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}


	public String getExeType() {
		return exeType;
	}


	public void setExeType(String exeType) {
		this.exeType = exeType;
	}


	public String getOrderDesc() {
		return orderDesc;
	}


	public void setOrderDesc(String orderDesc) {
		this.orderDesc = orderDesc;
	}


	public List<String> getOrderAccept() {
		return orderAccept;
	}


	public void setOrderAccept(List<String> orderAccept) {
		this.orderAccept = orderAccept;
	}

 
	@Override
	public String toString() {
		return "OrderMethod [oid=" + oid + ", orderMode=" + orderMode + ", orderCode=" + orderCode + ", exeType="
				+ exeType + ", orderDesc=" + orderDesc + ", orderAccept=" + orderAccept + "]";
	}

	
	
	
}





