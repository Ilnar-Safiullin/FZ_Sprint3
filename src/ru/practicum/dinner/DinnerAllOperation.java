package ru.practicum.dinner;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
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

    static void generateDishCombo(int numberOfCombos, String nextItem, Scanner scanner) {
        ArrayList<String> items = new ArrayList<>();
        if (!dishesList.containsKey(nextItem)) { // если нет в списке ключей, то вернет в меню. ниже будет скопировано, так как мы после первый ввод до цикла While, переменную nextItem должны проверить.
            System.out.println(nextItem + " такой категории еды нет, возврат в меню (_!_)");
            return;
        }
        items.add(nextItem);
        while (!nextItem.isEmpty()) {
            nextItem = scanner.nextLine();
            if (!nextItem.isEmpty()) { // добавил эту строку, чтобы пустая строка не добавлялась в Лист,
                if (!dishesList.containsKey(nextItem)) {
                    System.out.println(nextItem + " такой категории еды нет, возврат в меню (_!_)");
                    return;
                }
                items.add(nextItem);
            }
        }
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

