
public class CabInvoiceMain {

    static InvoiceGenerator invoice = new InvoiceGenerator();

    public static void main(String[] args) {
        System.out.println("Welcome to Cab Services");

        System.out.println(invoice.fareCalculation(1, 4));

    }
}