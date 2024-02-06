
package store;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;


public class Order {
    private int orderId;
    private Customer customer;
    private Map<Product, Integer> products;
    private double totalCost;
    private Payment payment;
    private Shipping shipping;
    private LocalDate orderDate;
    private ORDER_STATUS orderStatus;
    private static int idCounter;

    // Constructors
    public Order(Customer customer, double totalCost, 
                            Payment payment, Shipping shipping) {
        this.orderId = idCounter++;
        this.customer = customer;
        this.products = new HashMap<>();
        this.totalCost = totalCost;
        this.payment = payment;
        this.shipping = shipping;
        this.orderDate = LocalDate.now();
    }

    @Override
    public String toString() {
        return "Order{" + "orderId=" + orderId + ", customer=" + customer + ", products=" + products + ", totalCost=" + totalCost + ", payment=" + payment + ", shipping method=" + shipping.getShippingMethod() + ", shipping cost=" + shipping.getShippingCost() + ", orderDate=" + orderDate + ", order_status= " + orderStatus + '}';
    }
    
    
    // Getters
    public Customer getCustomer() {
        return customer;
    }

    public ORDER_STATUS getOrderStatus() {
        return orderStatus;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public int getOrderId() {
        return orderId;
    }

    public Map<Product, Integer> getProducts() {
        return products;
    }

    public Payment getPayment() {
        return payment;
    }

    public Shipping getShipping() {
        return shipping;
    }

    public double getTotalCost() {
        return totalCost;
    }
    
    // Setters
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public void setOrderStatus(ORDER_STATUS orderStatus) {
        this.orderStatus = orderStatus;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public void setProducts(Map<Product, Integer> products) {
        this.products = products;
    }

    public void setShipping(Shipping shipping) {
        this.shipping = shipping;
    }

    public void setTottalCost(double totalCost) {
        this.totalCost = totalCost;
    }  
}
