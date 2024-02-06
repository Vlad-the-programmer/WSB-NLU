
package store;


public class Product {
    private int productId;
    private String name;
    private String description;
    private double price;
    private int stockLevel;
    private static int idCounter;

    // Constructors
    public Product(String name, String description, double price, int stockLevel) {
        this.productId = idCounter++;
        this.name = name;
        this.description = description;
        this.price = price;
        this.stockLevel = stockLevel;
    }

    @Override
    public String toString() {
        return "Product{" + "productId=" + productId + ", name=" + name + ", description=" + description + ", price=" + price + ", stockLevel=" + stockLevel + '}';
    }
    
    // Getters
    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getProductId() {
        return productId;
    }

    public int getStockLevel() {
        return stockLevel;
    }

    // Setters
    public void setPrice(double price) {
        this.price = price;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStockLevel(int stockLevel) {
        this.stockLevel = stockLevel;
    }
}
