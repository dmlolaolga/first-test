package ru.bulgacov.qa.pages;

import io.qameta.allure.Owner;
import io.qameta.allure.Step;
import jdk.jfr.Description;

import static com.codeborne.selenide.Selenide.page;
import static com.codeborne.selenide.Selenide.switchTo;

@Owner("Lola.Maer")
@Description("Базовый абстрактный класс для всех Page Object'ов проекта. " +
        "Содержит общие методы навигации между окнами/вкладками браузера, " +
        "доступные всем наследникам.")
public abstract class BasePage {

    /**
     * Переключение на вкладку по индексу (0 - первая) с получением её Page Object.
     * Работает как селенидовский open(url, Page.class): передали класс - получили этот тип.
     */
    @Step("Переключиться на вкладку с индексом {index} и получить Page Object типа {pageClass}")
    public <T> T switchToWindow(int index, Class<T> pageClass) {
        switchTo().window(index);

        return page(pageClass);
    }
}
