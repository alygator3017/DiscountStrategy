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
public class CashRegister {
    private ReceiptInformation receipt;
    //start sale
    public final void startSale(String customerID, DatabaseAccessStrategy db, OutputStrategy output){
         receipt = new ReceiptInformation(customerID, db, output);
    }
    //add item
    public final void addNewItem(String itemID, int qty){
        receipt.addNewLineItem(itemID, qty);
    }
    
    //end sale
    public final void endSale(){
        receipt.outputReceipt();
    }
}
