package com.example.Billing.System.service;

import com.example.Billing.System.controller.Invoice;
import org.springframework.stereotype.Service;


public interface InvoiceService {

    void createInvoice(Invoice invoice);
}
