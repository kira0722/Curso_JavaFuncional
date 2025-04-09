package com.platzi.functional._14_optionals;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class Optionals2 {

    public static void main(String[] args) {
        List<String> names = getNames();
        if (names != null){
            //operar con nombres.
        }

        Optional<List<String>> optionalNames = getOptionalNames();
        if (optionalNames.isPresent()){

        }

        optionalNames.ifPresent(namesValue -> namesValue.forEach(System.out::println));

        Optional<String> valuablePlayer = optionalValuablePlayer();

        String valuablePlayerName = valuablePlayer.orElseGet(() -> "no player");

        System.out.println(valuablePlayerName);
    }


    static List<String> getNames(){
        List<String> list = new LinkedList<>();

        return Collections.emptyList();
    }

    static String mostValuablePlayer(){
//        return "";
        return null;
    }

    static int mostExpensiveTime(){
        return 0;
    }

    static Optional<List<String>> getOptionalNames(){
        List<String> namesList = new LinkedList<>();
        //obtencion de nombres
        return Optional.of(namesList);
    }

    static Optional<String> optionalValuablePlayer(){
//        return Optional.ofNullable()
        try {
//            return Optional.of("its me");
            //accesos
        }catch (Exception e){
            e.printStackTrace();
        }
        return Optional.empty();
    }

}
