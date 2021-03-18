package tasks.a1.mapper;

import tasks.a1.KeyValue;

/**
 * @author algorithm
 */
public class TokenCountingMapper implements ITokenCountingMapper {
    /**
     * the mapper class itself should implement a version of the interface in which the key type parameter is bound to String and the value type parameter is bound to Integer.
     * @param str key
     * @return one key-value <String, Integer>
     */
    @Override
    public KeyValue<String, Integer> map(String str) {
        return new KeyValue<>(str, 1);
    }
}
