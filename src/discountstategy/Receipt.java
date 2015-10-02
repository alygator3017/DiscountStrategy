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
     * customer name --- don't need yet
     * date and time ---don't need yet
     * receipt no --- don't need yet
     * LineItem(s)
     * subtotal
     * amount saved (discount)
     * total
     */
    
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
     * @param item
     * @param qty
     */
    //add new line item (in array)
    public void addNewLineItem(LineItem item, int qty){
        
        //temporary array
        LineItem[] temp = new LineItem[lineItems.length + 1];
        
        //for loop to copy current array into temp array
        for(int i = 0; i < lineItems.length; i++){
            temp[i] = lineItems[i];
        }
        
        //add new line item
        temp[temp.length - 1] = new LineItem(item.getItem() , qty);
        //copy temp array to lineItems array
        lineItems = temp;
        //null temp array
        temp = null;
    }    
    
    public LineItem[] getLineItemArray(){
        return lineItems;
    }
    
    
//    public static void main(String[] args) {
//        LineItem item1 = new LineItem(new Item("A100", "Hat", 20.00, new QtyDiscount(0.10, 2)), 2);
//        LineItem item2 = new LineItem(new Item("A200", "Shirt", 45.00, new PercentOffDiscount(0.15)), 2);
//        
//        Receipt receipt = new Receipt();
//        
//        receipt.addNewLineItem(item1, 4);
//        receipt.addNewLineItem(item2, 1);
//        
//        LineItem[] items = receipt.getLineItemArray();
//        for(int i = 0; i < receipt.getLineItemArray().length; i++){
//            System.out.println(items[i].getItem().getItemID());
//        }
//        
//    }
}
