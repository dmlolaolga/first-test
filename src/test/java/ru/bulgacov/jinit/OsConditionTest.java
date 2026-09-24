package ru.bulgacov.jinit;

import io.qameta.allure.*;
import jdk.jfr.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledOnOs;
import org.junit.jupiter.api.condition.OS;

@Epic("Инфраструктура автоматизации")
@Feature("Условный запуск тестов")
@Owner("Lola.Maer")
@Severity(SeverityLevel.MINOR)
@Description("Демонстрация условного отключения тестов в зависимости от операционной системы. " +
        "Используется для тестов, специфичных для определённой платформы (например, использующих " +
        "файловую систему Windows или горячие клавиши macOS).")
public class OsConditionTest {
    @Test
    @DisabledOnOs(OS.MAC)
    @DisplayName("Тест не запускается на macOS")
    @Description("Тест будет автоматически помечен как @Disabled (Skipped) в отчете Allure, " +
            "если запускается на операционной системе macOS. " +
            "Используется для платформо-зависимых проверок.")
    void testNotForMac() {
        System.out.println("Этот тест не запускается на Mac");
    }

}
