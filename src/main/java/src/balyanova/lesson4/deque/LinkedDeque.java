package src.balyanova.lesson4.deque;

import src.balyanova.lesson4.TwoSideLinkedListImpl;

public class LinkedDeque<E> extends TwoSideLinkedListImpl<E> implements Deque<E> {

    protected NodeDeq<E> first;
    protected NodeDeq<E> last;

    @Override
    public void insertFirst(E value) {
        NodeDeq<E> current = first;
        this.first = new NodeDeq<>(null, value, current);
    }

    @Override
    public void insert(int index, E value) {
        NodeDeq<E> prev = null;
        NodeDeq<E> current = first;
        int num = 0;

        while (current != null) {
            if (num == index) {
                break;
            }
            num++;
            prev = current;
            current = current.next;
        }

        if (current == first) {
            insertFirst(value);
            return;
        }
        if (current == last) {
            insertLast(value);
            return;
        }
        prev.next = new NodeDeq<>(prev, value, current);
        size++;
    }

    @Override
    public void insertLast(E value) {
        if (isEmpty()) {
            insertFirst(value);
            return;
        }
        NodeDeq<E> prev = null;
        NodeDeq<E> current = first;

        while (current != null) {
            prev = current;
            current = current.next;
        }

        NodeDeq<E> newNode  = new NodeDeq<>(prev, value, null);
        last.next = newNode;
        last = newNode;
    }

    @Override
    public E removeFirst() {
        return super.removeFirst();
    }

    public void removeLast() {
        if (isEmpty()) {
            return;
        }
        NodeDeq<E> prev = null;
        NodeDeq<E> current = first;

        while (current != null) {
            prev = current;
            current = current.next;
        }

        assert false;
        prev.next = current.next;
        current.next = null;
        size--;
    }

    @Override
    public boolean remove(E value) {
        return super.remove(value);
    }

    @Override
    public E getLast() {
        return super.getLast();
    }

    @Override
    public boolean insert(E value) {
        return false;
    }

    @Override
    public E remove() {
        return null;
    }

    @Override
    public E peekFront() {
        return null;
    }

    @Override
    public boolean isFull() {
        return false;
    }

    @Override
    public boolean insertLeft(E value) {
        if (isEmpty()) {
            insertFirst(value);
            return true;
        }
        NodeDeq<E> prev = null;
        NodeDeq<E> current = first;

        current.next = new NodeDeq<>(current, value, current.next);
        size++;
        return true;
    }

    @Override
    public boolean insertRight(E value) {
        if (isEmpty()) {
            insertFirst(value);
            return true;
        }
        NodeDeq<E> prev;
        NodeDeq<E> current = first;

        prev = current.prev;
        current.next = new NodeDeq<>(prev, value, current.prev);
        size++;
        return true;
    }

    @Override
    public E removeLeft() {
        if (isEmpty()) {
            return null;
        }
        NodeDeq<E> prev = null;
        NodeDeq<E> current = first;

        while (current != null) {
            prev = current;
            current = current.next;
        }

        assert prev != null;
        assert false;
        prev.next = current.next;
        current.next = null;
        size--;
        return current.item;
    }

    @Override
    public E removeRight() {
        if (isEmpty()) {
            return null;
        }
        NodeDeq<E> prev = null;
        NodeDeq<E> current = first;

        while (current != null) {
            prev = current;
            current = current.next;
        }

        assert prev != null;
        assert false;
        prev.next = current.next;
        current.next = null;
        size--;
        return current.item;
    }
}