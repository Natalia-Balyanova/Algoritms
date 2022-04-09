package src.balyanova.lesson4;

import src.balyanova.lesson4.deque.LinkedDeque;

import java.util.Collections;
import java.util.ListIterator;

public class Main {
    public static void main(String[] args) {
        System.out.println("testLinkedList");
        testLinkedList();
        System.out.println("testHomework");
        testHomeWork();
        System.out.println("testIterator");
        testIterator();
    }

    private static void testLinkedList() {
        TwoSideLinkedList<Integer> linkedList = new TwoSideLinkedListImpl<>();

        linkedList.insertFirst(1);
        linkedList.insertFirst(2);
        linkedList.insertFirst(3);
        linkedList.insertFirst(4);
        linkedList.insertFirst(5);
        linkedList.insertFirst(6);
        linkedList.insertFirst(7);
        linkedList.insertFirst(8);
        linkedList.insertLast(9);
        linkedList.insertLast(10);
        linkedList.insertLast(11);
        linkedList.insert(16, 34);
        linkedList.insert(15, 33);

        linkedList.display();

        System.out.println("Find 2: " + linkedList.contains(2));
        System.out.println("Find 1: " + linkedList.contains(1));
        System.out.println("Find 4: " + linkedList.contains(4));
        System.out.println("Find 4444: " + linkedList.contains(4444));

        System.out.println("remove first: " + linkedList.removeFirst());
        linkedList.display();
        linkedList.remove(4);
        linkedList.remove(11);
        System.out.println("remove first: " + linkedList.removeFirst());
        linkedList.display();
        System.out.println("remove first: " + linkedList.remove(34));
        linkedList.display();
    }

    private static void testHomeWork() { //заработало
        SimpleLinkedListImpl<Integer> linkedList = new SimpleLinkedListImpl<>();
        linkedList.insertFirst(1);
        linkedList.insertFirst(2);
        linkedList.insertFirst(3);

        for (Integer value : linkedList) {
            System.out.println("value: " + value);
        }
    }

    private static void testIterator() {//заработало
        java.util.List<Integer> linkedList = new java.util.LinkedList<>();
        Collections.addAll(linkedList, 1, 2, 3, 4, 5, 6, 7, 8, 9);

/*        for (Integer integer : linkedList) {
            System.out.println(integer);
        }*/
        ListIterator<Integer> iterator = linkedList.listIterator();
        //first:reset
        while (iterator.hasNext()) {
            Integer integer = iterator.next();
            System.out.println(integer + " до него: " + iterator.previousIndex());
            if (!iterator.hasNext()) {
                break;
            }
        }
    }
}

