package com.junit5tests.chapter12;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TaggedTests {
    /*
     a tag is a string which will be assigned to the test through an annotation. characters that are
     not allowed include !, | and & and some others. it's better to just stick to alphanumerics and
     alphabets. If we want several tags, then we will need to create several @Tag annotation lines
     for each method that we are annotating.
     */

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
    @Tag("sanity")
    void firstMethod() {
        System.out.println("This is the first test method");
    }

    @Test
    @Tag("sanity")
    @Tag("acceptance")
    @DisplayName("US1234 - TC12 - this method is the second one")
    void secondMethod() {
        System.out.println("This is the second test method");
    }

    @Test
    @Tag("acceptance")
    void thirdMethod() {
        System.out.println("This is the third test method");
    }

    @ParameterizedTest(name = "Run: {index} - Actual value: {arguments}") //to change the way the test results show in the console
    @Tag("acceptance")
    @ValueSource(ints = {1, 5, 6})
    void intValues(int theParameters) {
        System.out.println("theParameters = " + theParameters);
    }
}
