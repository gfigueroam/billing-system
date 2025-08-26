package com.example.Billing.System.service;

import com.example.Billing.System.model.InvoiceDTO;
import com.example.Billing.System.repository.InvoiceRepository;
import com.example.Billing.System.repository.UserRepository;
import com.example.Billing.System.repository.entities.Invoice;
import com.example.Billing.System.repository.entities.User;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.function.Function;
import java.util.stream.Collectors;

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
        System.out.println(user);
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
                .map(invoice -> modelMapper.map(invoice, InvoiceDTO.class)) ;
    }
}
