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
public interface MapInterface<K, V> {
    
    public V put(K key, V value);
    
    public V remove(K key);
    
    public V get(K key);
    
    public boolean contains(K key);
    
    public void clear();
    
    public void rehash();
    
    public boolean isHashTableTooFull();
    
    public boolean isEmpty();
    
    public int size();
    
    public int getHashIndex(K key);
    
    public int getNextPrime(int integer);
    
    public boolean isPrime(int integer);
    
}
