package discountstategy;

/**
 *
 * @author Alyson
 */
public class Item {
    //properties
    private String itemID;
    private String itemName;
    private double unitPrice;
    //DiscountStrategy passed in
    private DiscountStrategy discount;
    
    //constructor

    public Item() {
    }

    /**
     *
     * @param itemID
     * @param itemName
     * @param unitPrice
     * @param discount
     */
    public Item(String itemID, String itemName, double unitPrice, DiscountStrategy discount) {
        setItemID(itemID);
        setItemName(itemName);
        setUnitPrice(unitPrice);
        setDiscount(discount);
    }
    
    public final double getAmountSaved(int qty){
        return discount.getAmountSaved(unitPrice, qty);
    }
    
    public final double getDiscountedProductTotal(int qty){
        return discount.getDiscountedProductTotal(unitPrice, qty);
    }
    

    public final String getItemID() {
        return itemID;
    }

    public final void setItemID(String itemID) {
        this.itemID = itemID;
    }

    public final String getItemName() {
        return itemName;
    }

    public final void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public final double getUnitPrice() {
        return unitPrice;
    }

    public final void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public final DiscountStrategy getDiscount() {
        return discount;
    }

    public final void setDiscount(DiscountStrategy discount) {
        this.discount = discount;
    }
    
    //debug
//    public static void main(String[] args) {
//        Item item = new Item("A100", "Hat", 20.00, new PercentOffDiscount(0.10));
//        double amtSaved = item.getAmountSaved(2);
//        System.out.println("Expected 4.00 and got: " + amtSaved);
//        
//        Item item2 = new Item("A100", "Hat", 20.00, new QtyDiscount(0.10, 2));
//        double amtSaved2 = item.getAmountSaved(2);
//        System.out.println("Expected 4.00 and got: " + amtSaved2);
//    }
}
