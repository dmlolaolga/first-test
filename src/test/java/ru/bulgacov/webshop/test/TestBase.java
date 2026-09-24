package ru.bulgacov.webshop.test;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.*;
import io.qameta.allure.selenide.AllureSelenide;
import jdk.jfr.Description;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import ru.bulgacov.webshop.util.AttachManager;

import static com.codeborne.selenide.Selenide.*;

@Epic("WebShop UI Тесты")
@Feature("Базовая конфигурация тестов")
@Owner("Lola.Maer")
@Description("Базовый класс для всех UI тестов WebShop. Отвечает за глобальную настройку Selenide, " +
        "подключение интеграции с Allure и сбор артефактов (скриншоты, логи) после каждого теста.")
public class TestBase {

    @Step("Глобальная инициализация: настройка браузера и подключение Allure-слушателя Selenide")
    @Description("Устанавливает размер окна браузера 1920x1080 и регистрирует AllureSelenide listener " +
            "для автоматического логирования команд Selenide в отчет.")
    @Owner("Lola.Maer")
    @Severity(SeverityLevel.BLOCKER) // Если настройка упадет, все тесты не запустятся
    @BeforeAll
    static void setUp() {
        // Объединение двух @BeforeAll в один для предсказуемого порядка выполнения
        Configuration.browserSize = "1920x1080";
        Configuration.timeout = 8000; // Таймаут ожидания элементов

        SelenideLogger.addListener("AllureSelenide", new AllureSelenide()
                .screenshots(true)      // Делать скриншоты при падении шагов Selenide
                .savePageSource(true)); // Сохранять HTML страницы при падении шагов Selenide
    }
/*
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }

    @BeforeAll
    static void before() {
        Configuration.browserSize = "1920x1080";
    }*/

    @Step("Очистка состояния браузера и сбор артефактов после выполнения теста")
    @Description("Очищает cookies и localStorage для изоляции тестов друг от друга. " +
            "Добавляет в отчет Allure: скриншот, исходный код страницы и логи консоли браузера.")
    @Owner("Lola.Maer")
    @Severity(SeverityLevel.NORMAL)
    @AfterEach
    void after() {
        clearBrowserCookies();
        clearBrowserLocalStorage();

        // Сбор вложений в отчет Allure
        AttachManager.takeScreenshot();
        AttachManager.pageSource();
        AttachManager.browserConsoleLogs();
        // Опционально: закрытие браузера после каждого теста, если тесты тяжелые
        // com.codeborne.selenide.Selenide.closeWebDriver();
    }

    /*
     * Временно закомментировано: закрытие драйвера перед каждым тестом.
     * Раскомментируйте, если нужно гарантировать чистый браузер перед каждым тестом
     * (например, при параллельном запуске или проблемах с утечками сессий).
     * Минус: увеличивает время прогона тестов, так как браузер запускается заново.

* @Step("Закрыть WebDriver перед каждым тестом для обеспечения чистой сессии")
* @Description("Принудительно закрывает браузер и освобождает ресурсы WebDriver " +
*              "перед запуском каждого теста. Используется для изоляции тестов " +
*              "и предотвращения утечек cookies/session storage между запусками.")
* @Owner("Lola.Maer")
* @Severity(SeverityLevel.MINOR)
* @BeforeEach
    * void closeDriver () {
       closeWebDriver();
   }*/
}
