package com.app.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="pruchase_tab")
public class PurchaseOrder {

	
	@Id
	@GeneratedValue(generator="purchgen")
	@GenericGenerator(name="purchgen",strategy="increment")
	@Column(name="oid")
	private Integer oid;
	
	@Column(name="ocode")
	private String orderCode;
	
	@Column(name="mode")
	private String ordermode;
	
	
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="whuser_fk")
	private WhUserType vendor;
	
	@Column(name="rfno")
	private String refno;
	
	@Column(name="qc")
	private String qc;
	
	@Column(name="ostatus")
	private String orderstatus;
	
	@Column(name="odesc")
	private String orderdesc;
	
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="sht_fk")
	private ShipmentType ship;

	public PurchaseOrder(Integer oid) {
		super();
		this.oid = oid;
	}

	public PurchaseOrder() {
		super();
	}

	public Integer getOid() {
		return oid;
	}

	public void setOid(Integer oid) {
		this.oid = oid;
	}

	public String getOrderCode() {
		return orderCode;
	}

	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}

	public String getOrdermode() {
		return ordermode;
	}

	public void setOrdermode(String ordermode) {
		this.ordermode = ordermode;
	}

	public WhUserType getVendor() {
		return vendor;
	}

	public void setVendor(WhUserType vendor) {
		this.vendor = vendor;
	}

	public String getRefno() {
		return refno;
	}

	public void setRefno(String refno) {
		this.refno = refno;
	}

	public String getQc() {
		return qc;
	}

	public void setQc(String qc) {
		this.qc = qc;
	}

	public String getOrderstatus() {
		return orderstatus;
	}

	public void setOrderstatus(String orderstatus) {
		this.orderstatus = orderstatus;
	}

	public String getOrderdesc() {
		return orderdesc;
	}

	public void setOrderdesc(String orderdesc) {
		this.orderdesc = orderdesc;
	}

	public ShipmentType getShip() {
		return ship;
	}

	public void setShip(ShipmentType ship) {
		this.ship = ship;
	}

	@Override
	public String toString() {
		return "PurchaseOrder [oid=" + oid + ", orderCode=" + orderCode + ", ordermode=" + ordermode + ", vendor="
				+ vendor + ", refno=" + refno + ", qc=" + qc + ", orderstatus=" + orderstatus + ", orderdesc="
				+ orderdesc + ", ship=" + ship + "]";
	}

	
	
}
