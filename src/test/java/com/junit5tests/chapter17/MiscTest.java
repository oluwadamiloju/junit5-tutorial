package com.junit5tests.chapter17;

import org.junit.jupiter.api.*;

import java.util.concurrent.TimeUnit;

public class MiscTest {
    @Test
    @Timeout(value = 5)
        //seconds is the default unit
    void timeoutTest() throws InterruptedException {
        System.out.println("Timeout demo");
        Thread.sleep(6000); // demonstrates
    }

    @Test //demonstrates the stress of using multiple annotations
    @Timeout(value = 90)
    @DisplayName("This is an annotated method")
    @Tag("aTag")
    void annotatedMethod() {
        System.out.println("This is an annotated method");
    }

    @MyAnnotation
    void anotherAnnotatedMethod() throws InterruptedException {
        System.out.println("This is a custom annotated method");
        Thread.sleep(3000);
    }

    @TestInstance(TestInstance.Lifecycle.PER_CLASS) //inner class for nested tests
    @Nested
    class NestedTest {
        @BeforeAll
        void beforeAll() {
            System.out.println("Before All in nested test");
        }

        @Test
        void nestedTestMethod() {
            System.out.println("Nested test method");
        }
    }
}
