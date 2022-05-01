
import java.util.HashMap;
import java.util.Map;

public class InvoiceGenerator {
    //List<Rides> rides = new ArrayList<>();
    int costPerKm = 10;
    int costPerMin = 1;
    int minFare = 5;
    double totalFare = 0;
    double averageFarePerRide = 0;


    double costPerKmNormal = 10;
    int costPerMinNormal = 1;
    double minFareNormal = 5;
    double costPerKmPremium = 15;
    int costPerMinPremium = 2;
    double minFareNormalPremium = 20;


    //Calculating total fare....
    public double fareCalculation(double distance, int time) {
        totalFare = distance * costPerKm + time * costPerMin;
        if (totalFare < minFare) {
            return minFare;
        } else {
            return totalFare;
        }
    }

    //Multiple Ride...
    public double multipleFare(Rides[] rides) {
        totalFare = 0.0;
        for (Rides ride : rides) {
            totalFare = totalFare + fareCalculation(ride.distance, ride.time);
        }
        System.out.print("Total Fare is: ");
        return totalFare;
    }

    //Invoice summary...
    public InvoiceSummary invoiceSummary(Rides[] rides) {
        totalFare = 0.0;
        for (Rides ride : rides) {
            totalFare = totalFare + fareCalculation(ride.distance, ride.time);
        }
        return new InvoiceSummary(rides.length, totalFare);

    }

    // Getting list of rides by using id...
    public InvoiceSummary getInvoice(int userId) {
        Map<Integer, Rides[]> map = new HashMap<>();

        Rides[] rides1 = {new Rides(5.0, 5),
                new Rides(0.1, 1)
        };
        Rides[] rides2 = {new Rides(7.0, 10),
                new Rides(6, 1)
        };

        Rides[] rides3 = {new Rides(8.0, 15),
                new Rides(9, 10)
        };
        map.put(1, rides1);
        map.put(2, rides2);
        map.put(3, rides3);

        for (Map.Entry<Integer, Rides[]> entry : map.entrySet()) {
            if (userId == entry.getKey()) {
                System.out.println(entry.getKey());
                Rides[] ridesArray = entry.getValue();
                System.out.println(ridesArray);
            }
        }
        return null;
    }

    public double calculateFare(double distance, int time, String type) {
        if (type.equalsIgnoreCase("Normal")) {
            totalFare = distance * costPerKmNormal + time * costPerMinNormal;
            return Math.max(totalFare, minFareNormal);

        } else if (type.equalsIgnoreCase("Premium")) {
            totalFare = distance * costPerKmPremium + time * costPerMinPremium;
            return Math.max(totalFare, minFareNormalPremium);

        } else {
            System.out.println("Please Enter Proper Customer Type");
            return 0.0;
        }
    }


    public double calculateFareMultipleRides(Rides[] rides, String type) {
        double totalFare = 0.0;
        if (type.equalsIgnoreCase("Normal")) {
            for (Rides ride : rides) {
                totalFare += calculateFare(ride.distance, ride.time, type);
            }
            return totalFare;

        } else if (type.equalsIgnoreCase("Premium")) {
            for (Rides ride : rides) {
                totalFare += calculateFare(ride.distance, ride.time, type);

            }
            return totalFare;
        } else
            System.out.println("Please Enter Proper Customer Type");
        return 0.0;
    }


    public InvoiceSummary invoiceSummaryType(Rides[] rides, String type) {
        double totalFare = 0.0;
        if (type.equalsIgnoreCase("Normal")) {
            for (Rides ride : rides) {
                totalFare += calculateFare(ride.distance, ride.time,type);
            }
        } else if (type.equalsIgnoreCase("Premium")) {
            for (Rides ride : rides) {
                totalFare += calculateFare(ride.distance, ride.time,type);
            }
        }
        return new InvoiceSummary(rides.length, totalFare);
    }
}