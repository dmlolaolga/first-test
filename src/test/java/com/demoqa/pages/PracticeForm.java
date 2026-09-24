package com.demoqa.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import jdk.jfr.Description;

import java.io.File;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

@Owner("Lola.Maer")
@Severity(SeverityLevel.NORMAL)
@Description("Практическая форма DemoQA. Содержит методы для заполнения всех полей: " +
        "личные данные, контакты, выбор даты из календаря, загрузка файлов и выбор региона.")
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

    @Step("Заполнить поле 'First Name': '{name}'")
    public PracticeForm fillName(String name) {
        nameInput.setValue(name);

        return this;
    }

    @Step("Заполнить поле 'Last Name': '{surname}'")
    public PracticeForm fillSurname(String surname) {
        surnameInput.setValue(surname);

        return this;
    }

    @Step("Заполнить поле 'Email': '{email}'")
    public PracticeForm fillEmail(String email) {
        emailInput.setValue(email);

        return this;
    }

    @Step("Выбрать пол: Male")
    public PracticeForm chooseGenderMale() {
        genderMaleRadio.click();

        return this;
    }

    @Step("Заполнить номер телефона: '{phoneNumber}'")
    public PracticeForm fillPhoneNumber(String phoneNumber) {
        mobileInput.setValue(phoneNumber);

        return this;
    }

    // Дату не вводят, а выбирают - отсюда select. Год, месяц и день - одно действие.
    @Step("Выбрать дату рождения: '{day} {month} {year}'")
    public PracticeForm selectDateOfBirth(String day, String month, String year) {
        dateOfBirthInput.click();
        yearOfBirthSelect.selectOption(year);
        monthOfBirthSelect.selectOption(month);
        dayOfBirth(day).click();

        return this;
    }

    @Step("Ввести и выбрать предмет: '{subject}'")
    public PracticeForm writeAndChooseSubject(String subject) {
        subjectsInput.setValue(subject);
        subjectsMenu.$(byText(subject)).click();

        return this;
    }

    @Step("Выбрать хобби: Sports")
    public PracticeForm chooseHobbiesSports() {
        hobbiesSportsCheckbox.click();

        return this;
    }

    @Step("Загрузить фото профиля: '{photoPath}'")
    public PracticeForm uploadProfilePhoto(String photoPath) {
        pictureInput.uploadFile(new File(photoPath));

        return this;
    }

    @Step("Заполнить текущий адрес: '{address}'")
    public PracticeForm enterCurrentAddress(String address) {
        currentAddressInput.setValue(address);

        return this;
    }

    @Step("Выбрать штат: '{state}'")
    public PracticeForm chooseState(String state) {
        stateSelect.click();
        stateSelect.$(byText(state)).click();

        return this;
    }

    @Step("Выбрать город: '{city}'")
    public PracticeForm chooseCity(String city) {
        citySelect.click();
        citySelect.$(byText(city)).click();

        return this;
    }

    @Step("Отправить форму")
    public TableWithFinalData submit() {
        submitButton.click();

        return new TableWithFinalData();
    }
}
