package ru.bulgacov.jinit;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AssertionsTest {
    @Test
    void assertAllTest() {
        assertAll(
                () -> assertTrue(1 < 2),
                () -> assertTrue(1 > 2),
                () -> assertEquals(1, 1),
                () -> assertEquals(1, 2));
    }
}