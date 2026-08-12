package com.demoqa.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class TableWithFinalData {
    private final SelenideElement head = $("#example-modal-sizes-title-lg");
    private final SelenideElement dataInTheTable = $(".table");

    public TableWithFinalData checkTextHead(String queryTextHead) {
        // Проверка текста заголовка
        head.shouldHave(text(queryTextHead));

        return this;
    }

    public TableWithFinalData checkDataInTheTable(
            String queryNameAndSurname,
            String queryEmail,
            String queryGenderMale,
            String queryMobile,
            String queryDateOfBirth,
            String querySubjects,
            String queryHobbiesSports,
            String queryPicture,
            String queryCurrentAddress,
            String queryStateAndCity) {
        // Проверка введенного текста данных в таблице
        dataInTheTable.shouldHave(text(queryNameAndSurname),
                text(queryEmail),
                text(queryGenderMale),
                text(queryMobile),
                text(queryDateOfBirth),
                text(querySubjects),
                text(queryHobbiesSports),
                text(queryPicture),
                text(queryCurrentAddress),
                text(queryStateAndCity));

        return this;
    }

}
