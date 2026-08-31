package ru.bulgacov.webshop.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$$;


public class WsDecktopsPage {
    private final SelenideElement firstComputer = $$("div.product-grid div").get(0);
    
    public WsBuildYourOwnCheapComputerPage chooseFirstComputer() {
        firstComputer.click();
        return new WsBuildYourOwnCheapComputerPage();
    }
}
