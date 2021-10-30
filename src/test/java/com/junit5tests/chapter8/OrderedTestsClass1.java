package com.junit5tests.chapter8;

import org.junit.jupiter.api.*;

@TestMethodOrder(MethodOrderer.DisplayName.class) //ordered test alphanumerically depending on options chosen
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class OrderedTestsClass1 {
    @BeforeAll
    void beforeAll() {
        System.out.println("--This is the before All method");
    }

    @BeforeEach
    void beforeEach() {
        System.out.println("----This is the before Each method");
    }

    @AfterAll
    void afterAll() {
        System.out.println("--This is the after All method");
    }

    @AfterEach
    void afterEach() {
        System.out.println("----This is the after Each method");
    }

    @Test
    void firstMethod() {
        System.out.println("This is the first test method");
    }

    @Test
    @DisplayName("US1234 - TC12 - this method is the second one")
    void secondMethod() {
        System.out.println("This is the second test method");
    }

    @Test
    @DisplayName("Third test")
    void fifthTest() {
        System.out.println("This is the \"fifth\" test method");
    }
}
