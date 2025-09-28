// 代码生成时间: 2025-09-29 00:03:20
package com.example.taxsystem;

import org.springframework.stereotype.Service;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

@Service
public class TaxCalculationService {

    private static final double TAX_RATE = 0.2; // 20% tax rate

    /**
     * Calculates the tax amount based on the given income.
     *
     * @param income the income amount
     * @return the calculated tax amount
     */
    public double calculateTax(double income) {
        if (income < 0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Income cannot be negative.");
        }
        return income * TAX_RATE;
    }

    /**
     * Calculates the total amount including tax.
     *
     * @param income the income amount
     * @return the total amount including tax
     */
    public double calculateTotalAmountWithTax(double income) {
        try {
            double tax = calculateTax(income);
            return income + tax;
        } catch (ResponseStatusException e) {
            // Log the error (e.g., using a logger like SLF4J)
            // throw e; // Re-throw the exception if you want to propagate it
            // For simplicity, we'll just return a negative value to indicate an error
            return -1;
        }
    }
}
