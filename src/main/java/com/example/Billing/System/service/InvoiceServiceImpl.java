package com.example.Billing.System.service;

import com.example.Billing.System.model.InvoiceDTO;
import com.example.Billing.System.repository.InvoiceRepository;
import com.example.Billing.System.repository.entities.Invoice;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;


@Service
public abstract class InvoiceServiceImpl implements InvoiceService {
    private InvoiceRepository repository;

    @Autowired
    private ModelMapper modelMapper;

    public InvoiceServiceImpl(InvoiceRepository invoiceRepository) {
        this.repository = invoiceRepository;

    }

    @Override
    public void createInvoice(InvoiceDTO invoiceDTO) {
        Invoice invoiceEntity = modelMapper.map(invoiceDTO, Invoice.class);
        System.out.println(invoiceEntity.toString());
        repository.save(invoiceEntity);
    }

    @Override
    public void getInvoiceById(UUID id) {
        //.findById
        Invoice invoiceEntity = repository.getReferenceById(id);
        InvoiceDTO invoiceDTO = modelMapper.map(invoiceEntity,InvoiceDTO.class);


    }
}
