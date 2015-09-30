
package discountstategy;

/**
 *
 * @author Alyson
 */
public class LineItem {
    /**
     * what is in a line item?
     * 
     * the product information
     * id
     * name
     * qty
     * price
     * subtotal
     * discount
     */
    
    //item property
    private Item item;
    
    //properties
//    private String itemId; 
//    private String itemName;
    private int itemQty;
//    private double unitPrice;
//    private double discount;
//    private double subtotal;
    
    public LineItem(){
     
    }

    public LineItem(Item item, int itemQty) {
        //when calling LineItem constructor need to add new Item(String itemID,
        //String itemName, double unitPrice, DiscountStrategy discount)
        setItem(item);
        setItemQty(itemQty);
    }
    
    public double getSubTotal(){
        double subtotal = item.getUnitPrice() - item.getAmountSaved(itemQty);
        return subtotal;
    }
    
    public Item getItem() {
        return item;
    }

    public final void setItem(Item item) {
        this.item = item;
    }

    public int getItemQty() {
        return itemQty;
    }

    public final void setItemQty(int itemQty) {
        this.itemQty = itemQty;
    }

    
    //debug
//    public static void main(String[] args) {
//        LineItem lineItem = new LineItem(new Item("A100", "Hat", 20.00, new QtyDiscount(0.10, 2)), 2);
//        //create a Receipt LineItem
//        // ID     NAME      QTY     PRICE     SUBTOTAL     DISCOUNT
//        String id = lineItem.getItemId();
//        String name = lineItem.getItemName();
//        int qty = lineItem.getItemQty();
//        double unitPrice = lineItem.getUnitPrice();
//        double subtotal = lineItem.getSubTotal();
//        double discount = lineItem.getDiscount();
//        
//        System.out.println("Should get:");
//        System.out.println("A100   Hat    2    20.0   40.0   4.0");
//        System.out.println("Got:");
//        System.out.println(id + "\t" + name + "\t" + qty + "\t" + unitPrice + "\t"
//            + subtotal + "\t" + discount);
//    }
}
