package ru.suntsov.animals;

import java.util.concurrent.ThreadLocalRandom;

public class Cuckoo extends Bird{
    @Override
    public void Sing(){
        int num = ThreadLocalRandom.current().nextInt(1,11);

        System.out.println("\u001B[32m");

        for(int i = 0; i < num; i++){
             System.out.print("ку-ку ");
        }
         System.out.println("\u001B[0m");
    }
}