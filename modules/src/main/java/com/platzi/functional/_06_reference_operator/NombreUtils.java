package com.platzi.functional._06_reference_operator;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class NombreUtils {
    public static void main(String[] args) {
        List<Integer> profesores = getList(1, 2, 3, 4, 5);

        Consumer<Integer> printer = integer -> System.out.println(integer);
        profesores.forEach(printer);

        System.out.println("/////////////////////////////");
        profesores.forEach(System.out::println);
    }

    public static <T> List<T> getList(T ... elements){
        return Arrays.asList(elements);
    }

}
