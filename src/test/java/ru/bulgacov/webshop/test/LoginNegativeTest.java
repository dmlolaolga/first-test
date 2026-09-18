package ru.bulgacov.webshop.test;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import ru.bulgacov.webshop.pages.WsWelcomePage;

import static com.codeborne.selenide.Selenide.*;
import static ru.bulgacov.webshop.config.Config.WEB_SHOP_URL;

@Tag("Login")
@Tag("Negative")
public class LoginNegativeTest extends TestBase {

    @ParameterizedTest(
            name = "Авторизация с невалидным email: {0}"
    )
    @CsvFileSource(resources = "/email.csv")
    @DisplayName("Сообщение об ошибке при вводе невалидного email")
    void invalidEmailLoginTest(String invalidEmail) {

        open(WEB_SHOP_URL, WsWelcomePage.class)
                .openLogin()
                .enterEmail(invalidEmail)
                .verifyEmailValidationErrorAppear();
    }
}