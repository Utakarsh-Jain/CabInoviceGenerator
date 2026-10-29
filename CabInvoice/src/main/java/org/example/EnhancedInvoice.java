package org.example;
import java.util.List;
public class EnhancedInvoice {
    private final MultipleRides multipleRides;
    public EnhancedInvoice() {
        multipleRides = new MultipleRides();
    }
    // Calculate total rides, total fare and average fare
    public InvoiceSummary calculateInvoice(List<Ride> rides) {
        if (rides == null) {
            throw new IllegalArgumentException("Ride list cannot be null");
        }

        double totalFare = multipleRides.calculateTotalFare(rides);
        int totalRides = rides.size();

        return new InvoiceSummary(totalRides, totalFare);
    }
}
