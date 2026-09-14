package ru.bulgacov.jinit;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.util.concurrent.TimeUnit;

public class TimeoutTest {
    @Test
    @Timeout(value = 2, unit = TimeUnit.SECONDS)
    void timeoutTest() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println("Тест завершён");
    }
}
