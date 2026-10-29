
package org.example;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MultipleRidesTest {

    private MultipleRides multipleRides;

    @BeforeEach
    void setUp() {
        multipleRides = new MultipleRides();
    }

    @Test
    @DisplayName("Calculate total fare for multiple rides")
    void calculateTotalFare() {
        List<Ride> rides = List.of(
                new Ride(5, 10),
                new Ride(10, 20),
                new Ride(2, 5)
        );

        assertEquals(205.0,
                multipleRides.calculateTotalFare(rides), 0.001);
    }

    @Test
    @DisplayName("Return zero for an empty ride list")
    void calculateTotalFareForEmptyList() {
        assertEquals(0.0,
                multipleRides.calculateTotalFare(List.of()), 0.001);
    }

    @Test
    @DisplayName("Calculate fare for a single ride")
    void calculateFareForSingleRide() {
        List<Ride> rides = List.of(new Ride(5, 10));

        assertEquals(60.0,
                multipleRides.calculateTotalFare(rides), 0.001);
    }
}
