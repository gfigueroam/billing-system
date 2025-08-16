package com.example.Billing.System.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.PastOrPresent;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Currency;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InvoiceDTO {

        private UUID userId;
        @NotBlank private String companyName;
        //MethodArgumentNotValidException
        @PastOrPresent private LocalDate date;
        private BigDecimal amount;

}


