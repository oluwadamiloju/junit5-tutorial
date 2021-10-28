package com.junit5tests.chapter3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LifecycleMethods {
    @Test
    void firstMethod() {
        System.out.println("This is the first test method");
    }

    @Test
    @DisplayName("US1234 - TC12 - this method is the second one")
    void secondMethod() {
        System.out.println("This is the second test method");
    }
}
