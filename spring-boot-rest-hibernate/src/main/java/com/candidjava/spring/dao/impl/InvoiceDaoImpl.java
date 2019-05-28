package com.candidjava.spring.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.candidjava.spring.bean.Invoice;
import com.candidjava.spring.dao.BaseDaoImpl;
import com.candidjava.spring.dao.InvoiceDao;

@Repository("invoiceDao")
public class InvoiceDaoImpl extends BaseDaoImpl<Invoice> implements InvoiceDao{

	public InvoiceDaoImpl(SessionFactory sessionfactory) {
		super(sessionfactory);
	}

	@Override
	protected Class<Invoice> getEntityClass() {
		// TODO Auto-generated method stub
		return Invoice.class;
	}



}
