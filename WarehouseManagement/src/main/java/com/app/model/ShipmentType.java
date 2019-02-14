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
@Table(name = "shipmenttypetab")
public final class ShipmentType {
	@Id
	@GeneratedValue(generator="st_gen")
	@GenericGenerator(name = "st_gen", strategy = "increment")
	@Column(name = "id")
	private Integer id;

	@Column(name = "shp_mode")
	private String shipmentMode;
	@Column(name = "shp_code")
	private String shipmentCode;
	@Column(name = "shp_enble")
	private String enableShipment;
	
	@Column(name = "shp_grd")
	private String shipmentGrade;
	@Column(name = "shp_dsc")
	private String shipmentDsc;

	
	public ShipmentType() {
		super();
	}
	public ShipmentType(Integer id) {
		super();
		this.id = id;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getShipmentMode() {
		return shipmentMode;
	}
	public void setShipmentMode(String shipmentMode) {
		this.shipmentMode = shipmentMode;
	}
	public String getShipmentCode() {
		return shipmentCode;
	}
	public void setShipmentCode(String shipmentCode) {
		this.shipmentCode = shipmentCode;
	}
	public String getEnableShipment() {
		return enableShipment;
	}
	public void setEnableShipment(String enableShipment) {
		this.enableShipment = enableShipment;
	}
	public String getShipmentGrade() {
		return shipmentGrade;
	}
	public void setShipmentGrade(String shipmentGrade) {
		this.shipmentGrade = shipmentGrade;
	}
	public String getShipmentDsc() {
		return shipmentDsc;
	}
	public void setShipmentDsc(String shipmentDsc) {
		this.shipmentDsc = shipmentDsc;
	}
	@Override
	public String toString() {
		return "ShipmentType [id=" + id + ", shipmentMode=" + shipmentMode + ", shipmentCode=" + shipmentCode
				+ ", enableShipment=" + enableShipment + ", shipmentGrade=" + shipmentGrade + ", shipmentDsc="
				+ shipmentDsc + "]";
	}

}
