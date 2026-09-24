package ru.bulgacov.qa;

import com.codeborne.selenide.Configuration;
import com.demoqa.pages.PracticeForm;
import io.qameta.allure.*;
import jdk.jfr.Description;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.bulgacov.qa.pages.ResultCostPage;
import ru.bulgacov.qa.pages.WelcomePage;
import ru.bulgacov.qa.pages.YandexSearchPage;
import ru.bulgacov.webshop.test.TestBase;

import static com.codeborne.selenide.Selenide.open;

@Epic("UI Автоматизация (E2E)")
@Owner("Lola.Maer")
@Description("Класс содержит сквозные (End-to-End) тесты для проверки ключевых бизнес-процессов на внешних ресурсах.")
public class QaTest extends TestBase {

    @BeforeAll
    static void setUp() {
        Configuration.timeout = 10000;
        Configuration.pageLoadTimeout = 10000;
        Configuration.browserSize = "1920x1080";
    }

    @Test
    @Feature("Сайт ivanbulgakovqa.ru")
    @Story("Проверка стоимости менторства")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Стоимость предоплаты за обучение должна составлять 47 000 рублей")
    @Description("Сквозной сценарий: поиск в Яндексе -> переход на сайт -> навигация до страницы оплаты -> проверка итоговой суммы.")
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
                .search("bulgacov qa")//1-2. открыть поисковик, ввести данные сайта
                .submit()//3. нажать кнопку поиска
                .closeDefaultBrowserBannerIfAppeared()
                .closeDistributionBannerIfAppeared()
                .openLink("ivanbulgakovqa.ru")//4. кликнуть на нужный сайт

                // сайт открылся новой вкладкой
                .switchToWindow(1, WelcomePage.class)
                .openStudySection()//5. нажать на кнопку "Стоимость"
                .clickWantToQa()//6. нажать на кнопку "Хочу вкатиться в QA"
                .clickRunToPay()//7. нажать кнопку "Бегу оплачивать"

                // оплата открылась ещё одной вкладкой
                .switchToWindow(2, ResultCostPage.class)
                .checkPriceAmount("47 000");//8. проверить, что к оплате 47 000 рублей
    }

    @Test
    @Feature("Сайт demoqa.com")
    @Story("Форма регистрации студента")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Успешная регистрация студента с заполнением всех полей формы")
    @Description("Сквозной тест заполнения формы Practice Form: ввод личных данных, выбор даты из календаря, " +
            "загрузка файла, выбор региона и полная валидация введенных данных в итоговой таблице.")
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
                .fillEmail("alexander.petrov@test.ru")//4. Почту alexander.petrov@test.ru
                .chooseGenderMale()//5. Выбрать пол Male
                .fillPhoneNumber("8799900011")//6. Ввести телефон 8799900011
                .selectDateOfBirth("15", "March", "2000")//7. Ввести дату рождения (15 марта 2000 года)
                .writeAndChooseSubject("Maths")//8. Написать и выбрать предмет Maths
                .chooseHobbiesSports()//9. Поставить галочку на хобби Sports
                .uploadProfilePhoto("src/test/resources/picture.jpg")//10. Загрузить фото профиля
                .enterCurrentAddress("г. Москва, ул. Тверская, д. 1")//11. Вписать адрес: г. Москва, ул. Тверская, д. 1
                .chooseState("NCR")//12. Выбрать штат NCR
                .chooseCity("Delhi")//13. Выюрать город Delhi
                .submit()//14. Нажать кнопку Submit

                //15. Проверить, что в появившейся таблице все данные совпадают с тем, что вводилось.
                .checkHeader("Thanks for submitting the form")
                .checkStudentName("Александр", "Петров")
                .checkStudentEmail("alexander.petrov@test.ru")
                .checkGender("Male")
                .checkMobile("8799900011")
                .checkDateOfBirth("15", "March", "2000")
                .checkSubjects("Maths")
                .checkHobbies("Sports")
                .checkPicture("picture.jpg")
                .checkAddress("г. Москва, ул. Тверская, д. 1")
                .checkStateAndCity("NCR", "Delhi");
    }
}
