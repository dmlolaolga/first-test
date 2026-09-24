package ru.bulgacov.jinit;

import io.qameta.allure.*;
import jdk.jfr.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

@Epic("Инфраструктура автоматизации")
@Feature("Параметризованные тесты")
@Owner("Lola.Maer")
@Severity(SeverityLevel.NORMAL)
@Description("Демонстрация параметризованных тестов JUnit 5 с использованием @CsvFileSource. " +
        "Тестовые данные загружаются из внешнего CSV-файла, что позволяет отделить данные от логики теста " +
        "и легко расширять набор тестовых случаев без изменения кода.")
public class ParameterizedCsvTest {

    @ParameterizedTest
    @CsvFileSource(resources = "/file.csv", numLinesToSkip = 1)
    @DisplayName("Проверка имени '{0}' с количеством букв {1}")
    @Description("Тест выполняется для каждой строки из CSV-файла (кроме заголовка). " +
            "В отчете Allure каждый запуск отображается как отдельный тест-кейс с конкретными данными из файла.")
    void csvFileSourceTest(String name, int count) {

        System.out.println("Имя: " + name + ", кол-во букв: " + count);
    }
}
