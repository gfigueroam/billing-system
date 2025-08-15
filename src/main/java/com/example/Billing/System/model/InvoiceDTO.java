package com.example.Billing.System.model;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Data
public class InvoiceDTO {
    private UUID userId;
    private String companyName;
    private LocalDate date;
    private BigDecimal amount;

}
