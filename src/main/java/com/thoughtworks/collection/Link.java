package com.thoughtworks.collection;

import java.util.ArrayList;
import java.util.List;

public class Link<T> implements SingleLink<T> {
    List<T> arrayList;

    public Link(List<T> arrayList) {
        this.arrayList =  new ArrayList<>(arrayList);
    }
    public Link() {
        this.arrayList =  new ArrayList<>();
    }
    @Override
    public T getHeaderData() {
        return arrayList.get(0);
    }

    @Override
    public T getTailData() {
        return arrayList.get(arrayList.size() - 1);
    }

    @Override
    public int size() {
        return arrayList.size();
    }

    @Override
    public boolean isEmpty() {
        return arrayList.size() > 0 ? false : true;
    }

    @Override
    public boolean deleteFirst() {
        if (!this.isEmpty()) {
            arrayList.remove(0);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean deleteLast() {
        if (!this.isEmpty()) {
            arrayList.remove(arrayList.size() - 1);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void addHeadPointer(T item) {
        arrayList.add(0,item);
    }

    @Override
    public void addTailPointer(T item) {
        arrayList.add(item);
    }

    @Override
    public T getNode(int index) {
        return arrayList.get(index - 1);
    }
}
