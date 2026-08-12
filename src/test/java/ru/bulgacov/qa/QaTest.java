package ru.bulgacov.qa;

import com.demoqa.pages.PracticeForm;
import org.junit.jupiter.api.Test;
import ru.bulgacov.qa.pages.YandexSearchPage;

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

        open("https://ya.ru/", YandexSearchPage.class)
                .search("bulgacov qa")//яндекс поиск
                .pressEnter()
                .closeDefaultBrowserSelectWindow()
                .openLink("ivanbulgakovqa.ru")
                .clickPrice()
                .paymentAmountCheck("47 000");
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
         * 8. Написать и выбрать предмет Maths
         * 9. Поставить галочку на хобби Sports
         * 10. Загрузить фото профиля
         * 11. Вписать адрес: г. Москва, ул. Тверская, д. 1
         * 12. Выбрать штат NCR
         * 13. Выюрать город Delhi
         * 14. Нажать кнопку Submit
         * 15. Проверить, что в появившейся таблице все данные совпадают с тем, что вводилось.
         */

        open("https://demoqa.com/automation-practice-form", PracticeForm.class)//1. Открыть сайт https://demoqa.com/automation-practice-form
                .fillName("Александр")//2. Ввести имя «Александр»
                .fillSurname("Петров")//3. Фамилию «Петров»
                .fillEmail("alexander.petrov@test.ru")// 4. Почту alexander.petrov@test.ru
                .chooseAGenderMale()//5. Выбрать пол Male
                .fillPhoneNumber("8799900011")//6. Ввести телефон 8799900011
                .fillDateOfBirth()//7. Ввести дату рождения (15 марта 2000 года)
                .chooseYearOfBirth("2000")
                .chooseMonthOfBirth("March")
                .chooseABirthday("15")
                .writeAndChooseSubject("Maths")//8. Написать и выбрать предмет Maths
                .chooseHobbiesSports()//9. Поставить галочку на хобби Sports
                .uploadProfilePhoto("src/test/resources/picture.jpg")//10. Загрузить фото профиля
                .enterTheCurrentAddress("г. Москва, ул. Тверская, д. 1")//11. Вписать адрес: г. Москва, ул. Тверская, д. 1
                .chooseState("NCR")//12. Выбрать штат NCR
                .chooseCity("Delhi")//13. Выюрать город Delhi
                .clickSubmitButton()//14. Нажать кнопку Submit
                .checkTextHead("Thanks for submitting the form")//15. Проверить, что в появившейся таблице все данные совпадают с тем, что вводилось.
                .checkDataInTheTable(
                        "Александр Петров",
                        "alexander.petrov@test.ru",
                        "Male",
                        "8799900011",
                        "15 March,2000",
                        "Maths",
                        "Sports",
                        "picture.jpg",
                        "г. Москва, ул. Тверская, д. 1",
                        "NCR Delhi");
    }
}
