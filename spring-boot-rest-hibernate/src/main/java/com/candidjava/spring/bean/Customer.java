
package com.candidjava.spring.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.candidjava.spring.dao.GenericDao;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name="Customer")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Customer  extends GenericDao{

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	@Column(name="name")
	private String name;

	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	public String getGstNo() {
		return gstNo;
	}

	public void setGstNo(String gstNo) {
		this.gstNo = gstNo;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getReferenceBy() {
		return referenceBy;
	}

	public void setReferenceBy(String referenceBy) {
		this.referenceBy = referenceBy;
	}

	public String getLandLine() {
		return landLine;
	}

	public void setLandLine(String landLine) {
		this.landLine = landLine;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@Column(name="country")
	private String country;

	@Column(name="shopName")
	private String shopName;

	@Column(name="gstNo")
	private String gstNo;

	@Column(name="address")
	private String address;

	@Column(name="mobile")
	private String mobile;

	@Column(name="referenceBy")
	private String referenceBy;

	@Column(name="landLine")
	private String landLine;

	@Column(name="pincode")
	private String pincode;

	@Column(name="email")
	private String email;

	@Column(name="state")
	private String state;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

}
