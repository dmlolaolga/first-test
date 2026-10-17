package package1;

public class CartTest {

    public static void main(String[] args) {
        Cart cart = new Cart();
        cart.addItem("Яйца", 100);
        cart.addItem("Мфсло", 200);

        System.out.println(cart.getTotalPrice());
    }
}
