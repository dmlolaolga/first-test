package ru.bulgacov.jinit;

import io.qameta.allure.*;
import jdk.jfr.Description;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@Epic("Инфраструктура автоматизации")
@Feature("Управление выполнением тестов")
@Owner("Lola.Maer")
@Severity(SeverityLevel.NORMAL)
@Description("Демонстрация аннотации @Disabled для временного отключения тестов. " +
        "Отключённые тесты отображаются в отчете Allure со статусом Skipped и указанием причины.")
public class DisabledTest {
    @Test
    @Disabled("Баг 123: падает из-за некорректного ответа API на dev-стенде")
    @DisplayName("Тест временно отключён (баг 123)")
    @Description("Тест не будет выполнен до исправления бага 123. " +
            "В отчете Allure отображается как Skipped с указанием причины отключения.")
    void disabledTest() {
        System.out.println("Этот тест не будет выполнен");

    }

    @Test
    @DisplayName("Активный тест (выполняется)")
    @Description("Обычный тест без ограничений. Выполняется при каждом запуске.")
    void activeTest() {
        System.out.println("Этот тест будет выполнен");
    }
}
