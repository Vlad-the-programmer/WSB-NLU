
package store;

 public class Discount {
     
    private Product product;    
    private int discountPercent ;
    
    // Constructors
    public Discount(Product product, int discountPercent) {
        this.product = product;     
        this.discountPercent = discountPercent;
    }
    
    // Apply discount to a totalcost of a cart
    public double applyDiscount(double amount) {
        return amount - (amount * discountPercent) / 100;
    }
    
    // Getters and setters
    public Product getProduct() {
        return product;
    }
    
    public int getDiscountPercent() {
        return discountPercent;
    }

    public void setDiscountPercent(int discountPercent) {
        this.discountPercent = discountPercent;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
    
    @Override
    public String toString() {
        return "Discount [product=" + product + ", discountPercent=" + discountPercent + "]";
    }
}
