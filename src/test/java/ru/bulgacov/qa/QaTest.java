package ru.bulgacov.qa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class QaTest {

    @Test
    void mentoringPriceShouldBe47000Test() {
        /*
         * Тест-кейс - проверить, что  предоплата по обучению - 47000 рублей
         * 1. открыть поисковик (Яндекс)
         * 2. ввести данные сайта (bulgakov qa)
         * 3. нажать кеопку поиска
         * 4. в поисковой выдаче найти нужный сайт, кликнуть на него
         * 5. нажать на кнопку "Стоимость"
         * 6. нажать на кнопку "Хочу вкатиться в QA"
         * 7. нажать кнопку "Бегу оплачивать"
         * 8. проверить, что к оплате 47 000 рублей
         */
        Configuration.holdBrowserOpen = true;
        open("https://ya.ru/");
        $("#text").setValue("bulgakov qa");
        $(".search3__button.search3__button_icon_yes").pressEnter();

        //Убрать баннер "Установить браузер"
        if($("[aria-label='Нет, спасибо']").isDisplayed()) {
            $("[aria-label='Нет, спасибо']").click();
        }
        sleep(3000);
        $(".SplashscreenCentrePic .DistributionButtonClose").click();
        $(byText("ivanbulgakovqa.ru")).click();
        sleep(3000);

        switchTo().window(1);

        $$(".t-menu__list li").last().click();
        $x("/html/body/div[1]/div[42]/div/div/div[32]/div/a").click();
        $(byText("Бегу оплачивать")).click();

        switchTo().window(2);

        $(".ant-flex h3").shouldHave(text(" 47 000 "));
    }

    @Test
    void submitStudentRegistrationWithAllFieldsTest() {
        /*
         * Тест-кейс: Заполнение формы «Student Registration Form» на demoqa.com
         * 1. Открыть сайт https://demoqa.com/automation-practice-form
         * 2. Ввести имя «Александр»
         * 3. Фамилию «Петров»
         * 4. Почту alexander.petrov@test.ru
         * 5. Выберать пол Male
         * 6. Ввести телефон 8799900011
         * 7. Ввести дату рождения (15 марта 2000 года)
         * 8. Написать предмет Maths
         * 9. Поставить галочку на хобби Sports
         * 10. Загрузить фото профиля
         * 11. Вписать адрес: г. Москва, ул. Тверская, д. 1
         * 12. Выбрать штат NCR
         * 13. Выюрать город Delhi
         * 14. Нажать кнопку Submit
         * 15. Проверить, что в появившейся таблице все данные совпадают с тем, что вводилось.
         */

        //1. Открыть сайт https://demoqa.com/automation-practice-form
        open("https://demoqa.com/automation-practice-form");
        //2. Ввести имя «Александр»
        $("#firstName").setValue("Александр");
        //3. Фамилию «Петров»
        $("[placeholder='Last Name']").setValue("Петров");
        //4. Почту alexander.petrov@test.ru
        $("[class='mr-sm-2 form-control']").setValue("alexander.petrov@test.ru");
        //5. Выберать пол Male
        $("[id=gender-radio-1]").click();
        //6. Ввести телефон 8799900011
        $("#userNumber").setValue("8799900011");
        //7. Ввести дату рождения (15 марта 2000 года)
        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").selectOption("2000");
        $(".react-datepicker__month-select").selectOption("March");
        $$(".react-datepicker__day").find(text("10")).click();
        $("#subjectsInput").setValue("Maths");
        //8. Написать предмет Maths
        $(".subjects-auto-complete__menu").$(byText("Maths")).click();
        //9. Поставить галочку на хобби Sports
        $("#hobbies-checkbox-1").click();
        //10. Загрузить фото профиля
        $("#uploadPicture").uploadFile(new File("src/test/resources/picture.jpg"));
        //11. Вписать адрес: г. Москва, ул. Тверская, д. 1
        $("#currentAddress").setValue("г. Москва, ул. Тверская, д. 1");
        //12. Выбрать штат NCR
        $("#state").scrollIntoView(true).click();
        $("#state").$(byText("NCR")).click();
        //13. Выюрать город Delhi
        $("#city").click();
        $("#city").$(byText("Delhi")).click();
        //14. Нажать кнопку Submit
        $("#submit").click();
        //15. Проверить, что в появившейся таблице все данные совпадают с тем, что вводилось.
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table").shouldHave(text("Александр Петров"),
                text("alexander.petrov@test.ru"),
                text("Male"),
                text("8799900011"),
                text("10 March,2000"),
                text("Maths"),
                text("Sports"),
                text("picture.jpg"),
                text("г. Москва, ул. Тверская, д. 1"),
                text("NCR Delhi"));
    }
}