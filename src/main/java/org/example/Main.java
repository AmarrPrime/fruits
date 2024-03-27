package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {


    public static void main(String[] args) throws FileNotFoundException {
        List<String> fruits = getFruits("C:\\Users\\Nelriadok\\IdeaProjects\\Picknick\\src\\main\\resources\\input.txt");

        System.out.println("Число слов в файле: " + fruits.size());
        String fruitMax = getLongestFruit(fruits);
        System.out.println("Самое длинное слово в файле: " + fruitMax);

        System.out.println("Количество повторений слов: ");
        Map<String, Integer> frequencies = getFrequencies(fruits);
        for (Map.Entry<String, Integer> entry : frequencies.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public static List<String> getFruits(String filename) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(filename));
        List<String> fruits = new ArrayList<>();
        String content = scanner.nextLine();
        scanner.close();
        for (String fruit : content.split(" ")) {
            fruits.add(fruit);
        }
        return fruits;

    }

    public static String getLongestFruit(List<String> fruits) {
        String fruitMax = fruits.get(0);
        for (String fruit : fruits) {
            if (fruit.length() > fruitMax.length()) {
                fruitMax = fruit;
            }
        }
        return fruitMax;
    }

    public static Map<String, Integer> getFrequencies(List<String> fruits) {
        Map<String, Integer> frequenciesResult = new HashMap<>();
        for (String fruit : fruits) {
            Integer count = frequenciesResult.get(fruit);
            if (count == null) {
                frequenciesResult.put(fruit, 1);
            } else {
                frequenciesResult.put(fruit, ++count);
            }
        }
        return frequenciesResult;
    }
}