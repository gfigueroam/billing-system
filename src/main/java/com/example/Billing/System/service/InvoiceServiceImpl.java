package com.example.Billing.System.service;

import com.example.Billing.System.controller.Invoice;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;


@Service
public class InvoiceServiceImpl implements InvoiceService {


    @Override
    public void createInvoice(Invoice invoice) {
        System.out.println(invoice);
    }
}
