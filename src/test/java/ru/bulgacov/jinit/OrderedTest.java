package ru.bulgacov.jinit;

import io.qameta.allure.*;
import jdk.jfr.Description;
import org.junit.jupiter.api.*;

@Epic("Инфраструктура автоматизации")
@Feature("Управление порядком выполнения тестов")
@Owner("Lola.Maer")
@Severity(SeverityLevel.MINOR)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@Description("Демонстрация принудительного порядка выполнения тестов через аннотацию @Order. " +
        "По умолчанию JUnit 5 выполняет тесты в псевдослучайном порядке, но @TestMethodOrder " +
        "вместе с @Order позволяет задать строгую последовательность.")
public class OrderedTest {
    @Test
    @Order(1)
    @DisplayName("Шаг 1: Первый тест")
    @Description("Выполняется первым согласно аннотации @Order(1). " +
            "В отчете Allure тесты будут отображены в указанном порядке.")
    void test1() {
        System.out.println("Test 1");
    }

    @Test
    @Order(2)
    @DisplayName("Шаг 2: Второй тест")
    @Description("Выполняется вторым согласно аннотации @Order(2).")
    void test2() {
        System.out.println("Test 2");
    }

    @Test
    @Order(3)
    @DisplayName("Шаг 3: Третий тест")
    @Description("Выполняется третьим согласно аннотации @Order(3).")
    void test3() {
        System.out.println("Test 3");
    }
}
