package ru.bulgacov.webshop.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Owner;
import io.qameta.allure.Step;
import jdk.jfr.Description;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

@Owner("Lola.Maer")
@Description("Верхнее навигационное меню сайта. Отвечает за взаимодействие с главными разделами каталога (например, переход в раздел 'Computers' и выбор подкатегории).")
public class WsNavigationTopMenu {
    private final SelenideElement topMenu =  $$("ul.top-menu li a").get(1);
    private final SelenideElement catalogDesktops = $(byText("Desktops"));

    @Step("Навести курсор на пункт меню 'Computers' в верхнем меню")
    public WsNavigationTopMenu hoverComputersTopMenu() {
        topMenu.hover();
        return this;
    }

    @Step("Выбрать категорию 'Desktops' из выпадающего меню")
    public WsDesktopsPage chooseDesktops() {
        catalogDesktops.click();
        return new WsDesktopsPage();
    }
}