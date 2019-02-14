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

/**
 * @author:RAGHU SIR 
 *  Generated F/w:SHWR-Framework 
 */
@Entity
@Table(name = "ordermethodtab")
public final class OrderMethod {
	@Id
	@GeneratedValue(generator="om_gen")
	@GenericGenerator(name="om_gen",strategy="increment")
	@Column(name = "id")
	private Integer id;
	@Column(name = "om_mode")
	private String mode;
	@Column(name = "om_code")
	private String code;
	@Column(name = "om_methd")
	private String methd;
	
	@ElementCollection(fetch=FetchType.EAGER)
	@CollectionTable(name="om_accept_tab",
		joinColumns=@JoinColumn(name="omId"))
	@OrderColumn(name="pos")
	@Column(name="acpt")
	private List<String> accept;
	
	@Column(name = "om_dsc")
	private String dsc;
	public OrderMethod() {
		super();
	}
	public OrderMethod(Integer id) {
		super();
		this.id = id;
	}
	public OrderMethod(Integer id, String mode, String code, String methd, List<String> accept, String dsc) {
		super();
		this.id = id;
		this.mode = mode;
		this.code = code;
		this.methd = methd;
		this.accept = accept;
		this.dsc = dsc;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getMode() {
		return mode;
	}
	public void setMode(String mode) {
		this.mode = mode;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMethd() {
		return methd;
	}
	public void setMethd(String methd) {
		this.methd = methd;
	}
	public List<String> getAccept() {
		return accept;
	}
	public void setAccept(List<String> accept) {
		this.accept = accept;
	}
	public String getDsc() {
		return dsc;
	}
	public void setDsc(String dsc) {
		this.dsc = dsc;
	}
	@Override
	public String toString() {
		return "OrderMethod [id=" + id + ", mode=" + mode + ", code=" + code + ", methd=" + methd + ", accept=" + accept
				+ ", dsc=" + dsc + "]";
	}
	
	
}
