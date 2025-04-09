package com.platzi.functional._15_streams_intro;

import java.util.*;
import java.util.stream.Collectors;
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

        //Tema de reduce, los tres tipos

        //reduce binaryaccumulator
        Stream<String> aLongStoryStream = Stream.of("Cuando", "despertó,", "el", "dinosaurio", "todavía", "estaba", "allí.");
        Optional<String> longStoryOptional = aLongStoryStream.reduce((previousStory, nextPart) -> previousStory + " " + nextPart);
        longStoryOptional.ifPresent(System.out::println); //"Cuando despertó, el dinosaurio todavía estaba allí."
        System.out.println("\nHasta aqui el tema de reduce(BinaryAccumulator), donde se define con el lambda, que el previous que es el primer elemento" +
                "\nSe concatene con un espacio, antes de agregar el siguiente elemento al acumulador");

        System.out.println("\n \n \n");

        //reduce(valorIniciar, BinaryOperator)
        Stream<Integer> firstTenNumbersStream = Stream.iterate(0, i -> i + 1).limit(10);
        int sumOfFirstTen = firstTenNumbersStream.reduce(0, Integer::sum);
        System.out.println("el resultado de la suma del stream es: "+sumOfFirstTen);
        System.out.println("\nHasta aqui el tema de reduce (valorInicial, BinaryOPerator, donde en el stream estoy generando numeros desde 0" +
                "\nHasta el limete que se establecio que es 10, para luego acumular los elementos del stream en un unico valor  , dando a entender " +
                "\nque comenzara la operacion desde 0" +
                "\ne ira sumando los numeros hasta el limite que definimos )");


        System.out.println("\n \n \n");


        //reduce (valorInicial, BinaryFunction <v, t , v>, BinaryOperator<v>
        Stream<String> aLongStoryStreamAgain = Stream.of("Cuando", "despertó,", "el", "dinosaurio", "todavía", "estaba", "allí.");
        int charCount = aLongStoryStreamAgain.reduce(0, (count, word) -> count + word.length(), Integer::sum);
        System.out.println("Este es el resultado de la suma de la longitud del stream: " + charCount);

        System.out.println("\nHasta aqui el tema de reduce(valorInicial (0), BinaryFunction(count valor acumulado, word es el siguiente elemento" +
                "\nword.leght calcula la longitud de cada palabra en el stream" +
                "\ncount + word.lenght, en cada paso suma la longitud de la palabra al acumulador: count" +
                "\ncount es el numero total de caracteres de todas las palabras en el stream)" +
                "\nBinaryOperator(Integer::sum, es un stream paralelo, ya que el stream se divide en varios hilos y cada uno tiene su acumulador" +
                "\nel combine se encarga de combinar los resultados parciales de cada hilo para producir el resultado final) ");

        System.out.println("\n \n \n");


        //COUNT, cuenta la longitud que tiene un stream
        Stream<Integer> yearsStream = Stream.of(1990, 1991, 1994, 2000, 2010, 2019, 2020, 2021, 2022, 2023, 2024, 2025);
        long yearsCount = yearsStream.count();
        System.out.println("La longitud existente en el stream es de: " + yearsCount);
        System.out.println("\nHasta aqui va el teme de count, que cuenta la longitud del stream");

        System.out.println("\n \n \n");



        //toarray, agrega los datos de un stream, a un arreglo, si queremos podemos especificar que tipo de dato queremos o si lo dejamos
        //por default, lo cual seria un tipo objeto
        Stream<String> numbersText = Stream.of("uno", "dos", "tres");
//        Object[] array = numbersText.toArray();
        String[] arrayText = numbersText.toArray(String[]::new);
        for (String obj : arrayText){
            System.out.println(obj);
        }

        System.out.println("\nHasta aqui el tema de toArray, el cual agrega todos los datos del stream, y los convierte a un arreglo" +
                "\nDonde el tipo de dato por defecto es (object), o podemos especificar que tipo de dato queremos manejar " );
        System.out.println("\n \n \n");


        //filter y map (filtrado y transformacion de datos)
        List<Integer> numeritos = Arrays.asList(1, 2, 3, 32, 45, 42, 46, 50);
        List<Integer> numeritosFiltros = numeritos.stream()
                .filter(n -> n % 2 == 0)
                .filter(n -> n > 10)
                .map(n -> n * 2)
                .collect(Collectors.toList());

        System.out.println(numeritosFiltros);
        System.out.println("\nHasta aqui va el tema de .filter(que filtra una lista o stream, segun las condiociones que nostros" +
                "\nDecidamos poner), .map (transforma los elementos de un stream, aplicando una funcion u accion, a cada uno" +
                "\n de los elementos");
        System.out.println("\n \n \n");



        //flatMap
        List<List<Integer>> listaDeListas = Arrays.asList(
                Arrays.asList(1, 2, 3),
                Arrays.asList(4, 5),
                Arrays.asList(6, 7, 8),
                Arrays.asList(19, 32, 12)
        );

        // Aplanar la lista de listas en un solo Stream de números
        List<Integer> resultado2  = listaDeListas.stream()
                .flatMap(List::stream)  // Aplanar cada lista dentro del Stream
                .collect(Collectors.toList());

        System.out.println("Esta es la fusion de 2 listas en una: "+resultado2);
        System.out.println("\nHasta aqui va el tema de flatmap (trasnforma los elementos del stream original, en un nuevo stream de elementos y los aplana" +
                "\n en un solo stream)");
        System.out.println("\n \n \n");


//        Stream<List<Courses>> coursesLists; // Stream{List["Java", "Java 8 Functional", "Spring"], List["React", "Angular", "Vue.js"], List["Big Data", "Pandas"]}
//        Stream<Courses> allCourses;



        //distinc
        List<Integer> numeritos2 = Arrays.asList(1, 2, 3, 4 ,4 ,5, 5);
        List<Integer> resultaditos2 = numeritos2.stream()
                .distinct()
                .collect(Collectors.toList());
        System.out.println("Esta es la lista sin duplicados: "+resultaditos2);
        System.out.println("\nHasta aqui va el tema de distinc(el cual elimina los datos duplicados)");
        System.out.println("\n \n \n");


        //limit
        List<Integer> numeritos3 = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // Crear un Stream y limitar a los primeros 3 números
        List<Integer> primerosTres = numeritos3.stream()
                .limit(3)
                .collect(Collectors.toList());

        System.out.println("Los primeros 3 numeros son: "+primerosTres);
        System.out.println("\nHasta aqui va el tema de limit (el cual limita la salida de datos del stream, al limite que nostros decidamos");
        System.out.println("\n \n \n");


        //peek
        List<Integer> numeritos4 = Arrays.asList(1, 2, 3, 4, 5, 6);

        // Crear un Stream, aplicar transformaciones y usar peek para inspeccionar los elementos
        List<Integer> resultado4 = numeritos4.stream()
                .filter(n -> n % 2 == 0)   // Filtrar solo números pares
                .peek(n -> System.out.println("Después de filter: " + n))  // Inspeccionar después del filtro
                .map(n -> n * 2)           // Multiplicar por 2
                .peek(n -> System.out.println("Después de map: " + n))    // Inspeccionar después del map
                .collect(Collectors.toList());  // Recolectar el resultado

        // Imprimir el resultado final
        System.out.println("Resultado final: " + resultado4);
        System.out.println("\nHasta aqui va el tema de peek (es un log dentro del stream, no modifica el stream, solo muestra" +
                "\nel proceso que esta sucediendo dentro del stream");
        System.out.println("\n \n \n");




        //skip
        List<Integer> numeritos5 = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // Crear un Stream, omitir los primeros 3 elementos y recolectar el resto
        List<Integer> resultado5 = numeritos5.stream()
                .skip(3)  // Omitir los primeros 3 elementos
                .collect(Collectors.toList());

        // Imprimir el resultado
        System.out.println("Este es el resultado, despues de omitir los 3 primeros numeros: "+resultado5);
        System.out.println("\nHasta aqui va el tema de skip(el cual omite los 3 primeros elementos del stream, sin modificar el stream");
        System.out.println("\n \n \n");





        //sorted
        List<String> palabras = Arrays.asList("java", "python", "c", "javascript", "ruby");

        // Crear un Stream y ordenar por la longitud de las palabras
        List<String> resultadoTexto = palabras.stream()
                .sorted(Comparator.comparingInt(String::length))  // Ordenar por longitud
                .collect(Collectors.toList());

        // Imprimir el resultado
        System.out.println("Este es el resultado de ordenar el texto por longitud"+resultadoTexto);
        System.out.println("\nHasta aqui va el tema de sorted(el cual ordena el stream, por defecto de menor a mayor" +
                "\ncon comparator, le estaras dando un orden personalizado segun las necesidades de uno");
        System.out.println("\n \n \n");




    }
}
