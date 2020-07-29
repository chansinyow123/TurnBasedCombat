/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ADT;

/**
 *
 * @author chans
 */
public class LinkedList<T> implements ListInterface<T> {

    private Node head = null;
    private int size = 0;

    public class Node {

        T data;
        Node next = null;
    }

    public void add(T value) {
        Node node = new Node();
        node.data = value;

        if (head == null) {
            head = node;
        } else {
            Node n = head;
            while (n.next != null) {
                n = n.next;
            }
            n.next = node;
        }
        
        size++;
    }

    public void add(int index, T value) {

        Node node = new Node();
        node.data = value;

        if (index == 0) {
            node.next = head;
            head = node;
        } else {
            Node n = head;

            for (int i = 0; i < index - 1; i++) {
                n = n.next;
            }

            node.next = n.next;
            n.next = node;
        }
        
        size++;
    }

    public void remove(int index) {
        if (index == 0) {
            head = head.next;
        } else {
            Node n = head;
            for (int i = 0; i < index - 1; i++) {
                n = n.next;
            }
            n.next = n.next.next;
        }
        
        size--;
    }

    public T get(int index) {
        Node n = head;
        
        for (int i = 0; i < index; i++) {
            n = n.next;
        }
        
        return n.data;
    }
    
    public void set(int index, T value) {
        if (index == 0) {
            head.data = value;
        } else {
            Node n = head;

            for (int i = 0; i < index; i++) {
                n = n.next;
            }
            
            n.data = value;
        }
    }
    
    public void clear() {
        head = null;
    }
    
    public int size() {
        return size;
    }
    
    public boolean isEmpty() {
        return (head == null);
    }

    public String toString() {
        
        String outputStr = "";
        Node n = head;

        while (n.next != null) {
            outputStr += n.data + " ";
            n = n.next;
        }
        outputStr += n.data;
        return outputStr;
    }
}
