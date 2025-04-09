package com.platzi.functional._10_chaining;

public class Chaining2 {
    public static void main(String[] args) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Hola")
                .append("Alumno")
                .append("de")
                .append("platzi");

        Chainer chainer = new Chainer();
        chainer.sayHi().sayBye();

        Chainer chainer1 = chainer.sayHi();
        Chainer chainer2 = chainer1.sayBye();
        chainer2.sayBye();
    }

    static class Chainer{
        public Chainer sayHi(){
            System.out.println("HOLA");
            return this;
        }

        public Chainer sayBye(){
            System.out.println("bye");
            return this;
        }
    }
}
