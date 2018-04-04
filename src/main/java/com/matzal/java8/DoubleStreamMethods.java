package com.matzal.java8;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class DoubleStreamMethods {

    public List<String> getIntValueAndReturnWithPrefix(List<Double> doubleList, String prefix){
        return doubleList.stream()
                .filter(Objects::nonNull)
                .mapToInt(Double::intValue)
                .mapToObj(i -> prefix + i)
                .collect(Collectors.toList());
    }
}
