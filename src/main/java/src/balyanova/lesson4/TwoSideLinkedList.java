package src.balyanova.lesson4;

public interface TwoSideLinkedList<E>  extends LinkedList<E> {

    void insertLast(E value);

    E getLast();

    void insert(int index, E value);
}