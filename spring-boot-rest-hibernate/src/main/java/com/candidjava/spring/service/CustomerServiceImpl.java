package com.candidjava.spring.service;

import java.io.IOException;
import java.sql.Blob;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.candidjava.spring.bean.Customer;
import com.candidjava.spring.dao.CustomerDao;


@Service
@Transactional
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	CustomerDao customerDao;

	public void createCustomer(Customer customer) {
		customerDao.save(customer);
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

	public void createCustomerWithImage(Customer customerObject, MultipartFile file) throws IOException {



		int id =(int) customerDao.saveObject(customerObject);

		Blob blob = customerDao.createBlobObject(file);

		if (id > 0) {
			System.out.println(file.getName());
		}
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
