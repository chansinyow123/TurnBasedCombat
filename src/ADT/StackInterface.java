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
public interface StackInterface<T> {
    
    public void push(T value);
    
    public T pop();
    
    public T peek();
    
    public int size();
    
    public boolean isEmpty();
}
