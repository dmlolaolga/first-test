package package1;

import static package1.User.randomNumber;

public class UserTest {
    public static void main(String[] args) {
        User user1 = new User();
        user1.setAge(randomNumber());
        user1.setFirstName("Lola");
        user1.setLastName("Kart");

        user1.greet();

        User user2 = new User();
        user2.setAge(randomNumber());
        user2.setFirstName("Masha");
        user2.setLastName("Valanova");

        user2.greet();
    }
}