package com.candidjava.spring.service;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import com.candidjava.spring.bean.Customer;
import com.candidjava.spring.bean.Invoice;


public interface InvoiceService{

	public void addNewInvoice(Invoice invoice);

	public List<Customer> getAllCustomers();

	public Customer findById(int id);

	public void update(Customer customer);

	public void delete(int id);

}
