package ru.bulgacov.webshop.pages;

import com.codeborne.selenide.ElementsCollection;
import io.qameta.allure.Owner;
import io.qameta.allure.Step;
import jdk.jfr.Description;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.$$;

@Owner("Lola.Maer")
@Description("Страница со списком товаров категории 'Desktops'. Позволяет открыть карточку конкретного товара по его названию.")
public class WsDesktopsPage {
    private final ElementsCollection productLinks = $$("h2.product-title a");

    @Step("Открыть карточку товара '{itemName}' из списка Desktops")
    public WsBuildYourOwnCheapComputerPage openProduct(String itemName) {
        productLinks.findBy(exactText(itemName)).click();
        return new WsBuildYourOwnCheapComputerPage();
    }
}
