package org.example;

import org.example.RideType;

public class Ride {
    private final double distance;
    private final int time;
    private final RideType type;

    // Constructor for a normal ride
    public Ride(double distance, int time) {
        this(distance, time, RideType.NORMAL);
    }

    // Constructor for a ride with a specified type
    public Ride(double distance, int time, RideType type) {
        if (!Double.isFinite(distance) || distance < 0) {
            throw new IllegalArgumentException("Invalid distance");
        }

        if (time < 0) {
            throw new IllegalArgumentException("Invalid time");
        }

        if (type == null) {
            throw new IllegalArgumentException("Ride type cannot be null");
        }

        this.distance = distance;
        this.time = time;
        this.type = type;
    }

    public double getDistance() {
        return distance;
    }

    public int getTime() {
        return time;
    }

    public RideType getType() {
        return type;
    }
}
