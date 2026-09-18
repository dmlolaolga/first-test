package ru.bulgacov.webshop.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class WsNavigationTopMenu {
    private final SelenideElement topMenu =  $$("ul.top-menu li a").get(1);
    private final SelenideElement catalogDesktops = $(byText("Desktops"));

    public WsNavigationTopMenu hoverComputersTopMenu() {
        topMenu.hover();
        return this;
    }

    public WsDecktopsPage chooseDesktops() {
        catalogDesktops.click();
        return new WsDecktopsPage();
    }
}
