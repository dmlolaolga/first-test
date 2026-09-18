package com.demoqa.pages;

import com.codeborne.selenide.SelenideElement;

import java.io.File;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class PracticeForm {
    private final SelenideElement nameInput = $("#firstName"),
            surnameInput = $("[placeholder='Last Name']"),
            emailInput = $("[class='mr-sm-2 form-control']"),
            genderMaleRadio = $("[id=gender-radio-1]"),
            mobileInput = $("#userNumber");

    private final SelenideElement dateOfBirthInput = $("#dateOfBirthInput"),
            yearOfBirthSelect = $(".react-datepicker__year-select"),
            monthOfBirthSelect = $(".react-datepicker__month-select");

    private final SelenideElement subjectsInput = $("#subjectsInput"),
            subjectsMenu = $(".subjects-auto-complete__menu"),
            hobbiesSportsCheckbox = $("#hobbies-checkbox-1"),
            pictureInput = $("#uploadPicture"),
            currentAddressInput = $("#currentAddress"),
            stateSelect = $("#state"),
            citySelect = $("#city"),
            submitButton = $("#submit");

    /**
     * День зависит от даты из теста, поэтому метод, а не поле.
     * По тексту ищем условием findBy, а не CSS-селектором.
     * exactText, иначе "1" совпадёт с "15"; :not(--outside-month) отсекает соседние месяцы.
     */
    private SelenideElement dayOfBirth(String day) {
        return $$(".react-datepicker__day:not(.react-datepicker__day--outside-month)")
                .findBy(exactText(day));
    }

    public PracticeForm fillName(String name) {
        nameInput.setValue(name);

        return this;
    }

    public PracticeForm fillSurname(String surname) {
        surnameInput.setValue(surname);

        return this;
    }

    public PracticeForm fillEmail(String email) {
        emailInput.setValue(email);

        return this;
    }

    public PracticeForm chooseGenderMale() {
        genderMaleRadio.click();

        return this;
    }

    public PracticeForm fillPhoneNumber(String phoneNumber) {
        mobileInput.setValue(phoneNumber);

        return this;
    }

    // Дату не вводят, а выбирают - отсюда select. Год, месяц и день - одно действие.
    public PracticeForm selectDateOfBirth(String day, String month, String year) {
        dateOfBirthInput.click();
        yearOfBirthSelect.selectOption(year);
        monthOfBirthSelect.selectOption(month);
        dayOfBirth(day).click();

        return this;
    }

    public PracticeForm writeAndChooseSubject(String subject) {
        subjectsInput.setValue(subject);
        subjectsMenu.$(byText(subject)).click();

        return this;
    }

    public PracticeForm chooseHobbiesSports() {
        hobbiesSportsCheckbox.click();

        return this;
    }

    public PracticeForm uploadProfilePhoto(String photoPath) {
        pictureInput.uploadFile(new File(photoPath));

        return this;
    }

    public PracticeForm enterCurrentAddress(String address) {
        currentAddressInput.setValue(address);

        return this;
    }

    public PracticeForm chooseState(String state) {
        stateSelect.click();
        stateSelect.$(byText(state)).click();

        return this;
    }

    public PracticeForm chooseCity(String city) {
        citySelect.click();
        citySelect.$(byText(city)).click();

        return this;
    }

    public TableWithFinalData submit() {
        submitButton.click();

        return new TableWithFinalData();
    }
}
