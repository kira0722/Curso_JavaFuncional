package com.platzi.functional._07_inference;

import com.platzi.functional._06_reference_operator.NombreUtils;

import java.util.List;
import java.util.function.Function;

public class Inferencia {
    public static void main(String[] args) {
        Function<Integer, String> funcionConvertidora =
                x -> "al doble: " + (x * 2);

        List<String> alumnos = NombreUtils.getList("Hugo", "Paco", "Luis");
        alumnos.forEach((String name) -> System.out.println(name));
        alumnos.forEach( name -> System.out.println(name));
        alumnos.forEach(System.out::println);

    }

}
