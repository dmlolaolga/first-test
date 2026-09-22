package ru.bulgacov.webshop.test;

import io.qameta.allure.*;
import net.datafaker.Faker;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import ru.bulgacov.webshop.pages.WsWelcomePage;
import ru.bulgacov.webshop.test.TestBase;

import static com.codeborne.selenide.Selenide.*;
import static ru.bulgacov.webshop.config.Config.WEB_SHOP_URL;


public class RegistrationTest extends TestBase {
    private static final Faker faker = new Faker();

    @Test
    @Tag("positive")
    //@Order("")
    @Severity(SeverityLevel.CRITICAL)
    @Epic("Авторизация")
    @Feature("Регистрация")
    @Story("Регистрация нового пользователя")
    @Link("TASK-120")
    @Issue("BUG-19")
    @DisplayName("Успешная регистраця нового пользователя")
    @Description("Создаём нового пользователя со случайными данными через интерфейс")
    //@Disabled
    void registrationTest() {
        String password = faker.harryPotter().character() + faker.number().positive();
        String email = faker.internet().emailAddress();

        open(WEB_SHOP_URL, WsWelcomePage.class)
                .openRegistration()
                .verifyRegistrationOpened()
                .selectMaleGender()
                .enterFirstName(faker.name().firstName())
                .enterLastName(faker.name().lastName())
                .enterEmail(email)
                .enterPassword(password)
                .confirmPassword(password)
                .submitRegistration()
                .checkRegistrationCompleted()
                .checkUserLoggedIn(email);
    }
}
