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



public class HashSet<T> implements SetInterface<T> {

    private Node<T>[] hashTable;
    private int numberOfEntries;
    private static final int DEFAULT_SIZE = 101;
    private static final double MAX_LOAD_FACTOR = 0.9;

    public HashSet() {
        this(DEFAULT_SIZE);
    }

    public HashSet(int tableSize) {
        int primeSize = getNextPrime(tableSize);

        //System.out.println(primeSize);
        hashTable = new Node[primeSize];
        numberOfEntries = 0;
    }

    public String toString() {
        String outputStr = "";
        for (int index = 0; index < hashTable.length; index++) {
            if (hashTable[index] == null) {
                outputStr += "null\n";
            } else {
                Node<T> currentNode = hashTable[index];
                while (currentNode != null) {
                    outputStr += currentNode.value + ", ";
                    currentNode = currentNode.next;
                } // end while

                outputStr += "\n";
            } // end if
        } // end for

        outputStr += "\n";
        return outputStr;
    }

    public boolean add(T value) {
        // assumes key and value are not null

        if (isHashTableTooFull()) {
            rehash();
        } // end if

        int index = getHashIndex(value);

        // index always in range due to mod of hash fn
        if (hashTable[index] == null) {
            // key not found, so insert new entry

            hashTable[index] = new Node<T>(value);
            numberOfEntries++;
        } else { // search chain beginning at hashTable[index] for a node that contains key

            Node<T> currentNode = hashTable[index];
            Node<T> nodeBefore = null;

            while ((currentNode != null) && !value.equals(currentNode.value)) {
                nodeBefore = currentNode;
                currentNode = currentNode.next;
            } // end while

            if (currentNode == null) {
                // key not in chain; add new entry to end of chain
                Node<T> newNode = new Node<T>(value);
                nodeBefore.next = newNode;
                numberOfEntries++;
            } else {
                // key found; 
                return false;
            } // end if
        } // end if

        return true;
    } // end add

    public boolean remove(T value) {

        int index = getHashIndex(value);

        // search chain beginning at hashTable[index] for a node that contains key
        Node<T> nodeBefore = null;
        Node<T> currentNode = hashTable[index];

        while ((currentNode != null) && !value.equals(currentNode.value)) {
            nodeBefore = currentNode;
            currentNode = currentNode.next;
        } // end while

        if (currentNode != null) {
            // key found;

            if (nodeBefore == null) {
                // remove first node
                hashTable[index] = currentNode.next;
            } else {
                nodeBefore.next = currentNode.next;
            }

            numberOfEntries--;
            return true;
        } // end if

        //else return false because cannot find value
        return false;
    } // end remove

    public boolean contains(T value) {

        int index = getHashIndex(value);

        // search chain beginning at hashTable[index] for a node that contains key
        Node<T> currentNode = hashTable[index];

        while ((currentNode != null) && !value.equals(currentNode.value)) {
            currentNode = currentNode.next;
        } // end while

        if (currentNode != null) {
            // key found; return true
            return true;
        } // end if

        // else not found; result false
        return false;
    } // end contains

    public void clear() {
        for (int index = 0; index < hashTable.length; index++) {
            hashTable[index] = null;
        }

        numberOfEntries = 0;
    } // end clear

    public int getNextPrime(int integer) {
        while (!isPrime(integer)) {
            integer = integer + 1;
        } // end while

        return integer;
    } // end getNextPrime

    public boolean isPrime(int integer) {
        boolean result;
        boolean done = false;

        if (integer == 2) {
            result = true;
        } else if (integer == 1 || (integer % 2 == 0)) {
            result = false;
        } else {
            result = true; // assume prime
            for (int divisor = 3; !done && (divisor * divisor <= integer); divisor = divisor + 2) {
                if (integer % divisor == 0) {
                    result = false;
                    done = true;
                }
            }
        }
        return result;
    }

    public void rehash() {
        Node<T>[] oldTable = hashTable;
        int oldSize = oldTable.length;
        int newSize = getNextPrime(oldSize + oldSize);

        hashTable = new Node[newSize];    // increase size of array

        numberOfEntries = 0; // reset number of dictionary entries, since
        // it will be incremented by add during rehash

        // rehash dictionary entries from old array to new, bigger array.
        for (int index = 0; index < oldSize; ++index) {
            // rehash chain in old table
            Node<T> currentNode = oldTable[index];

            while (currentNode != null) { // skip empty lists

                add(currentNode.value);
                // easy, but deallocates entry and reallocates it **********************
                currentNode = currentNode.next;
            } // end while
        } // end for
    } // end rehash

    public boolean isHashTableTooFull() {
        return numberOfEntries > MAX_LOAD_FACTOR * hashTable.length;
    } // end isHashTableTooFull

    public boolean isEmpty() {
        return numberOfEntries == 0;
    } // end isEmpty

    public int size() {
        return numberOfEntries;
    } // end getSize

    public int getHashIndex(T value) {

        int hashIndex = value.hashCode() % hashTable.length;

        if (hashIndex < 0) {
            hashIndex = hashIndex + hashTable.length;
        } // end if

        return hashIndex;
    } // end getHashIndex

    private class Node<T> {

        private T value;
        private Node<T> next;

        private Node(T dataValue) {
            value = dataValue;
            next = null;
        } // end constructor

        private Node(T dataValue, Node<T> nextNode) {
            value = dataValue;
            next = nextNode;
        } // end constructor

    }

}
