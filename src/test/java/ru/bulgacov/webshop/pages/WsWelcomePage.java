package ru.bulgacov.webshop.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Owner;
import io.qameta.allure.Step;
import jdk.jfr.Description;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

@Owner("Lola.Maer")
@Description("Главная страница (Welcome Page) веб-магазина. Содержит элементы навигации и проверки состояния авторизации пользователя.")
public class WsWelcomePage {
    private final SelenideElement registerButton = $("a.ico-register");
    private final SelenideElement loginLink = $("a.ico-login");
    private final SelenideElement userEmailInHeader =  $$("div.header-links ul li a").get(0);


    @Step("Открыть страницу регистрации")
    public WsRegistrationPage openRegistration() {
        registerButton.click();
        return new WsRegistrationPage();
    }

    @Step("Открыть страницу авторизации")
    public WsLoginPage openLogin() {
        loginLink.click();
        return new WsLoginPage();
    }

    @Step("Проверить, что пользователь {email} успешно авторизован")
    @Description("Проверяет наличие email пользователя в шапке сайта. Это основной индикатор того, " +
            "что сессия создана и пользователь вошел в систему.")
    public WsWelcomePage checkUserLoggedIn(String email) {
        userEmailInHeader.shouldHave(text(email));
        return this;

    }
}
