package comp533.a1.model.mapper;

import comp533.a1.model.KeyValue;

public class IntSummingMapper implements IMapper{
    @Override
    public KeyValue<String, Integer> map(String str) {
        int p;
        try{
            p = Integer.parseInt(str);
        } catch (Exception e){
            return new KeyValue<>(str, 1);
        }
        return new KeyValue<>("ResultKey", p);
    }
}
