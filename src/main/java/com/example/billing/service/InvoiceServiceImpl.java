package com.example.billing.service;

import com.example.billing.model.InvoiceDTO;
import com.example.billing.repository.InvoiceRepository;
import com.example.billing.repository.UserRepository;
import com.example.billing.repository.entities.Invoice;
import com.example.billing.repository.entities.User;
import jakarta.persistence.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Slf4j
@Service
public class InvoiceServiceImpl implements InvoiceService {

    private final InvoiceRepository invoiceRepository;
    private final ModelMapper modelMapper;
    private final UserRepository userRepository;

    public InvoiceServiceImpl(InvoiceRepository repository, ModelMapper modelMapper, UserRepository userRepository) {
        this.invoiceRepository = repository;
        this.modelMapper = modelMapper;
        this.userRepository = userRepository;
    }

    @Override
    public void createInvoice(InvoiceDTO invoiceDTO) {
        Invoice invoiceEntity = modelMapper.map(invoiceDTO, Invoice.class);
        invoiceEntity.setId(null);

        Optional<User> user = userRepository.findById(invoiceDTO.getUserId());

        if (user.isEmpty())
            throw new EntityNotFoundException("User not found");
        invoiceRepository.save(invoiceEntity);
    }

    @Override
    public InvoiceDTO getInvoiceById(UUID id) throws EntityNotFoundException {
        Optional<Invoice> invoiceEntity = invoiceRepository.findById(id);
        if (invoiceEntity.isEmpty())
            throw new EntityNotFoundException("Invoice not found");
        return modelMapper.map(invoiceEntity, InvoiceDTO.class);
    }

    @Override
    public Page<InvoiceDTO> getInvoices(Pageable pageable) {
        return invoiceRepository.findAll(pageable)
                .map(invoice -> modelMapper.map(invoice, InvoiceDTO.class));
    }
}
