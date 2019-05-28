
package com.candidjava.spring.bean;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.candidjava.spring.dao.GenericDao;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


/**
 * @author balkrishna
 *
 */
@Entity(name = "ForeignKeyAssoEntity")
@Table(name="Invoice")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Invoice  extends GenericDao{

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="INV_ID", unique = true, nullable = false)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	@Column(name="billNo")
	private String billNo;

	@Column(name="total")
	private int total;

	@Column(name="subTotal")
	private int subTotal;

	@Column(name="shippingCharges")
	private int shippingCharges;

	@Column(name="gstPercentage")
	private int gstPercentage;

	@Column(name="gstAmount")
	private int gstAmount;

	@Column(name="gTotal")
	private int gTotal;

	/*@OneToMany(cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            mappedBy = "invoiceId")
    private List<Row> rows = new ArrayList<>();*/


	@OneToMany(cascade = CascadeType.PERSIST,
            mappedBy = "invoiceId")
    private List<Row> rows = new ArrayList<>();


	public List<Row> getRows() {
		return rows;
	}

	public void setRows(List<Row> rows) {
		this.rows = rows;
	}

	public Invoice(){
		super();
	}

	public Invoice( String billNo, int total, int subTotal, int shippingCharges, int gstPercentage,
			int gstAmount, int gTotal) {
		this.billNo = billNo;
		this.total = total;
		this.subTotal = subTotal;
		this.shippingCharges = shippingCharges;
		this.gstPercentage = gstPercentage;
		this.gstAmount = gstAmount;
		this.gTotal = gTotal;
	}

	/*@OneToMany(fetch=FetchType.LAZY, targetEntity=Row.class, cascade=CascadeType.ALL)
	@JoinColumn(name = "invoiceId", referencedColumnName="INVOICE_ID")
*/


	/*@OneToMany(fetch = FetchType.LAZY, mappedBy = "invoiceId")
    private List<Row> rows;

	public List<Row> getRows() {
		return rows;
	}

	public void setRows(List<Row> rows) {
		this.rows = rows;
	}*/

	public String getBillNo() {
		return billNo;
	}

	public void setBillNo(String billNo) {
		this.billNo = billNo;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getSubTotal() {
		return subTotal;
	}

	public void setSubTotal(int subTotal) {
		this.subTotal = subTotal;
	}

	public int getShippingCharges() {
		return shippingCharges;
	}

	public void setShippingCharges(int shippingCharges) {
		this.shippingCharges = shippingCharges;
	}

	public int getGstPercentage() {
		return gstPercentage;
	}

	public void setGstPercentage(int gstPercentage) {
		this.gstPercentage = gstPercentage;
	}

	public int getGstAmount() {
		return gstAmount;
	}

	public void setGstAmount(int gstAmount) {
		this.gstAmount = gstAmount;
	}

	public int getgTotal() {
		return gTotal;
	}

	public void setgTotal(int gTotal) {
		this.gTotal = gTotal;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
