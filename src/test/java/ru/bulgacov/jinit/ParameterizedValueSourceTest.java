package ru.bulgacov.jinit;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class ParameterizedValueSourceTest {
    @ParameterizedTest
    @ValueSource(strings = {"Vlad", "Masha", "Donald"})
    void valueSourceTest(String name) {
        System.out.println("Имя: " + name);
    }
}
