package org.example;
import java.util.List;
public class InvoiceService {
    private final RideRepository rideRepository;
    private final EnhancedInvoice enhancedInvoice;
    public InvoiceService(
            RideRepository rideRepository,
            EnhancedInvoice enhancedInvoice) {
        this.rideRepository = rideRepository;
        this.enhancedInvoice = enhancedInvoice;
    }
    // Generate an invoice using the user's ID
    public InvoiceSummary getInvoice(String userId) {
        List<Ride> rides = rideRepository.getRides(userId);
        return enhancedInvoice.calculateInvoice(rides);
    }
}
