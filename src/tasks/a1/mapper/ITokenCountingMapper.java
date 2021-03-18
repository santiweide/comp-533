package tasks.a1.mapper;

import tasks.a1.KeyValue;

/**
 * @author algorithm
 */
public interface ITokenCountingMapper {
    /**
     * The key and value of the return value of the map method in the mapper interface should be generic
     * @param str key
     * @return key-value
     */
    KeyValue map(String str);
}
