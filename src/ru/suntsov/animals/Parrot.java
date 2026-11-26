package ru.suntsov.animals;

import java.util.concurrent.ThreadLocalRandom;

public class Parrot extends Bird{

    final String text;

    public Parrot(String new_text){
        if (new_text == null || new_text.trim().isEmpty()) {
            throw new IllegalArgumentException("Текст попугая должен содержать хотя бы один символ");
        }
        this.text = new_text;
    }

    @Override
    public void Sing(){
        int num = ThreadLocalRandom.current().nextInt(1,text.length()+1);

        System.out.println("\u001B[32m" + text.substring(0, num) + "\u001B[0m");
    }
}