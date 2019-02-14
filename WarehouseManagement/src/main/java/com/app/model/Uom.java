package com.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * @author:RAGHU SIR 
 *  Generated F/w:SHWR-Framework 
 */
@Entity
@Table(name = "uomtab")
public final class Uom {
	@Id
	@GeneratedValue(generator="uom_gen")
	@GenericGenerator(name = "uom_gen", strategy = "increment")
	@Column(name = "u_id")
	private Integer id;
	@Column(name = "u_type")
	private String uomType;
	@Column(name = "u_model")
	private String uomModel;
	@Column(name = "u_dsc")
	private String uomDsc;
	
	public Uom() {
		super();
	}
	public Uom(Integer id) {
		super();
		this.id = id;
	}
	public Uom(Integer id, String uomType, String uomModel, String uomDsc) {
		super();
		this.id = id;
		this.uomType = uomType;
		this.uomModel = uomModel;
		this.uomDsc = uomDsc;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
	public String getUomDsc() {
		return uomDsc;
	}
	public void setUomDsc(String uomDsc) {
		this.uomDsc = uomDsc;
	}
	@Override
	public String toString() {
		return "Uom [id=" + id + ", uomType=" + uomType + ", uomModel=" + uomModel + ", uomDsc=" + uomDsc + "]";
	}

}