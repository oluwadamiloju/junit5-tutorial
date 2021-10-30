package com.junit5tests.chapter7;

import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ParameterizedTests4 {
    List<String> sourceList_String() { // declared static if theres's no lifecycle per class annotation or if it's in a different class
        return Arrays.asList("tomato", "carrot", "cabbage");
    }

    @ParameterizedTest
    @MethodSource(value = "sourceList_String")
    void methodSourceList_String(String fruit) {
        System.out.println("fruit = " + fruit);
    }

    //for a stream of strings
    Stream<String> sourceStream_String() {
        return Stream.of("pear", "grape", "apple");
    }

    @ParameterizedTest
    @MethodSource(value = "sourceStream_String")
    void methodSourceStream_String(String fruit) {
        System.out.println("fruit = " + fruit);
    }

    //to pass in more than one parameter
    List<Arguments> sourceList_StringDouble() {
        return Arrays.asList(arguments("tomato", 2.0), arguments("carrots", 4.5), arguments("cabbage", 7.8));
    }

    @ParameterizedTest
    @MethodSource(value = "sourceList_StringDouble")
    void methodSourceList_StringDouble(String fruit, double price) {
        System.out.println("fruit = " + fruit + ", price = " + price);
    }

    Stream<Arguments> sourceStream_StringDouble() {
        return Stream.of(arguments("apple", 8.9), arguments("pear", 1.9));
    }

    @ParameterizedTest
    @MethodSource(value = "sourceStream_StringDouble")
    void methodSourceStream_StringDouble(String fruit, double price) {
        System.out.println("fruit = " + fruit + ", price = " + price);
    }

    //to pass in parameters from a different class
    @ParameterizedTest
    @MethodSource(value = "com.junit5tests.chapter7.ParameterProvider#sourceStream_StringDouble")
    void methodSourceStream_StringDouble2(String fruit, double price) {
        System.out.println("fruit = " + fruit + ", price = " + price);
    }
}
