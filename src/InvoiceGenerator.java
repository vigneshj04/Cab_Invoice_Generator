public class InvoiceGenerator {

    int costPerKm = 10;
    int costPerMin = 1;
    int minFare = 5;

    //Calculating total fare....
    public double fareCalculation(double distance, int time) {
        double totalFare = distance * costPerKm + time * costPerMin;
        if (totalFare < minFare) {
            return minFare;
        } else {
            return totalFare;
        }
    }
}