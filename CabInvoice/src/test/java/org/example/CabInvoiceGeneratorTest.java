package org.example;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CabInvoiceGeneratorTest {

    CabInvoiceGenerator cab = new CabInvoiceGenerator();

    @Test
    void calculateFareForValidRide() {
        assertEquals(60.0, cab.calculateFare(5, 10));
    }

    @Test
    void calculateMinimumFare() {
        assertEquals(5.0, cab.calculateFare(0, 0));
    }

    @Test
    void calculateFareForZeroDistance() {
        assertEquals(10.0, cab.calculateFare(0, 10));
    }

    @Test
    void calculateFareForZeroTime() {
        assertEquals(50.0, cab.calculateFare(5, 0));
    }

    @Test
    void shouldThrowExceptionForNegativeDistance() {
        assertThrows(IllegalArgumentException.class,
                () -> cab.calculateFare(-5, 10));
    }

    @Test
    void shouldThrowExceptionForNegativeTime() {
        assertThrows(IllegalArgumentException.class,
                () -> cab.calculateFare(5, -10));
    }

    @Test
    void shouldThrowExceptionForInfiniteDistance() {
        assertThrows(IllegalArgumentException.class,
                () -> cab.calculateFare(Double.POSITIVE_INFINITY, 10));
    }

    @Test
    void shouldThrowExceptionForNaNDistance() {
        assertThrows(IllegalArgumentException.class,
                () -> cab.calculateFare(Double.NaN, 10));
    }
}
