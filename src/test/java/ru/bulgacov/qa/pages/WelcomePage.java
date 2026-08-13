package ru.bulgacov.qa.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.$;

public class WelcomePage extends BasePage {
    private final SelenideElement priceMenuButton = $$(".t-menu__list li").last(),
            wantToQaButton = $x("/html/body/div[1]/div[42]/div/div/div[32]/div/a"),
            runToPayButton = $(byText("Бегу оплачивать"));

    public WelcomePage openStudySection() {
        priceMenuButton.click();

        return this;
    }

    public WelcomePage clickWantToQa() {
        wantToQaButton.click();

        return this;
    }

    // Оплата открывается новой вкладкой, её Page Object даст switchToWindow
    public WelcomePage clickRunToPay() {
        runToPayButton.click();

        return this;
    }
}
