package com.example.Billing.System.service;

import com.example.Billing.System.model.InvoiceDTO;

import java.util.UUID;


public interface InvoiceService {

    void createInvoice(InvoiceDTO invoiceDTO);

    void getInvoiceById(UUID id);
}
