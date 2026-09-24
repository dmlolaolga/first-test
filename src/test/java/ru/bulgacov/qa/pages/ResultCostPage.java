package ru.bulgacov.qa.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Owner;
import io.qameta.allure.Step;
import jdk.jfr.Description;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

@Owner("Lola.Maer")
@Description("Страница с итоговым расчётом стоимости. " +
        "Содержит методы для проверки корректности отображения итоговой суммы.")
public class ResultCostPage extends BasePage {
    private final SelenideElement priceAmount = $(".ant-flex h3");

    @Step("Проверить, что итоговая сумма равна: '{expectedPrice}'")
    public ResultCostPage checkPriceAmount(String expectedPrice) {
        priceAmount.shouldHave(text(expectedPrice));

        return this;
    }
}
