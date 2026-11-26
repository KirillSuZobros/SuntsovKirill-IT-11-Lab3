package ru.suntsov.main;

import static java.lang.Integer.parseInt;
import static java.lang.Math.pow;
import ru.suntsov.utility.*;

public class Main {

    public static final String RESET = "\u001B[0m";
    public static final String GREEN = "\u001B[32m";
    public static final String RED = "\u001B[31m";


    static double power(String s1, String s2){
        int X = parseInt(s1);
        int Y = parseInt(s2);

        return pow(X,Y);
    }

    public static void main(String[] args)  {

        if(args.length == 2){
            try{
                double res = power(args[0], args[1]);
                System.out.println(GREEN + "\n9) - Задание 7 - 3" + RESET);
                System.out.println(GREEN + "\nРезультат возведения " + args[0] + " в степень " + args[1] + RESET + " = " + res);
            }
            catch(Exception e){
                System.out.println(RED + "\nОшибка ввода чисел" + RESET);
            }
        }
        else{
            System.out.println(RED + "\nДля выполнения задания 7 - 3 введите 2 аргумента при запуске main" + RESET);
        }

        boolean running = true;
        while (running) { 
            System.out.print(GREEN + "\nГлавное меню" + RESET);
            System.out.print("\n1) - Задание 1 - 7");
            System.out.print("\n2) - Задание 1 - 8");
            System.out.print("\n3) - Задание 2 - 2");
            System.out.print("\n4) - Задание 3 - 5");
            System.out.print("\n5) - Задание 4 - 3");
            System.out.print("\n6) - Задание 5 - 4");
            System.out.print("\n7) - Задание 6 - 2");
            System.out.print("\n8) - Задание 7 - 2");
            System.out.print("\n9) - Задание 8 - 4");

            int user_choice;
            do { 
                user_choice = Getters.getInt("Введите номер задания (от 1 до 9) или 0 для выхода");
            } while (user_choice > 9 || user_choice < 0);

            switch (user_choice) {
                case 1:
                    Tasks.Task1();
                    break;
                case 2:
                    Tasks.Task2();
                    break;
                case 3:
                    Tasks.Task3();
                    break;
                case 4:
                    Tasks.Task4();
                    break;
                case 5:
                    Tasks.Task5();
                    break;
                case 6:
                    Tasks.Task6();
                    break;
                case 7:
                    Tasks.Task7();
                    break;
                case 8:
                    Tasks.Task8();
                    break;
                case 9:
                    Tasks.Task9();
                    break;
                default:
                    running = false;
            }
        }
           
        

    }
}