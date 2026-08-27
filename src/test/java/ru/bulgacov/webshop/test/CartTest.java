package ru.bulgacov.webshop.test;

import net.datafaker.Faker;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.bulgacov.webshop.pages.WsRegistrationPage;
import ru.bulgacov.webshop.steps.AuthSteps;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static ru.bulgacov.webshop.config.Config.WEB_SHOP_REGISTRATION_URL;
import static ru.bulgacov.webshop.config.Config.WEB_SHOP_URL;

public class CartTest {
    private static final Faker faker = new Faker();
    private final AuthSteps autSteps = new AuthSteps();

    @BeforeEach
    void beforEach() {
        autSteps.registerNewUser();
    }

    @Test
    void addItemToCartTest() {
        open(WEB_SHOP_URL);
        $$("ul.top-menu li a").get(1).hover();
        $(byText("Desktops")).click();
        $$("div.product-grid div").get(0).click();

        String itemName = $("[itemprop=name]").getText();
        String itemPrice = $("[itemprop=price]").getText();
        String itemQuantity = "2";


       $$("dl dd ul").get(0).$$("li input").get(0).click();
        $("input.qty-input").setValue(itemQuantity);
        $("input.add-to-cart-button").click();
        $("div.bar-notification.success").shouldBe(visible);
        $("span.cart-qty").shouldHave(text("(" + itemQuantity +")")); // (2)
        $("a.ico-cart").click();

        $("a.product-name").shouldHave(text(itemName));
        String itemQuantityInCart = $("input.qty-input").getAttribute("value");
        assertEquals(itemQuantity, itemQuantityInCart);

        $("span.product-subtotal").shouldHave(text(String.valueOf(
                Float.parseFloat(itemPrice) * Float.parseFloat(itemQuantity))));


        System.out.println(1);

    }
}
