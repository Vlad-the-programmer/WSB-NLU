
package store;
import java.util.HashMap;
import java.util.Map;



public class ShoppingCart {
    private Map<Product, Integer> cart;
    
    // Constructors
    public ShoppingCart() {
        this.cart = new HashMap<>();
    }

    // add a product to a cart
    public void addProduct(Product product, int quantity) {
        if(cart.containsKey(product)){
            cart.compute(product, 
                    (p,q ) -> q+quantity <= product.getStockLevel()? q + quantity: 1);
        }else{
            cart.put(product, quantity);
        }
    }
    
    // remove a product to a cart
    public void removeProduct(Product product) {
        try{
            if(cart.get(product) > 1){
                cart.compute(product, (p, q) -> q-1);
            }else{
                cart.remove(product);
            }
        } 
        catch (NullPointerException e){
            System.out.println("The cart is empty. No products to remove...");
        }
    }
    
    // returns a num of products in a cart
    public int cartSize() {
        return cart.size();
    }
    
    // Get products and their quantities in cart
    public Map<Product, Integer> getCartProducts() {
        return cart;
    }
       
    // calculate and return a total cost of all products in a cart
    public double totalCost() {
        double total = 0.0;
        
        try{
            for (Map.Entry<Product, Integer> entry : cart.entrySet()) {
                Product product = entry.getKey();
                int quantity = entry.getValue();

                total += (product.getPrice() * quantity);
            }
        }
        catch (NullPointerException e){
            return 0.0;
        }
        return total;
    }
    
     // Clear cart
    public void clearCart(){
        if (cart != null){
            cart.clear();
        }
        System.out.println("Cart is already empty!");
    }
}
