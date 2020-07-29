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
public class Stack<T> implements StackInterface<T> {

    private T arr[];
    private int top;
    private final int startSize = 2;
    private int maxSize;

    // Constructor to initialize stack
    public Stack() {
        this.maxSize = 2;
        this.arr = (T[]) new Object[startSize];
        this.top = -1;
    }

    // Utility function to add an element x in the stack
    public void push(T value) {
        
        if (size() >= maxSize) {
            maxSize *= 2;
            arr = Arrays.copyOf(arr, maxSize);
            //System.out.println("Max Size: " + maxSize);
        }
        
        arr[++top] = value;
    }

    // Utility function to pop top element from the stack
    public T pop() {
        // check for stack underflow
        if (isEmpty()) {
            System.out.println("Unable to POP, Program Terminated\n");
            System.exit(1);
        }
        
        //Shrink array Size
        if (size() < maxSize / 2 && maxSize != startSize) {
            maxSize /= 2;
            arr = Arrays.copyOf(arr, maxSize);
            //System.out.println("Max Size: " + maxSize);
        }

        // decrease stack size by 1 and (optionally) return the popped element
        return arr[top--];
    }

    // Utility function to return top element in a stack
    public T peek() {
        if (!isEmpty()) {
            return arr[top];
        }

        return null;
    }

    // Utility function to return the size of the stack
    public int size() {
        return top + 1;
    }

    // Utility function to check if the stack is empty or not
    public boolean isEmpty() {
        return top == -1;	// or return size() == 0;
    }
    
}