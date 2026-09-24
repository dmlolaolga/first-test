package ru.bulgacov.webshop.test;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import ru.bulgacov.webshop.pages.WsWelcomePage;

import static com.codeborne.selenide.Selenide.*;
import static ru.bulgacov.webshop.config.Config.WEB_SHOP_URL;

@Epic("Авторизация пользователей")
@Feature("Форма входа")
@Story("Валидация email при авторизации")
@Owner("Lola.Maer")
@Tag("Login")
@Tag("Negative")
public class LoginNegativeTest extends TestBase {

    @ParameterizedTest(
            name = "Авторизация с невалидным email: {0}"
    )
    @CsvFileSource(resources = "/email.csv")
    @DisplayName("Сообщение об ошибке при вводе невалидного email")
    @Severity(SeverityLevel.NORMAL)
    @Description("Проверяет, что при вводе невалидного email в форме авторизации " +
            "появляется сообщение об ошибке валидации. Тестовые данные берутся " +
            "из файла /email.csv и включают различные некорректные форматы email.")
    //@Issue("BUG-456")
    //@Link(name = "Требование", url = "https:...")
    void invalidEmailLoginTest(String invalidEmail) {

        open(WEB_SHOP_URL, WsWelcomePage.class)
                .openLogin()
                .enterEmail(invalidEmail)
                .verifyEmailValidationErrorAppear();
    }
}