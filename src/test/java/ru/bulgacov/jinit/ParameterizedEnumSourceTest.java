package ru.bulgacov.jinit;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

public class ParameterizedEnumSourceTest {
    enum Color { RED, GREEN, BLUE }
    @ParameterizedTest
    @EnumSource(Color.class)
    void enumSourceTest(Color color) {
        System.out.println(color.name());
    }
}
