package ru.bulgacov.qa.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;

public class YandexSearchResultsPage {
    private final SelenideElement closeWindowFirst = $("[aria-label='Нет, спасибо']");
    private final SelenideElement closeWindowSecond = $("[class='Button DistributionButton DistributionButtonClose DistributionButtonClose_view_button Button_view_clear Button_size_l']");

    public YandexSearchResultsPage closeDefaultBrowserSelectWindow() {
        sleep(3000);
        if (closeWindowFirst.isDisplayed()) {
            closeWindowFirst.click();
        }

        if(closeWindowSecond.isDisplayed()) {
            closeWindowSecond.click();
        }

        return this;
    }

    public WelcomePage openLink(String webSiteName) {
        $(byText(webSiteName)).click();

        return new WelcomePage();
    }

}
