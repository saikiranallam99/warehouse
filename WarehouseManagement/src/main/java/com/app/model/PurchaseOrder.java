package com.app.model;

import java.lang.Integer;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author:RAGHU SIR 
 *  Generated F/w:SHWR-Framework 
 */
@Entity
@Table(name = "purchaseordertab")
public final class PurchaseOrder {
	@Id
	@GeneratedValue
	@Column(name = "id")
	private Integer id;

	
	public PurchaseOrder() {
		super();
	}

	public PurchaseOrder(Integer id) {
		super();
		this.id = id;
	}
	
}
