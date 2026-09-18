package ru.bulgacov.webshop.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.bulgacov.webshop.pages.WsBuildYourOwnCheapComputerPage;
import ru.bulgacov.webshop.pages.WsNavigationTopMenu;
import ru.bulgacov.webshop.pages.WsShoppingCart;
import ru.bulgacov.webshop.steps.AuthSteps;

import java.util.Locale;

import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static ru.bulgacov.webshop.config.Config.WEB_SHOP_URL;

public class CartTest {
    private final AuthSteps authSteps = new AuthSteps();
    private static final String PRODUCT_NAME = "Build your own cheap computer";
    private static final String PROCESSOR = "Slow";
    private static final String ITEM_QUANTITY = "2";

    private float processorSurcharge(String processor) {
        return switch (processor) {
            case "Slow" -> 0f;
            case "Medium" -> 15f;
            case "Fast" -> 100f;
            default -> throw new IllegalArgumentException(
                    "Unknown processor: " + processor
            );
        };
    }

    @BeforeEach
    void beforeEach() {
        authSteps.registerNewUser();
    }

    @Test
    void addItemToCartTest() {
        WsBuildYourOwnCheapComputerPage page =
                open(WEB_SHOP_URL, WsNavigationTopMenu.class)
                        .hoverComputersTopMenu()
                        .chooseDesktops()
                        .openProduct(PRODUCT_NAME)
                        .checkProductName(PRODUCT_NAME);

        double basePrice = page.getBasePrice();

        //Тест самостоятельно вычисляет ожидаемую итоговую цену
        float expectedSurcharge = processorSurcharge(PROCESSOR);
        double expectedTotalPrice = basePrice + expectedSurcharge;
        String expectedTotalPriceFormatted = String.format(Locale.US, "%.2f", expectedTotalPrice);

        //Выполняем действия, передавая в методы известные тестовые данные (строки), а не индексы
        page.chooseProcessor(PROCESSOR)
                .setQuantityCopiesItems(ITEM_QUANTITY)
                .clickAddToCartButton()
                .shouldBeVisibleSuccessNotification()
                .checkItemQuantityCart(ITEM_QUANTITY)
                .clickOnCartIcon();

        WsShoppingCart cartPage = new WsShoppingCart();

        //Проверяем корзину ВЫЧИСЛЕННЫХ тестом значений
        assertEquals(ITEM_QUANTITY, cartPage.getItemQuantityInCart());
        cartPage.checkPriceSubtotal(expectedTotalPriceFormatted, ITEM_QUANTITY);
    }
}
