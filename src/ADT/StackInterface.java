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
    
    //[1, 2, 3]
    public void push(T value);
    
    //[1, 2]
    public T pop();
    
    //[2]
    public T peek();
    
    public int size();
    
    public boolean isEmpty();
}
