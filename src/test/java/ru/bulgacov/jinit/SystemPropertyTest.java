package ru.bulgacov.jinit;

import io.qameta.allure.*;
import jdk.jfr.Description;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledIfSystemProperty;

@Epic("Инфраструктура автоматизации")
@Feature("Условный запуск тестов")
@Owner("Lola.Maer")
@Severity(SeverityLevel.MINOR)
@Description("Демонстрация условного запуска тестов через системные свойства JUnit. " +
        "Тест выполняется только при наличии системного свойства 'env' со значением 'dev'.")
class SystemPropertyTest {
    @Test
    @EnabledIfSystemProperty(named = "env", matches = "dev")
    void testOnlyForDev() {
        System.out.println("Тест запущен для dev");
    }
}