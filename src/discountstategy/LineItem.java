
package discountstategy;

/**
 *
 * @author Alyson
 */
public class LineItem {
      
    private Item item;    
    private int itemQty;
    
    public LineItem(){
     
    }

    /**
     *
     * @param item
     * @param itemQty
     */
    public LineItem(Item item, int itemQty) {
        if(item == null || itemQty <= 0) {
            throw new IllegalArgumentException();
        }
        setItem(item);
        setItemQty(itemQty);
    }
    
    public final double getSubTotal(){
        double subtotal = item.getUnitPrice() * itemQty;
        return subtotal;
    }
    
    public final Item getItem() {
        return item;
    }

    public final void setItem(Item item) {
        if(item == null) {
            throw new IllegalArgumentException();
        }
        this.item = item;
    }

    public final int getItemQty() {
        return itemQty;
    }

    public final void setItemQty(int itemQty) {
        if(itemQty <=0) {
            throw new IllegalArgumentException();
        }
        this.itemQty = itemQty;
    }

    public final double getDiscount(){
        return item.getAmountSaved(itemQty);
    }
    
}
