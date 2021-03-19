package comp533.a2.model.partitioner;

public class PartitionerFactory {
    private static IPartitioner partitioner = new Partitioner();

    public static IPartitioner getPartitioner(){
        return partitioner;
    }
    public static void setPartitioner(IPartitioner partitioner){
        PartitionerFactory.partitioner = partitioner;
    }

}
