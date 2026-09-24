package ru.bulgacov.jinit;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Epic("Параметризованные тесты")
@Feature("Валидация строк")
class ParameterizedMethodSourceTest {

    @Story("Подсчет количества символов в имени")
    @Owner("Lola.Maer")
    @Severity(SeverityLevel.NORMAL)
    @Description("Тест проверяет, что фактическая длина переданной строки совпадает с ожидаемым числом")
    @DisplayName("Проверка длины имени: {0} (ожидается {1} символов)")
    @Step("Проверить, что длина имени '{name}' равна {count}")
    @ParameterizedTest
    @MethodSource("wordLetterCountProvider")
    void methodSourceTest(String name, int count) {
        System.out.println("Имя: " + name + ", кол-во букв: " + count);
        //assert name.length() == count;
        assertEquals(count, name.length(), "Длина имени '" + name + "' не совпадает с ожидаемой");// Для отчета при падении
    }

    static Stream<Arguments> wordLetterCountProvider() {
        return Stream.of(Arguments.of("Vlad", 4),
                Arguments.of("Masha", 5),
                Arguments.of("Donald Trump", 12));
    }
}