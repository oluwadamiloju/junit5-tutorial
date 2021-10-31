package com.junit5tests.chapter10;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.*;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class DisabledAndEnabledTests {
    /*
    @Disabled disables a test without any other condition.
    The test would be ignored on a class level but will still run if ran alone
    @Disabled(message) provides an explanation to the person running it on why a test is disabled.
    One of the possibly frequent uses for disabling the test would be that we want to disable it on an operating system.
    @DisabledOnOs disables a test if it's on a particular OS. @EnabledOnOs enables a test only if it's on a particular OS.
    @DisabledIfSystemProperty/ @DisabledIfSystemProperties disabled a test if the system property's value matches the regex specified.
    @DisabledIf allows us to create a method which returns a boolean value and based on the result of the boolean value,
    the test will either be enabled or disabled.
     */

    @Test
    @Disabled(value = "Demo for @Disabled")
    void firstTest() {
        System.out.println("This is the first test");
    }

    @Test
    @DisabledOnOs(value = OS.WINDOWS, disabledReason = "Demo for @DisabledOnOs")
    void secondTest() {
        System.out.println("This is the second test");
    }

    @Test
    @EnabledOnOs(value = OS.MAC, disabledReason = "Demo for @EnabledOnOS")
    void thirdTest() {
        System.out.println("This is the third test");
    }

    @Test
    @DisabledIfSystemProperty(named = "env", matches = "staging", disabledReason = "@DisabledIfSystemProperty Demo")
    void fourthTest() {
        System.out.println("This is the fourth test");
    }

    @Test
    @DisabledIf(value = "provider", disabledReason = "Demo for @DisabledIf")
    void fifthTest() {
        System.out.println("This is the fifth test");
    }

    boolean provider() {
        return LocalDate.now().getDayOfWeek().equals(DayOfWeek.SUNDAY);
    }

    @Test
    void sixthTest() {
        System.out.println("This is the sixth test");
    }
}
