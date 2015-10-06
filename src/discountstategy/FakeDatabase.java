
package discountstategy;

/**
 *
 * @author Alyson
 */
public class FakeDatabase implements DatabaseAccessStrategy {

    OutputStrategy error = new ConsoleOutput();
    private final static String ERROR_CUSTOMERID = "FakeDatabase.findCustomer has"
            + " an illegal arguement.";
    private final static String ERROR_ITEMID = "FakeDatabse.findItem has an illegal"
            + " arguement.";
    private CustomerInformationStrategy[] customers = {
        new Customer("101", "John Smith"),
        new Customer("102", "Martha Jones"),
        new Customer("103", "Rose Tyler"),
        new Customer("104", "Mickey Smith"),
        new Customer("105", "Donna Nobel"),
        new Customer("106", "Jack Harkness"),
        new Customer("107", "Amy Pond"),
        new Customer("108", "Rory Pond"),
        new Customer("109", "Christopher Eccleston"),
        new Customer("110", "David Tennant"),
        new Customer("111", "Matt Smith"),
        new Customer("112", "Peter Capaldi"),
        new Customer("113", "River Song"),
        new Customer("114", "Clara Oswald"),
        new Customer("115", "The Doctor")
        
    };
    private Item[] items = {
        new Item("2001", "Sonic Screwdriver", 69.99, new NoDiscount()),
        new Item("2002", "Scarf", 22.00, new QtyDiscount(0.10,3)),
        new Item("2003", "Fez", 12.00, new PercentOffDiscount(0.20)),
        new Item("2004", "Tardis", 0.99, new NoDiscount())
    };


    @Override
    public final CustomerInformationStrategy findCustomer(String customerID) {
        //error check
        if (customerID == null || customerID.length() == 0) {
            error.outputData(ERROR_CUSTOMERID);
            return null;
        } else {
        }

        CustomerInformationStrategy customer = null;
        for (CustomerInformationStrategy c : customers) {
            if (customerID.equals(c.getCustomerID())) {
                customer = c;
                break;
            }
        }

        return customer;
    }
    @Override
    public final Item findItem(String itemID) {
        //error check
        if (itemID == null || itemID.length() == 0) {
            error.outputData(ERROR_ITEMID);
            return null;
        } 

        Item item = null;
        for (Item i : items) {
            if (itemID.equals(i.getItemID())) {
                item = i;
                break;
            }
        }

        return item;
    }
}
