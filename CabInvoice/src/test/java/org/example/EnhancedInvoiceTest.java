package org.example;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class EnhancedInvoiceTest {

    private EnhancedInvoice enhancedInvoice;

    @BeforeEach
    void setUp() {
        enhancedInvoice = new EnhancedInvoice();
    }

    @Test
    @DisplayName("Calculate total rides, total fare and average fare")
    void calculateInvoice() {
        List<Ride> rides = List.of(
                new Ride(5, 10),
                new Ride(10, 20),
                new Ride(2, 5)
        );

        InvoiceSummary invoice =
                enhancedInvoice.calculateInvoice(rides);

        assertAll(
                () -> assertEquals(3, invoice.getTotalRides()),
                () -> assertEquals(205.0, invoice.getTotalFare(), 0.001),
                () -> assertEquals(205.0 / 3,
                        invoice.getAverageFare(), 0.001)
        );
    }

    @Test
    @DisplayName("Return zero values for an empty ride list")
    void calculateInvoiceForEmptyList() {
        InvoiceSummary invoice =
                enhancedInvoice.calculateInvoice(List.of());

        assertAll(
                () -> assertEquals(0, invoice.getTotalRides()),
                () -> assertEquals(0.0, invoice.getTotalFare(), 0.001),
                () -> assertEquals(0.0, invoice.getAverageFare(), 0.001)
        );
    }

    @Test
    @DisplayName("Calculate invoice for one ride")
    void calculateInvoiceForSingleRide() {
        InvoiceSummary invoice = enhancedInvoice.calculateInvoice(
                List.of(new Ride(5, 10))
        );

        assertAll(
                () -> assertEquals(1, invoice.getTotalRides()),
                () -> assertEquals(60.0, invoice.getTotalFare(), 0.001),
                () -> assertEquals(60.0, invoice.getAverageFare(), 0.001)
        );
    }

    @Test
    @DisplayName("Reject a null ride list")
    void calculateInvoiceForNullList() {
        assertThrows(
                IllegalArgumentException.class,
                () -> enhancedInvoice.calculateInvoice(null)
        );
    }
}
