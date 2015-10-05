/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package discountstategy;

import java.text.NumberFormat;

/**
 *
 * @author Alyson
 */
public class ReceiptInformation {

    //what is on a receipt
    private static final String DASHED = "------------------------------------------------------";
    //database access
    DatabaseAccessStrategy data;
    OutputStrategy output;
    //LineItem array of LineItem objects
    private LineItem[] lineItems;
    //cusomter object
    private CustomerInformationStrategy customer;
    private String customerID;
    //receipt no
    int receiptNo = 0;
    //properties
    private int qty;
    //subtotal of all items
    private double totalSubtotal;
    //subtotal of all discounts
    private double totalDiscount;
    //total of all items after discounts
    private double amountTotal;

    /**
     *
     * @param customerID
     * @param db
     * @param output
     */
    public ReceiptInformation(String customerID, DatabaseAccessStrategy db, OutputStrategy output) {
        setCustomer(customerID);
        setDatabaseStrategy(db);
        setOutputStrategy(output);
        receiptNo++;
        lineItems = new LineItem[0];
        //date

    }

    //print receipt
    public final void outputReceipt() {
        NumberFormat nf = NumberFormat.getCurrencyInstance();
        
        //header
        //customer date receipt no
        output.outputData("Kohls Department Store \n");
        output.outputData("Customer Name: " + getCustomer());
        //output.outputData("Date of Sale: " );
        output.outputData("Receipt No.: " + receiptNo);
        output.outputData(DASHED);
        //items
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
        //totals
        output.outputData("\t\t\t\tSubtotal: " + nf.format(getTotalSubtotal()));
        output.outputData("\t\t\t\tSaved: " + nf.format(getTotalDiscount()));
        output.outputData("\t\t\t\tTotal: " + nf.format(getAmountTotal()));

        //thank you
        output.outputData("Thank you for Shopping at Kohls!");
    }

    //set databse strategy
    private void setDatabaseStrategy(DatabaseAccessStrategy db) {
        this.data = db;
    }

    //set output strategy
    private void setOutputStrategy(OutputStrategy output) {
        this.output = output;
    }

    /**
     * gather line items in some way.
     *
     * for loop
     *
     * @param itemID
     * @param qty
     */
    //add new line item (in array)
    public final void addNewLineItem(String itemID, int qty) {
        //line item constructor object
        LineItem itemObj = new LineItem(data.findItem(itemID), qty);
        //temporary array
        LineItem[] temp = new LineItem[lineItems.length + 1];

        //for loop to copy current array into temp array
        for (int i = 0; i < lineItems.length; i++) {
            temp[i] = lineItems[i];
        }

        //add new line item
        temp[temp.length - 1] = itemObj;
        //copy temp array to lineItems array
        lineItems = temp;
        //null temp array
        temp = null;
        totalSubtotal += itemObj.getSubTotal();
        totalDiscount += itemObj.getItem().getAmountSaved(qty);
        amountTotal = totalSubtotal - totalDiscount;
    }

    private LineItem[] getLineItemArray() {
        return lineItems;
    }

    private final void setCustomer(String customerID) {
        customer = new Customer();
        this.customerID = customerID;
    }

    private final String getCustomer() {
        return data.findCustomer(customerID).getCustomerName();
    }

    private final double getTotalSubtotal() {
        return totalSubtotal;
    }

    private final double getTotalDiscount() {
        return totalDiscount;
    }

    private final double getAmountTotal() {
        return amountTotal;
    }

//    public static void main(String[] args) {
//
//        ReceiptInformation receipt = new ReceiptInformation();
//
//        receipt.addNewLineItem("2002", 4);
//        receipt.addNewLineItem("2004", 1);
//
//        LineItem[] items = receipt.getLineItemArray();
//        for (int i = 0; i < receipt.getLineItemArray().length; i++) {
//            System.out.println(items[i].getItem().getItemID() + "\t"
//                    + items[i].getItem().getItemName() + "\t" + items[i].getItemQty()
//                    + "\t" + items[i].getSubTotal() + "\t" + items[i].getDiscount());
//        }
//        System.out.println("Subtotal: $" + receipt.getTotalSubtotal());
//        System.out.println("Discount: $" + receipt.getTotalDiscount());
//        System.out.println("Total: $" + receipt.getAmountTotal());
//
//    }
}
