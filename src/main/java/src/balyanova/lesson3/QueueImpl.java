package src.balyanova.lesson3;

import java.util.Arrays;

public class QueueImpl<E> implements Queue<E>{

    private final E[] data;
    private int maxSize;
    private int tail;
    private int head;
    private int nElem;

    public QueueImpl(int maxSize) {
        this.maxSize = maxSize;
        this.data = (E[]) new Object[maxSize];
        tail = -1;
        head = 0;
        nElem = 0;
    }

    @Override
    public boolean insert(E value) {
        if (isFull()) {
            return false;
        }
        if (tail == maxSize - 1) {
            tail = -1;
        }
        data[++tail] = value;
        nElem++;
        return true;
    }

    @Override
    public E remove() {
        if (isEmpty()) {
            return null;
        }
        E value = data[head++];
        if(head == maxSize) {
            data[head++] = null;
        }
        nElem--;
        return value;
    }

    @Override
    public E peekFront() {
        return data[head];
    }

    @Override
    public int size() {
        return nElem;
    }

    @Override
    public boolean isEmpty() {
        return (nElem == 0);
    }

    @Override
    public boolean isFull() {
        return (nElem == maxSize - 1);//если написать так, то все работает и выводится, кроме того что сам массив уменьшил на 1 элемент
        //return (nElem == maxSize);//не будет печатать содержимое массива (пустой)
    }

    @Override
    public void display() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = head; i <= tail; i++) {
            sb.append(data[i]);
            if (i != tail) {
                sb.append(", ");
            }
        }
        return sb.append("]").toString();
    }

//    @Override
//    public String toString() {
//        return Arrays.toString(data);
//    }
}
