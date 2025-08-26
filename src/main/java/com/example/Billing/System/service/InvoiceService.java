package com.example.Billing.System.service;

import com.example.Billing.System.model.InvoiceDTO;
import jakarta.persistence.EntityNotFoundException;

import java.util.List;
import java.util.UUID;


public interface InvoiceService {

    void createInvoice(InvoiceDTO invoiceDTO);

    InvoiceDTO getInvoiceById(UUID id) throws EntityNotFoundException;

    List<InvoiceDTO> getInvoices();
}
