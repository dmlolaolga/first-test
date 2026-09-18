package ru.bulgacov.jinit;

import org.junit.jupiter.api.*;

public class LifecycleTest {
    @BeforeAll
    static void setUpAll() {
        System.out.println("Перед всеми тестами");
    }

    @BeforeEach
    void setUp() {
        System.out.println("Перед каждым тестом");
    }

    @Test
    void test1() {
        System.out.println("Test 1");
    }

    @Test
    void test2() {
        System.out.println("Test 2");
    }

    @AfterEach
    void tearDown() {
        System.out.println("После каждого теста");
    }

    @AfterAll
    static void tearDownAll() {
        System.out.println("После всех тестов");
    }
}
