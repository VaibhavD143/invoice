package com.example.invoice.controllers;

import com.example.invoice.models.Customer;
import com.example.invoice.models.Invoice;
import com.example.invoice.models.Item;
import com.example.invoice.services.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("invoice")
public class InvoiceController {

    @Autowired
    private InvoiceService invoiceService;

    @GetMapping("/findAll")
    public List<Invoice> findAll(){
        return invoiceService.findAll();
    }

    @PostMapping("/save")
    public Invoice save(@RequestBody Invoice invoice){
        System.out.println(invoice.toString());
        for( Item item : invoice.getItems()){
            System.out.println(item.toString());
        }
        return invoiceService.save(invoice);
    }
}
