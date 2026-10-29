
package org.example;

public class InvoiceSummary {

    private final int totalRides;
    private final double totalFare;
    private final double averageFare;

    public InvoiceSummary(int totalRides, double totalFare) {
        this.totalRides = totalRides;
        this.totalFare = totalFare;
        this.averageFare =
                totalRides == 0 ? 0.0 : totalFare / totalRides;
    }

    public int getTotalRides() {
        return totalRides;
    }

    public double getTotalFare() {
        return totalFare;
    }

    public double getAverageFare() {
        return averageFare;
    }

    // Display the invoice details
    public void displayInvoice() {
        System.out.println("Total Rides: " + totalRides);
        System.out.println("Total Fare: Rs. " + totalFare);
        System.out.println("Average Fare: Rs. " + averageFare);
    }
}
