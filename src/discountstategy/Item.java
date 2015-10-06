package discountstategy;

/**
 *
 * @author Alyson
 */
public class Item {

    private String itemID;
    private String itemName;
    private double unitPrice;

    private DiscountStrategy discount;
    


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
        if(itemID == null || itemID.isEmpty() || itemName == null || itemName.isEmpty() || unitPrice < 0 || discount == null) {
            throw new IllegalArgumentException();
        }
        setItemID(itemID);
        setItemName(itemName);
        setUnitPrice(unitPrice);
        setDiscount(discount);
    }
    
    public final double getAmountSaved(int qty){
        if(qty <= 0) {
            throw new IllegalArgumentException();
        }
        return discount.getAmountSaved(unitPrice, qty);
    }
    
    public final double getDiscountedProductTotal(int qty){
        if(qty <= 0) {
            throw new IllegalArgumentException();
        }
        return discount.getDiscountedProductTotal(unitPrice, qty);
    }
    

    public final String getItemID() {
        return itemID;
    }

    public final void setItemID(String itemID) {
        if(itemID == null || itemID.isEmpty()) {
            throw new IllegalArgumentException();
        }
        this.itemID = itemID;
    }

    public final String getItemName() {
        return itemName;
    }

    public final void setItemName(String itemName) {
        if(itemName == null || itemName.isEmpty()) {
            throw new IllegalArgumentException();
        }
        this.itemName = itemName;
    }

    public final double getUnitPrice() {
        return unitPrice;
    }

    public final void setUnitPrice(double unitPrice) {
        if(unitPrice < 0) {
            throw new IllegalArgumentException();
        }
        this.unitPrice = unitPrice;
    }

    public final DiscountStrategy getDiscount() {
        return discount;
    }

    public final void setDiscount(DiscountStrategy discount) {
        if(discount == null) {
            throw new IllegalArgumentException();
        }
        this.discount = discount;
    }
    

}
