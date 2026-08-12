package ru.bulgacov.qa.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class WelcomePage {
    private final SelenideElement costPage = $$(".t-menu__list li").last();
    private final SelenideElement wantToQA = $x("/html/body/div[1]/div[42]/div/div/div[32]/div/a");
    private final SelenideElement runToPay = $(byText("Бегу оплачивать"));


    public ResultCostPage clickPrice() {
        sleep(3000);
        switchTo().window(1);
        costPage.click();//welcome страница обучения
        wantToQA.click();
        runToPay.click();

        return new ResultCostPage();
    }
}
