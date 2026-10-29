package org.example;
import java.util.List;
public class MultipleRides {
    // Calculate fare for one ride
    public double calculateFare(double distance, int time) {
        if (!Double.isFinite(distance) || distance < 0 || time < 0) {
            throw new IllegalArgumentException("Invalid ride details");
        }
        double fare = (distance * 10) + time;
        return Math.max(fare, 5);
    }
    // Calculate total fare for multiple rides
    public double calculateTotalFare(List<Ride> rides) {
        double totalFare = 0;
        for (Ride ride : rides) {
            totalFare += calculateFare(
                    ride.getDistance(), ride.getTime());
        }
        return totalFare;
    }
}
