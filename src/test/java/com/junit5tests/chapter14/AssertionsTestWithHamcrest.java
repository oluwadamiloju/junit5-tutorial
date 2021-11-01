package com.junit5tests.chapter14;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.junit.jupiter.api.Assertions.*;

public class AssertionsTestWithHamcrest {
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

    /*
    Tests with hamcrest -  hamcrest is an external library that allows you create more assertions fot
    tests that are most likely not included in JUnit5

    The tests being with assertThat. The first item will always be the subject of the assertion
     */
    @Test
    void assertForMapTest() {
        Map<String, Integer> theMap = new HashMap<>();
        theMap.put("firstKey", 1);
        theMap.put("secondKey", 2);
        theMap.put("thirdKey", 3);

//        assertThat(theMap, Matchers.hasKey("secondKey")); //check if the map has a key
        assertThat(theMap, Matchers.hasValue(3)); //check if the map has a value
    }

    @Test
    void assertForListTest() {
        List<String> theList = Arrays.asList("firstString", "secondString", "thirdString");

        assertThat(theList, hasItem("thirdString"));
    }

    @Test
    void assertForListTestWithAnyOf() {
        List<String> theList = Arrays.asList("firstString", "secondString", "thirdString");

        assertThat(theList, Matchers.anyOf(hasItem("thirdString"), hasItem("noString")));
    }

    @Test
    void assertForListTestWithAllOf() {
        List<String> theList = Arrays.asList("firstString", "secondString", "thirdString");

        assertThat(theList, Matchers.allOf(hasItem("thirdString"), hasItem("noString")));
    }

    @Test
    void assertForListTestWithContainsAnyOrder() {
        List<String> theList = Arrays.asList("firstString", "secondString", "thirdString");

        assertThat(theList, Matchers.containsInAnyOrder("thirdString", "secondString", "firstString"));
    }
}
