
package org.example;
public class Ride {
    private final double distance;
    private final int time;

    // Constructor to initialize ride details
    public Ride(double distance, int time) {
        this.distance = distance;
        this.time = time;
    }

    public double getDistance() {
        return distance;
    }

    public int getTime() {
        return time;
    }
}
