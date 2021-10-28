package com.junit5tests.chapter4;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

public class ParameterizedTests {
    @ParameterizedTest(name = "Run: {index} - Actual value: {arguments}") //to change the way the test results show in the console
    @ValueSource(ints = {1, 5, 6})
    void intValues(int theParameters) {
        System.out.println("theParameters = " + theParameters);
    }

    @ParameterizedTest
//    @NullSource //to pass in a null value
//    @EmptySource //to pass in an empty string
    @NullAndEmptySource //to pass in composite null and empty values
    @ValueSource(strings = {"firstString", "secondString"})
    void stringValues(String theParameters) {
        System.out.println("theParameters = " + theParameters);
    }
}
