package ru.bulgacov.webshop.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class WsBuildYourOwnCheapComputerPage {
    private final SelenideElement itemName = $("[itemprop=name]");
    private final SelenideElement itemPrice = $("[itemprop=price]");
    private final SelenideElement processorContainer = $$("dl dd ul").get(0);
    private final SelenideElement quantityCopiesItems = $("input.qty-input");
    private final SelenideElement addToCartButton = $("input.add-to-cart-button");
    private final SelenideElement successNotification = $("div.bar-notification.success");
    private final SelenideElement itemQuantityCart = $("span.cart-qty");
    private final SelenideElement cartIcon = $("a.ico-cart");

    //Проверяем, что имя на странице совпадает с ожидаемым из теста. Это ловит ошибку "открылся не тот товар".
    public WsBuildYourOwnCheapComputerPage checkProductName(String expectedName) {
        itemName.shouldHave(exactText(expectedName));
        return this;
    }

    //Возвращаем базовую цену как число. Добавлена очистка от пробелов и валюты на случай, если сайт вернет "1 200.00 ₽"
    public double getBasePrice() {
        String priceText = itemPrice.getText()
                .replace(",", ".")
                .replaceAll("[^0-9.]", "");
        return Double.parseDouble(priceText);
    }

    //Принимаем строку (например, "Medium"). Это делает тест чище и устойчивее к изменениям порядка элементов.
    public WsBuildYourOwnCheapComputerPage chooseProcessor(String processorName) {
        processorContainer.$$("li")
                .findBy(text(processorName))
                .$("input")
                .click();
        return this;
    }

    public WsBuildYourOwnCheapComputerPage setQuantityCopiesItems(String itemQuantity) {
        quantityCopiesItems.setValue(itemQuantity);
        return this;
    }

    public WsBuildYourOwnCheapComputerPage clickAddToCartButton() {
        addToCartButton.click();
        return this;
    }

    public WsBuildYourOwnCheapComputerPage shouldBeVisibleSuccessNotification() {
        successNotification.shouldBe(visible);
        return this;
    }

    public WsBuildYourOwnCheapComputerPage checkItemQuantityCart(String itemQuantity) {
        itemQuantityCart.shouldHave(text("(" + itemQuantity + ")"));
        return this;
    }

    public WsShoppingCart clickOnCartIcon() {
        cartIcon.click();
        return new WsShoppingCart();
    }

}