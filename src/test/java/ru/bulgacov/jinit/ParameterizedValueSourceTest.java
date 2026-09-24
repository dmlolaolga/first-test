package ru.bulgacov.jinit;

import io.qameta.allure.*;
import jdk.jfr.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@Epic("Инфраструктура автоматизации")
@Feature("Параметризованные тесты")
@Owner("Lola.Maer")
@Severity(SeverityLevel.NORMAL)
@Description("Демонстрация параметризованных тестов JUnit 5 с использованием @ValueSource. " +
        "Один и тот же тест выполняется для каждого значения из списка, что позволяет избежать дублирования кода.")
public class ParameterizedValueSourceTest {

    @ParameterizedTest
    @ValueSource(strings = {"Vlad", "Masha", "Donald"})
    @DisplayName("Проверка обработки имени пользователя: {0}")
    @Description("Тест выполняется 3 раза с разными именами. " +
            "В отчете Allure каждый запуск отображается как отдельный тест-кейс с указанием конкретного параметра.")
    void valueSourceTest(String name) {
        System.out.println("Имя: " + name);
    }
}
