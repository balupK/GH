package com.candidjava.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.candidjava.spring.bean.Customer;
import com.candidjava.spring.bean.Invoice;
import com.candidjava.spring.dao.CustomerDao;
import com.candidjava.spring.dao.InvoiceDao;


@Service
@Transactional
public class InvoiceServiceImpl implements InvoiceService{

	@Autowired
	CustomerDao customerDao;

	@Autowired
	InvoiceDao invoiceDao;


	public void addNewInvoice(Invoice invoice) {
		invoiceDao.save(invoice);
	}

	public List<Customer> getAllCustomers() {
		return customerDao.getAll();
	}

	public Customer findById(int id) {
		return customerDao.get(new Long(id));
	}

	public void update(Customer customer) {
		customerDao.update(customer);
	}

	public void delete(int id) {
		Customer customer = findById(id);
		customerDao.delete(customer);
	}


	/*public com.candidjava.spring.bean.Customer findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public com.candidjava.spring.bean.Customer update(com.candidjava.spring.bean.Customer user, int id) {
		// TODO Auto-generated method stub
		return null;
	}
*/
}
