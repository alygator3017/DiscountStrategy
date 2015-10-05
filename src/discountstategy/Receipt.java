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
public class Receipt {

    //what is on a receipt

    /**
     * customer name --- don't need yet date and time ---don't need yet receipt
     * no --- don't need yet LineItem(s) subtotal amount saved (discount) total
     */
    //database access
    DatabaseAccessStrategy data = new FakeDatabase();
    //LineItem array of LineItem objects
    private LineItem[] lineItems = new LineItem[0];
    //cusomter object

    //properties
    //subtotal of all items
    private double totalSubtotal;
    //subtotal of all discounts
    private double totalDiscount;
    //total of all items after discounts
    private double amountTotal;

    /**
     * gather line items in some way.
     *
     * for loop
     *
     * @param itemID
     * @param qty
     */
    //add new line item (in array)
    public void addNewLineItem(String itemID, int qty) {

        //temporary array
        LineItem[] temp = new LineItem[lineItems.length + 1];

        //for loop to copy current array into temp array
        for (int i = 0; i < lineItems.length; i++) {
            temp[i] = lineItems[i];
        }

        //add new line item
        temp[temp.length - 1] = new LineItem(data.findItem(itemID), qty);
        //copy temp array to lineItems array
        lineItems = temp;
        //null temp array
        temp = null;
    }

    public LineItem[] getLineItemArray() {
        return lineItems;
    }

    public static void main(String[] args) {

//        Receipt receipt = new Receipt();
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

    }
}
