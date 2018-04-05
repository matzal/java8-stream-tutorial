package com.matzal.java8.personExamples;

import com.sun.xml.internal.ws.util.StringUtils;

import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class PersonStreamMethods {

    List<Person> getPersonsWithNameStarting(String nameStart, List<Person> inputList) {
        return inputList.stream()
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
}
