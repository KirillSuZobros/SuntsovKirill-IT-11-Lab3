package ru.suntsov.people;

public class Name{
    private final String name;
    private final String surname;
    private final String patronymic;

    public Name(String s1){
        this(s1,null,null);
    }

    public Name(String s1, String s2){
        this(s1,s2,null);
    }

    public Name(String s1, String s2, String s3){

        if(isBlank(s1) && isBlank(s2) && isBlank(s3)){
            throw new IllegalArgumentException("Хотя бы один параметр имени должен быть не null и не пустой строкой.");
        }
        this.name = s1;
        this.surname = s2;
        this.patronymic = s3;
    }

    private boolean isBlank(String s1){
        return (s1 == null || s1.trim().isEmpty());
    }

    public String getName(){return name;}
    public String getSurname(){return surname;}
    public String getPatronymic(){return patronymic;}

    @Override
    public String toString(){
        String result = "";
        if(surname != null && !surname.isEmpty()) result = surname + " ";
        if(name != null && !name.isEmpty()) result = result + name + " ";
        if(patronymic != null && !patronymic.isEmpty()) result = result + patronymic+" ";
        return result.trim();
    }
}