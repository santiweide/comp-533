package comp533.a2.model.mapper;

import comp533.a2.model.KeyValue;

/**
 * @author algorithm
 */
public interface IMapper {
    /**
     * The key and value of the return value of the map method in the mapper interface should be generic
     * @param str key
     * @return key-value
     */
    KeyValue map(String str);
}
