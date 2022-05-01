import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class InvoiceGeneratorTest {

    private Assertions Assert;

    @Test
    void givenDistanceAndTime_shouldReturn_totalFare() {
        InvoiceGenerator invoice = new InvoiceGenerator();
        double expected = invoice.fareCalculation(5.5, 4);
        Assert.assertEquals(expected, 50, 0);
    }

    @Test
    void givenDistanceAndTime_shouldReturn_totalFareForMultipleRides() {
        InvoiceGenerator invoice = new InvoiceGenerator();
        Rides[] rides = {new Rides(4, 5),
                new Rides(3, 7),
                new Rides(5, 8)
        };
        double actual = invoice.multipleFare(rides);
        Assert.assertEquals(140, actual, 0);
    }

    @Test
    void givenMultipleRides_shouldReturn_invoiceSummary() {
        InvoiceGenerator invoice = new InvoiceGenerator();
        Rides[] rides = {new Rides(4.0, 5),
                new Rides(3, 7),
                new Rides(5, 8)
        };
        InvoiceSummary summary = invoice.invoiceSummary(rides);
        InvoiceSummary expectedInvoice = new InvoiceSummary(3, 140.0);
        Assert.assertEquals(expectedInvoice, summary);
    }
}