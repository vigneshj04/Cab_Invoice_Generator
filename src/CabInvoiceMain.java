
public class CabInvoiceMain {

    static InvoiceGenerator invoice = new InvoiceGenerator();

    public static void main(String[] args) {
        System.out.println("Welcome to Cab Service");

        System.out.println(invoice.fareCalculation(5.5, 4));
        Rides[] rides = {new Rides(4, 5),
                new Rides(3,7),
                new Rides(5,8)
        };
        System.out.println(invoice.multipleFare(rides));
        System.out.println(invoice.getInvoice(1));

    }

}