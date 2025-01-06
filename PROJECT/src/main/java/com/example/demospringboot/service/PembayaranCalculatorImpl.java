package com.example.demospringboot.service;

import org.springframework.stereotype.Service;

@Service
public class PembayaranCalculatorImpl implements PembayaranCalculator {

    @Override
    public double calculateTotalPaymentWithInterest(double nominal, double bunga) {
        // Menghitung bunga
        double bungaAmount = nominal * (bunga / 100);
        return nominal + bungaAmount;
    }
}
