package ru.bulgacov.webshop;

import net.datafaker.Faker;
import org.junit.jupiter.api.Test;
import ru.bulgacov.webshop.pages.WsRegistrationPage;
import ru.bulgacov.webshop.pages.WsWelcomePage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static ru.bulgacov.webshop.config.Config.WEB_SHOP_URL;


public class RegistrationTest {
    private static final Faker faker = new Faker();

    @Test
    void registrationTest() {
        String password = faker.harryPotter().character() + faker.number().positive();
        String email = faker.internet().emailAddress();

        open(WEB_SHOP_URL, WsWelcomePage.class)
        .openRegistration()
                .verifyRegistratinOpened()
                .selectMaleGender()
                .enterFirstName(faker.name().firstName())
                .enterLastName(faker.name().lastName())
                .enterEmail(email)
                .enterPassword(password)
                .confirmPassword(password)
                .submitRegistration()
                .chekRegistrationCompleted()
                .chekUserLoggedIn(email);
    }
}
