package ru.bulgacov.webshop.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import jdk.jfr.Description;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

@Owner("Lola.Maer")
@Severity(SeverityLevel.CRITICAL) // Добавление в корзину и расчет цены — критический бизнес-процесс
@Description("Страница кастомизации товара 'Build your own cheap computer'. " +
        "Содержит методы выбора комплектующих, указания количества, получения базовой цены " +
        "и валидации успешного добавления товара в корзину.")
public class WsBuildYourOwnCheapComputerPage {
    private final SelenideElement itemName = $("[itemprop=name]");
    private final SelenideElement itemPrice = $("[itemprop=price]");
    private final SelenideElement processorContainer = $$("dl dd ul").get(0);
    private final SelenideElement quantityCopiesItems = $("input.qty-input");
    private final SelenideElement addToCartButton = $("input.add-to-cart-button");
    private final SelenideElement successNotification = $("div.bar-notification.success");
    private final SelenideElement itemQuantityCart = $("span.cart-qty");
    private final SelenideElement cartIcon = $("a.ico-cart");

    @Step("Проверить, что открыт товар с названием: '{expectedName}'")
//Проверяем, что имя на странице совпадает с ожидаемым из теста. Это ловит ошибку "открылся не тот товар".
    public WsBuildYourOwnCheapComputerPage checkProductName(String expectedName) {
        itemName.shouldHave(exactText(expectedName));
        return this;
    }

    @Step("Получить базовую цену товара")
//Возвращаем базовую цену как число. Добавлена очистка от пробелов и валюты на случай, если сайт вернет "1 200.00 ₽"
    public double getBasePrice() {
        String priceText = itemPrice.getText()
                .replace(",", ".")
                .replaceAll("[^0-9.]", "");
        return Double.parseDouble(priceText);
    }

    @Step("Выбрать процессор: '{processorName}'")
//Принимаем строку (например, "Medium"). Это делает тест чище и устойчивее к изменениям порядка элементов.
    public WsBuildYourOwnCheapComputerPage chooseProcessor(String processorName) {
        processorContainer.$$("li")
                .findBy(text(processorName))
                .$("input")
                .click();
        return this;
    }

    @Step("Установить количество товаров: '{itemQuantity}' шт.")
    public WsBuildYourOwnCheapComputerPage setQuantityCopiesItems(String itemQuantity) {
        quantityCopiesItems.setValue(itemQuantity);
        return this;
    }

    @Step("Нажать кнопку 'Добавить в корзину'")
    public WsBuildYourOwnCheapComputerPage clickAddToCartButton() {
        addToCartButton.click();
        return this;
    }

    @Step("Проверить появление зеленого уведомления об успешном добавлении")
    public WsBuildYourOwnCheapComputerPage shouldBeVisibleSuccessNotification() {
        successNotification.shouldBe(visible);
        return this;
    }

    @Step("Проверить отображение количества товаров на иконке корзины: '({itemQuantity})'")
    public WsBuildYourOwnCheapComputerPage checkItemQuantityCart(String itemQuantity) {
        itemQuantityCart.shouldHave(text("(" + itemQuantity + ")"));
        return this;
    }

    @Step("Перейти в корзину, нажав на иконку корзины в шапке")
    public WsShoppingCart clickOnCartIcon() {
        cartIcon.click();
        return new WsShoppingCart();
    }
}