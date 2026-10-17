package homework.tusk5;

import java.util.Objects;

public class Product {
    private String name;
    private double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public boolean equals (Object object) {
        if (this == object) return  true;
        if (object == null || getClass() != object.getClass()) return  false;
        Product product = (Product) object;
        return Double.compare(product.price, price) == 0 && Objects.equals(name, product.name);

    }

    @Override
    public int hashCode () {
        return Objects.hash(name,price);
    }

    @Override
    public String toString() {return name + " (" + price + " руб.)";
    }
}

