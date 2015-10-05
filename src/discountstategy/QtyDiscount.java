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
public class QtyDiscount implements DiscountStrategy {
    //discount rate
    private double discountRate;
    public double minQty;
    //return discount
    //return discount price

    /**
     *
     * @param discountRate
     * @param minQty
     */
    public QtyDiscount(double discountRate, int minQty) {
        this.discountRate = discountRate;
        this.minQty = minQty;
    }
    
    @Override
    public final double getDiscountedProductTotal(double unitPrice, int qty){
        if(qty >= minQty){
            return (unitPrice * qty) - getAmountSaved(unitPrice, qty);
        }else{
            return unitPrice * qty;
        }
        
    }
    
    @Override
    public final double getAmountSaved(double unitPrice, int qty){
        if(qty >= minQty){
            return (unitPrice * qty) * discountRate;
        }else{
            return 0;
        }
        
    }

    @Override
    public final double getDiscountRate() {
        return discountRate;
    }

    @Override
    public final void setDiscountRate(double discountRate) {
        this.discountRate = discountRate;
    }
    
    public final double getMinQty() {
        return minQty;
    }

    public final void setMinQty(double minQty) {
        this.minQty = minQty;
    }
    
    //debug
//    public static void main(String[] args) {
//        DiscountStrategy discount = new QtyDiscount(0.10, 5);
////        discount.setDiscountRate(0.10);
//        double amt = discount.getAmountSaved(10.00, 2 );
//        System.out.println("Discount amt: $" + amt);
//        
//        double newTotal = discount.getDiscountedProductTotal(10.00, 2 );
//        System.out.println("Discounted Price Total: $" + newTotal);
//    }
}
