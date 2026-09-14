package ru.bulgacov.jinit;

import org.junit.jupiter.api.RepeatedTest;

public class RepeatedTestExample {
    @RepeatedTest(3)
    void repeatedTest() {
        System.out.println("Тест выполняется");
    }
}
