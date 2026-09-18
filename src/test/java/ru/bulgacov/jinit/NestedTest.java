package ru.bulgacov.jinit;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class NestedTest {
    @Test
    void mainTest() {
        System.out.println("Основной тест");
    }

    @Nested
    class PositiveTests {
        @Test
        void positiveTest1() {
            System.out.println("Positive test 1");
        }

        @Test
        void positiveTest2() {
            System.out.println("Positive test 2");
        }
    }

    @Nested
    class NegativeTests {
        @Test
        void negativeTest1() {
            System.out.println("Negative test 1");
        }

        @Test
        void negativeTest2() {
            System.out.println("Negative test 2");
        }
    }
}
