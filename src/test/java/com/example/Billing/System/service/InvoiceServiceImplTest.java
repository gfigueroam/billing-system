package com.example.Billing.System.service;

import com.example.Billing.System.model.InvoiceDTO;
import com.example.Billing.System.repository.InvoiceRepository;
import com.example.Billing.System.repository.UserRepository;
import com.example.Billing.System.repository.entities.Invoice;
import com.example.Billing.System.repository.entities.User;
import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class InvoiceServiceImplTest {

    @Spy
    private InvoiceRepository invoiceRepository;

    @Mock
    UserRepository userRepository;
    @Mock
    ModelMapper modelMapper;

    @Captor
    ArgumentCaptor<Invoice> captor;

    @InjectMocks
    InvoiceServiceImpl invoiceService;


    @Test
    void createInvoiceUserNotFound() {
        InvoiceDTO invoiceDTO = new InvoiceDTO();
        Invoice invoice = new Invoice();
        when(modelMapper.map(any(), any())).
                thenReturn(invoice);

        when(userRepository.findById(any())).
                thenReturn(Optional.empty());

        Exception e = assertThrows(EntityNotFoundException.class, () -> invoiceService.createInvoice(invoiceDTO));
        assertEquals("User not found", e.getMessage());
    }

    @Test
    void createInvoiceSuccessfully() {
        Invoice invoice = new Invoice();
        when(modelMapper.map(any(), any())).
                thenReturn(invoice);
        when(userRepository.findById(any())).
                thenReturn(Optional.of(new User()));
        invoiceService.createInvoice(new InvoiceDTO());
        verify(invoiceRepository).save(captor.capture()); //use for spies and captor
        assertEquals(invoice, captor.getValue());

    }

    @Test
    void getInvoiceById() {
    }

    @Test
    void getInvoices() {
    }
    /*@BeforeAll
    void setUp() {

    }

    @BeforeEach
    void setUp() {

    }

    @AfterEach
    void tearDown() {

    }
    */
}