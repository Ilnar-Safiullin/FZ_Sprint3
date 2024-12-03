package ru.practicum.dinner;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class DinnerAllOperation {
    static HashMap<String, ArrayList<String>> dishesList = new HashMap<>();

    static void addNewDish(String dishType, String dishName) {
        if (dishesList.containsKey(dishType)) {
            ArrayList<String> dishes = dishesList.get(dishType);
            dishes.add(dishName);
        } else {
            ArrayList<String> dishes = new ArrayList<>();
            dishes.add(dishName);
            dishesList.put(dishType, dishes);
        }
    }

    static void generateDishCombo(int numberOfCombos, ArrayList items) {
        for (int i = 0; i < numberOfCombos; i++) {
            Random random = new Random();
            ArrayList<String> combo = new ArrayList<>();
            for (int j = 0; j < items.size(); j++) {
                ArrayList<String> list = dishesList.get(items.get(j));
                int randomNumber = random.nextInt(list.size());
                combo.add(list.get(randomNumber));
            }
            System.out.println("Комбо " + (i + 1));
            System.out.println(combo);
        }
    }
}

// Есть ли ошибку в классе? я не создавал конструктор отдельный, может его нужно было как настроить сделать а не по умолчанию оставить.
// Может чтото лишнее обьявлено тут.