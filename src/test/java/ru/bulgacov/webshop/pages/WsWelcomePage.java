package ru.bulgacov.webshop.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class WsWelcomePage {
    private final SelenideElement registerButton = $("a.ico-register");
    private final SelenideElement loginLink = $("a.ico-login");
    private final SelenideElement userEmailInHeader =  $$("div.header-links ul li a").get(0);

    public WsRegistrationPage openRegistration() {
        registerButton.click();
        return new WsRegistrationPage();
    }

    public WsLoginPage openLogin() {
        loginLink.click();
        return new WsLoginPage();
    }

    public WsWelcomePage checkUserLoggedId(String email) {
        userEmailInHeader.shouldHave(text(email));
        return this;

    }
}
