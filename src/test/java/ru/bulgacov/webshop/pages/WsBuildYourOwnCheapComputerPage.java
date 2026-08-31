package ru.bulgacov.webshop.pages;

import com.codeborne.selenide.SelenideElement;

import java.util.Locale;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class WsBuildYourOwnCheapComputerPage {
    private final SelenideElement itemName = $("[itemprop=name]");
    private final SelenideElement itemPrice = $("[itemprop=price]");
    private final SelenideElement processor = $$("dl dd ul").get(0);
    private final SelenideElement quantityCopiesItems = $("input.qty-input");
    private final SelenideElement addToCartButton = $("input.add-to-cart-button");
    private final SelenideElement successNotification = $("div.bar-notification.success");
    private final SelenideElement itemQuantityCart = $("span.cart-qty");
    private final SelenideElement cartIcon = $("a.ico-cart");;

    public String getItemName() {
        return itemName.getText();
    }

    public String getItemPrice(int pocessorPower) {
        double price = Double.parseDouble(itemPrice.getText());

        if(pocessorPower == 1) {
            return String.format(Locale.US, "%.2f", price + 15);
        }

        if(pocessorPower == 2) {
            return String.format(Locale.US, "%.2f", price + 100);
        }

        return itemPrice.getText();
    }

    public String getItemQuantity() {
        return "2";
    }

    public WsBuildYourOwnCheapComputerPage chooseProcessor(int index) {
        processor.$$("li input").get(index).click();
        return this;
    }

    public WsBuildYourOwnCheapComputerPage setQuantityCopiesItems(String itemQuantity) {
        quantityCopiesItems.setValue(itemQuantity);
        return this;
    }

    public WsBuildYourOwnCheapComputerPage сlickAddToCartButton() {
        addToCartButton.click();
        return this;
    }

    public WsBuildYourOwnCheapComputerPage shouldBeVisibleSuccessNotification() {
        successNotification.shouldBe(visible);
        return this;
    }

    public WsBuildYourOwnCheapComputerPage сheckItemQuantityCart(String itemQuantity) {
        itemQuantityCart.shouldHave(text("(" + itemQuantity +")"));
        return this;
    }

    public WsShoppingCart clickOnCartIcon() {
        cartIcon.click();
        return new WsShoppingCart();
    }

}
