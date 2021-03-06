package comp533.a1.model;

public class KeyValue <KeyType, ValueType>{
    private KeyType key;
    private  ValueType value;

    public KeyValue(KeyType key, ValueType value) {
        this.key = key;
        this.value = value;
    }

    public KeyType getKey() {
        return key;
    }

    public ValueType getValue() {
        return value;
    }

    public void setValue(ValueType value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "(" + key + "," + value + ")";
    }

    public Class getKeyValueClass(){
        return KeyValue.class;
    }
}
