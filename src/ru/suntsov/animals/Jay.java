package ru.suntsov.animals;

public class Jay implements CanMeow{
    private final String name;

    public Jay(String new_name){
        if (new_name == null || new_name.trim().isEmpty()) {
            throw new IllegalArgumentException("Имя сойки должно содержать хотя бы один символ");
        }
        this.name = new_name;
    }
    
    @Override
    public void meow(){
        System.out.println(this.name + ": мя-а-ау!");
    }

    public void Meow(int n){
        if(n>0){
            String line = this.name + ": ";
            for (int i = 0; i < n - 1; i++){
                line = line + "мя-а-ау-";
            }
            line = line + "мя-а-ау!";
            System.out.println(line);

        }
        
    }

    @Override
    public String toString(){
        return "сойка: " + this.name;
    }
}