package com.example.Billing.System.service;

import com.example.Billing.System.model.InvoiceDTO;
import com.example.Billing.System.repository.InvoiceRepository;
import com.example.Billing.System.repository.entities.Invoice;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class InvoiceServiceImpl implements InvoiceService {

    private InvoiceRepository repository;
    private ModelMapper modelMapper;

    @Override
    public void createInvoice(InvoiceDTO invoiceDTO) {
        Invoice invoiceEntity = modelMapper.map(invoiceDTO, Invoice.class);
        System.out.println(invoiceEntity.toString());
        repository.save(invoiceEntity);
    }

    @Override
    public InvoiceDTO getInvoiceById(UUID id) throws EntityNotFoundException {
        Optional<Invoice> invoiceEntity = repository.findById(id);
        if (invoiceEntity.isEmpty())
            throw new EntityNotFoundException("User not found");
        return modelMapper.map(invoiceEntity, InvoiceDTO.class);
    }
}
