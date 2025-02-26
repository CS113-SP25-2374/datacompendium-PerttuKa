package CS113;

import java.util.Iterator;

public class LinkedListPK<E> implements ListInterface<E>, IteratableInterface<E>{

    private class Node<E> {
        E element;
        Node<E> prev;
        Node<E> next;
        private Node(E element) {
            this.element = element;
        }
    }

    private class Iterator implements IteratorInterface<E> {
        Node<E> current;
        LinkedListPK<E> list;

        private Iterator(LinkedListPK<E> parentList){
            list = parentList;
            current = list.head;
        }
        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public E next() {
            LinkedListPK<E>.Node<E> temp = current;
            current = current.next;
            return temp.element;
        }

        @Override
        public void remove() {
            if(list.head == null) throw new IllegalStateException();

            if (current != null){
                list.unlink(current.prev);
            } else {
                list.unlink(list.tail);
            }


        }
    }

    Node<E> head;
    Node<E> tail;

    int size;

    private Node<E> getIndex(int index) {
        if (index >= size || index < 0) throw new IndexOutOfBoundsException();

        Node<E> current = head;
        for (int i = 0; i < index; i++){
            current = current.next;
        }
        return current;
    }

//    private Node<E> getElement(int element){
//
//    }

    @Override
    public boolean add(E element) {
        Node<E> node = new Node<>(element);
        size++;

        if(head == null){
            head = tail= node;
            return true;
        }

        tail.next = node;
        node.prev = tail;
        tail = node;

        return true;
    }

    private void unlink(Node<E> node){
        Node<E> current = node;
        Node<E> prev = current.prev;
        Node<E> next = current.next;

        size--;

        if(current == head) {
            head = current.next;
        }
        if (current == tail){
            head = current.prev;
        }
        if (prev != null){
            prev.next = next;
        }
        if (next != null){
            next.prev = prev;
        }
    }

    @Override
    public void add(int index, E element) {
        Node<E> node = new Node<>(element);
        Node<E> current = getIndex(index);
        size++;

        node.next = current.next;
        current.next = node;
        node.prev = current;
        if(node.next != null){
            node.next.prev =  node;
        }


    }

    @Override
    public void clear() {

    }

    @Override
    public boolean contains(E element) {
        return false;
    }

    @Override
    public int indexOf(Object object) {
        return 0;
    }

    @Override
    public E get(int index) {
        return null;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean remove(int index) {
        unlink(getIndex(index));
        return true;
    }

    @Override
    public boolean remove(E element) {
        Node<E> node = new Node<>(element);
        size--;



        return true;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public void set(int index, E element) {

    }

    @Override
    public IteratorInterface<E> interator() {
        return new Iterator(this);
    }
}
