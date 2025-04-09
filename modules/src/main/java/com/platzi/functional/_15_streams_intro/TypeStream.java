package com.platzi.functional._15_streams_intro;

import javax.swing.text.html.Option;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class TypeStream {
    public static void main(String[] args) {
        IntStream infiniteStream =  IntStream.iterate(0, x -> x + 1);
        infiniteStream.limit(10)
                .parallel()
                .filter(x -> x % 2 == 0)
                .forEach(System.out::println);

        System.out.println("aqui finaliza el tema de de la funcion parelela");

        //Nos indica si un stream contiene un elemento según el Predicate que le pasemos:
        Stream<Integer> numbersStream = Stream.of(1, 2, 3, 4, 5, 6, 7, 11).peek(System.out::println);
        boolean biggerThanTen = numbersStream.anyMatch(i -> i > 7); //true porque tenemos el 11
        System.out.println(biggerThanTen);
        System.out.println("\nHasta aqui va el tema de anymatch (lo que quiere decir es que segun el predicate, si hay algun valor en el stream que" +
                "\ncumple alguno de todos los valores que haya cumple la condicion, sera verdadero o falso");


        //allMatch
        //Nos indica si todos los elementos de un Stream cumplen con un cierto Predicate:
        Stream<Integer> agesStream = Stream.of(19, 21, 35, 45, 12).peek(System.out::println);
        boolean allLegalDrinkingAge = agesStream.allMatch(age -> age > 11); //false, tenemos un menor
        System.out.println(allLegalDrinkingAge);
        System.out.println("\nHasta aqui va el tema de allmatch, (se refiere a que si todos los valores que este en el predicate o stream" +
                "\ncumple con la condicion, sera verdadero o falso");


        //noneMatch
        //Nos indica si todos los elementos de un Stream NO CUMPLEN un cierto Predicate:
        Stream<Integer> oddNumbers = Stream.of(1, 3, 5, 7, 9, 11).peek(System.out::println);
        boolean allAreOdd = oddNumbers.noneMatch(i -> i % 2 == 0);
        System.out.println(allAreOdd);
        System.out.println("\nHasta aqui el tema de noneMatch, el cual valida si ninguno de los valores en el predicate o" +
                "\nstream cumple con la condicion, retornara falso o verdadero\n");



        //finAny
        //Encuentra cualquier elemento que cumpla con la condicion
        List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5);

        Integer resultado = numeros.stream()
                .filter(n -> n > 3)
                .findAny()
                .orElse(-1);

        System.out.println("Elemento encontrado: " + resultado);
        System.out.println("\nHasta aqui el tema de findany, donde encuentra cualquier elemento/s que cumpla con la condicion");



        //findFirst
        //Encuentra el primer valor que cumpla con la condicion
        List<Integer> numeros2 = Arrays.asList(2, 12, 23, 12, 23);
        Integer resultados2 = numeros2.stream()
                .filter(n -> n < 10)
                .findFirst()
                .orElse(-1);

        System.out.println("El primer elemento encontrado es: " + resultados2);
        System.out.println("\nHasta aqui el tema de findFirst, donde encuentra el primer valor que cumpla con la condicion");
        System.out.println("\n \n \n");

        //Min, encuentra el elemento de menor valor
        Stream<Long> bigNumbers = Stream.of(100L, 10L, 1000L, 20L);
        Optional<Long> miniumOptional = bigNumbers.min(Long::compare);
        miniumOptional.ifPresent(min -> System.out.println("\neste es el numero menor: " + min));
        System.out.println("\nhasta aqui el teme de min, donde encuentra el numero menor del stream");


        //max encuentra el elemento de mayor valor
        Stream<Long> bigNumbers2 = Stream.of(100L, 10L, 1000L, 20L);
        Optional<Long> maxiumOptional = bigNumbers2.max(Long::compare);
        maxiumOptional.ifPresent(max -> System.out.println("\nEste es el numero mayor:" + max));
        System.out.println("\nhasta aqui el teme de max, donde encuentra el numero mayor del stream");

        System.out.println("\n \n \n");

        Stream<String> aLongStoryStream = Stream.of("Cuando", "despertó,", "el", "dinosaurio", "todavía", "estaba", "allí.");
        Optional<String> longStoryOptional = aLongStoryStream.reduce((previousStory, nextPart) -> previousStory + " " + nextPart);
        longStoryOptional.ifPresent(System.out::println); //"Cuando despertó, el dinosaurio todavía estaba allí."
        System.out.println("\nHasta aqui el tema de reduce(BinaryAccumulator), donde se define con el lambda, que el previous que es el primer elemento" +
                "\nSe concatene con un espacio, antes de agregar el siguiente elemento al acumulador");

        System.out.println("\n \n \n");

        Stream<Integer> firstTenNumbersStream = Stream.iterate(0, i -> i + 1).limit(10);
        int sumOfFirstTen = firstTenNumbersStream.reduce(0, Integer::sum);
        System.out.println("el resultado de la suma del stream es: "+sumOfFirstTen);
        System.out.println("\nHasta aqui el tema de reduce (valorInicial, BinaryOPerator, donde en el stream estoy generando numeros desde 0" +
                "\nHasta el limete que se establecio que es 10, para luego acumular los elementos del stream en un unico valor  , dando a entender " +
                "\nque comenzara la operacion desde 0" +
                "\ne ira sumando los numeros hasta el limite que definimos )");


        System.out.println("\n \n \n");

        Stream<String> aLongStoryStreamAgain = Stream.of("Cuando", "despertó,", "el", "dinosaurio", "todavía", "estaba", "allí.");
        int charCount = aLongStoryStreamAgain.reduce(0, (count, word) -> count + word.length(), Integer::sum);
        System.out.println("Este es el resultado de la suma de la longitud del stream: " + charCount);
        System.out.println("\nHasta aqui el tema de reduce(valorInicial (0), BinaryFunction(count valor acumulado, word es el siguiente elemento" +
                "\nword.leght calcula la longitud de cada palabra en el stream" +
                "\ncount + word.lenght, en cada paso suma la longitud de la palabra al acumulador: count" +
                "\ncount es el numero total de caracteres de todas las palabras en el stream)" +
                "\nBinaryOperator(Integer::sum, es un stream paralelo) ");




    }
}
