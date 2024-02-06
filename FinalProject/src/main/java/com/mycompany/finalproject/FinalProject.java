
package com.mycompany.finalproject;
import store.*;
import java.util.Map;

public class FinalProject {

    public static void main(String[] args) {

        //Create a new product
        Product p1 = new Product("iPhone8", "New iPhone", 999.99, 10);
        Product p2 = new Product("iPhone10", "New iPhone1", 1500, 13);

        // Create a new customer
        Customer customer1 = new Customer("John", "Smith", 
                            "123 Main St", "johnsmith@email.com");
        Customer customer2 = new Customer("Jack", "Smith", 
                            "124 Main St", "jacksmith@email.com");
        
       //Create a new Inventory
        Shop shop = new Shop();

        // Add the product to the inventory
        shop.addProduct(p1, 10);
        shop.addProduct(p2, 13);
        
        shop.addCustomer(customer1);
        shop.addCustomer(customer2);


        // Create a new shopping cart
        ShoppingCart cart = new ShoppingCart();
        ShoppingCart cart2 = new ShoppingCart();

        // Add the product to the cart
        cart.addProduct(p1, 5);
        cart2.addProduct(p2, 2);

//        cart.clearCart();

        // Print cart
        for (Map.Entry<Product, Integer> e: cart.getCartProducts().entrySet()){
            System.out.println("Cart 1");
            System.out.println(e.getKey());
            System.out.println(e.getValue());
        }
        
        for (Map.Entry<Product, Integer> e: cart2.getCartProducts().entrySet()){
            System.out.println("Cart 2");
            System.out.println(e.getKey());
            System.out.println(e.getValue());
        }
//        cart.removeProduct(p1);
        
        
        // Check if the product is in stock
        if (shop.inStock(p1)) {
            System.out.println("Product1 is in stock");
        } else {
            System.out.println("Product1 is out of stock");
        }
        
        if (shop.inStock(p2)) {
            System.out.println("Product2 is in stock");
        } else {
            System.out.println("Product2 is out of stock");
        }

        
        Discount discount = new Discount(p1, 10);
        Discount discount2 = new Discount(p2, 10);

        // Create a new payment
        Payment payment1 = new Payment("Credit Card",
                                    "1234567890", 
                                    customer1.getFullName(),
                                    discount.applyDiscount(cart.totalCost()),
                                    PAYMENT_STATUS.UNPAID);
        
        Payment payment2 = new Payment("Bank transfer",
                                    discount2.applyDiscount(cart2.totalCost()),
                                    "1234567850", 
                                    "123456789",
                                    PAYMENT_STATUS.UNPAID);

        // Print the total cost of items in the cart
        System.out.println("Total cost: " + cart.totalCost());
        
        // Print the payment details
        System.out.println("Payment amount: "+ payment1.getAmount());
        System.out.println("Payment method: "+ payment1.getPaymentMethod());
        payment1.makePayment();
        
        System.out.println("---------------------------------------------- ");

        // Print the total cost of items in the cart
        System.out.println("Total cost: " + cart2.totalCost());

        // Print the payment details
        System.out.println("Payment amount: "+ payment2.getAmount());
        System.out.println("Payment method: "+ payment2.getPaymentMethod());
        payment2.makePayment();

    
    Shipping shipping1 = new Shipping("Express", 9.0);
    Order order1 = new Order(customer1, cart.totalCost(),
                                payment1, shipping1);
    order1.setProducts(cart.getCartProducts());
    

    
    Shipping shipping2 = new Shipping("Express", 10.0);
    Order order2 = new Order(customer2, cart2.totalCost(),
                                payment2, shipping2);
    order2.setProducts(cart2.getCartProducts());

    shop.addOrder(order1);
    shop.addOrder(order2);
     
//    shop.cancelOrder(order1);
    
    shop.getOrdersOnCertainDayOfCurrentWeek();
//    shop.getInventoriesAndQunatitiesSaveToFile();
//    
//    shop.ItemsBoughtByCustomersSaveToFile();
//      
    }
}
