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
    
    //LineItem object
    private LineItem[] lineItem;
    
    //properties
    
    //subtotal of line item (price * qty from LineItem class) getSubTotal
    private double lineItemTotalPrice;
    //discount
    private double lineItemDiscount;
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
     */
    
}
