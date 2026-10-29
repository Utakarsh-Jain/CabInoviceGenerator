package org.example;
import java.util.*;
public class CabInvoiceGenerator {
    public double calculateFare(double distance, int time) {
        if (!Double.isFinite(distance) || distance < 0 || time < 0) {
            throw new IllegalArgumentException("Invalid ride details");
        }
        double fare = distance * 10 + time;
        return Math.max(fare, 5);
    }
    public static void main(String[] args) {
        CabInvoiceGenerator cab = new CabInvoiceGenerator();
        System.out.println(cab.calculateFare(5, 10));
    }
}