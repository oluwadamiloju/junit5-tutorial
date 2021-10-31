package com.junit5tests.chapter13;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AssertionsTest {
    @Test
    void assertEqualsTest() {
        assertEquals(12, 3 * 4);
    }
}
