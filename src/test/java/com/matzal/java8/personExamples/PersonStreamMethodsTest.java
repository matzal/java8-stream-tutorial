package com.matzal.java8.personExamples;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Java6Assertions.assertThat;

class PersonStreamMethodsTest {

    PersonStreamMethods personStreamMethods = new PersonStreamMethods();

    private final Person MAX = new Person("Max", 18);
    private final Person PETER = new Person("Peter", 23);
    private final Person PAMELA = new Person("Pamela", 23);
    private final Person DAVID = new Person("David", 12);
    private final Person PATRICK = new Person("Patrick", 40);

    private List<Person> samplePersons =
            Arrays.asList(MAX, PETER, PAMELA, DAVID, PATRICK);

    @Test
    void getPersonsWithNameStartingTest() {
        //given
        //when
        List<Person> filteredPersonsList = personStreamMethods
                .getPersonsWithNameStarting("pa", samplePersons);
        //then
        assertThat(filteredPersonsList).containsExactly(PAMELA, PATRICK);

    }

    @Test
    void getPersonsWithNameStartingTest_ListWithNull() {
        //given
        List<Person> personListWithNull = new ArrayList<>(samplePersons);
        personListWithNull.add(null);
        //when
        List<Person> filteredPersonsList = personStreamMethods
                .getPersonsWithNameStarting("p", personListWithNull);
        //then
        assertThat(filteredPersonsList).containsExactly(PETER, PAMELA, PATRICK);

    }

    @Test
    void getPersonsByAgeTest() {
        //given
        //when
        Map<Integer, List<Person>> personsByAge = personStreamMethods
                .getPersonsByAge(samplePersons);
        //then
        assertThat(personsByAge).containsKeys(12, 18, 23, 40)
                .containsValues(Arrays.asList(MAX),
                        Arrays.asList(DAVID),
                        Arrays.asList(PETER, PAMELA),
                        Arrays.asList(PATRICK));
    }

    @Test
    void getPersonsByAgeTest_checkEntry() {
        //given
        //when
        List<Person> personsWithAge12 = personStreamMethods
                .getPersonsByAge(samplePersons)
                .get(12);
        //then
        assertThat(personsWithAge12).containsExactly(DAVID);
    }

    @Test
    void getAverageAgeTest() {
        //given
        //when
        Double averageAge = personStreamMethods.getAverageAge(samplePersons);
        //then
        assertThat(averageAge).isEqualTo(23.2);
    }

    @Test
    void getAgeStatisticsTest() {
        //given
        //when
        IntSummaryStatistics statistics = personStreamMethods.getAgeStatistics(samplePersons);
        //then
        assertThat(statistics).hasFieldOrPropertyWithValue("count", 5L);
        assertThat(statistics).hasFieldOrPropertyWithValue("average", 23.2);
    }
}