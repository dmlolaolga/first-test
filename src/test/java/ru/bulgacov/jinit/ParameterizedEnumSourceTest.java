package ru.bulgacov.jinit;

import io.qameta.allure.*;
import jdk.jfr.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

@Epic("Инфраструктура автоматизации")
@Feature("Параметризованные тесты")
@Owner("Lola.Maer")
@Severity(SeverityLevel.NORMAL)
@Description("Демонстрация параметризованных тестов JUnit 5 с использованием @EnumSource. " +
        "Тест выполняется для каждого значения перечисления (enum), что позволяет проверить логику для всех возможных состояний.")
public class ParameterizedEnumSourceTest {
    enum Color { RED, GREEN, BLUE }

    @ParameterizedTest
    @EnumSource(Color.class)
    @DisplayName("Проверка обработки цвета: {0}")
    @Description("Тест выполняется 3 раза для каждого значения enum Color (RED, GREEN, BLUE). " +
            "В отчете Allure каждый запуск отображается как отдельный тест-кейс с указанием конкретного значения enum.")
    void enumSourceTest(Color color) {
        System.out.println(color.name());
    }
}
