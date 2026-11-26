package ru.suntsov.utility;

import ru.suntsov.animals.*;
import ru.suntsov.geometry.*;
import ru.suntsov.people.*;
import ru.suntsov.secret.*;
import ru.suntsov.main.*;

import java.util.ArrayList;
import java.util.List;

public class Tasks {

    public static final String RESET = "\u001B[0m";
    public static final String GREEN = "\u001B[32m";
    public static final String RED = "\u001B[31m";

    public static void Task1(){
        System.out.println(GREEN + "\n1) - Задание 1 - 7" + RESET);
        String t1_name, t1_surname, t1_patr;
        try{
            System.out.println("Введите ФИО человека - хотя бы 1 параметр должен быть заполнен");
            t1_name = Getters.getNamePart("Имя (Только русские буквы)");
            t1_surname = Getters.getNamePart("Фамилию (Только русские буквы)");
            t1_patr = Getters.getNamePart("Отчество (Только русские буквы)");
            Name name = new Name(t1_name, t1_surname, t1_patr); 
            System.out.println(GREEN + "\nПолучившееся ФИО: " + RESET + name.toString());

        } 
        catch(IllegalArgumentException e){
            System.out.println(RED + "Ошибка ввода - " + e + RESET);
        }        
    }

    static public void Task2PrintArray(List<Human> arr){
        int i = 1;
        if(arr.isEmpty()) System.out.println(GREEN + "Пока нет людей" + RESET);
        else
        for (Human arr1 : arr) {
            System.out.println(GREEN + i + ") " + RESET + arr1.toString());
            i++;
        }
    }

    public static void Task2(){        
        boolean running = true;        
        List<Human> main_arr = new ArrayList<Human>();
        while (running) { 
            System.out.println(GREEN + "\n2) - Задание 1 - 8\n" + RESET);
            Task2PrintArray(main_arr);
            System.out.println("\n1) - Добавить человека");
            System.out.println("2) - Изменить рост человека");
            System.out.println("3) - Вывести имя и отца человека");
            System.out.println("4) - Обновить список людей");
            int user_choice;
            do { 
                user_choice = Getters.getInt("Введите номер действия (от 1 до 4) или 0 для выхода");
            } while (user_choice > 4 || user_choice < 0);
            switch (user_choice) {
                case 1:
                    String t1_name, t1_surname, t1_patr;
                    int height;
                    boolean sex;
                    try{
                        System.out.println("Введите ФИО человека - хотя бы 1 параметр должен быть заполнен");
                        t1_name = Getters.getNamePart("Имя (Только русские буквы)");
                        t1_surname = Getters.getNamePart("Фамилию (Только русские буквы)");
                        t1_patr = Getters.getNamePart("Отчество (Только русские буквы)");

                        height = Getters.getInt("Введите рост человека (не меньше 1)");

                        sex = Getters.getBool("Введите пол человека 0 - Ж|1 - М");

                        boolean hasFather = Getters.getBool("Есть ли у человека отец 0 - Нет|1 - Да");

                        if(hasFather && main_arr.size() != 0){
                            int num = Getters.getInt("Введите номер отца");
                            if(num > 0 && num <= main_arr.size()) main_arr.add(new Human(new Name(t1_name, t1_surname, t1_patr), height, main_arr.get(num-1), sex));
                            else System.out.println("Человека с индексом " + num + " нет");
                        }
                        else{
                            if(hasFather && main_arr.size() == 0) System.out.println("В списке людей нет ни одного человека");
                            main_arr.add(new Human(new Name(t1_name, t1_surname, t1_patr), height, null, sex));
                        }                       

                    } 
                    catch(IllegalArgumentException e){
                        System.out.println(RED + "Ошибка ввода - " + e + RESET);
                    }                      
                    break;
                case 2:
                    int num = Getters.getInt("Введите номер человека");
                    if(num > 0 && num <= main_arr.size()){
                        int new_height = Getters.getInt("Введите новый рост человека");
                        try {
                            main_arr.get(num-1).setHeight(new_height);
                        } 
                        catch (IllegalArgumentException e) {
                            System.out.println(RED + "Ошибка ввода - " + e + RESET);
                        }
                    }
                    else System.out.println("Человека с индексом " + num + " нет");
                    break;
                case 3:
                    int num2 = Getters.getInt("Введите номер человека");
                    if(num2 > 0 && num2 <= main_arr.size()){
                        Human father = main_arr.get(num2-1).getFather();
                        System.out.println(GREEN + "Человек: " +  RESET + main_arr.get(num2-1).getName());
                        if(father != null) System.out.println( GREEN + "Отец: " + RESET + father.getName());
                        else  System.out.println( RED + "Отца у этого человека нет" + RESET);
                    }
                    else System.out.println("Человека с индексом " + num2 + " нет");
                    break;
                case 4:
                    break;
                default:
                    running = false;
            }
        }
    }

    static public void Task3PrintArray(List<Secret> arr){
        int i = 1;
        if(arr.isEmpty()) System.out.println(GREEN + "Пока нет людей" + RESET);
        else
        for (Secret arr1 : arr) {
            System.out.println(GREEN + i + ") " + RESET + arr1.toString());
            i++;
        }
    }

    public static void Task3(){
        boolean running = true;        
        List<Secret> main_arr = new ArrayList<Secret>();
        while (running) { 
            System.out.println(GREEN + "\n3) - Задание 2 - 2\n" + RESET);
            Task3PrintArray(main_arr);
            System.out.println("\n1) - Добавить человека");
            System.out.println("2) - Узнать каким по очереди был данный хранитель секрета");
            System.out.println("3) - Узнать сколько еще человек узнали секрет после текущего хранителя");
            System.out.println("4) - Получить имя N-го человек узнавшего секрет");
            System.out.println("5) - Узнать разницу в количестве символов текста секрета с N-ым человеком");
            System.out.println("6) - Обновить список людей");

            int user_choice, num, num_other;
            do { 
                user_choice = Getters.getInt("Введите номер действия (от 1 до 6) или 0 для выхода");
            } while (user_choice > 6 || user_choice < 0);
            switch (user_choice) {
                case 1:
                    String t1_name, t1_text;
                    try{

                        boolean newSecret = Getters.getBool(GREEN + "Вы хотите ввести новый секрет? 0 - Нет|1 - Да" + RESET);
                        
                        if(newSecret){
                            t1_name = Getters.getString("Введите имя хранителя секрета");
                            t1_text = Getters.getString("Введите текст секрета");
                            main_arr.add(new Secret(t1_name, t1_text));
                        }
                        else{
                            if(main_arr.isEmpty()) System.out.println(RED+"Нет других секретов"+RESET);
                            else{
                                num = Getters.getInt("Введите номер другого секрета");
                                t1_name = Getters.getString("Введите новое имя хранителя секрета");
                                if(num > 0 && num <= main_arr.size()) main_arr.add(new Secret(t1_name, main_arr.get(num-1)));
                                else System.out.println(RED+"Хранителя секрета с индексом " + num + " нет"+RESET);
                            }
                        }
                    } 
                    catch(IllegalArgumentException e){
                        System.out.println(RED + "Ошибка ввода - " + e + RESET);
                    }                      
                    break;
                case 2:
                    num = Getters.getInt("Введите номер человека");
                    if(num > 0 && num <= main_arr.size()){
                        System.out.println("Номер " + main_arr.get(num-1).getName() + " в очереди секрета равен " +  main_arr.get(num-1).getSecretHolderNumber());
                    }
                    else System.out.println(RED+"Человека с индексом " + num + " нет"+RESET);
                    break;
                case 3:
                    num = Getters.getInt("Введите номер человека");
                    if(num > 0 && num <= main_arr.size()){
                        System.out.println("После " + main_arr.get(num-1).getName() + " идёт человек: " +  main_arr.get(num-1).getSecretHolderAfterNumber());
                    }
                    else System.out.println(RED+"Человека с индексом " + num + " нет"+RESET);
                    break;
                case 4:
                    num = Getters.getInt("Введите номер человека");
                    if(num > 0 && num <= main_arr.size()){
                        num_other = Getters.getInt("Введите сдвиг номера ко второму человеку");
                        try{
                            System.out.println("Имя второго человека: " + main_arr.get(num-1).getSecretHolderElseName(num_other));
                        }
                        catch(IllegalArgumentException e){
                            System.out.println(RED + "Ошибка ввода - " + e + RESET);
                        } 
                    }
                    else System.out.println(RED+"Человека с индексом " + num + " нет"+RESET);
                    break;
                case 5:
                    num = Getters.getInt("Введите номер человека");
                    if(num > 0 && num <= main_arr.size()){
                        num_other = Getters.getInt("Введите сдвиг номера ко второму человеку");
                        try{
                            System.out.println("Разница в тексте со вторым человеком: " + main_arr.get(num-1).getSecretHolderElseTextDiff(num_other));
                        }
                        catch(IllegalArgumentException e){
                            System.out.println(RED + "Ошибка ввода - " + e + RESET);
                        } 
                    }
                    else System.out.println(RED + "Человека с индексом " + num + " нет"+ RESET);
                    break;
                case 6:
                    break;
                default:
                    running = false;
            }
        }
    }

    public static void Task4(){
        System.out.println(GREEN + "\n4) - Задание 3 - 5" + RESET);
        
        PointExtended p = new PointExtended(Getters.getInt("Введите координату X"), Getters.getInt("Введите координату Y"), Getters.getInt("Введите координату Z"));

        System.out.println(GREEN + "\nПолучившаяся точка: " + RESET + p.toString());   
    }

    public static void Task5(){
        
        boolean running = true;        
        List<Bird> main_arr = new ArrayList<Bird>();
        main_arr.add(new Sparrow());
        main_arr.add(new Cuckoo());
        do{
            try {
                main_arr.add(new Parrot(Getters.getString("Введите текст попугая")));
            } 
            catch(IllegalArgumentException e){
                System.out.println(RED + "Ошибка ввода - " + e + RESET);
            } 
        } while(main_arr.size() == 2);

        while (running) { 
            System.out.println(GREEN + "\n5) - Задание 4 - 3" + RESET);
            System.out.println("\n1) - Спеть воробью");
            System.out.println("2) - Спеть кукушке");
            System.out.println("3) - Спеть попугаю");
            int user_choice;
            do { 
                user_choice = Getters.getInt("Введите номер действия (от 1 до 3) или 0 для выхода");
            } while (user_choice > 3 || user_choice < 0);
            switch (user_choice) {
                case 1, 2, 3:
                    main_arr.get(user_choice-1).Sing();
                    break;
                default:
                    running = false;
            }
        }
    }

    public static void DoMoew(List<CanMeow> arr){
        for (CanMeow obj : arr) obj.meow();
    }

    public static void Task6ArrayPrint(List<CanMeow> arr){
        int i = 1;
        if(arr.isEmpty()) System.out.println(GREEN + "Пока нет животных" + RESET);
        else
        for (CanMeow arr1 : arr) {
            System.out.println(GREEN + i + ") " + RESET + arr1.toString());
            i++;
        }
        
    }

    public static void Task6(){
        
        boolean running = true;        
        List<CanMeow> main_arr = new ArrayList<CanMeow>();

        while (running) { 
            System.out.println(GREEN + "\n6) - Задание 5 - 4" + RESET);
            Task6ArrayPrint(main_arr);
            System.out.println("\n1) - Добавить кота");
            System.out.println("2) - Добавить сойку");
            System.out.println("3) - Помяукать");
            int user_choice;
            do { 
                user_choice = Getters.getInt("Введите номер действия (от 1 до 3) или 0 для выхода");
            } while (user_choice > 3 || user_choice < 0);
            switch (user_choice) {
                case 1:
                    try{
                        main_arr.add(new Cat(Getters.getString("Введите имя кота")));
                    }
                    catch(IllegalArgumentException e){
                        System.out.println(RED + "Ошибка ввода - " + e + RESET);
                    } 
                    break;
                case 2:
                    try{
                        main_arr.add(new Jay(Getters.getString("Введите имя сойки")));
                    }
                    catch(IllegalArgumentException e){
                        System.out.println(RED + "Ошибка ввода - " + e + RESET);
                    } 
                    break;
                case 3:
                    if(!main_arr.isEmpty()){
                        System.out.println(GREEN + "\nМяуканье: " + RESET);
                        DoMoew(main_arr);
                    }
                    else{
                        System.out.println(RED + "\nВ массиве нет мяукающих существ: " + RESET);
                    }
                    break;
                default:
                    running = false;
            }
        }
    }

    public static void Task7(){
        System.out.println(GREEN + "\n7) - Задание 6 - 2" + RESET);
        System.out.println(GREEN + "\nТочка 1:" + RESET);
        Point p = new Point(Getters.getInt("Введите координату X"),Getters.getInt("Введите координату Y"));
        System.out.println(GREEN + "\nТочка 2:" + RESET);
        Point p2 = new Point(Getters.getInt("Введите координату X"),Getters.getInt("Введите координату Y"));

        System.out.println(GREEN + "\nТочки равны: " + RESET + p.equals(p2));   
    }

    public static void Task8(){
        
        boolean running = true;        
        List<CanMeow> main_arr = new ArrayList<CanMeow>();

        while (running) { 
            System.out.println(GREEN + "\n8) - Задание 7 - 2" + RESET);
            Task6ArrayPrint(main_arr);
            System.out.println("\n1) - Добавить кота");
            System.out.println("2) - Добавить сойку");
            System.out.println("3) - Помяукать");
            int user_choice;
            do { 
                user_choice = Getters.getInt("Введите номер действия (от 1 до 3) или 0 для выхода");
            } while (user_choice > 3 || user_choice < 0);
            switch (user_choice) {
                case 1:
                    try{
                        main_arr.add(new Cat(Getters.getString("Введите имя кота")));
                    }
                    catch(IllegalArgumentException e){
                        System.out.println(RED + "Ошибка ввода - " + e + RESET);
                    } 
                    break;
                case 2:
                    try{
                        main_arr.add(new Jay(Getters.getString("Введите имя сойки")));
                    }
                    catch(IllegalArgumentException e){
                        System.out.println(RED + "Ошибка ввода - " + e + RESET);
                    } 
                    break;
                case 3:
                    if(!main_arr.isEmpty()){
                        System.out.println(GREEN + "\nМяуканье: " + RESET);
                        MainCanMeow.DoMoew(main_arr);
                    }
                    else{
                        System.out.println(RED + "\nВ массиве нет мяукающих существ: " + RESET);
                    }
                    break;
                default:
                    running = false;
            }
        }
    }

    public static void Task9(){
        System.out.println(GREEN + "\n9) - Задание 8 - 4" + RESET);
        System.out.println(GREEN + "\nВведите точку" + RESET);
        Point p = new Point(Getters.getInt("Введите координату X"), Getters.getInt("Введите координату Y"));
        System.out.println(GREEN + "\nТочка 1: " + RESET + p);

        Point p2 = p.clone();

        System.out.println(GREEN + "\nКлон точки: " + RESET + p2);
        System.out.println(GREEN + "\nТочки лежат в одном месте в памяти: " + RESET + (p2 == p));
    }
}