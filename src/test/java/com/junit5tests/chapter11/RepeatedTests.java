package com.junit5tests.chapter11;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;

import static org.junit.jupiter.api.Assumptions.assumingThat;

public class RepeatedTests {
    /*
    The @RepeatedTest annotation allows us to repeat tests
     */

    @RepeatedTest(2)
    void firstRepeatedTest() {
        System.out.println("we are repeating this test");
    }

    @RepeatedTest(value = 3,
            name = "Running repetition: {currentRepetition}. Total is: {totalRepetitions}")
    @DisplayName("This is a repeated test method")
    void secondRepeatedTest() {
        System.out.println("we are repeating this test too");
    }

    @RepeatedTest(4)
    void thirdRepeatedTest(RepetitionInfo repetitionInfo) {
        assumingThat(repetitionInfo.getCurrentRepetition() == 3,
                () -> System.out.println("This code only runs for repetition 3"));
    }
}
