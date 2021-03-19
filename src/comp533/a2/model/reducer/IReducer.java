package comp533.a2.model.reducer;

import comp533.a2.model.KeyValue;

import java.util.List;
import java.util.Map;

public interface IReducer {
    Map reduce(List<KeyValue> list);
}
