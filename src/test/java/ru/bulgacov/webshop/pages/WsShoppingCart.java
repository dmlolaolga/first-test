package ru.bulgacov.webshop.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class WsShoppingCart {
    private final SelenideElement productName = $("a.product-name");
    private final SelenideElement itemQuantityInCart = $("input.qty-input");
    private final SelenideElement priceSubtotal = $("span.product-subtotal");

    public WsShoppingCart checkProductName(String itemName) {
        productName.shouldHave(text(itemName));
        return this;
    }

    public String getItemQuantityInCart() {
        return itemQuantityInCart.getAttribute("value");
    }

    public WsShoppingCart checkPriceSubtotal(String itemPrice, String itemQuantity) {
        priceSubtotal.shouldHave(text(String.valueOf(
                Float.parseFloat(itemPrice) * Float.parseFloat(itemQuantity))));
        return this;
    }

}
