/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package discountstategy;

/**
 *
 * @author Alyson
 */
public class FakeDatabase {

    ErrorHandlingOutputStrategy error = new ConsoleOutput();
    //error constant string properties
    private final static String ERROR_CUSTOMERID = "FakeDatabase.findCustomer has"
            + " an illegal arguement.";
    private final static String ERROR_ITEMID = "FakeDatabse.findItem has an illegal"
            + " arguement.";
    //create fake database of customers using array
    private Customer[] customers = {};
    //create fake datavase of products using array
    private Item[] items = {};

    //find customer using customer array
    public final Customer findCustomer(String customerID) {
        //error check
        if (customerID == null || customerID.length() == 0) {
            error.consoleOutput(ERROR_CUSTOMERID);
            return null;
        } else {
        }

        Customer customer = null;
        for (Customer c : customers) {
            if (customerID.equals(c.getCustomerID())) {
                customer = c;
                break;
            }
        }

        return customer;
    }
    //find product using product array
    public final Item findItem(String itemID) {
        //error check
        if (itemID == null || itemID.length() == 0) {
            error.consoleOutput(ERROR_ITEMID);
            return null;
        } else {
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
