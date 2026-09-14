package ru.bulgacov.jinit;

import org.junit.jupiter.params.provider.ArgumentsProvider;import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;
class ParameterizedArgumentsSourceTest {
    @ParameterizedTest
    @ArgumentsSource(MyArgumentsProvider.class)
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