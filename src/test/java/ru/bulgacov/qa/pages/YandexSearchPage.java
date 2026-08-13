package ru.bulgacov.qa.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class YandexSearchPage extends BasePage {
    private final SelenideElement searchInput = $("#text");

    public YandexSearchPage search(String query) {
        searchInput.setValue(query);

        return this;
    }

    public YandexSearchResultsPage submit() {
        searchInput.pressEnter();

        return new YandexSearchResultsPage();
    }
}
