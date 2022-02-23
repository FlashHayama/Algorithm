package MockTesting;

import java.util.List;

public class ShoppingCart {
    private ProductService productService;
    private List<Product> products;

    public ProductService getProductService() {
        return productService;
    }

    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public double getCartValue() {
        double result = 0;
        for(Product p : products) {
            result += productService.getPrice(p) * p.getQuantity();
        }
        result = result * productService.getDiscount(result);
        return result;
    }
}
