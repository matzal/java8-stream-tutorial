package com.matzal.java8;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

class StringStreamMethodsTest {

    @Test
    public void elementsStartWithTest() {
        //given
        List<String> myList = Arrays.asList("Jan", "Tomek", "Anna", "Alicja", "Andrzej");
        StringStreamMethods stringStreamMethods = new StringStreamMethods();
        //when
        List<String> filteredList = stringStreamMethods.elementsStartWith(myList, "An");
        //then
        assertThat(filteredList).containsExactly("Andrzej", "Anna");
    }
}