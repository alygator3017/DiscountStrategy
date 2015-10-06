package discountstategy;

/**
 *
 * @author Alyson
 */
public class QtyDiscount implements DiscountStrategy {
    private double discountRate;
    public double minQty;

    /**
     *
     * @param discountRate
     * @param minQty
     */
    public QtyDiscount(double discountRate, int minQty) {
        if(discountRate <= 0 || minQty <= 1) {
            throw new IllegalArgumentException();
        }
        this.discountRate = discountRate;
        this.minQty = minQty;
    }
    
    @Override
    public final double getDiscountedProductTotal(double unitPrice, int qty){
        if(unitPrice < 0 || qty <= 0) {
            throw new IllegalArgumentException();
        }
        if(qty >= minQty){
            return (unitPrice * qty) - getAmountSaved(unitPrice, qty);
        }else{
            return unitPrice * qty;
        }
        
    }
    
    @Override
    public final double getAmountSaved(double unitPrice, int qty){
        if(unitPrice < 0 || qty <= 0) {
            throw new IllegalArgumentException();
        }
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
        if(discountRate <= 0) {
            throw new IllegalArgumentException();
        }
        this.discountRate = discountRate;
    }
    
    public final double getMinQty() {
        return minQty;
    }

    public final void setMinQty(double minQty) {
        if(minQty <= 1) {
            throw new IllegalArgumentException();
        }
        this.minQty = minQty;
    }
    
}
