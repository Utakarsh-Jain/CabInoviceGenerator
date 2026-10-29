
package org.example;

import java.util.List;

public class CabInvoiceGenerator {

    // Calculate fare for a normal ride
    public double calculateFare(double distance, int time) {
        validateRide(distance, time);

        double fare = (distance * 10) + time;
        return Math.max(fare, 5);
    }

    // Calculate fare according to the ride type
    public double calculateFare(Ride ride) {
        if (ride == null) {
            throw new IllegalArgumentException("Ride cannot be null");
        }

        double distance = ride.getDistance();
        int time = ride.getTime();

        if (ride.getType() == RideType.PREMIUM) {
            double fare = (distance * 15) + (time * 2);
            return Math.max(fare, 20);
        }

        return calculateFare(distance, time);
    }

    // Calculate total fare for multiple rides
    public double calculateTotalFare(List<Ride> rides) {
        if (rides == null) {
            throw new IllegalArgumentException("Ride list cannot be null");
        }

        double totalFare = 0;

        for (Ride ride : rides) {
            totalFare += calculateFare(ride);
        }

        return totalFare;
    }

    // Validate distance and time
    private void validateRide(double distance, int time) {
        if (!Double.isFinite(distance) || distance < 0 || time < 0) {
            throw new IllegalArgumentException("Invalid ride details");
        }
    }
}
