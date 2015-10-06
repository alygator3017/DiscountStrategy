
package discountstategy;

/**
 *
 * @author Alyson
 */
public class CashRegister {
    private ReceiptInformation receipt;

    public final void startSale(String customerID, DatabaseAccessStrategy db, OutputStrategy output){
        
        if(customerID == null || customerID.isEmpty() || db == null || output == null) {
            throw new IllegalArgumentException();
        }
         receipt = new ReceiptInformation(customerID, db, output);
    }

    public final void addNewItem(String itemID, int qty){
        if(itemID == null || itemID.isEmpty() || qty <= 0) {
            throw new IllegalArgumentException();
        }
        receipt.addNewLineItem(itemID, qty);
    }
    

    public final void endSale(){
        receipt.outputReceipt();
    }
}
