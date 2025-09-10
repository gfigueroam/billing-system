package com.example.billing.controller;

import com.example.billing.model.InvoiceDTO;
import com.example.billing.service.InvoiceService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/invoices")
@AllArgsConstructor
public class InvoiceController {

    //@Qualifier("InvoiceServiceImpl")
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

    public ResponseEntity<?> getInvoices(Pageable pageable) {
        Page<InvoiceDTO> invoices = invoiceService.getInvoices(pageable);
        return new ResponseEntity<>(invoices,
                HttpStatus.OK);
    }


}
