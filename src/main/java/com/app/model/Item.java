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
@Table(name="itemtable")
public class Item {
	
	
	
	
	@Id
	@GeneratedValue(generator="itemgen")
	@GenericGenerator(name="itemgen",strategy="increment")
	@Column(name="itemid")
	private Integer id;
	
	@Column(name="icode")
	private String itemcode;
	
	@Column(name="widht")
	private double width;
	
	@Column(name="lenght")
	private double length;
	
	@Column(name="hight")
	private double height;
	
	@Column(name="cost")
	private double cost;
	
	@Column(name="currency")
	private String baseCurrency;
	
	@Column(name="descrp")
	private String descrep;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="uom_fk")
	private Uom uom;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="odm_fk")
	private OrderMethod odm;
	

	public Item() {
		super();
	}

	public Item(Integer id) {
		super();
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getItemcode() {
		return itemcode;
	}

	public void setItemcode(String itemcode) {
		this.itemcode = itemcode;
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public double getLength() {
		return length;
	}

	public void setLength(double length) {
		this.length = length;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public String getBaseCurrency() {
		return baseCurrency;
	}

	public void setBaseCurrency(String baseCurrency) {
		this.baseCurrency = baseCurrency;
	}

	public String getDescrep() {
		return descrep;
	}

	public void setDescrep(String descrep) {
		this.descrep = descrep;
	}

	public Uom getUom() {
		return uom;
	}

	public void setUom(Uom uom) {
		this.uom = uom;
	}

	public OrderMethod getOdm() {
		return odm;
	}

	public void setOdm(OrderMethod odm) {
		this.odm = odm;
	}

	@Override
	public String toString() {
		return "Item [id=" + id + ", itemcode=" + itemcode + ", width=" + width + ", length=" + length + ", height="
				+ height + ", cost=" + cost + ", baseCurrency=" + baseCurrency + ", descrep=" + descrep + ", uom=" + uom
				+ ", odm=" + odm + "]";
	}

	
	

}
