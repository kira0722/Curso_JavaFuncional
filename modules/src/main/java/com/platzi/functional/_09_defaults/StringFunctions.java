package com.platzi.functional._09_defaults;

public class StringFunctions {

    @FunctionalInterface
    interface StringOperations{
        int getAmount();

        default void operate(String texto){
            int x = getAmount();
            while (x-- > 0){
                System.out.println(texto);
            }
        }
    }

    @FunctionalInterface
    interface DoOperations{
        void take(String text);

        default void execute(int x, String text){
            while (x-- > 0){
                take(text);
            }
        }
    }

    public static void main(String[] args) {
        StringOperations six = () -> 6;
        six.operate("Alumno");
        System.out.println("\n");

        DoOperations operateFive = text -> System.out.println(text);
        operateFive.execute(2,"platzi");
    }
}
