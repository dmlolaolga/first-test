package ru.bulgacov.qa.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class YandexSearchPage {
    private final SelenideElement searchInput = $("#text");
    private final SelenideElement submitPressEnter = $("#text");
    // fillSerchInput, clickSubmitButton (не рекомендуются)
    // search, submit
    public YandexSearchPage search(String query) {
        searchInput.setValue(query);//яндекс поиск

        return this;
    }

    public YandexSearchResultsPage pressEnter() {
        submitPressEnter.pressEnter();//яндекс поиск

        return new YandexSearchResultsPage();
    }
}