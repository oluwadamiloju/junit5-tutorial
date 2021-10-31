package com.junit5tests.chapter9;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assumptions.*;

public class AssumptionsTest {
    @ParameterizedTest(name = "Run number: {index} - Actual value: {arguments}") //assumeTrue demo
    @ValueSource(ints = {1, 5, 6})
    void intValues(int theParameters) {
        assumeTrue(theParameters > 4);
        System.out.println("theParameters = " + theParameters);
    }

    @ParameterizedTest //assumeFalse demo
    @CsvSource(value = {"sarah, akinkunmi", "sara, lynn", "saraya, connor"})
    void csvSource_StringString(String firstname, String lastname) {
        assumeFalse(firstname.equals("sarah"), "The assumption failed for the following parameters: " + lastname);
        System.out.println("firstname = " + firstname + ", lastname = " + lastname);
    }

    @ParameterizedTest //assumingThat demo
    @CsvSource(value = {"oluwadamiloju, 21, false", "sarah, 8, true", "oluwadamisi, 65, false"})
    void csvSource_differentParamTypes(String name, int age, boolean isAChild) {
        assumingThat(age > 20, () -> System.out.println("This code ran"));
        System.out.println("name = " + name + ", age = " + age + ", isAChild = " + isAChild);
    }

    /*
    assumeTrue and assumeFalse skip a test entirely if it does not meet the condition specified, while
    assumingThat will run the test(s) that do not meet the condition but not the executable that would
    follow if the test(s) had met the condition
     */
}
