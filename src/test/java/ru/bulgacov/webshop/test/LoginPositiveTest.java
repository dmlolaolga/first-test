package ru.bulgacov.webshop.test;

import io.qameta.allure.*;
import jdk.jfr.Description;
import net.datafaker.Faker;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import ru.bulgacov.webshop.pages.WsLoginPage;
import ru.bulgacov.webshop.pages.WsRegistrationPage;
import ru.bulgacov.webshop.pages.WsWelcomePage;

import static com.codeborne.selenide.Selenide.*;
import static ru.bulgacov.webshop.config.Config.*;

@Epic("Авторизация пользователей")
@Feature("Форма входа")
@Owner("Lola.Maer")
@Tag("Login")
@Tag("Positive")
public class LoginPositiveTest extends TestBase {

    private static final Faker faker = new Faker();

    private String email;
    private String password;

    @Nested
    @Story("Успешная авторизация")
    @Description("Набор тестов для проверки успешной авторизации ранее зарегистрированного пользователя")
    public class PositiveTests {

        @Step("Подготовка тестовых данных: регистрация нового пользователя")
        @Description("Генерирует случайные данные пользователя через Faker, регистрирует его " +
                "и проверяет успешность регистрации. После этого очищает cookies и localStorage " +
                "для изоляции теста авторизации.")
        @BeforeEach
        void beforeEach() {
            password = faker.harryPotter().character() + faker.number().positive();
            email = faker.internet().emailAddress();

            open(WEB_SHOP_REGISTRATION_URL, WsRegistrationPage.class)
                    .register(
                            faker.name().firstName(),
                            faker.name().lastName(),
                            email,
                            password)
                    .checkUserLoggedIn(email);

            cookies().clear();
            localStorage().clear();
        }

        @Test
        @Severity(SeverityLevel.CRITICAL)
        @DisplayName("Успешная авторизация зарегистрированного пользователя")
        @Description("Проверяет полный флоу успешной авторизации: " +
                "открытие страницы логина → ввод email и пароля → установка чекбокса 'Запомнить меня' → " +
                "подтверждение формы → проверка, что пользователь авторизован.")
       // @Link(name = "Тест-кейс", url = "https://...")
        void successLoginTest() {
            open(WEB_SHOP_LOGIN_URL, WsLoginPage.class)
                    .checkLoginPageOpened()
                    .enterEmail(email)
                    .enterPassword(password)
                    .checkRememberMe()
                    .submitLogin()
                    .checkUserLoggedIn(email);
        }
    }

    @ParameterizedTest(name = "Авторизация с невалидным email: {0}")
    @CsvFileSource(resources = "/email.csv")
    void innalidEmaiLoginTest(String email) {
        open(WEB_SHOP_URL, WsWelcomePage.class)
                .openLogin()
                .enterEmail(email)
                .enterPassword("password")
                .verifyEmailValidationErrorAppear()
                .submitLogin();
    }
}
