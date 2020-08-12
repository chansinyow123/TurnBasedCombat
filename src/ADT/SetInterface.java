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



//this is hash ser interface
public interface SetInterface<T> {
    
    public boolean add(T value);
    
    public boolean remove(T value);
    
    public boolean contains(T value);
    
    public void clear();
    
    public int getNextPrime(int integer);
    
    public boolean isPrime(int integer);
    
    public void rehash();
    
    public boolean isHashTableTooFull();
    
    public boolean isEmpty();
    
    public int size();
    
    public int getHashIndex(T value);
}
