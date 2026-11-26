package ru.suntsov.animals;

public class Sparrow extends Bird{
    @Override
    public void Sing(){
        System.out.println("\u001B[32m" + "чырык" + "\u001B[0m");
    }
}