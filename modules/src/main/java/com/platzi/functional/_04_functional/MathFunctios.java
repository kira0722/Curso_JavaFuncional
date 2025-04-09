package com.platzi.functional._04_functional;

import java.util.function.Function;
import java.util.function.Predicate;

public class MathFunctios {
    public static void main(String[] args) {
        Function<Integer, Integer> squareFunction =
                new Function<Integer, Integer>() {
            @Override
            public Integer apply(Integer x) {
                return x * x;
            }
        };

        System.out.println(squareFunction.apply(5));
        System.out.println(squareFunction.apply(25));


        Function<Integer, Boolean> isOdd = x -> x % 2 == 1;

        Predicate<Integer> isEven = X -> X % 2 == 0;

        isEven.test(4); //true
        System.out.println(isEven.test(5) + " este es el resultado de la ecuacion");

        Predicate<Student> isApproved = student -> student.getCalificacion() > 6.0;

        Student sinhue = new Student(7.9);
        System.out.println(isApproved.test(sinhue)+ " este es el resultado del estudiante");


    }

    static class Student {
        private double calificacion;

        public Student(double calificacion) {
            this.calificacion = calificacion;
        }

        public double getCalificacion() {
            return calificacion;
        }
    }
}
