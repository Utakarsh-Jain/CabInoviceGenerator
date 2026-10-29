
package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class InvoiceServiceTest {

    private RideRepository rideRepository;
    private InvoiceService invoiceService;

    @BeforeEach
    void setUp() {
        rideRepository = new RideRepository();

        invoiceService = new InvoiceService(
                rideRepository,
                new EnhancedInvoice()
        );
    }

    @Test
    @DisplayName("Generate invoice for a user")
    void getInvoiceForUser() {
        rideRepository.addRide("USER1", new Ride(5, 10));
        rideRepository.addRide("USER1", new Ride(10, 20));

        InvoiceSummary invoice = invoiceService.getInvoice("USER1");

        assertAll(
                () -> assertEquals(2, invoice.getTotalRides()),
                () -> assertEquals(180.0, invoice.getTotalFare(), 0.001),
                () -> assertEquals(90.0, invoice.getAverageFare(), 0.001)
        );
    }

    @Test
    @DisplayName("Return empty invoice for a user with no rides")
    void getInvoiceForUnknownUser() {
        InvoiceSummary invoice = invoiceService.getInvoice("USER2");

        assertAll(
                () -> assertEquals(0, invoice.getTotalRides()),
                () -> assertEquals(0.0, invoice.getTotalFare(), 0.001),
                () -> assertEquals(0.0, invoice.getAverageFare(), 0.001)
        );
    }

    @Test
    @DisplayName("Reject an empty user ID")
    void getInvoiceWithEmptyUserId() {
        assertThrows(
                IllegalArgumentException.class,
                () -> invoiceService.getInvoice("")
        );
    }
}
