package com.junit5tests.chapter13;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class AssertionsTest {
    @Test
    void assertEqualsTest() {
        assertEquals("firstString", "secondString", "The string values are not equal");
    }

    @Test
    void assertEqualsListTest() {
        List<String> expectedValues = Arrays.asList("firstString", "secondString", "thirdString");
        List<String> actualValues = Arrays.asList("firstString", "secondString", "thirdString");

        assertEquals(expectedValues, actualValues);
    }

    @Test
    void assertArrayEqualsTest() {
        int[] expectedValues = {2, 5, 6};
        int[] actualValues = {2, 5, 6};

        assertArrayEquals(expectedValues, actualValues);
    }

    @Test
    void assertTrueOrFalseTest() {
        assertFalse(false);
//        assertTrue(false, "this boolean condition did not evaluate to true");
    }

    @Test
    void assertThrowsTest() {
        assertThrows(NullPointerException.class, null);
    }

    @Test
    void assertAllTest() {
        assertAll(
                () -> assertEquals("firstString", "secondString", "The string values are not equal"),
                () -> assertThrows(NullPointerException.class, null),
                () -> assertTrue(false, "this boolean condition did not evaluate to true")
        );
    }
}
