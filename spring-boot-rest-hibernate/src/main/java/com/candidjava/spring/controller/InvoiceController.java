package com.candidjava.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.candidjava.spring.bean.Customer;
import com.candidjava.spring.bean.Invoice;
import com.candidjava.spring.service.CustomerService;
import com.candidjava.spring.service.InvoiceRepository;
import com.candidjava.spring.service.InvoiceService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value={"/invoice"})
public class InvoiceController {

	@Autowired
	CustomerService customerService;

	@Autowired
	InvoiceService invoiceService;

	@Autowired
	InvoiceRepository invoiceRepository;

	@PostMapping(value="/new",headers="Accept=application/json")
	 public ResponseEntity<String> createCustomer(@RequestBody Invoice invoice){
		/* Row row = new Row();
		 row.setAmount(23);
		 row.setQty(1);
		 List<Row> list = new ArrayList<>();
		 list.add(row);
		 invoice.setRows(list);*/
		 invoiceService.addNewInvoice(invoice);
	     return new ResponseEntity<String>(HttpStatus.OK);
	 }

	 @GetMapping(value="/getinvoiceId", headers="Accept=application/json")
	 public int getInvoiceId() {
	  return invoiceRepository.findInvoiceId();
	 }

	 @GetMapping(value="/getAll", headers="Accept=application/json")
	 public List<Customer> getAllCustomers() {
	  List<Customer> customers=customerService.getAllCustomers();
	  return customers;

	 }

	 @GetMapping(value="/get", headers="Accept=application/json")
	 public Customer getCustomer(@PathVariable("id") int id) {
	  Customer customer=customerService.findById(id);
	  return customer;
	 }

	 @PutMapping(value="/update" , headers="Accept=application/json")
	 public ResponseEntity<String> updateCustomer(@RequestBody Customer customer) {
		customerService.update(customer);
		return new ResponseEntity<String>(HttpStatus.OK);
	 }

	 @DeleteMapping(value="/{id}", headers ="Accept=application/json")
		public ResponseEntity<Customer> deleteUser(@PathVariable("id") int id){
		 Customer customer = customerService.findById(id);
			if (customer == null) {
				return new ResponseEntity<Customer>(HttpStatus.NOT_FOUND);
			}
			customerService.delete(id);
			return new ResponseEntity<Customer>(HttpStatus.NO_CONTENT);
		}


	 /*
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> getUserById(@PathVariable("id") int id) {
        System.out.println("Fetching User with id " + id);
        User user = userService.findById(id);
        if (user == null) {
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }

	 @PostMapping(value="/create",headers="Accept=application/json")
	 public ResponseEntity<String> createUser(@RequestBody User user){
	     System.out.println("Creating User "+user.getName());
	     userService.createUser(user);
	     //HttpHeaders headers = new HttpHeaders();
	     //headers.setLocation(ucBuilder.path("/user/{id}").buildAndExpand(user.getId()).toUri());
	     return new ResponseEntity<String>(HttpStatus.OK);
	 }




	 @GetMapping(value="/get", headers="Accept=application/json")
	 public List<User> getAllUser() {
	  List<User> tasks=userService.getUser();
	  return tasks;

	 }

	@PutMapping(value="/update", headers="Accept=application/json")
	public ResponseEntity<String> updateUser(@RequestBody User currentUser)
	{
		System.out.println("sd");
	User user = userService.findById(currentUser.getId());
	if (user==null) {
		return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
	}
	userService.update(currentUser, currentUser.getId());
	return new ResponseEntity<String>(HttpStatus.OK);
	}

	@DeleteMapping(value="/{id}", headers ="Accept=application/json")
	public ResponseEntity<User> deleteUser(@PathVariable("id") int id){
		User user = userService.findById(id);
		if (user == null) {
			return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
		}
		userService.deleteUserById(id);
		return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
	}

	@PatchMapping(value="/{id}", headers="Accept=application/json")
	public ResponseEntity<User> updateUserPartially(@PathVariable("id") int id, @RequestBody User currentUser){
		User user = userService.findById(id);
		if(user ==null){
			return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
		}
		User usr =	userService.updatePartially(currentUser, id);
		return new ResponseEntity<User>(usr, HttpStatus.OK);
	}*/
}
