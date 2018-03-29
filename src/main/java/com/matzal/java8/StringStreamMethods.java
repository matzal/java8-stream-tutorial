package com.matzal.java8;

import java.util.List;
import java.util.stream.Collectors;

public class StringStreamMethods {

    public List<String> elementsStartWith(List<String> inputList, final String beginningOfString){
        return inputList
                .stream()
                .filter(s -> s.startsWith(beginningOfString))
                .sorted()
                .collect(Collectors.toList());
    }
}
