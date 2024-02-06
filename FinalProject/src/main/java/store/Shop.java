
package store;
import java.util.ArrayList;
import java.util.List;
//File 
import java.io.FileWriter;  
import java.io.File;  
import java.io.IOException;
import java.io.BufferedWriter;
// input
import java.util.Scanner;
// time
import java.time.DayOfWeek;
// Exceptions
import java.util.InputMismatchException;


public class Shop {
    private List<Product> products = new ArrayList<>();
    private List<Order> orders = new ArrayList<>();
    private List<Customer> customers = new ArrayList<>();

    
    public Shop() {}
    
    // Add customer
    public void addCustomer(Customer customer){ customers.add(customer); }

    // Add a product to a store inventory
    public void addProduct(Product product, int stock) {
        if (products.contains(product)){
            products.get(products.lastIndexOf(product)).setStockLevel(stock);
        } else {
            product.setStockLevel(stock);
            products.add(product);
        }
    }
    
    // Remove product and reject related orders if requested
    public void removeProductAndRejectOrdersWithProduct(Product product, boolean reject_orders){
        if (products.contains(product)) {
            products.remove(product);
            if (reject_orders) {
                orders.stream()
                        .filter(order -> order.getProducts().containsKey(product))
                        .toList()
                        .forEach(order -> order.setOrderStatus(ORDER_STATUS.REJECTED));
            }
        }
    }
    
    // Reduce the stock of bought products by the their quantity in an order
    public void reduceStockOfProductsOrdered(Order order) {
        order.getProducts().forEach((p, quantityInOrder) -> {
           p.setStockLevel(p.getStockLevel() - quantityInOrder);
        });
    }
    
    // Add an order or deny it if the product's stock was sold out 
    public void addOrder(Order newOrder) {
        newOrder.getProducts().forEach((p, q) -> {
            if (q > p.getStockLevel()) {
                System.out.println("Order denied! Item " + p.getName() + " has been sold out.");
                newOrder.setOrderStatus(ORDER_STATUS.REJECTED);
            } else {
               orders.add(newOrder); 
               reduceStockOfProductsOrdered(newOrder);
               newOrder.setOrderStatus(ORDER_STATUS.OPEN);
            }
        });
    }
    
    // Cancel order if it's unpaid or not canceled
    public void cancelOrder(Order orderToCalncel) {
        if (orders.contains(orderToCalncel)) {
            if ( orderToCalncel.getOrderStatus() != ORDER_STATUS.CANCELED 
                    && orderToCalncel.getOrderStatus() != ORDER_STATUS.REJECTED
                    && orderToCalncel.getPayment().getPaymentStatus() != PAYMENT_STATUS.PAID) {
                
//                orders.remove(orderToCalncel);
                orderToCalncel.setOrderStatus(ORDER_STATUS.CANCELED);
                System.out.println("Order canceled...");
            } else System.out.println("Order not valid or already paid...");
        }
    }
    
    // check if there is enough units of a product left
    public boolean inStock(Product product) {
        int value = product.getStockLevel();
        
        if (value > 0) {
            return true;
        }
        return false;
    }
    
    // update a stock of a product
    public void updateStock(Product product, int quantity) {
        int value = product.getStockLevel();
        value += quantity;
        product.setStockLevel(value);
    }
    
    // Write available inventory to a file
    public void getInventoriesAndQunatitiesSaveToFile(){
       
        try {
            BufferedWriter buffer = new BufferedWriter(
                    new FileWriter(new File("./inventory.txt"))
            );
            
            this.getProducts().stream().forEach(p -> {
                try {
                    buffer.write(
                            "Name: " 
                            + p.getName() 
                            + " " 
                            + "Stock: "
                            + String.valueOf(p.getStockLevel())
                            + " "
                            + "Price a unit: "
                            + String.valueOf(p.getPrice() + "\n")
                    );
                } catch(IOException e) {
                    e.getStackTrace();
                } 
            });
            buffer.close();
        } catch(IOException e) {
            e.getStackTrace();
        } 
    }
    
    // Get list of orders that were made on a particular day
    private List<Order> getOrdersOnCertainDayList(DayOfWeek day) {
        return orders.stream()
                      .filter(order -> order.getOrderDate().getDayOfWeek() == day)
                      .toList();
    }
    
    // according to user inputed number of a day get list of orders made on that day
    public void getOrdersOnCertainDayOfCurrentWeek() {
        while(true) {
            System.out.println("Enter a number of a day of a current week (1-7) or 0 to exit: ");
            Scanner input = new Scanner(System.in);

            try {
                int day = input.nextInt();
                
                switch(day) {
                    case 1:
                        getOrdersOnCertainDayList(DayOfWeek.MONDAY).forEach(order -> {
                             System.out.println("Order details: ");
                             System.out.println(order);
                        });
                        break;
                    case 2:
                        getOrdersOnCertainDayList(DayOfWeek.TUESDAY).forEach(order -> {
                             System.out.println("Order details: ");
                             System.out.println(order);
                        });
                        break;
                    case 3:
                        getOrdersOnCertainDayList(DayOfWeek.WEDNESDAY).forEach(order -> {
                             System.out.println("Order details: ");
                             System.out.println(order);
                        });
                        break;
                    case 4:
                        getOrdersOnCertainDayList(DayOfWeek.THURSDAY).forEach(order -> {
                             System.out.println("Order details: ");
                             System.out.println(order);
                        });
                        break;
                    case 5:
                        getOrdersOnCertainDayList(DayOfWeek.FRIDAY).forEach(order -> {
                             System.out.println("Order details: ");
                             System.out.println(order);
                        });
                    case 6:
                        getOrdersOnCertainDayList(DayOfWeek.SATURDAY).forEach(order -> {
                             System.out.println("Order details: ");
                             System.out.println(order);
                        });
                        break;
                    case 7:
                        getOrdersOnCertainDayList(DayOfWeek.SUNDAY).forEach(order -> {
                             System.out.println("Order details: ");
                             System.out.println(order);
                        });
                        break;
                    case 0:
                        break;
                    default:
                        System.out.println( "Invalid day of a week...");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Enter a number 1-7 or 0 to exit!!!");
            }
        }
    }
    
    // Write to a file customers and products bought by them
    public void ItemsBoughtByCustomersSaveToFile(){
        
        try {
            BufferedWriter buffer = new BufferedWriter(
                    new FileWriter(new File("./itemsBoughtByCustomers.txt"))
            );
                
            for (Customer customer : customers) {
                buffer.write(customer.getFirstName() + " " + customer.getLastName());
            
                orders.stream()
                    .filter(o -> o.getCustomer() == customer)
                    .filter(o -> o.getOrderStatus() == ORDER_STATUS.OPEN 
                            || o.getOrderStatus() == ORDER_STATUS.PENDING
                    )
                    .forEach(o -> {
                        o.getProducts().forEach( (p, q) -> {
                            try {
                                buffer.write(
                                            " Name: " 
                                            + p.getName() 
                                            + " " 
                                            + "Id: "
                                            + String.valueOf(p.getProductId())
                                            + " "
                                            + "Price a unit: "
                                            + String.valueOf(p.getPrice())
                                            + " "
                                            + "Quantity bought: "
                                            + String.valueOf(q) + "\n");
                            } catch(IOException e) {
                                e.getStackTrace();
                            }
                        });
                    });
            }
                buffer.close();
        }
        catch(IOException e) {
            e.getStackTrace();
        } 
    }
    
    // Getters Setters
    public List<Order> getOrders() {
        return orders;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
