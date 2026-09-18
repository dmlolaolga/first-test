package ru.bulgacov.jinit;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class ParameterizedMethodSourceTest {
    @ParameterizedTest
    @MethodSource("wordLetterCountProvider")
    void methodSourceTest(String name, int count) {
        System.out.println("Имя: " + name + ", кол-во букв: " + count);
        assert name.length() == count;
    }

    static Stream<Arguments> wordLetterCountProvider() {
        return Stream.of(Arguments.of("Vlad", 4),
                Arguments.of("Masha", 5),
                Arguments.of("Donald Trump", 11));
    }
}