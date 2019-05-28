package com.candidjava.spring.bean;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.candidjava.spring.dao.GenericDao;

@Entity(name = "ForeignKeyAssoEntity")
@Table(name="ROW")
public class Row {


	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	@Column(name="sno")
	private int sno;

	@Column(name="itemDetails")
	private String itemDetails ;

	@Column(name="qty")
	private int qty;

	@Column(name="price")
	private int price;

	@Column(name="amount")
	private int amount;

	/*@Column(name="invoice_id")
    private Long invoiceId;*/

	@ManyToOne(cascade = CascadeType.ALL,
			fetch = FetchType.LAZY)
    @JoinColumn(name = "invoice_id" , referencedColumnName = "INV_ID")
    private Invoice invoiceId;


	/*@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="invoice_id", referencedColumnName="id")
	*/
	/*@Column(name="INV_ID")
    private Long invoiceId;*/

	public Row () {
		super();
	};


	/*Row (int sno, String itemDetails, int qty, int price, int amount, Invoice invoice) {
		this.invoice = invoice;
		this.qty = qty;
		this.price = price;
		this.sno = sno;
		this.itemDetails = itemDetails;
	}*/


	/*public Row(int sno, String itemDetails, int qty, int price, int amount, Invoice invoice) {
		super();
		this.sno = sno;
		this.itemDetails = itemDetails;
		this.qty = qty;
		this.price = price;
		this.amount = amount;
		this.invoice = invoice;
	}*/

	public Row(int sno, String itemDetails, int qty, int price, int amount) {
		super();
		this.sno = sno;
		this.itemDetails = itemDetails;
		this.qty = qty;
		this.price = price;
		this.amount = amount;
	}


	public Row(int sno, String itemDetails, int qty, int price, int amount, Invoice invoiceId) {
		super();
		this.sno = sno;
		this.itemDetails = itemDetails;
		this.qty = qty;
		this.price = price;
		this.amount = amount;
		this.invoiceId = invoiceId;
	}


	public int getSno() {
		return sno;
	}

	/*public Invoice getInvoiceId() {
		return invoiceId;
	}

	public void setInvoiceId(Invoice invoiceId) {
		this.invoiceId = invoiceId;
	}*/

	public void setSno(int sno) {
		this.sno = sno;
	}

	public String getItemDetails() {
		return itemDetails;
	}

	public void setItemDetails(String itemDetails) {
		this.itemDetails = itemDetails;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}


	public Invoice getInvoiceId() {
		return invoiceId;
	}


	public void setInvoiceId(Invoice invoiceId) {
		this.invoiceId = invoiceId;
	}

}
