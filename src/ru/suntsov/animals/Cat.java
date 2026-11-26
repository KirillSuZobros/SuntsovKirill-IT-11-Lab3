package ru.suntsov.animals;

public class Cat implements CanMeow{
    private final String name;

    public Cat(String new_name){
        if (new_name == null || new_name.trim().isEmpty()) {
            throw new IllegalArgumentException("Имя кота должно содержать хотя бы один символ");
        }
        this.name = new_name;
    }
    
    @Override
    public void meow(){
        System.out.println(this.name + ": мяу!");
    }

    public void Meow(int n){
        if(n>0){
            String line = this.name + ": ";
            for (int i = 0; i < n - 1; i++){
                line = line + "мяу-";
            }
            line = line + "мяу!";
            System.out.println(line);

        }
        
    }

    @Override
    public String toString(){
        return "кот: " + this.name;
    }
}