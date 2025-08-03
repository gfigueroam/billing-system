package com.example.Billing.System.controller;

import com.example.Billing.System.service.InvoiceService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/invoice")
public class InvoiceController {

    @Qualifier("InvoiceServiceImpl")
    private InvoiceService invoiceService;

    public InvoiceController(InvoiceService invoiceService){
        this.invoiceService = invoiceService;
    }

    @PostMapping("")
    public ResponseEntity<String> createInvoice(@RequestBody Invoice invoice) {
        invoiceService.createInvoice(invoice);
        return new ResponseEntity<>("test",
                HttpStatus.CREATED);
    }



}
