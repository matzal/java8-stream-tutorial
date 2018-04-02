package com.matzal.java8;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StringStreamMethods {

    public List<String> elementsStartWith(List<String> inputList, final String beginningOfString) {
        return inputList
                .stream()
                .filter(Objects::nonNull)
                .filter(s -> s.startsWith(beginningOfString))
                .sorted()
                .collect(Collectors.toList());
    }

    public Integer parseToIntAndFindMax(List<String> stringList) {
        return stringList
                .stream()
                .filter(Objects::nonNull)
                .filter(s -> s.matches("^[0-9]*$"))
                .mapToInt(Integer::parseInt)
                .max()
                .orElseThrow(NoSuchElementException::new);
    }

    public Supplier<Stream<String>> stringStreamSupplier(String startsWithFilter, String... args) {
        return () -> Stream.of(args)
                .filter(Objects::nonNull)
                .filter(s -> s.startsWith(startsWithFilter));
    }
}
