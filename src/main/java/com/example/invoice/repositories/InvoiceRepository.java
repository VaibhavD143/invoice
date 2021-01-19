package com.example.invoice.repositories;

import com.example.invoice.models.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InvoiceRepository extends JpaRepository<Invoice,Integer> {
    public List<Invoice> findAllByOrderByIdDesc();
    public List<Invoice> findAllByOrderByDateDesc();

}
