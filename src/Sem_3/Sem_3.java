package Sem_3;

import java.util.Comparator;

public class Sem_3 {
    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<Integer>();

        // Проверка метода addFirst
        linkedList.addFirst(1);
        linkedList.addFirst(2);
        linkedList.addFirst(3);

        // Проверка метода deleteFirst
        linkedList.deleteFirst();
        System.out.println("Size after deleteFirst: " + linkedList.getSize());

        // Проверка метода addLast
        linkedList.addLast(4);
        linkedList.addLast(5);

        // Проверка метода deleteLast
        linkedList.deleteLast();
        System.out.println("Size after deleteLast: " + linkedList.getSize());

        // Проверка метода contains
        System.out.println("Contains 2: " + linkedList.contains(2));
        System.out.println("Contains 5: " + linkedList.contains(5));

        // Проверка метода sort
        linkedList.sort();

        // Вывод элементов после сортировки
        System.out.print("Sorted elements: ");
        linkedList.printElements();
    }
}

