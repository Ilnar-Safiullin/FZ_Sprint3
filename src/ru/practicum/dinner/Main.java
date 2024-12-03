package ru.practicum.dinner;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static DinnerAllOperation dc;
    static Scanner scanner;

    public static void main(String[] args) {

        dc = new DinnerAllOperation();
        scanner = new Scanner(System.in);

        while (true) {
            printMenu();
            String command = scanner.next();

            switch (command) {
                case "1":
                    System.out.println("Введите тип блюда:");    // 1. Здесь оставил сообщения и ввод, в каком задании так делали, что сообщения и ввод в мейне должно было остаться,
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
                    if (!dc.dishesList.containsKey(nextItem)) { // если нет в списке ключей, то вернет в меню. ниже будет скопировано, так как мы после первый ввод до цикла While, переменную nextItem должны проверить.
                        System.out.println(nextItem + " такой категории еды нет, возврат в меню (_!_)");
                        break;
                    }
                    ArrayList<String> items = new ArrayList<>();
                    items.add(nextItem);
                    boolean outInMenu = true; // добавил булен, так как нужно если ввели категорию которой нет, выкидывало в меню просто и ничего не печатало лишнего.
                    while (!nextItem.isEmpty()) {
                        outInMenu = true;
                        nextItem = scanner.nextLine();
                        if (!nextItem.isEmpty()) { // добавил эту строку, чтобы пустая строка не добавлялась в Лист,
                            if (!dc.dishesList.containsKey(nextItem)) {
                                System.out.println(nextItem + " такой категории еды нет, возврат в меню (_!_)");
                                outInMenu = false;
                                break;
                            }
                            if (outInMenu) {
                                items.add(nextItem);
                            }
                        }
                        break;
                    }
                    if (outInMenu) {
                        dc.generateDishCombo(numberOfCombos, items);
                        break;
                    }
                case "3":
                    System.out.println("Пока, пока ]_(ツ)_/¯");
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

И нам же не нужно эту работу в гит кидать? Как будто не указано нигде и также зип архив просит.

Закоментил Первый вариант, он посимпатичнее был гораздо, но там всетаки метод scanner частично был в классе DinnerAllOperation.
Этот варинт второй, тоже закоментю. Тут метода сканнер нет нигде кроме мейна. Но при этом код получился франкенштейн.

Ссылка на гитХаб: git@github.com:Ilnar-Safiullin/FZ_Sprint3.git

Спасибо за обратную связь и хорошего дня!
*/