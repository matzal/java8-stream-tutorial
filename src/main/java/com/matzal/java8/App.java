package com.matzal.java8;

import java.util.function.Supplier;
import java.util.stream.Stream;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        Supplier<Stream<String>> streamSupplier =
                () -> Stream.of("d2", "a2", "b1", "b3", "c")
                .filter(s -> s.startsWith("b"));
        System.out.println(streamSupplier.get().anyMatch(s -> s.contains("b")));
        System.out.println(streamSupplier.get().noneMatch(String::isEmpty));
    }
}
