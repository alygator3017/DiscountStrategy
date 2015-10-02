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
public class Tester {
    public static void main(String[] args) {
        LineItem item1 = new LineItem(new Item("A100", "Hat", 20.00, new QtyDiscount(0.10, 2)), 2);
        LineItem item2 = new LineItem(new Item("A200", "Shirt", 45.00, new PercentOffDiscount(0.15)), 2);
        
        Receipt receipt = new Receipt();
        
        receipt.addNewLineItem(item1, 4);
        receipt.addNewLineItem(item2, 1);
        
        LineItem[] items = receipt.getLineItemArray();
        for(int i = 0; i < receipt.getLineItemArray().length; i++){
            System.out.println(items[i].getItem().getItemID());
        }
        
    }
}
