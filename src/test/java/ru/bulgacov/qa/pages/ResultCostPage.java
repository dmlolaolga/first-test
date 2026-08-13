package ru.bulgacov.qa.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class ResultCostPage extends BasePage {
    private final SelenideElement priceAmount = $(".ant-flex h3");

    public ResultCostPage checkPriceAmount(String expectedPrice) {
        priceAmount.shouldHave(text(expectedPrice));

        return this;
    }
}
