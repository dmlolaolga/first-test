package ru.bulgacov.qa.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import jdk.jfr.Description;

import static com.codeborne.selenide.Selenide.$;

@Owner("Lola.Maer")
@Severity(SeverityLevel.NORMAL)
@Description("Страница поисковой системы Яндекс. Содержит методы для ввода поискового запроса и его отправки.")
public class YandexSearchPage extends BasePage {
    private final SelenideElement searchInput = $("#text");

    @Step("Ввести в поиск запрос: '{query}'")
    public YandexSearchPage search(String query) {
        searchInput.setValue(query);

        return this;
    }

    @Step("Отправить поисковый запрос нажатием клавиши Enter")
    public YandexSearchResultsPage submit() {
        searchInput.pressEnter();

        return new YandexSearchResultsPage();
    }
}
