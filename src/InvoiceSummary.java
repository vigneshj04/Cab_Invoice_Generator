public class InvoiceSummary {

    int totalNumOfRides;
    double totalFare;
    double averageFarePerRide;

    public InvoiceSummary(int totalNumOfRides, double totalFare) {
        this.totalNumOfRides = totalNumOfRides;
        this.totalFare = totalFare;
        this.averageFarePerRide = this.totalFare / this.totalNumOfRides;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InvoiceSummary summary = (InvoiceSummary) o;
        return totalNumOfRides == summary.totalNumOfRides && Double.compare(summary.totalFare,
                totalFare) == 0 && Double.compare(summary.averageFarePerRide, averageFarePerRide) == 0;
    }
}