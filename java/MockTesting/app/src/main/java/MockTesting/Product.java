package MockTesting;

public class Product {
    private String productID;
    private String name;
    private int quantity;

    public Product(String productID, String name, int quantity) {
        this.productID = productID;
        this.name = name;
        this.quantity = quantity;
    }

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getName() {
        return name;
    }
}
