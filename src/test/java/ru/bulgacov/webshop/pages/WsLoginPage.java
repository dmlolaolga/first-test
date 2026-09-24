package ru.bulgacov.webshop.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import jdk.jfr.Description;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

@Owner("Lola.Maer")
@Severity(SeverityLevel.CRITICAL)
@Description("Страница авторизации пользователя. Содержит элементы формы входа, " +
        "методы для ввода учетных данных, обработки чекбокса 'Запомнить меня' и проверки ошибок валидации.")
public class WsLoginPage {

    private final SelenideElement pageTitle = $("div.page-title h1");
    private final SelenideElement emailInput = $("input#Email");
    private final SelenideElement passwordInput = $("input#Password");
    private final SelenideElement rememberMeCheckbox = $("input#RememberMe");
    private final SelenideElement loginButton = $("input.login-button");
    private final SelenideElement headerEmail = $("label[for='Email']");

    @Step("Проверить, что открыта страница авторизации")
    public WsLoginPage checkLoginPageOpened() {
        pageTitle.shouldHave(text("Welcome, Please Sign In!"));
        return this;
    }

    @Step("Ввести электронную почту {email}")
    public WsLoginPage enterEmail(String email) {
        emailInput.setValue(email);
        return this;
    }

    @Step("Ввести пароль {password}")
    public WsLoginPage enterPassword(String password) {
        passwordInput.setValue(password);
        return this;
    }

    @Step("Отметить чекбокс 'Запомнить меня'")
    public WsLoginPage checkRememberMe() {
        rememberMeCheckbox.click();
        return this;
    }

    @Step("Подтвердить авторизацию")
    public WsWelcomePage submitLogin() {
        loginButton.click();
        return new WsWelcomePage();
    }

    @Step("Проверить, что появилось сообщение с ошибкой валидации почты")
    public WsLoginPage verifyEmailValidationErrorAppear() {
        headerEmail.click();
        $("span.field-validation-error").shouldBe(visible);
        return this;
    }

}
