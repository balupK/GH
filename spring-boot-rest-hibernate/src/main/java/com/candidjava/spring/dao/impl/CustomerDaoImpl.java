package com.candidjava.spring.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.candidjava.spring.bean.Customer;
import com.candidjava.spring.dao.BaseDaoImpl;
import com.candidjava.spring.dao.CustomerDao;

@Repository("customerDao")
public class CustomerDaoImpl extends BaseDaoImpl<Customer> implements CustomerDao{

	public CustomerDaoImpl(SessionFactory sessionfactory) {
		super(sessionfactory);
	}

	@Override
	protected Class<Customer> getEntityClass() {
		// TODO Auto-generated method stub
		return Customer.class;
	}


}
