package com.junit5tests.chapter6;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

public class ParameterizedTests3 {
    @ParameterizedTest //one file
    @CsvFileSource(files = "src/test/resources/params/shoppinglist.csv", numLinesToSkip = 1)
    void csvFileSource_StringDoubleIntStringString(String name, double price, int quantity, String unitOfMeasurement, String provider) {
        System.out.println("name = " + name + ", price = " + price + ", quantity = " + quantity + ", unitOfMeasurement = " + unitOfMeasurement + ", provider = " + provider);
    }

    @ParameterizedTest //two files
    @CsvFileSource(files = {"src/test/resources/params/shoppinglist.csv", "src/test/resources/params/shoppinglist2.csv"}, numLinesToSkip = 1)
    void csvFileSourceFromTwoFiles_StringDoubleIntStringString(String name, double price, int quantity, String unitOfMeasurement, String provider) {
        System.out.println("name = " + name + ", price = " + price + ", quantity = " + quantity + ", unitOfMeasurement = " + unitOfMeasurement + ", provider = " + provider);
    }

    @ParameterizedTest //file with a different delimiter that's not one character
    @CsvFileSource(files = "src/test/resources/params/shoppinglist3.csv", numLinesToSkip = 1, delimiterString = "__")
    void csvFileSourceWithDifferentDelimiter_StringDoubleIntStringString(String name, double price, int quantity, String unitOfMeasurement, String provider) {
        System.out.println("name = " + name + ", price = " + price + ", quantity = " + quantity + ", unitOfMeasurement = " + unitOfMeasurement + ", provider = " + provider);
    }

    @ParameterizedTest //file with empty and null values
    @CsvFileSource(files = "src/test/resources/params/shoppinglist4.csv", numLinesToSkip = 1, delimiterString = "__")
    void csvFileSourceWithNullAndEmptyValues_StringDoubleIntStringString(String name, double price, int quantity, String unitOfMeasurement, String provider) {
        System.out.println("name = " + name + ", price = " + price + ", quantity = " + quantity + ", unitOfMeasurement = " + unitOfMeasurement + ", provider = " + provider);
    }
}
