package Sem_3;

import java.util.Arrays;
import java.util.Comparator;
import java.util.NoSuchElementException;

public class LinkedList<E extends Comparable<E>> {

    private int size;
    private Node<E> first;
    private Node<E> last;

    public int getSize() {
        return size;
    }

    public void addFirst(E e) {
        size++;
        Node<E> node = new Node<>(e);
        if (first == null) {
            first = node;
            last = first;
            return;
        }
        node.next = first;
        first.previous = node;
        first = node;
    }

    public void deleteFirst() {
        if (first != null) {
            first = first.next;
            first.previous = null;
            size--;
        } else throw new NoSuchElementException();
    }

    public void addLast(E e) {
        if (first == null) {
            addFirst(e);
            return;
        }
        size++;
        Node<E> node = new Node<>(e);
        Node<E> last = null;
        for (Node<E> i = first; i != null; i = i.next) {
            last = i;
        }
        last.next = node;
        node.previous = last;
        this.last = node;
    }

    public void deleteLast() {
        if (first == null) throw new NoSuchElementException();
        size--;
        Node<E> last = null;
        for (Node<E> i = first; i != null; i = i.next) {
            last = i;
        }
        this.last = last.previous;
        last = null;
    }

    public boolean contains(E e) {
        for (Node<E> i = first; i != null; i = i.next) {
            if (i.data.equals(e)) return true;
        }
        return false;
    }

    public void sort(Comparator<? super E> c) {
        Object[] arr = new Object[size];
        Node<E> tmp = new Node<E>(first.data);
        tmp.next = first.next;
        for (Object o : arr) {
            o = tmp;
            tmp = tmp.next;
        }
        Arrays.sort(arr, (Comparator) c);
        first = null;
        int cnt = 0;
        for (Node<E> i = first; i != null; i = i.next) {
            i.data = (E) arr[cnt++];
        }
    }
    public void printElements() {
        Node<E> current = first;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public void sort() {
    }


    class Node<T> {

        public T data;
        public Node next;
        public Node previous;

        public Node(T data) {
            this.data = data;
            next = null;
            previous = null;
        }
    }
}

