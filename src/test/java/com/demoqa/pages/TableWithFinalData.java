package com.demoqa.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import jdk.jfr.Description;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

@Owner("Lola.Maer")
@Severity(SeverityLevel.CRITICAL) // Проверка итоговых данных формы - критически важный шаг
@Description("Модальное окно с итоговой таблицей отправленной формы. " +
        "Содержит методы для строгой проверки соответствия введенных пользователем данных отображаемым результатам.")
public class TableWithFinalData {
    private final SelenideElement header = $("#example-modal-sizes-title-lg");
    private final SelenideElement dataInTheTable = $(".table");
    // Строки вида <tr><td>Подпись</td><td>Значение</td></tr>
    private final ElementsCollection resultRows = dataInTheTable.$$("tbody tr");

    // Подписи строк - как на странице. Enum, чтобы не опечататься и чтобы IDE подсказывала.
    public enum ResultRow {
        STUDENT_NAME("Student Name"),
        STUDENT_EMAIL("Student Email"),
        GENDER("Gender"),
        MOBILE("Mobile"),
        DATE_OF_BIRTH("Date of Birth"),
        SUBJECTS("Subjects"),
        HOBBIES("Hobbies"),
        PICTURE("Picture"),
        ADDRESS("Address"),
        STATE_AND_CITY("State and City");

        private final String label;

        ResultRow(String label) {
            this.label = label;
        }

        public String getLabel() {
            return label;
        }
    }

    @Step("Проверить заголовок модального окна: '{expectedHeaderText}'")
    public TableWithFinalData checkHeader(String header) {
        this.header.shouldBe(visible).shouldHave(exactText(header));

        return this;
    }

    /**
     * Раньше проверяли "где-то в таблице есть такой текст" - тест прошёл бы,
     * даже попади телефон в строку с адресом. Теперь значение сверяем в своей строке.
     */
    @Step("Проверить строку таблицы '{rowLabel}' со значением '{expectedValue}'")
    public TableWithFinalData checkResultRow(ResultRow row, String expectedValue) {
        // По тексту в CSS не ищут, поэтому строку отбираем условием findBy
        SelenideElement tableRow = resultRows.findBy(text(row.getLabel()));

        // Страховка от чужой строки: левая ячейка должна быть ровно нашей подписью
        tableRow.$("td:nth-child(1)").shouldHave(exactText(row.getLabel()));
        tableRow.$("td:nth-child(2)").shouldHave(exactText(expectedValue));

        return this;
    }

    // Обёртки ниже прячут формат значения (пробелы, запятые), чтобы тест читался как текст

    @Step("Проверить имя студента: '{name} {surname}'")
    public TableWithFinalData checkStudentName(String name, String surname) {
        return checkResultRow(ResultRow.STUDENT_NAME, name + " " + surname);
    }

    @Step("Проверить email студента: '{email}'")
    public TableWithFinalData checkStudentEmail(String email) {
        return checkResultRow(ResultRow.STUDENT_EMAIL, email);
    }

    @Step("Проверить пол: '{gender}'")
    public TableWithFinalData checkGender(String gender) {
        return checkResultRow(ResultRow.GENDER, gender);
    }

    @Step("Проверить номер телефона: '{mobile}'")
    public TableWithFinalData checkMobile(String mobile) {
        return checkResultRow(ResultRow.MOBILE, mobile);
    }

    // Формат на странице: "15 March,2000"
    @Step("Проверить дату рождения: '{day} {month}, {year}'")
    public TableWithFinalData checkDateOfBirth(String day, String month, String year) {
        return checkResultRow(ResultRow.DATE_OF_BIRTH, day + " " + month + "," + year);
    }

    // varargs: checkSubjects("Maths", "Computer Science") -> "Maths, Computer Science"
    @Step("Проверить выбранные предметы: '{subjects}'")
    public TableWithFinalData checkSubjects(String... subjects) {
        return checkResultRow(ResultRow.SUBJECTS, String.join(", ", subjects));
    }

    @Step("Проверить выбранные хобби: '{hobbies}'")
    public TableWithFinalData checkHobbies(String... hobbies) {
        return checkResultRow(ResultRow.HOBBIES, String.join(", ", hobbies));
    }

    // В таблице только имя файла, без пути
    @Step("Проверить имя загруженной картинки: '{fileName}'")
    public TableWithFinalData checkPicture(String fileName) {
        return checkResultRow(ResultRow.PICTURE, fileName);
    }

    @Step("Проверить адрес: '{address}'")
    public TableWithFinalData checkAddress(String address) {
        return checkResultRow(ResultRow.ADDRESS, address);
    }

    // Штат и город в одной строке: "NCR Delhi"
    @Step("Проверить штат и город: '{state} {city}'")
    public TableWithFinalData checkStateAndCity(String state, String city) {
        return checkResultRow(ResultRow.STATE_AND_CITY, state + " " + city);
    }
}
