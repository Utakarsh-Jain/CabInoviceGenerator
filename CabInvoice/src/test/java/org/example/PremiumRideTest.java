package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PremiumRidesTest {

    private CabInvoiceGenerator generator;

    @BeforeEach
    void setUp() {
        generator = new CabInvoiceGenerator();
    }

    @Test
    @DisplayName("Calculate normal ride fare")
    void calculateNormalRideFare() {
        Ride ride = new Ride(5, 10, RideType.NORMAL);

        assertEquals(60.0, generator.calculateFare(ride), 0.001);
    }

    @Test
    @DisplayName("Calculate premium ride fare")
    void calculatePremiumRideFare() {
        Ride ride = new Ride(5, 10, RideType.PREMIUM);

        // (5 * 15) + (10 * 2) = 95
        assertEquals(95.0, generator.calculateFare(ride), 0.001);
    }

    @Test
    @DisplayName("Apply minimum fare for normal ride")
    void normalRideMinimumFare() {
        Ride ride = new Ride(0, 0, RideType.NORMAL);

        assertEquals(5.0, generator.calculateFare(ride), 0.001);
    }

    @Test
    @DisplayName("Apply minimum fare for premium ride")
    void premiumRideMinimumFare() {
        Ride ride = new Ride(0, 0, RideType.PREMIUM);

        assertEquals(20.0, generator.calculateFare(ride), 0.001);
    }

    @Test
    @DisplayName("Calculate total fare for mixed ride types")
    void calculateMixedRideFare() {
        Ride normal = new Ride(5, 10, RideType.NORMAL);
        Ride premium = new Ride(5, 10, RideType.PREMIUM);

        assertEquals(
                155.0,
                generator.calculateTotalFare(
                        java.util.List.of(normal, premium)
                ),
                0.001
        );
    }
}
