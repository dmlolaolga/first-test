package ru.bulgacov.webshop.pages;

import com.codeborne.selenide.SelenideElement;

import java.util.Locale;

import static com.codeborne.selenide.Condition.exactText;
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
        float total = Float.parseFloat(itemPrice) * Float.parseFloat(itemQuantity);

        // Форматируем число: %.2f означает "число с плавающей точкой, 2 знака после запятой"
        // Locale.US гарантирует, что разделителем будет точка, а не запятая
        String expectedTotal = String.format(Locale.US, "%.2f", total);

        priceSubtotal.shouldHave(exactText(expectedTotal));
        return this;
    }

}
