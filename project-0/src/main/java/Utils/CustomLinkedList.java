package Utils;

import java.util.Iterator;


public class CustomLinkedList<E> implements CustomListInterface<E>, Iterable<E>{
    private Node<E> head;
    private Node<E> tail;
    private int size;


    @Override
    public void add(E e) {
        Node<E> newNode = new Node<E>(e);
        if (size == 0) {
            head = newNode;
            tail = newNode;
        }

        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;
        size++;
    }

    @Override
    public E get(int index) {
        //Implement this method
        Node<E> cursor = head;
        for(int i = 0; i < index; i++) {
            cursor = cursor.next;
        }
        return cursor.obj;
    }

    @Override
    public int size() {
        //Implement this method
        return size;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private Node<E> cursor = head;

            @Override
            public boolean hasNext() {
                if (cursor == null){
                    return false;
                }
                return true;
            }

            @Override
            public E next() {
                E e = cursor.obj;
                cursor = cursor.next;
                return e;
            }
        };
    }

    private class Node<E> {
        Node<E> next;
        Node<E> prev;
        E obj;

        Node() {

        }

        Node(E e) {
            obj = e;
        }

        Node(E e, Node<E> next) {
            this(e);
            this.next = next;
        }

        Node(E e, Node<E> next, Node<E> prev) {
            this(e, next);
            this.prev = prev;
        }
    }
}