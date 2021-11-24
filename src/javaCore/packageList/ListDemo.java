package javaCore.packageList;

public class ListDemo<T> {
    private T[] objects;
    private int size;

    public ListDemo(int initialSize) {
        this.objects = (T[]) new Object[initialSize];
    }

    public void add(T element) {
        objects[size++] = element;
    }

    public T get(int index) {
        return objects[index];
    }

    public int getSize() {
        return size;
    }
}
