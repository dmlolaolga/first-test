package ru.bulgacov.jinit;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class DisabledTest {
    @Test
    @Disabled("Баг 123")
    void disabledTest() {
        System.out.println("Этот тест не будет выполнен");

    }

    @Test
    void activeTest() {
        System.out.println("Этот тест будет выполнен");
    }
}
