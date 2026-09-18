package ru.bulgacov.webshop.pages;

import com.codeborne.selenide.ElementsCollection;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.$$;


public class WsDesktopsPage {
    private final ElementsCollection productLinks = $$("h2.product-title a");
    
    public WsBuildYourOwnCheapComputerPage openProduct(String itemName) {
        productLinks.findBy(exactText(itemName)).click();
        return new WsBuildYourOwnCheapComputerPage();
    }
}
