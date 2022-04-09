package src.balyanova.lesson4.deque;

import src.balyanova.lesson3.Queue;

public interface Deque<E> extends Queue<E> {
//1. Реализовать Deque
    boolean insertLeft(E value);
    boolean insertRight(E value);

    E removeLeft();
    E removeRight();

    class NodeDeq<E> {
        E item;
        NodeDeq<E> next;
        NodeDeq<E> prev;

        public NodeDeq(NodeDeq<E> prev, E item, NodeDeq<E> next) {
            this.prev = prev;
            this.item = item;
            this.next = next;
        }
    }
}