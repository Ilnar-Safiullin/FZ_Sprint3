package ru.practicum.dinner;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

    static DinnerAllOperation dc;
    static Scanner scanner;
    static HashMap<String, ArrayList<String>> dishesList; // 1. если я закоментирую вот эту строку и еще одну ниже с комментом 1, то программа так же будет нормально работать, значит можно отсюда убрать эту строку?

    public static void main(String[] args) {
        dishesList = new HashMap<>(); // 1. Так же к первому вопросу относится, получается если строку выше уберем, то и эту можем убрать.
        dc = new DinnerAllOperation();
        scanner = new Scanner(System.in);

        while (true) {
            printMenu();
            String command = scanner.next();

            switch (command) {
                case "1":
                    System.out.println("Введите тип блюда:");    // 2. Здесь оставил сообщения и ввод, в каком задании так делали, что сообщения и ввод в мейне должно было остаться,
                    String dishType = scanner.next();            // хотя удобнее вроде если убрать и сообщения и ввод сам внутрь метода. Есть ли какое то правило где все это должно быть?
                    System.out.println("Введите название блюда:");
                    String dishName = scanner.next();
                    dc.addNewDish(dishType, dishName);
                    break;
                case "2":
                    System.out.println("Начинаем конструировать обед...");
                    System.out.println("Введите количество наборов, которые нужно сгенерировать:");
                    int numberOfCombos = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Вводите типы блюда, разделяя символом переноса строки (enter). Для завершения ввода введите пустую строку");
                    String nextItem = scanner.next();
                    scanner.nextLine();
                    dc.generateDishCombo(numberOfCombos, nextItem, scanner); // 3. Здесь пришлось scanner тоже ввести, ато внутри метода много раз вводится же слово
                    break;
                case "3":
                    System.out.println("Пока, пока ]_(ツ)_/¯");
                    return;
            }
        }
    }

    private static void printMenu() {
        System.out.println("Выберите команду:");
        System.out.println("1 - Добавить новое блюдо");
        System.out.println("2 - Сгенерировать комбинации блюд");
        System.out.println("3 - Выход");
    }
}
/* Привет Сергей, этот блок показался легче чем предыдущий, замучился только next() и nextLine() расставлять - подбирать,
 чтобы в нужном месте пустая строка считывалась и цикл прекращался. Попробывал все заменить на next() просто, и в итоге
программа просто стояла на месте когда я пустую строку оставлял и Enter жал. Может есть какая та команда, которая пустую
строку может считать. Чтобы не мучаться с next() и nextLine(). Оставил также вопросы внутри кода.

В Мейне оставил только ПринтМеню. Все остальное бросил в класс DinnerAllOperation. Так как методов мало, наверное нет
смысла плодить кучу классов. Как по твеому мнению надо было расскинуть тут методы по класссам.

И нам же не нужно комментить эту работу и в гит кидать? Как будто не указано нигде и также зип архив просит

Спасибо за обратную связь и хорошего дня!
*/