package com.matzal.java8;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class DoubleStreamMethodsTest {

    DoubleStreamMethods doubleStreamMethods;

    @BeforeEach
    void setUp() {
        doubleStreamMethods = new DoubleStreamMethods();
    }

    @Test
    void getIntValueAndReturnWithPrefixTest() {
        //given
        List<Double> doubleList = Arrays.asList(5.0, 6.5, 1.9, 0.6);
        //when
        List<String> elementsWithPrefix = doubleStreamMethods.getIntValueAndReturnWithPrefix(doubleList, "element: ");
        //then
        assertThat(elementsWithPrefix).containsExactlyInAnyOrder(
                "element: 5",
                "element: 6",
                "element: 1",
                "element: 0");
    }

    @Test
    void getIntValueAndReturnWithPrefixTest_ListContainsNull() {
        //given
        List<Double> doubleList = Arrays.asList(5.0, 7.5, null, 1.9, 0.6);
        //when
        List<String> elementsWithPrefix = doubleStreamMethods.getIntValueAndReturnWithPrefix(doubleList, "element: ");
        //then
        assertThat(elementsWithPrefix).containsExactlyInAnyOrder(
                "element: 5",
                "element: 7",
                "element: 1",
                "element: 0");
    }
}