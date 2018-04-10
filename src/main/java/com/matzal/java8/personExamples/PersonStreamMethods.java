package com.matzal.java8.personExamples;

import com.sun.xml.internal.ws.util.StringUtils;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class PersonStreamMethods {

    private final Collector<Person, StringJoiner, String> personNameCollector =
            Collector.of(
                    () -> new StringJoiner(" | "),
                    (j, p) -> j.add(p.getName().toUpperCase()),
                    StringJoiner::merge,
                    StringJoiner::toString);

    private Collector<Person, StringJoiner, String> getPersonNameCollector() {
        return personNameCollector;
    }

    List<Person> getPersonsWithNameStarting(String nameStart, List<Person> personList) {
        return personList.stream()
                .filter(Objects::nonNull)
                .filter(p -> p.getName()
                        .startsWith(StringUtils.capitalize(nameStart)))
                .collect(Collectors.toList());
    }

    Map<Integer, List<Person>> getPersonsByAge(List<Person> personList) {
        return personList.stream()
                .filter(Objects::nonNull)
                .collect(Collectors.groupingBy(Person::getAge));
    }

    Double getAverageAge(List<Person> personList) {
        return personList.stream()
                .filter(Objects::nonNull)
                .collect(Collectors.averagingInt(Person::getAge));
    }

    IntSummaryStatistics getAgeStatistics(List<Person> personList) {
        return personList.stream()
                .filter(Objects::nonNull)
                .collect(Collectors.summarizingInt(Person::getAge));
    }

    String getNamesOfPersonsOlderThan(List<Person> personList, int age) {
        return personList.stream()
                .filter(Objects::nonNull)
                .filter(p -> p.getAge() >= age)
                .map(Person::getName)
                .collect(Collectors.joining(" and ", "", " are older than " + age + "."));
    }

    Map<Integer, String> getAgeMapWithNames(List<Person> personList) {
        return personList.stream()
                .filter(Objects::nonNull)
                .collect(Collectors.toMap(
                        Person::getAge,
                        Person::getName,
                        (p1, p2) -> p1 + "; " + p2));
    }

    String getAllNamesUpperCase(List<Person> personList) {
        return personList.stream()
                .filter(Objects::nonNull)
                .collect(getPersonNameCollector());
    }

    Person getOldestPerson(List<Person> personList) throws IllegalArgumentException {
        return personList.stream()
                .filter(Objects::nonNull)
                .reduce((p1, p2) -> p1.getAge() > p2.getAge() ? p1 : p2)
                .orElseThrow(IllegalArgumentException::new);
    }

    Person getYoungestPerson(List<Person> personList) throws IllegalArgumentException {
        return personList.stream()
                .filter(Objects::nonNull)
                .reduce((p1, p2) -> p1.getAge() < p2.getAge() ? p1 : p2)
                .orElseThrow(IllegalArgumentException::new);
    }
}
