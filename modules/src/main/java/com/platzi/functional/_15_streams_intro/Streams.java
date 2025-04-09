package com.platzi.functional._15_streams_intro;

import com.platzi.functional._06_reference_operator.NombreUtils;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class Streams {
    public static void main(String[] args) {
        List<String> courseList = NombreUtils.getList("Java",
                "FrontEnd!",
                "FullStack");

        for (String course : courseList){
            String  newCourseName = course.toLowerCase().replace("!", "!!");
            System.out.println("Platzi: " + newCourseName);
        }

        Stream<String> courseStream = Stream.of("Java", "FrontEnd", "FullStack");

//        Stream<Integer> courseLengthStream = courseStream.map(course -> course.length());
//
//        Optional<Integer> longest = courseLengthStream.max((x, y) -> y -x);

//        Stream<String> emphasisCourses = courseStream.map(course -> course + "!");
        Stream<String> justJavaCourses = courseStream.filter(coures -> coures.contains("Java"));
        justJavaCourses.forEach(System.out::println);

        Stream<String> courseStream2 = courseList.stream();

        addOperator(
                courseStream2.map(course -> course + "!!")
                .filter(course -> course.contains("Java"))
        ).forEach(System.out::println);


    }

    static <T> Stream<T> addOperator(Stream<T> stream){
        return stream.peek(data -> System.out.println("Dato: " + data));
    }

}
