package ru.bulgacov.jinit;

import io.qameta.allure.*;
import jdk.jfr.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledIfEnvironmentVariable;

@Epic("Инфраструктура автоматизации")
@Feature("Условный запуск тестов")
@Owner("Lola.Maer")
@Severity(SeverityLevel.MINOR)
@Description("Демонстрация условного запуска тестов через переменные окружения (Environment Variables). " +
        "В отличие от системных свойств JVM (-D), переменные окружения задаются на уровне ОС или CI/CD-сервера " +
        "и доступны всем процессам, запущенным в данной сессии.")
public class EnvironmentVariableTest {

    @Test
    @EnabledIfEnvironmentVariable(named = "env", matches = "dev")
    @DisplayName("Тест запускается только в окружении dev")
    @Description("Тест будет пропущен (Skipped), если переменная окружения 'env' не установлена " +
            "или не равна 'dev'. Используется для изоляции тестов, специфичных для конкретного окружения " +
            "(например, интеграционных тестов, работающих только с dev-сервисами).")
    void testOnlyForDevEnvironment() {

        System.out.println("Тест запущен в dev environment");
    }

}
