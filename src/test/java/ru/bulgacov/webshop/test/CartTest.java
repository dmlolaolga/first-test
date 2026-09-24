package ru.bulgacov.webshop.test;


import io.qameta.allure.*;
import jdk.jfr.Description;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ru.bulgacov.webshop.pages.WsBuildYourOwnCheapComputerPage;
import ru.bulgacov.webshop.pages.WsNavigationTopMenu;
import ru.bulgacov.webshop.pages.WsShoppingCart;
import ru.bulgacov.webshop.steps.AuthSteps;

import java.util.Locale;

import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static ru.bulgacov.webshop.config.Config.WEB_SHOP_URL;

@Epic("Корзина покупок")
@Feature("Добавление и проверка товаров")
@Owner("Lola.Maer")
@Description("Тесты, проверяющие функциональность корзины: добавление кастомизируемых товаров, " +
        "корректный расчет итоговой стоимости с учетом динамических наценок и количества.")
@Tag("Cart")
@Tag("Positive")
public class CartTest extends TestBase{
    private final AuthSteps authSteps = new AuthSteps();
    private static final String PRODUCT_NAME = "Build your own cheap computer";
    private static final String PROCESSOR = "Slow";
    private static final String ITEM_QUANTITY = "2";

    /**
     * Вычисляет наценку в зависимости от выбранного процессора.
     */
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
    @Step("Подготовка: Регистрация нового пользователя для теста корзины")
    void beforeEach() {
        authSteps.registerNewUser();
    }



    @Story("Расчет итоговой стоимости и количества товаров")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Проверка общей суммы, колличества добавленных товаров в корзине")
    @Description("Тест регистрирует пользователя, переходит к товару 'Build your own cheap computer', " +
            "выбирает процессор, устанавливает количество и добавляет товар в корзину. " +
            "Ожидаемая цена вычисляется динамически: Базовая цена + Наценка за процессор. " +
            "Проверяется соответствие фактической суммы в корзине вычисленному значению.")
    @Link(name = "Тест-кейс", url = "https://...")
    @Test
    void addItemToCartTest() {
        // Навигация и проверка базовых данных
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

        //Проверяем корзину ВЫЧИСЛЕННЫХ тестом значений
        WsShoppingCart cartPage = new WsShoppingCart();

        assertEquals(ITEM_QUANTITY, cartPage.getItemQuantityInCart(),
                "Количество товаров в корзине не совпадает с ожидаемым");
        cartPage.checkPriceSubtotal(expectedTotalPriceFormatted, ITEM_QUANTITY);
    }
}
