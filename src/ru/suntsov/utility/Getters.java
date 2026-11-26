package ru.suntsov.utility;

import java.util.Scanner;

public class Getters{
    
    public static int getInt(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nВведите число:");
        while(!scanner.hasNextInt()){
           System.out.println("\nВведено не число");
           scanner.next();
           System.out.println("\nВведите число:");
        }

        return scanner.nextInt();
    }

    public static int getInt(String str) {
    Scanner scanner = new Scanner(System.in);
    while (true) {
        System.out.println("\n" + str);
        String input = scanner.nextLine().trim();
        try {
            return Integer.parseInt(input); // пробуем превратить строку в число
        } 
        catch (NumberFormatException e) {
            System.out.println("\nНеверный ввод");
        }
    }
}

    public static boolean getBool(String str) {
    Scanner scanner = new Scanner(System.in);
    while (true) {
        System.out.println("\n" + str);
        String input = scanner.nextLine().trim();
        if (input.equals("1")) {
            return true;
        } 
        else if (input.equals("0")) {
            return false;
        }
        System.out.println("\nНеверный ввод. Введите 1 или 0.");
    }
}


    public static boolean isNamePart(String str){
        return str == null || str.isEmpty() || str.matches("^[а-яА-ЯёЁ]+$");
    }

    public static String getNamePart(String str){
        Scanner scanner = new Scanner(System.in, "CP866");
        System.out.println("\nВведите " + str);
        String result;
        boolean isGood;  
        do{
            result = scanner.nextLine();
            isGood = isNamePart(result);
            if(!isGood) System.out.println("\nНеверный ввод " + result);

        } while(!isGood);

        if(result!=null && !result.isEmpty()){
            result = result.substring(0,1).toUpperCase() + result.substring(1).toLowerCase();
        }

        return result;
    }

    public static String getString(String str){
        Scanner scanner = new Scanner(System.in, "CP866");
        System.out.println(str);
        return scanner.nextLine();
    }

}