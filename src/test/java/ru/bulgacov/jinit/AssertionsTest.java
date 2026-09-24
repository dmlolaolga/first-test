package ru.bulgacov.jinit;

import io.qameta.allure.*;
import jdk.jfr.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@Epic("Инфраструктура автоматизации")
@Feature("Ассерты JUnit 5")
@Owner("Lola.Maer")
@Severity(SeverityLevel.NORMAL)
@Description("Демонстрация группировки нескольких ассертов через assertAll. " +
        "В отличие от обычных ассертов, assertAll выполняет все проверки и собирает все ошибки, " +
        "а не падает на первом же неудачном ассерте. Это позволяет увидеть все проблемы за один запуск.")
class AssertionsTest {
    @Test
    @DisplayName("Группировка нескольких ассертов через assertAll")
    @Description("Тест содержит 4 ассерта, 2 из которых заведомо ложные. " +
            "assertAll выполнит все проверки и в отчете Allure отобразит все ошибки сразу, " +
            "а не остановится на первом падении. Это экономит время на отладке.")
    void assertAllTest() {
        assertAll(
                () -> assertTrue(1 < 2),
                () -> assertTrue(1 > 2),
                () -> assertEquals(1, 1),
                () -> assertEquals(1, 2));
    }
}