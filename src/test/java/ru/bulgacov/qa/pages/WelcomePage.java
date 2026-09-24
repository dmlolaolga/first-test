package ru.bulgacov.qa.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import jdk.jfr.Description;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.$;

@Owner("Lola.Maer")
@Severity(SeverityLevel.NORMAL)
@Description("Главная страница сайта. Содержит элементы навигации: меню стоимости, " +
        "кнопку перехода в раздел обучения и кнопку начала процесса оплаты.")
public class WelcomePage extends BasePage {
    private final SelenideElement priceMenuButton = $$(".t-menu__list li").last(),
            wantToQaButton = $x("/html/body/div[1]/div[42]/div/div/div[32]/div/a"),
            runToPayButton = $(byText("Бегу оплачивать"));

    public WelcomePage openStudySection() {
        priceMenuButton.click();

        return this;
    }

    @Step("Открыть раздел стоимости через меню")
    public WelcomePage clickWantToQa() {
        wantToQaButton.click();

        return this;
    }

    @Step("Нажать кнопку перехода в раздел обучения")// Оплата открывается новой вкладкой, её Page Object даст switchToWindow
    public WelcomePage clickRunToPay() {
        runToPayButton.click();

        return this;
    }
}
