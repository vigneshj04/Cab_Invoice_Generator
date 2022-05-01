import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class InvoiceGeneratorTest {

    private Assertions Assert;

    @Test
    void givenDistanceAndTime_shouldReturn_totalFare() {
        InvoiceGenerator invoice = new InvoiceGenerator();
        double actual = invoice.fareCalculation(5.5, 4);
        Assert.assertEquals(59, actual, 0);
    }

    @Test
    void givenDistanceAndTime_shouldReturn_totalFareForMultipleRides() {
        InvoiceGenerator invoice = new InvoiceGenerator();
        Rides[] rides = {new Rides(4, 5),
                new Rides(3, 7),
                new Rides(5, 8)
        };
        double actual = invoice.multipleFare(rides);
        Assert.assertEquals(140,actual,0);
    }
}