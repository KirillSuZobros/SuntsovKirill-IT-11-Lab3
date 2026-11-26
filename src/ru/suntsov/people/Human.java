package ru.suntsov.people;

public class Human{
    private Name name;
    private int height;
    private final Human father;
    private boolean male = true;

    public Human(Name new_name, int new_height, Human father, boolean new_sex){

        if (new_name == null) {
            throw new IllegalArgumentException("Имя человека не может быть null");
        }

        setHeight(new_height);
        
        this.name = new_name;
        this.father = father;
        this.male = new_sex;

        String father_surname;

        if( (name.getSurname() == null || name.getSurname().isEmpty()) && father != null && father.getName().getSurname() != null) {

            father_surname = father.getName().getSurname();

            if(male) name = new Name (name.getName(), father_surname, name.getPatronymic() );
            
            else if(father_surname.endsWith("ов") || father_surname.endsWith("ин"))
            name = new Name (name.getName(), father_surname + "а", name.getPatronymic() );

            else name = new Name (name.getName(), father_surname, name.getPatronymic() );
        }

        String father_name;

        if( (name.getPatronymic() == null || name.getPatronymic().isEmpty()) && father != null && father.getName().getName() != null) {

            father_name = father.getName().getName();

            if(father_name.endsWith("а") || father_name.endsWith("я")) 
            father_name = father_name.substring(0, father_name.length()-1);

            if(male) name = new Name (name.getName(), name.getSurname(), father_name + "ович");

            else  name = new Name (name.getName(), name.getSurname(), father_name + "овна");
        }
    }    

    public Human(String s1, int new_height , Human father, boolean new_sex){
        this(new Name(s1), new_height, father, new_sex);
    }

    public Human(Name new_name, int new_height, boolean new_sex){
        this(new_name, new_height, null, new_sex);
    }

    public Human(String s1, int new_height, boolean new_sex){
        this(new Name(s1), new_height, null, new_sex);
    }

    public Name getName(){return name;}

    public Human getFather(){return father;}

    public int getHeight(){return height;}
    
    public void setHeight(int new_height){

         if(new_height < 1 || new_height > 500){
            throw new IllegalArgumentException("Рост человека не может быть отрицательным или больше 500");
        }
        
        this.height = new_height;
    }

    @Override
    public String toString(){
        return name.toString() + ", " + height;
    }
}