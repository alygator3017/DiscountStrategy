
package discountstategy;

/**
 *
 * @author Alyson
 */
public class PercentOffDiscount implements DiscountStrategy {

    private double discountRate;



    public PercentOffDiscount(double discountRate) {
        this.discountRate = discountRate;
    }
    
    @Override
    public final double getDiscountedProductTotal(double unitPrice, int qty){
        if(unitPrice < 0 || qty <= 0) {
            throw new IllegalArgumentException();
        }
        return (unitPrice * qty) - getAmountSaved(unitPrice, qty);
    }
    
    @Override
    public final double getAmountSaved(double unitPrice, int qty){
        if(unitPrice < 0 || qty <= 0) {
            throw new IllegalArgumentException();
        }
        return (unitPrice * qty) * discountRate;
    }

    @Override
    public final double getDiscountRate() {
        return discountRate;
    }

    @Override
    public final void setDiscountRate(double discountRate) {
        if(discountRate < 0) {
            throw new IllegalArgumentException();
        }
        this.discountRate = discountRate;
    }
    

}
