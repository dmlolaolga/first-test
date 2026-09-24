package ru.bulgacov.webshop.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Owner;
import io.qameta.allure.Step;
import jdk.jfr.Description;

import java.util.Locale;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

@Owner("Lola.Maer")
@Description("Страница корзины покупок (Shopping Cart). Отвечает за валидацию состава корзины " +
        "и проверку корректности математических расчетов на стороне фронтенда.")
public class WsShoppingCart {
    private final SelenideElement productName = $("a.product-name");
    private final SelenideElement itemQuantityInCart = $("input.qty-input");
    private final SelenideElement priceSubtotal = $("span.product-subtotal");

    @Step("Проверить название товара в корзине: {itemName}")
    public WsShoppingCart checkProductName(String itemName) {
        productName.shouldHave(text(itemName));
        return this;
    }

    @Step("Получить текущее количество товаров в поле ввода")
    @Description("Возвращает значение атрибута 'value' из поля количества. " +
            "Allure автоматически отобразит возвращаемое значение в отчете.")
    public String getItemQuantityInCart() {
        return itemQuantityInCart.getAttribute("value");
    }

    @Step("Проверить корректность итоговой стоимости: цена {itemPrice}, количество {itemQuantity}")
    @Description("Вычисляет ожидаемую сумму (цена × количество) и сверяет её с отображаемой на странице. " +
            "Использует exactText для предотвращения частичных совпадений и Locale.US для корректного формата чисел.")
    public WsShoppingCart checkPriceSubtotal(String itemPrice, String itemQuantity) {
        // Вычисляем ожидаемую сумму
        float total = Float.parseFloat(itemPrice) * Float.parseFloat(itemQuantity);

        // Форматируем число: %.2f означает "число с плавающей точкой, 2 знака после запятой"
        // Locale.US гарантирует, что разделителем будет точка, а не запятая
        String expectedTotal = String.format(Locale.US, "%.2f", total);

        priceSubtotal.shouldHave(exactText(expectedTotal));
        return this;
    }
}