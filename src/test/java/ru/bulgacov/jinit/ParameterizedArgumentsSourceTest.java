package ru.bulgacov.jinit;

import io.qameta.allure.*;
import jdk.jfr.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.provider.ArgumentsProvider;import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

@Epic("Инфраструктура автоматизации")
@Feature("Параметризованные тесты")
@Owner("Lola.Maer")
@Severity(SeverityLevel.NORMAL)
@Description("Демонстрация параметризованных тестов JUnit 5 с использованием @ArgumentsSource. " +
        "Это самый гибкий способ параметризации: данные генерируются программно внутри кастомного ArgumentsProvider, " +
        "что позволяет подключать любые источники (БД, API, файлы сложной структуры, генераторы случайных данных).")
class ParameterizedArgumentsSourceTest {

    @ParameterizedTest
    @ArgumentsSource(MyArgumentsProvider.class)
    @DisplayName("Проверка имени '{0}' с количеством букв {1}")
    @Description("Тест выполняется для каждого набора аргументов, сгенерированного MyArgumentsProvider. " +
            "В отчете Allure каждый запуск отображается как отдельный тест-кейс с конкретными данными.")
    void argumentsSourceTest(String name, int count) {
        System.out.println( "Имя: " + name + ", кол-во букв: " + count );
    }
    static class MyArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(
                ExtensionContext context ) {
            return Stream.of(
                    Arguments.of("Vlad", 4),
                    Arguments.of("Masha", 5),
                    Arguments.of("Donald Trump", 11) );
        }
    }
}