package com.example.demospringboot.service;

public interface PembayaranCalculator {
    double calculateTotalPaymentWithInterest(double nominal, double bunga);
}
