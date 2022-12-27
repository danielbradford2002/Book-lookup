// --== CS400 Project One File Header ==--
// Name: Daniel Bradford
// CSL Username: bradford
// Email: dcbradford@wisc.edu
// Lecture #: 001 @11:00am
// Notes to Grader:

import java.util.LinkedList;
import java.util.NoSuchElementException;

public class HashtableMap<KeyType, ValueType> implements MapADT<KeyType, ValueType> {
    protected LinkedList<LinkedNode<KeyType, ValueType>>[] map;
    public int size;
    public int capacity;

    /**
     * creates a new hashtable map
     *
     * @param capacity determines the capacity of the Hashtable Map
     */
    public HashtableMap(int capacity) {
        map = (LinkedList<LinkedNode<KeyType, ValueType>>[]) new LinkedList[capacity];
        size = 0;
        this.capacity = capacity;
    }

    /**
     * creates a new hashtable map with a default capacity of 15
     */
    public HashtableMap() {
        map = (LinkedList<LinkedNode<KeyType, ValueType>>[]) new LinkedList[15];
        size = 0;
        this.capacity = 15; //default capacity
    }

    /**
     * Inserts a new (key, value) pair into the map if the map does not contain a value mapped to
     * key yet.
     *
     * @param key   the key of the (key, value) pair to store
     * @param value the value that the key will map to
     * @return true if the (key, value) pair was inserted into the map, false if a mapping for key
     * already exists and the new (key, value) pair could not be inserted
     */
    @Override
    public boolean put(KeyType key, ValueType value) {
        //if key or value null return false and make sure key isn't already in map
        if (key == null || value == null) {
            return false;
        }
        int hash = Math.abs(key.hashCode() % capacity);
        if(map[hash] == null){
            map[hash] = new LinkedList<LinkedNode<KeyType, ValueType>>();
            map[hash].add(new LinkedNode<>(key, value));
            this.size++;
            resize();
            return true;
        }

        return false;
    }

    public void resize(){
        double loadFactor = (double) size/ (double) capacity;
        if(loadFactor >= 0.7){
            int newCapacity = capacity *2;
            capacity = newCapacity;
            LinkedList<LinkedNode<KeyType, ValueType>>[] newMap =
                    (LinkedList<LinkedNode<KeyType, ValueType>>[]) new LinkedList[capacity];
            for(int i = 0; i < capacity; i++){
                newMap[i] = map[i];
                if(map[i] == null){
                    continue;
                }
                for(int j = 0; j<map[i].size(); j++){
                    newMap[i].set(j, map[i].get(j));
                }
                map = newMap;
            }
        }
        return;
    }

    /**
     * Checks if a key is stored in the map.
     *
     * @param key the key to check for
     * @return true if the key is stored (mapped to a value) by the map
     *         and false otherwise
     */
    @Override
    public boolean containsKey(KeyType key) {
        try {
            get(key);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    /**
     * Returns the value mapped to a key if the map contains such a mapping.
     *
     * @param key the key for which to look up the value
     * @return the value mapped to the key
     * @throws NoSuchElementException if the map does not contain a mapping
     *                                for the key
     */
    @Override
    public ValueType get(KeyType key) throws NoSuchElementException {

        boolean exists =false;
        ValueType match = null;
        if (key == null){
            throw new NullPointerException();
        }

        for(int i = 0; i < capacity; i++){
            if(map[i] == null){
                continue;
            }

            for(int j=0; j<map[i].size();j++){
                if(key.equals(map[i].get(j).key)){
                    match = map[i].get(j).value;
                    exists = true;
                }
            }
        }
        if (exists==false){
            throw new NoSuchElementException();
        }
        return match;
    }

    /**
     * Removes a key and its value from the map.
     *
     * @param key the key for the (key, value) pair to remove
     * @return the value for the (key, value) pair that was removed,
     *         or null if the map did not contain a mapping for key
     */
    @Override
    public ValueType remove(KeyType key){
        if(!containsKey(key)){
            return null; //the map didnt contain a mapping for the key
        }
        ValueType removedValue = null;
        for(int i = 0; i < capacity; i++){
            if(map[i] ==null){
                continue;
            }
            for(int j=0; j<map[i].size();j++){
                if(key.equals(map[i].get(j).key)){
                    removedValue = map[i].get(j).value;
                    map[i].get(j).value = null;
                    map[i].get(j).key = null;
                }
            }
        }
        return removedValue;
    }

    /**
     * Returns the number of (key, value) pairs stored in the map.
     *
     * @return the number of (key, value) pairs stored in the map
     */
    @Override
    public int size(){
        return size;
    }

    /**
     * Removes all (key, value) pairs from the map.
     */
    @Override
    public void clear(){
        map = (LinkedList<LinkedNode<KeyType, ValueType>>[]) new LinkedList[capacity];
        size = 0;
    }

    public static void main (String args[]){
        HashtableMapTests.test1();
        HashtableMapTests.test2();
        HashtableMapTests.test3();
        HashtableMapTests.test4();
        HashtableMapTests.test5();
    }
}