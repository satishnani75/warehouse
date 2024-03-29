package com.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="uom_tab")
public class Uom {

	@Id
	@GeneratedValue(generator="uomgen")
	@GenericGenerator(name="uomgen" , strategy="increment")
	@Column(name="uid")
	private Integer uomId;

	@Column(name="utype")
	private String uomType;


	@Column(name="umode")
	private String uomModel;

	@Column(name="udisc")
	private String dsc;

	public Uom(Integer uomId) {
		super();
		this.uomId = uomId;
	}
	public Uom() {
		super();
	}

	public Integer getUomId() {
		return uomId;
	}
	public void setUomId(Integer uomId) {
		this.uomId = uomId;
	}
	public String getUomType() {
		return uomType;
	}
	public void setUomType(String uomType) {
		this.uomType = uomType;
	}
	public String getUomModel() {
		return uomModel;
	}
	public void setUomModel(String uomModel) {
		this.uomModel = uomModel;
	}
	public String getDsc() {
		return dsc;
	}
	public void setDsc(String dsc) {
		this.dsc = dsc;
	}

	@Override
	public String toString() {
		return "Uom [uomId=" + uomId + ", uomType=" + uomType + ", uomModel=" + uomModel + ", dsc=" + dsc + "]";
	}


}
