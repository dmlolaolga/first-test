package ru.bulgacov.webshop.test;

import io.qameta.allure.*;
import net.datafaker.Faker;
import org.junit.jupiter.api.*;
import ru.bulgacov.webshop.pages.WsWelcomePage;

import static com.codeborne.selenide.Selenide.*;
import static ru.bulgacov.webshop.config.Config.WEB_SHOP_URL;

@Epic("Авторизация и регистрация")
@Feature("Регистрация нового пользователя")
@Owner("Lola.Maer")
@Tag("Registration")
public class RegistrationTest extends TestBase {
    private static final Faker faker = new Faker();

    @Test
    @Tag("positive")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Регистрация нового пользователя")
    //@Disabled
    @DisplayName("Успешная регистрация нового пользователя")
    @Description("Тест проверяет полный флоу регистрации нового пользователя: " +
            "открытие страницы регистрации → заполнение формы случайными данными через Faker → " +
            "подтверждение регистрации → проверка успешного сообщения → " +
            "проверка, что пользователь авторизован и email отображается в шапке.")
    @Link(name = "Тест-кейс", url = "https://...")
    @Issue("BUG-19")
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
