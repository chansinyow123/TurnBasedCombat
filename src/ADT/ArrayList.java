/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ADT;

import java.util.Arrays;

/**
 *
 * @author chans
 */
public class ArrayList<T> implements ListInterface<T> {

    private T[] data;                          //data
    private final int startSize = 2;           //starting size
    private int maxSize = startSize;           //max size
    private int size = 0;                      //current size

    // Constructor to initialize queue
    public ArrayList() {
        this.data = (T[]) new Object[startSize];
    }

    public void add(T value) {
        // Enlarge array size
        if (size >= maxSize) {
            maxSize *= 2;
            data = Arrays.copyOf(data, maxSize);
            //System.out.println("Max Size: " + maxSize);
        }

        data[size] = value;
        size++;
    }

    //add value in the middle
    public void add(int index, T value) {

        //only allow add value in the middle
        if (index > size) {
            System.out.println("Array Index Out Of Bound, Program Terminated\n");
            System.exit(1);
        }

        // Enlarge array size
        if (size >= maxSize) {
            maxSize *= 2;
            data = Arrays.copyOf(data, maxSize);
            //System.out.println("Max Size: " + maxSize);
        }
        //index: 1, size: 3, maxSize: 4
        //2 > 3
        //1 > 2
        //1 insert
        int i;

        for (i = size; i > index; i--) {
            data[i] = data[i - 1];
        }

        data[i] = value;
        size++;
    }

    public T get(int index) {

        if (index >= size) {
            return null;
        } else {
            return data[index];
        }
    }

    public void set(int index, T value) {
        if (index >= size) {
            System.out.println("Array Index Out Of Bound, Program Terminated\n");
            System.exit(1);
        }

        data[index] = value;
    }

    public void remove(int index) {
        if (index >= size) {
            System.out.println("Array Index Out Of Bound, Program Terminated\n");
            System.exit(1);
        }

        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }

        size--;
        //System.out.println("Remove Size: " + size);

        //Shrink array Size
        if (size < maxSize / 2 && maxSize != startSize) {
            maxSize /= 2;
            data = Arrays.copyOf(data, maxSize);
            //System.out.println("Max Size: " + maxSize);
        }
    }

    public void clear() {
        size = 0;
        maxSize = startSize;
        data = Arrays.copyOf(data, maxSize);
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return (size == 0);
    }

}
