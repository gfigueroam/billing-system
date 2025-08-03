package com.example.Billing.System.controller;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

public record Invoice(UUID userId, String companyName, LocalDate date, BigDecimal amount) {
}
