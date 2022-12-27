

/**
 * a node that is part of a linked list that stores a KeyType and ValueType
 * @param <KeyType>
 * @param <ValueType>
 */
public class LinkedNode<KeyType, ValueType> {
    KeyType key;
    ValueType value;
    LinkedNode<KeyType, ValueType> next;

    /**
     * constructs a new linked node
     * @param key the key to the node
     * @param value the value that is mapped
     */
    public LinkedNode(KeyType key, ValueType value) {
        this.key = key;
        this.value = value;
    }

    public KeyType getKey(KeyType key){
        return key;
    }

    public ValueType getValue(ValueType value){
        return value;
    }
}
