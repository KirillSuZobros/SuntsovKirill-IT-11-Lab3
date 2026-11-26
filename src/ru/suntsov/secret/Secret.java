package ru.suntsov.secret;

import java.util.concurrent.ThreadLocalRandom;

public class Secret{
    private final String text;
    private final Secret prev;
    private Secret next = null;
    private final String name;

    public Secret(String new_name, String new_text){

        if(isBlank(new_name) || isBlank(new_text)){
            throw new IllegalArgumentException("Имя хранителя секрета и сам секрет должны быть заполнены");
        }

        this.prev = null;
        this.name = new_name;
        this.text = new_text;
    }

    public Secret(String new_name, Secret old_secret){
        if (old_secret == null) {
            throw new IllegalArgumentException("Исходный секрет не может быть null");
        }

        if(isBlank(new_name)){
            throw new IllegalArgumentException("Имя хранителя секрета должно быть заполнено");
        }

        if(old_secret.next != null){
            throw new IllegalArgumentException("Секрет можно передовать только 1 другому человеку");
        }

        this.prev = old_secret;
        this.name = new_name;        

        System.out.println("\u001B[32m" + old_secret.name + "\u001B[0m" + " сказал что " + old_secret.text);

        int X = ThreadLocalRandom.current().nextInt(old_secret.text.length()/10 + 1);
        int num;
        String alphabet = "АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ";
        String new_text = old_secret.text;

        for(int i = 0; i < X; i++){
            num = ThreadLocalRandom.current().nextInt(new_text.length() + 1);            
            char randomLetter = alphabet.charAt(ThreadLocalRandom.current().nextInt(alphabet.length()));

            new_text = new_text.substring(0, num) + randomLetter + new_text.substring(num);
        }

        this.text = new_text;
        old_secret.next = this;
    }

    private boolean isBlank(String s1){
        return (s1 == null || s1.trim().isEmpty());
    }

    public String getName() {return this.name;}

    public int getSecretHolderNumber(){
        Secret curr = this;
        int N = 1;
        while (curr.prev != null){
            N++;
            curr = curr.prev;
        }
        return N;
    }

    public int getSecretHolderAfterNumber(){
        Secret curr = this;
        int N = 0;
        while (curr.next != null){
            N++;
            curr = curr.next;
        }
        return N;
    }

    public String getSecretHolderElseName(int N){
        Secret curr = this;
        while (N != 0 && curr != null){
            if(N > 0){
                N--;
                curr = curr.next;
            }
            else{
                N++;
                curr = curr.prev;
            }
        }
        if(N != 0 || curr == null){
            throw new IllegalArgumentException("Не существует такого человека");
        }
        return curr.name;
    }

    public int getSecretHolderElseTextDiff(int N){
        Secret curr = this;
        while (N != 0 && curr != null){
            if(N > 0){
                N--;
                curr = curr.next;
            }
            else{
                N++;
                curr = curr.prev;
            }
        }
        if(N != 0 || curr == null){
            throw new IllegalArgumentException("Не существует такого человека");
        }
        return Math.abs(this.text.length() - curr.text.length());
    }

    @Override
    public String toString(){
        return name + ": это секрет!";
    }
}