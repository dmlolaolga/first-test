package ru.bulgacov.qa.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class ResultCostPage {
    private final SelenideElement costPage = $(".ant-flex h3");

    public ResultCostPage paymentAmountCheck(String number) {
        switchTo().window(2);
        sleep(10000);

        costPage.shouldHave(text(" " + number + " "));// страница оплаты

        return this;
    }

}
