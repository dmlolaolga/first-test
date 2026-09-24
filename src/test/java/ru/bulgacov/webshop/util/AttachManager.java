package ru.bulgacov.webshop.util;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Attachment;
import io.qameta.allure.Owner;
import jdk.jfr.Description;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.nio.charset.StandardCharsets;
import java.util.List;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.openqa.selenium.logging.LogType.BROWSER;

@Owner("Lola.Maer")
@Description("Утилитный класс для создания вложений в отчёт Allure. " +
        "Предоставляет методы для захвата скриншотов, исходного кода страницы " +
        "и логов консоли браузера.")
public class AttachManager {

    @Attachment(value = "Last screeshot", type = "image/png")
    @Description("Создаёт скриншот текущего состояния страницы браузера. " +
            "Используется для визуальной отладки при падении тестов.")
    public static byte[] takeScreenshot() {
        return ((TakesScreenshot) getWebDriver()).getScreenshotAs(OutputType.BYTES);
    }

    @Attachment(value = "Page source (HTML)", type = "text/html")
    @Description("Сохраняет исходный HTML-код текущей страницы. " +
            "Позволяет анализировать DOM-структуру при возникновении проблем с локаторами.")
    public static byte[] pageSource() {
        return getWebDriver().getPageSource().getBytes(StandardCharsets.UTF_8);
    }

    @Attachment(value = "Browser console logs", type = "text/plain")
    @Description("Извлекает логи консоли браузера (JavaScript ошибки, предупреждения, информация). " +
            "Помогает выявить проблемы на стороне клиента, которые не видны в UI.")
    public static String browserConsoleLogs() {
        if(!WebDriverRunner.hasWebDriverStarted()) {
            return "WebDriver has not been started yet";
        }

        try {
            List<String> logs = Selenide.getWebDriverLogs(BROWSER);
            if (logs.isEmpty()) {
                return "No browser console logs available";
            }
            return String.join("\n",logs);
        }catch (Exception e) {
            return "Unable to get browser console logs: " + e.getMessage();
        }
    }
}
