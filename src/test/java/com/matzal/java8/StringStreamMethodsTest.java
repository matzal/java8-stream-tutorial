package com.matzal.java8;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Supplier;
import java.util.stream.Stream;

class StringStreamMethodsTest {

    private StringStreamMethods stringStreamMethods;

    @BeforeEach
    void setUp() {
        stringStreamMethods = new StringStreamMethods();
    }

    @Test
    void elementsStartWithTest() {
        //given
        List<String> myList = Arrays.asList("Jan", "Tomek", "Anna", "Alicja", "Andrzej");
        //when
        List<String> filteredList = stringStreamMethods.elementsStartWith(myList, "An");
        //then
        assertThat(filteredList).containsExactly("Andrzej", "Anna");
    }

    @Test
    void elementsStartWithNoSuchElementTest() {
        //given
        List<String> myList = Arrays.asList("Jan", "Tomek", "Anna", "Alicja", "Andrzej");
        StringStreamMethods stringStreamMethods = new StringStreamMethods();
        //when
        List<String> filteredList = stringStreamMethods.elementsStartWith(myList, "Z");
        //then
        assertThat(filteredList).isEmpty();
    }

    @Test
    void parseToIntAndFindMaxTest() {
        //given
        List<String> stringNumbers = Arrays.asList("4", "8", "123", "32");
        //when
        Integer maxIntOfStringNumbers = stringStreamMethods.parseToIntAndFindMax(stringNumbers);
        //then
        assertThat(maxIntOfStringNumbers).isEqualTo(123);
    }

    @Test
    void parseToIntAndFindMax_ListWithNull() {
        //given
        List<String> stringNumbers = Arrays.asList("4", "8", null, "32");
        //when
        Integer maxIntOfStringNumbers = stringStreamMethods.parseToIntAndFindMax(stringNumbers);
        //then
        assertThat(maxIntOfStringNumbers).isEqualTo(32);
    }

    @Test
    void parseToIntAndFindMax_ListWithLetters() {
        //given
        List<String> stringNumbers = Arrays.asList("a", "b", "c", "d");
        //when
        //then
        Assertions.assertThrows(NoSuchElementException.class, () -> stringStreamMethods.parseToIntAndFindMax(stringNumbers));
    }

    @Test
    void stringStreamSupplierTest() {
        //given
        Supplier<Stream<String>> streamSupplier = stringStreamMethods.stringStreamSupplier("a",
                "a1", "anna", "b", "c2", "adam");
        //when
        boolean firstTerminalOperation = streamSupplier.get().allMatch(s -> s.startsWith("a"));
        boolean secondTerminalOperation = streamSupplier.get().allMatch(s -> s.startsWith("a"));
        //then
        assertThat(firstTerminalOperation).isEqualTo(true);
        assertThat(secondTerminalOperation).isEqualTo(true);
    }

    @Test
    void stringStreamSupplierTest_ListWithNull() {
        //given
        Supplier<Stream<String>> streamSupplier = stringStreamMethods.stringStreamSupplier("a",
                "a1", "anna", "b", null, "c2", "adam");
        //when
        boolean firstTerminalOperation = streamSupplier.get().allMatch(s -> s.startsWith("a"));
        boolean secondTerminalOperation = streamSupplier.get().allMatch(s -> s.startsWith("a"));
        //then
        assertThat(firstTerminalOperation).isEqualTo(true);
        assertThat(secondTerminalOperation).isEqualTo(true);
    }
}