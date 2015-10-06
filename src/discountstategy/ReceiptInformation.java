
package discountstategy;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Alyson
 */
public class ReceiptInformation {

    private static final String DASHED = "------------------------------------------------------";
    private DatabaseAccessStrategy data;
    private OutputStrategy output;
    private final Date currentDate = new Date();
    private final SimpleDateFormat date = new SimpleDateFormat("EEE, MMM d, yyyy hh:mm aaa");
    private LineItem[] lineItems;
    private CustomerInformationStrategy customer;
    private String customerID;
    int receiptNo = 0;
    private String dateTime;
    private int qty;
    private double totalSubtotal;
    private double totalDiscount;
    private double amountTotal;

    /**
     *
     * @param customerID
     * @param db
     * @param output
     */
    public ReceiptInformation(String customerID, DatabaseAccessStrategy db, OutputStrategy output) {
        if(customerID == null || customerID.isEmpty() || db == null || output == null ) {
            throw new IllegalArgumentException();
        }
        setCustomer(customerID);
        setDatabaseStrategy(db);
        setOutputStrategy(output);
        receiptNo++;
        lineItems = new LineItem[0];
        dateTime = date.format(currentDate);

    }

    public final void outputReceipt() {
        NumberFormat nf = NumberFormat.getCurrencyInstance();
        
        output.outputData("Kohls Department Store \n");
        output.outputData("Customer Name: " + getCustomer());
        output.outputData("Date of Sale: " + dateTime);
        output.outputData("Receipt No.: " + receiptNo);
        output.outputData(DASHED);
        LineItem[] items = getLineItemArray();
        for (int i = 0; i < getLineItemArray().length; i++) {
            output.outputData("Item ID: " + items[i].getItem().getItemID() + "\t"
                    + "Item Name: " + items[i].getItem().getItemName() + "\t" 
                    + "Unit Price: " + nf.format(items[i].getItem().getUnitPrice()) + "\t"
                    + "Quantity: " + items[i].getItemQty() + "\t"
                    + "Item Subtotal: " + nf.format(items[i].getSubTotal()) + "\t" 
                    + "Discount: " + nf.format(items[i].getDiscount()));
        }
        output.outputData(DASHED);
        output.outputData("\t\t\t\tSubtotal: " + nf.format(getTotalSubtotal()));
        output.outputData("\t\t\t\tSaved: " + nf.format(getTotalDiscount()));
        output.outputData("\t\t\t\tTotal: " + nf.format(getAmountTotal()));

        output.outputData("Thank you for Shopping at Kohls!");
    }

    private void setDatabaseStrategy(DatabaseAccessStrategy db) {
        if(db == null) {
            throw new IllegalArgumentException();
        }
        this.data = db;
    }

    private void setOutputStrategy(OutputStrategy output) {
        if(output == null) {
            throw new IllegalArgumentException();
        }
        this.output = output;
    }

    /**
     * @param itemID
     * @param qty
     */
    public final void addNewLineItem(String itemID, int qty) {
        if(itemID == null || itemID.isEmpty() || qty <= 0) {
            throw new IllegalArgumentException();
        }
        LineItem itemObj = new LineItem(data.findItem(itemID), qty);
        LineItem[] temp = new LineItem[lineItems.length + 1];

        for (int i = 0; i < lineItems.length; i++) {
            temp[i] = lineItems[i];
        }

        temp[temp.length - 1] = itemObj;
        lineItems = temp;
        temp = null;
        totalSubtotal += itemObj.getSubTotal();
        totalDiscount += itemObj.getItem().getAmountSaved(qty);
        amountTotal = totalSubtotal - totalDiscount;
    }

    private LineItem[] getLineItemArray() {
        return lineItems;
    }

    private void setCustomer(String customerID) {
        if(customerID == null || customerID.isEmpty()) {
            throw new IllegalArgumentException();
        }
        customer = new Customer();
        this.customerID = customerID;
    }

    private String getCustomer() {
        return data.findCustomer(customerID).getCustomerName();
    }

    private double getTotalSubtotal() {
        return totalSubtotal;
    }

    private double getTotalDiscount() {
        return totalDiscount;
    }

    private double getAmountTotal() {
        return amountTotal;
    }

}
