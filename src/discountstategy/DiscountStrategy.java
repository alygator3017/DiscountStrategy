
package discountstategy;

/**
 *
 * @author Alyson
 */
public interface DiscountStrategy {

    public abstract double getAmountSaved(double unitPrice, int qty);

    public abstract double getDiscountRate();

    public abstract double getDiscountedProductTotal(double unitPrice, int qty);

    public abstract void setDiscountRate(double discountRate);
    
    
}
