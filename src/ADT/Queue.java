/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ADT;

/**
 *
 * @author OngYiPin
 */
public class Queue<T> implements QueueInterface<T> {

    private T arr[];                    // array to store queue elements
    private int front;  		// front points to front element in the queue
    private int rear;   		// rear points to last element in the queue
    private int maxSize;                // maximum size of the queue
    private int count;  		// current size of the queue
    
    public Queue() {
        this(50);
    }

    // Constructor to initialize queue
    public Queue(int size) {
        this.arr = (T[]) new Object[size];
        this.maxSize = size;
        this.front = 0;
        this.rear = -1;
        this.count = 0;
    }

    // Utility function to remove front element from the queue
    public void dequeue() {
        // check for queue underflow
        if (isEmpty()) {
            System.out.println("Unable to DEQUEUE, Program Terminated\n");
            System.exit(1);
        }

        //System.out.println("Removing " + arr[front]);

        front = (front + 1) % maxSize;
        count--;
        //System.out.println("Front: " + front);
    }

    // Utility function to add an item to the queue
    public void enqueue(T item) {
        
        if (isFull()) {
            System.out.println("Unable to ENQUEUE, Program Terminated\n");
            System.exit(1);
        }

        //System.out.println("Inserting " + item);

        rear = (rear + 1) % maxSize;
        arr[rear] = item;
        count++;
        //System.out.println("Rear: " + rear + ", Max Size: " + maxSize);
    }

    // Utility function to return front element in the queue
    public T peek() {
        if (isEmpty()) {
            return null;
        }
        return arr[front];
    }

    // Utility function to check if the queue is empty or not
    public boolean isEmpty() {
        return (count == 0);
    }

    // Utility function to check if the queue is full or not
    public boolean isFull() {
        return (count == maxSize);
    }
    
    public int size() {
        return count;
    }
    
    public String toString() {
        
        String outputStr = "";
        
        outputStr += "Queue: ";
        for(int i = 0; i < count; i++) {
            outputStr += arr[(front+i) % maxSize] + ", ";
        }
        
        return outputStr;
    }
}