package ru.bulgacov.jinit;

import io.qameta.allure.*;
import jdk.jfr.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.util.concurrent.TimeUnit;

@Epic("Инфраструктура автоматизации")
@Feature("Управление выполнением тестов")
@Owner("Lola.Maer")
@Severity(SeverityLevel.CRITICAL)
@Description("Проверка механизма прерывания тестов по таймауту. " +
        "Тест намеренно выполняется дольше установленного лимита, чтобы продемонстрировать работу аннотации @Timeout.")
public class TimeoutTest {
    @Test
    @Timeout(value = 2, unit = TimeUnit.SECONDS)
    @DisplayName("Проверка срабатывания таймаута (ожидаемое падение теста)")
    @Description("Тест засыпает на 3 секунды, что превышает лимит в 2 секунды. " +
            "JUnit должен прервать выполнение и отметить тест как Failed (Timeout).")
    void timeoutTest() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        // Эта строка не должна выполниться при корректной работе таймаута
        System.out.println("Тест завершён");
    }
}
