
package store;

public class Shipping {
    private String shippingMethod;
    private double shippingCost;

    // Constructors
    public Shipping() {
        shippingMethod = "";
        shippingCost = 0.0;
    }

    public Shipping(String shippingMethod, double shippingCost) {
        this.shippingMethod = shippingMethod;
        this.shippingCost = shippingCost;
    }

    @Override
    public String toString() {
        return "Shipping{" + "shippingMethod=" + shippingMethod + ", shippingCost=" + shippingCost + '}';
    }
    
    // Getters and setters
    public String getShippingMethod() {
        return shippingMethod;
    }

    public double getShippingCost() {
        return shippingCost;
    }

    public void setShippingCost(double shippingCost) {
        this.shippingCost = shippingCost;
    }

    public void setShippingMethod(String shippingMethod) {
        this.shippingMethod = shippingMethod;
    }
    
    
    
    
}
