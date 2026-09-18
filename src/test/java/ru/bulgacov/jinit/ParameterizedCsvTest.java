package ru.bulgacov.jinit;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

public class ParameterizedCsvTest {
    @ParameterizedTest
    @CsvFileSource(resources = "/file.csv", numLinesToSkip = 1)
    void csvFileSourceTest(String name, int count) {
        System.out.println("Имя: " + name + ", кол-во букв: " + count);
    }
}
