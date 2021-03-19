package comp533.a2.model.partitioner;

public class Partitioner implements IPartitioner<String, Object>{
    @Override
    public int getPartition(String key, Object value, int p) {
        if (key.isEmpty() || !Character.isLetter(key.charAt(0))){
            return 0;
        } else {
            double s = Math.ceil(('z'-'a'+1)/(double) p);
            int f = Character.toLowerCase(key.charAt(0)) - 'a' + 1;
            return (int) Math.floor((double)f/s);
        }
    }
    
}
