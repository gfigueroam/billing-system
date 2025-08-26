package com.example.Billing.System.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InvoiceDTO {

    private UUID userId;
    @NotBlank(message = "Company name must not be blank")
    private String companyName;
    //MethodArgumentNotValidException
    @PastOrPresent(message = "Date can't be in the future")
    private LocalDate date;
    private BigDecimal amount;

}


