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
        Assertions.assertEquals(expectedInvoice, summary);
    }

    @Test
    public void givenUserId_ShouldReturnInvoiceSummary() {
        InvoiceGenerator invoice = new InvoiceGenerator();
        InvoiceSummary summary = invoice.getInvoice(1);
        InvoiceSummary expectedInvoices = new InvoiceSummary(2, 66);
        Assert.assertEquals(expectedInvoices, summary);

    }

    @Test
    void givenDistanceAndTime_WhenNormal_ShouldReturnTotalFare() {
        InvoiceGenerator invoice = new InvoiceGenerator();
        double actual = invoice.calculateFare(6, 4, "Normal");
        Assert.assertEquals(64, actual, 0);
    }

    @Test
    void givenMultipleRides_WhenNormal_ShouldReturnTotalFare() {
        InvoiceGenerator invoice = new InvoiceGenerator();
        Rides[] rides = {new Rides(4, 5),
                new Rides(3, 7),
        };
        double actual = invoice.calculateFareMultipleRides(rides, "Normal");
        Assert.assertEquals(82, actual, 0);
    }

    @Test
    void givenMultipleRides_WhenNormal_ShouldReturnInvoiceSummary() {
        InvoiceGenerator invoice = new InvoiceGenerator();
        Rides[] rides = {new Rides(4.0, 5),
                new Rides(3, 7),
                new Rides(5, 8)
        };
        InvoiceSummary summary = invoice.invoiceSummaryType(rides, "Normal");
        InvoiceSummary expectedInvoice = new InvoiceSummary(3, 140.0);
        Assert.assertEquals(expectedInvoice, summary);
    }

    @Test
    void givenDistanceAndTime_WhenPremium_ShouldReturnTotalFare() {
        InvoiceGenerator invoice = new InvoiceGenerator();
        double actual = invoice.calculateFare(7, 2, "Premium");
        Assert.assertEquals(109, actual, 0);
    }

    @Test
    void givenMultipleRides_WhenPremium_ShouldReturnTotalFare() {
        InvoiceGenerator invoice = new InvoiceGenerator();
        Rides[] rides = {new Rides(4, 5),
                new Rides(3, 7),
        };
        double actual = invoice.calculateFareMultipleRides(rides, "Premium");
        Assert.assertEquals(129, actual, 0);
    }

    @Test
    void givenMultipleRides_WhenPremium_ShouldReturnInvoiceSummary() {
        InvoiceGenerator invoice = new InvoiceGenerator();
        Rides[] rides = {new Rides(4, 5),
                new Rides(3, 7),
        };
        InvoiceSummary summary = invoice.invoiceSummaryType(rides, "Premium");
        InvoiceSummary expectedInvoice = new InvoiceSummary(2, 129.0);
        Assert.assertEquals(expectedInvoice, summary);
    }
}