package ru.bulgacov.jinit;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledIfEnvironmentVariable;

public class EnvironmentVariableTest {
    @Test
    @EnabledIfEnvironmentVariable(
            named = "env", matches = "dev")
    void testOnlyForDevEnvironment() {
        System.out.println("Тест запущен в dev environment");
    }

}
