package ru.bulgacov.jinit;

import io.qameta.allure.*;
import jdk.jfr.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@Epic("Инфраструктура автоматизации")
@Feature("Группировка тестов")
@Owner("Lola.Maer")
@Severity(SeverityLevel.NORMAL)
@Description("Демонстрация вложенных тестов через @Nested. Позволяет логически группировать тесты " +
        "внутри одного класса (например, разделять позитивные и негативные сценарии). " +
        "В отчете Allure вложенные классы отображаются как отдельные тест-контейнеры.")
class NestedTest {

    @Test
    @DisplayName("Основной тест (вне групп)")
    @Description("Тест, находящийся на верхнем уровне класса, вне вложенных групп.")
    void mainTest() {
        System.out.println("Основной тест");
    }

    @Nested
    @DisplayName("Позитивные тесты")
    @Description("Группа тестов, проверяющих корректную работу системы при валидных входных данных.")
    class PositiveTests {

        @Test
        @DisplayName("Позитивный сценарий №1")
        @Description("Проверка базового позитивного сценария.")
        void positiveTest1() {
            System.out.println("Positive test 1");
        }

        @Test
        @DisplayName("Позитивный сценарий №2")
        @Description("Проверка альтернативного позитивного сценария.")
        void positiveTest2() {
            System.out.println("Positive test 2");
        }
    }

    @Nested
    @DisplayName("Негативные тесты")
    @Description("Группа тестов, проверяющих корректную обработку системой невалидных данных и ошибочных сценариев.")
    class NegativeTests {

        @Test
        @DisplayName("Негативный сценарий №1")
        @Description("Проверка реакции системы на невалидные входные данные.")
        void negativeTest1() {
            System.out.println("Negative test 1");
        }

        @Test
        @DisplayName("Негативный сценарий №2")
        @Description("Проверка обработки граничных условий и ошибок.")
        void negativeTest2() {
            System.out.println("Negative test 2");
        }
    }
}
