
package discountstategy;

/**
 *
 * @author Alyson
 */
public class NoDiscount implements DiscountStrategy{
    public NoDiscount(){
        
    }
    @Override
    public double getAmountSaved(double unitPrice, int qty) {
        return 0.0;
    }

    @Override
    public double getDiscountRate() {
        return 0.0;
    }

    @Override
    public double getDiscountedProductTotal(double unitPrice, int qty) {
        return unitPrice * qty;
    }

    @Override
    public final void setDiscountRate(double discountRate) {
        
    }
    
}
