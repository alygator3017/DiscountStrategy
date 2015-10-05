
package discountstategy;

/**
 *
 * @author Alyson
 */
public class NoDiscount implements DiscountStrategy{
    public NoDiscount(){
        
    }
    @Override
    public final double getAmountSaved(double unitPrice, int qty) {
        return 0.0;
    }

    @Override
    public final double getDiscountRate() {
        return 0.0;
    }

    @Override
    public final double getDiscountedProductTotal(double unitPrice, int qty) {
        return unitPrice * qty;
    }

    @Override
    public final void setDiscountRate(double discountRate) {
        
    }
    
}
