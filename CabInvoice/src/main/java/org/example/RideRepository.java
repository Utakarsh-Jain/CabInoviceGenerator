package org.example;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class RideRepository {
    // Store rides against each user ID
    private final Map<String, List<Ride>> userRides = new HashMap<>();
    // Add a ride for a user
    public void addRide(String userId, Ride ride) {
        if (userId == null || userId.isBlank()) {
            throw new IllegalArgumentException("User ID cannot be empty");
        }
        if (ride == null) {
            throw new IllegalArgumentException("Ride cannot be null");
        }

        userRides.computeIfAbsent(userId, key -> new ArrayList<>())
                .add(ride);
    }

    // Retrieve rides belonging to a user
    public List<Ride> getRides(String userId) {
        if (userId == null || userId.isBlank()) {
            throw new IllegalArgumentException("User ID cannot be empty");
        }

        return new ArrayList<>(
                userRides.getOrDefault(userId, List.of())
        );
    }
}
