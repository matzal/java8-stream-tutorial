package com.matzal.java8;

        import org.junit.jupiter.api.Assertions;
        import org.junit.jupiter.api.BeforeEach;
        import org.junit.jupiter.api.Test;

        import static org.assertj.core.api.Assertions.*;

        import java.util.Arrays;
        import java.util.List;
        import java.util.NoSuchElementException;

class StringStreamMethodsTest {

    private StringStreamMethods stringStreamMethods;

    @BeforeEach
    void setUp() {
        stringStreamMethods = new StringStreamMethods();
    }

    @Test
    public void elementsStartWithTest() {
        //given
        List<String> myList = Arrays.asList("Jan", "Tomek", "Anna", "Alicja", "Andrzej");
        //when
        List<String> filteredList = stringStreamMethods.elementsStartWith(myList, "An");
        //then
        assertThat(filteredList).containsExactly("Andrzej", "Anna");
    }

    @Test
    public void elementsStartWithNoSuchElementTest() {
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
}