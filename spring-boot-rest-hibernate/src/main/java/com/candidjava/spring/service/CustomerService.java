package com.candidjava.spring.service;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.candidjava.spring.bean.Customer;

public interface CustomerService {

	public void createCustomer(Customer customer);

	public List<Customer> getAllCustomers();

	public Customer findById(int id);

	public void update(Customer customer);

	public void delete(int id);

	public void createCustomerWithImage(Customer customerObject, MultipartFile file) throws IOException;
}
