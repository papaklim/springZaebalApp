package ru.aklementev.springzaebalapptest;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Test {
    public static String nameToBeChecked;
    public static Scanner scanner = new Scanner(System.in);
    public static Map<String, Integer> zaebalCounter = new HashMap<String, Integer>() {
        {
            put("Sanya", 0);
            put("Dima", 10);
        }
    };

    public static void checkName(String nameToBeChecked) {
        if (zaebalCounter.containsKey(nameToBeChecked)) {
            System.out.println("Congrats, given key exits in Map");
            int requestCount = zaebalCounter.get(nameToBeChecked).intValue();
            requestCount++;
            zaebalCounter.put(nameToBeChecked, requestCount);
            System.out.println(zaebalCounter);
        }
        else
        {
            System.out.println("Sorry, given key doesn't exists in Map");
            zaebalCounter.put(nameToBeChecked, 0);
            System.out.println(zaebalCounter);
        }
    }

    public static void main(String[] args) {

        while (true) {
            System.out.println("Enter name: ");
            nameToBeChecked = scanner.nextLine();

            checkName(nameToBeChecked);
        }

    }
}
