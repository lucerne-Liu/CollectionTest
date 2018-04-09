package com.thoughtworks.collection;


public class Node<T> implements SingleLink<T> {
    private T data;
    private Node next;
    private Node head;
    public static int size = 0;

    public Node() {
        head = null;
        next = null;
    }

    public Node(T data) {
        this.data = data;
    }

    @Override
    public T getHeaderData() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException("Link is empty!");
        }
        return (T) head.data;
    }

    @Override
    public T getTailData() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException("Link is empty!");
        }
        return (T) findNodeByIndex(size - 1).data;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size <= 0;
    }

    @Override
    public boolean deleteFirst() {
        if (isEmpty()) {
            return false;
        } else {
            head = head.next;
            size--;
            return true;
        }
    }

    @Override
    public boolean deleteLast() {
        if (isEmpty()) {
            return false;
        } else {
            Node tailPrev = findNodeByIndex(size - 2);
            tailPrev.next = null;
            size--;
            return true;
        }
    }

    @Override
    public void addHeadPointer(T item) {
        Node newNode = new Node(item);
        if (head != null) {
            newNode.next = head;
        }
        head = newNode;
        size++;
    }

    @Override
    public void addTailPointer(T item) {
        if (head == null) {
            head = new Node(item);
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = new Node(item);
        }
        size++;
    }

    public Node findNodeByIndex(int index)
    {
        if (index < 0 || index > size - 1) {
            throw new IndexOutOfBoundsException("Index invalid!");
        }
        Node temp = head;
        int i = 0;
        while (temp.next != null) {
            if (i == index) {
                return temp;
            }
            temp = temp.next;
            i++;
        }
        return null;
    }

    @Override
    public T getNode(int index) {
        return (T) findNodeByIndex(index - 1).data;
    }
}
