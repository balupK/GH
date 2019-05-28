package com.candidjava.spring.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.candidjava.spring.bean.Invoice;

@Repository
public interface InvoiceRepository  extends JpaRepository<Invoice, Long> {

	@Query(value = "select max(i.INV_ID) from Invoice i", nativeQuery=true)
    int findInvoiceId();
}
