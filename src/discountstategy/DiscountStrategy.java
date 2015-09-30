
package discountstategy;

/**
 *
 * @author Alyson
 */
public interface DiscountStrategy {

    double getAmountSaved(double unitPrice, int qty);

    double getDiscountRate();

    double getDiscountedProductTotal(double unitPrice, int qty);

    void setDiscountRate(double discountRate);
    
    
}
