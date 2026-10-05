package ru.bulgacov.webshop.test;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;

public class JenkinsTest {

    @Test
    @Tags({@Tag("UI"), @Tag("positive")})
    @DisplayName("UI positive")
    void jenkinsTest1() {
        System.out.print("UI positive test");
    }

    @Test
    @Tags({@Tag("UI"), @Tag("negative")})
    @DisplayName("UI negative")
    void jenkinsTest2() {
        System.out.print("UI negative test ");
    }

    @Test
    @Tags({@Tag("API"), @Tag("positive")})
    @DisplayName("API positive")
    void jenkinsTest3() {
        System.out.print("API positive test");
    }

    @Test
    @Tags({@Tag("API"), @Tag("negative")})
    @DisplayName("API negative")
    void jenkinsTest4() {
        System.out.print("API negative test");
    }

}
