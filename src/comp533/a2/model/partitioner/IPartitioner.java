package comp533.a2.model.partitioner;

public interface IPartitioner<K,V> {
    int getPartition(K key, V value, int p);
}
