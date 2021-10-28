package com.junit5tests.chapter5;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class ParameterizedTests2 {
    @ParameterizedTest //passing multiple parameters of the same type
    @CsvSource(value = {"sarah, akinkunmi", "sarah, lynn", "sarah, connor"})
    void csvSource_StringString(String firstname, String lastname) {
        System.out.println("firstname = " + firstname + ", lastname = " + lastname);
    }

    @ParameterizedTest //multiple parameters of different types
    @CsvSource(value = {"oluwadamiloju, 21, false", "sarah, 8, true", "oluwadamisi, 65, false"})
    void csvSource_differentParamTypes(String name, int age, boolean isAChild) {
        System.out.println("name = " + name + ", age = " + age + ", isAChild = " + isAChild);
    }

    @ParameterizedTest //passing parameters with comma values
    @CsvSource(value = {"saraya, 'sarah, akinkunmi'", "maxi, 'maximum, akinkunmi'"})
    void csvSource_paramsWithCommaValues(String nickName, String fullName) {
        System.out.println("nickName = " + nickName + ", fullName = " + fullName);
    }

    @ParameterizedTest //passing parameters with different delimeters
    @CsvSource(value = {"sarah-akinkunmi", "maximum-akinkunmi"}, delimiter = '-')
    void csvSource_paramsWithDifferentDelimiters(String firstName, String lastName) {
        System.out.println("firstName = " + firstName + ", lastName = " + lastName);
    }
}
