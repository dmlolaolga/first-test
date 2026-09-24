package ru.bulgacov.jinit;

import io.qameta.allure.*;
import jdk.jfr.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

@Epic("Инфраструктура автоматизации")
@Feature("Повторяющиеся тесты")
@Owner("Lola.Maer")
@Severity(SeverityLevel.NORMAL)
@Description("Демонстрация аннотации @RepeatedTest из JUnit 5. " +
        "Тест выполняется заданное количество раз. В отчете Allure повторения группируются в один тест-контейнер.")
public class RepeatedTestExample {


    @RepeatedTest(3)
    @DisplayName("Повторение {currentRepetition} из {totalRepetitions}")
    @Description("Тест выполняется 3 раза. Каждое повторение отображается в Allure как отдельный шаг внутри общего контейнера.")
    void repeatedTest() {
        System.out.println("Тест выполняется");
    }
}
