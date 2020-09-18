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
public interface QueueInterface<T> {
    
    public void dequeue();
    
    public void enqueue(T item);
    
    public T peek();
    
    public boolean isEmpty();
    
    public boolean isFull();
    
    public int size();
}
