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
public class PercentOffDiscount implements DiscountStrategy {
    //discount rate
    private double discountRate;
    //return discount
    //return discount price

    public PercentOffDiscount(double discountRate) {
        this.discountRate = discountRate;
    }
    
    @Override
    public double getDiscountedProductTotal(double unitPrice, int qty){
        return (unitPrice * qty) - getAmountSaved(unitPrice, qty);
    }
    
    @Override
    public double getAmountSaved(double unitPrice, int qty){
        return (unitPrice * qty) * discountRate;
    }

    @Override
    public double getDiscountRate() {
        return discountRate;
    }

    @Override
    public void setDiscountRate(double discountRate) {
        this.discountRate = discountRate;
    }
    
    //debug
//    public static void main(String[] args) {
//        PercentOffDiscount discount = new PercentOffDiscount(0.10);
////        discount.setDiscountRate(0.10);
//        double amt = discount.getAmountSaved(10.00, 2 );
//        System.out.println("Discount amt: $" + amt);
//        
//        double newTotal = discount.getDiscountedProductTotal(10.00, 2 );
//        System.out.println("Discounted Price Total: $" + newTotal);
//    }
}
