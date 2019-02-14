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
@Table(name = "whusertypetab")
public final class WhUserType {
	@Id
	@GeneratedValue(generator="usr_gen")
	@GenericGenerator(name="usr_gen",strategy="increment")
	@Column(name = "id")
	private Integer id;
	@Column(name = "usr_type")
	private String userType;
	@Column(name = "usr_code")
	private String userCode;
	@Column(name = "usr_for")
	private String userFor;
	@Column(name = "usr_email")
	private String userEmail;
	@Column(name = "usr_cntct")
	private String userContact;
	@Column(name = "usr_id_type")
	private String userIdType;
	@Column(name = "usr_if_other")
	private String ifOther;
	@Column(name = "usr_id_num")
	private String userIdNum;
	
	public WhUserType() {
		super();
	}
	public WhUserType(Integer id) {
		super();
		this.id = id;
	}
	public WhUserType(Integer id, String userType, String userCode, String userFor, String userEmail,
			String userContact, String userIdType, String ifOther, String userIdNum) {
		super();
		this.id = id;
		this.userType = userType;
		this.userCode = userCode;
		this.userFor = userFor;
		this.userEmail = userEmail;
		this.userContact = userContact;
		this.userIdType = userIdType;
		this.ifOther = ifOther;
		this.userIdNum = userIdNum;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	public String getUserCode() {
		return userCode;
	}
	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}
	public String getUserFor() {
		return userFor;
	}
	public void setUserFor(String userFor) {
		this.userFor = userFor;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getUserContact() {
		return userContact;
	}
	public void setUserContact(String userContact) {
		this.userContact = userContact;
	}
	public String getUserIdType() {
		return userIdType;
	}
	public void setUserIdType(String userIdType) {
		this.userIdType = userIdType;
	}
	public String getIfOther() {
		return ifOther;
	}
	public void setIfOther(String ifOther) {
		this.ifOther = ifOther;
	}
	public String getUserIdNum() {
		return userIdNum;
	}
	public void setUserIdNum(String userIdNum) {
		this.userIdNum = userIdNum;
	}
	@Override
	public String toString() {
		return "WhUserType [id=" + id + ", userType=" + userType + ", userCode=" + userCode + ", userFor=" + userFor
				+ ", userEmail=" + userEmail + ", userContact=" + userContact + ", userIdType=" + userIdType
				+ ", ifOther=" + ifOther + ", userIdNum=" + userIdNum + "]";
	}
	
		
}
