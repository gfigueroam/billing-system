package com.example.Billing.System.controller;

import com.example.Billing.System.model.InvoiceDTO;
import com.example.Billing.System.service.InvoiceService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/invoices")
@AllArgsConstructor
public class InvoiceController {

    @Qualifier("InvoiceServiceImpl")
    private InvoiceService invoiceService;

    @PostMapping("")
    public ResponseEntity<?> createInvoice(@Valid @RequestBody InvoiceDTO invoiceDTO) {
        invoiceService.createInvoice(invoiceDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getInvoiceById(@PathVariable UUID id) {
        try {
            InvoiceDTO invoiceDTO = invoiceService.getInvoiceById(id);
            return new ResponseEntity<>(invoiceDTO,
                    HttpStatus.FOUND);
        } catch (EntityNotFoundException e) {
            return new ResponseEntity<>(e.getMessage(),
                    HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("")
    public ResponseEntity<?> getInvoices() {
        List<InvoiceDTO> invoices = invoiceService.getInvoices();
        return new ResponseEntity<>(invoices,
                HttpStatus.OK);
    }


}
