package ru.bulgacov.jinit;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledOnOs;
import org.junit.jupiter.api.condition.OS;

public class OsConditionTest {
    @Test
    @DisabledOnOs(OS.MAC)
    void testNotForMac() {
        System.out.println("Этот тест не запускается на Mac");
    }

}
