package com.example.billing.service;

import com.example.billing.model.InvoiceDTO;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;


public interface InvoiceService {

    void createInvoice(InvoiceDTO invoiceDTO);

    InvoiceDTO getInvoiceById(UUID id) throws EntityNotFoundException;

    Page<InvoiceDTO> getInvoices(Pageable pageable);
}
