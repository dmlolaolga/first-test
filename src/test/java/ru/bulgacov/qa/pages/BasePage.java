package ru.bulgacov.qa.pages;

import static com.codeborne.selenide.Selenide.page;
import static com.codeborne.selenide.Selenide.switchTo;

public abstract class BasePage {

    /**
     * Переключение на вкладку по индексу (0 - первая) с получением её Page Object.
     * Работает как селенидовский open(url, Page.class): передали класс - получили этот тип.
     */
    public <T> T switchToWindow(int index, Class<T> pageClass) {
        switchTo().window(index);

        return page(pageClass);
    }
}
