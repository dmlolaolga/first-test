package homework.tusk5;

import java.util.HashMap;
import java.util.Map;

public class Cart {
    private Map<Product, Integer> products = new HashMap<>();
    public void  addProduct(Product product, int quantity) {
        int currentQuantity = products.getOrDefault(product, 0);
        products.put(product, currentQuantity + quantity);
    }
    public double getTotalPrice() {
        double total = 0;
        for (Map.Entry<Product, Integer> entry : products.entrySet()) {
            total += entry.getKey().getPrice() * entry.getValue();
        }
        return total;
    }
    public int getProductCount() {
        int count = 0;
        for (int quantity : products.values()) {
            count += quantity;
        }
        return count;
    }
    public static void main(String[] args) {
        Product milk = new Product("Молоко", 89.90);
        Product bread = new Product("Хлеб", 55.50);
        Product cheese = new Product("Сыр", 320.00);

        Cart cart = new Cart();
        cart.addProduct(milk, 3);
        cart.addProduct(bread, 2);
        cart.addProduct(cheese, 1);
        cart.addProduct(milk, 2);

        System.out.println("Общее количество товаров в корзине: " + cart.getProductCount());
        System.out.println("Общая сумма к оплате: " + cart.getTotalPrice() + " руб.");

    }
}
