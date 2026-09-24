package ru.bulgacov.jinit;

import io.qameta.allure.*;
import jdk.jfr.Description;
import org.junit.jupiter.api.*;

@Epic("Инфраструктура автоматизации")
@Feature("Жизненный цикл тестов")
@Owner("Lola.Maer")
@Severity(SeverityLevel.NORMAL)
@Description("Демонстрация полного жизненного цикла тестов в JUnit 5. " +
        "Показывает порядок вызова фикстур: @BeforeAll → @BeforeEach → @Test → @AfterEach → @AfterAll. " +
        "В отчете Allure все фикстуры отображаются как setup/teardown шаги вокруг каждого теста.")
public class LifecycleTest {

    @BeforeAll
    @Step("Глобальная подготовка: инициализация ресурсов один раз перед всеми тестами")
    @DisplayName("Перед всеми тестами (выполняется 1 раз)")
    @Description("Статический метод, вызывается один раз перед запуском всех тестов в классе. " +
            "Используется для дорогостоящих операций: запуск браузера, подключение к БД, чтение конфигурации.")
    static void setUpAll() {
        System.out.println("Перед всеми тестами");
    }

    @BeforeEach
    @Step("Локальная подготовка: инициализация состояния перед каждым тестом")
    @DisplayName("Перед каждым тестом")
    @Description("Вызывается перед каждым @Test методом. Используется для сброса состояния, " +
            "открытия страниц, авторизации пользователя и т.д.")
    void setUp() {
        System.out.println("Перед каждым тестом");
    }

    @Test
    @DisplayName("Тест №1")
    @Description("Первый тест в классе. Выполняется после @BeforeEach и перед @AfterEach.")
    void test1() {
        System.out.println("Test 1");
    }

    @Test
    @DisplayName("Тест №2")
    @Description("Второй тест в классе. Перед ним снова вызывается @BeforeEach, " +
            "что гарантирует изоляцию от предыдущего теста.")
    void test2() {
        System.out.println("Test 2");
    }

    @AfterEach
    @Step("Локальная очистка: освобождение ресурсов после каждого теста")
    @DisplayName("После каждого теста")
    @Description("Вызывается после каждого @Test метода, даже если тест упал. " +
            "Используется для закрытия соединений, удаления тестовых данных, очистки cookies.")
    void tearDown() {
        System.out.println("После каждого теста");
    }

    @AfterAll
    @Step("Глобальная очистка: освобождение общих ресурсов после всех тестов")
    @DisplayName("После всех тестов (выполняется 1 раз)")
    @Description("Статический метод, вызывается один раз после выполнения всех тестов в классе. " +
            "Используется для закрытия браузера, остановки серверов, финальной очистки.")
    static void tearDownAll() {
        System.out.println("После всех тестов");
    }
}
