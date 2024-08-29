import java.util.HashMap;
import java.util.Map;

class ShoppingManager {
    private Map<String, Product> products;  //https://www.w3schools.com/java/java_hashmap.asp

    public ShoppingManager() {
        this.products = new HashMap<>();
    }

    public void addProduct(Product product) {
        products.put(product.getName(), product);
    }

    public void removeProduct(String productName) {
        products.remove(productName);
    }

    public Map<String, Product> getProducts() {
        return products;
    }

    public double calculateTotalValue() {
        double totalValue = 0;
        for (Product product : products.values()) {
            totalValue += product.getTotalValue();
        }
        return totalValue;
    }
}