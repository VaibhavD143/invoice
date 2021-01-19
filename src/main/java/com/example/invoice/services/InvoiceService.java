package com.example.invoice.services;

import com.example.invoice.models.Customer;
import com.example.invoice.models.Invoice;
import com.example.invoice.models.Item;
import com.example.invoice.models.Product;
import com.example.invoice.repositories.CustomerRepository;
import com.example.invoice.repositories.InvoiceRepository;
import com.example.invoice.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

@Service
public class InvoiceService {

    @Autowired
    private InvoiceRepository invoiceRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private ProductRepository productRepository;

    public List<Invoice> findAll(){
        return invoiceRepository.findAllByOrderByDateDesc();
    }

    @Transactional
    public Invoice save(Invoice invoice){
        Set<Item> items = invoice.getItems();
//        Set<Item> invoiceItems = new HashSet<>();
        Float totalAmount = 0f;

        for (Item item: items){
            Product product = productRepository.findById(item.getProduct().getId()).orElse(null);
//            invoiceItems.add(new Item(product,item.getQuantity(),item.getAmount()));
            item.setAmount(product.getPrice()*item.getQuantity());
            product.setQuantity(product.getQuantity()-item.getQuantity());
            productRepository.save(product);
            totalAmount+=(item.getAmount());
        }

//        invoice.setItems(invoiceItems);
//        invoice.setDate(new Date(new java.util.Date().getTime()));
        invoice.setInvoiceAmount(totalAmount);

        return invoiceRepository.save(invoice);
    }

}
