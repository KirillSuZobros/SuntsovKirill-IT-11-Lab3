package ru.suntsov.main;

import java.util.List;
import ru.suntsov.animals.CanMeow;

public class MainCanMeow {
    public static void DoMoew(List<CanMeow> arr){
        for (CanMeow obj : arr) obj.meow();
    }
}

