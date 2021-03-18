package comp533.a1.model.reducer;

import comp533.a1.model.KeyValue;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author algorithm
 */
public class TokenCountingReducer implements ITokenCountingReducer{

    @Override
    public Map<String, Integer> reduce(List<KeyValue> list){
        Map<String, Integer> ret = new HashMap<>();
        for(KeyValue<String, Integer> kv : list){
            ret.put(kv.getKey(), ret.get(kv.getKey())==null?kv.getValue():ret.get(kv.getKey())+kv.getValue());
        }
        return ret;
    }


}
