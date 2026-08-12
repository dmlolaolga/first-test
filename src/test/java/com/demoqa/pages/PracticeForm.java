package com.demoqa.pages;

import com.codeborne.selenide.SelenideElement;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class PracticeForm {
    private final SelenideElement name = $("#firstName");
    private final SelenideElement surname = $("[placeholder='Last Name']");
    private final SelenideElement email = $("[class='mr-sm-2 form-control']");
    private final SelenideElement genderMale = $("[id=gender-radio-1]");
    private final SelenideElement mobile = $("#userNumber");
    private final SelenideElement dateOfBirth = $("#dateOfBirthInput");
    private final SelenideElement yearOfBirth = $(".react-datepicker__year-select");
    private final SelenideElement monthOfBirth = $(".react-datepicker__month-select");
    //Этот селектор убран в функцию т.к. строку с $$ нельзя разделять с find
    //private final SelenideElement day = $$(".react-datepicker__day").find(text("15"));
    private final SelenideElement subjects = $("#subjectsInput");
    private final SelenideElement subjectsChoose = $(".subjects-auto-complete__menu");
    private final SelenideElement hobbiesSports = $("#hobbies-checkbox-1");
    private final SelenideElement picture = $("#uploadPicture");
    private final SelenideElement currentAddress = $("#currentAddress");
    private final SelenideElement state = $("#state");
    private final SelenideElement stateChoose = $("#state");
    private final SelenideElement city = $("#city");
    private final SelenideElement cityChoose = $("#city");
    private final SelenideElement submitButton = $("#submit");

    public PracticeForm fillName(String queryName) {
        name.setValue(queryName);

        return this;
    }

    public PracticeForm fillSurname(String querySurname) {
        surname.setValue(querySurname);

        return this;
    }

    public PracticeForm fillEmail(String queryEmail) {
        //4. Ввести почту alexander.petrov@test.ru
        email.setValue(queryEmail);

        return this;
    }

    public PracticeForm chooseAGenderMale() {
        //5. Выбрать пол Male
        genderMale.click();

        return this;
    }

    public PracticeForm fillPhoneNumber(String queryPhoneNumber) {
        //6. Ввести телефон 8799900011
        mobile.setValue(queryPhoneNumber);

        return this;
    }

    public PracticeForm fillDateOfBirth() {
        //7. Ввести дату рождения
        dateOfBirth.click();

        return this;
    }

    public PracticeForm chooseYearOfBirth(String queryYearOfBirth) {
        // Выбрать год рождения
        yearOfBirth.selectOption(queryYearOfBirth);

        return this;
    }

    public PracticeForm chooseMonthOfBirth(String queryMonthOfBirth) {
        // Выбрать месяц рождения
        monthOfBirth.selectOption(queryMonthOfBirth);

        return this;
    }

    public PracticeForm chooseABirthday(String queryBirthday) {
        // Выбрать день рождения
        $$(".react-datepicker__day").find(text(queryBirthday)).click();

        return this;
    }

    public PracticeForm writeAndChooseSubject(String querySubject) {
        //8. Написать предмет
        subjects.setValue(querySubject);
        subjectsChoose.$(byText(querySubject)).click();

        return this;
    }

    public PracticeForm chooseHobbiesSports() {
        //9. Выбрать хобби
        hobbiesSports.click();

        return this;
    }

    public PracticeForm uploadProfilePhoto(String queryProfilePhoto) {
        //10. Загрузить фото профиля
        picture.uploadFile(new File(queryProfilePhoto));

        return this;
    }

    public PracticeForm enterTheCurrentAddress(String queryCurrentAddress) {
        //11. Вписать адрес: г. Москва, ул. Тверская, д. 1
        currentAddress.setValue(queryCurrentAddress);

        return this;
    }

   public  PracticeForm chooseState(String queryState) {
       //12. Выбрать штат NCR
       state.scrollIntoView(true).click();
       stateChoose.$(byText(queryState)).click();

        return this;
   }

   public PracticeForm chooseCity(String queryCity) {
        //13. Выюрать город Delhi
       city.click();
       cityChoose.$(byText(queryCity)).click();

       return this;
   }

   public TableWithFinalData clickSubmitButton() {
       //14. Нажать кнопку Submit
       submitButton.click();

       return new TableWithFinalData();
   }

}

