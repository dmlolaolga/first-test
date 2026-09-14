package ru.bulgacov.jinit;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledIfSystemProperty;

class SystemPropertyTest {
    @Test
    @EnabledIfSystemProperty(named = "env", matches = "dev")
    void testOnlyForDev() {
        System.out.println("Тест запущен для dev");
    }
}