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
public interface ListInterface<T> {
    
    public void add(T value);
    
    public void add(int index, T value);
    
    public T get(int index);
    
    public void set(int index, T value);
    
    public void remove(int index);
    
    public void clear();
    
    public int size();
    
    public boolean isEmpty();
}
