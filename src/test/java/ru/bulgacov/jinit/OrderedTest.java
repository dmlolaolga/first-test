package ru.bulgacov.jinit;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

public class OrderedTest {
    @Test
    @Order(1)
    void test1() {
        System.out.println("Test 1");
    }

    @Test
    @Order(2)
    void test2() {
        System.out.println("Test 2");
    }

    @Test
    @Order(3)
    void test3() {
        System.out.println("Test 3");
    }
}
