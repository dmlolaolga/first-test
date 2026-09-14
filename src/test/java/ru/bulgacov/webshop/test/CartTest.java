package ru.bulgacov.webshop.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ru.bulgacov.webshop.pages.WsBuildYourOwnCheapComputerPage;
import ru.bulgacov.webshop.pages.WsNavigationTopMenu;
import ru.bulgacov.webshop.pages.WsShoppingCart;
import ru.bulgacov.webshop.steps.AuthSteps;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static ru.bulgacov.webshop.config.Config.WEB_SHOP_URL;

@Tag("Cart")
@Tag("Positive")
public class CartTest extends TestBase {
    private final AuthSteps autSteps = new AuthSteps();
    public int pocessorPower = 0;

    @BeforeEach
    void beforEach() {
        autSteps.registerNewUser();
    }

    @Test
    @DisplayName("Проверка общей суммы, колличества добавленных товаров в корзине")
    void addItemToCartTest() {
        WsBuildYourOwnCheapComputerPage page =
                open(WEB_SHOP_URL, WsNavigationTopMenu.class)
                        .hoverComputersTopMenu()
                        .chooseDesktops()
                        .chooseFirstComputer();
        String itemName = page.getItemName();
        String itemPrice = page.getItemPrice(pocessorPower);
        String itemQuantity = page.getItemQuantity();
        page.chooseProcessor(pocessorPower)
                .setQuantityCopiesItems(itemQuantity)
                .сlickAddToCartButton()
                .shouldBeVisibleSuccessNotification()
                .сheckItemQuantityCart(itemQuantity)
                .clickOnCartIcon()
                .checkProductName(itemName);

        WsShoppingCart pageWsShoppingCart = new WsShoppingCart();
        assertEquals(itemQuantity, pageWsShoppingCart.getItemQuantityInCart());
        pageWsShoppingCart.checkPriceSubtotal(itemPrice, itemQuantity);
    }
}