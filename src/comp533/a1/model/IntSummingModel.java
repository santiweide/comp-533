package comp533.a1.model;

import comp533.a1.model.mapper.IMapper;
import comp533.a1.model.mapper.IntSummingMapper;
import comp533.a1.model.mapper.MapperFactory;
import comp533.a1.model.reducer.IReducer;
import comp533.a1.model.reducer.ReducerFactory;
import gradingTools.comp533s19.assignment0.AMapReduceTracer;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IntSummingModel extends AMapReduceTracer implements IModel {
    private String inputString;
    private Map<String, Integer> output;
    private PropertyChangeSupport support;

    public IntSummingModel() {
        output = new HashMap<>();
        support = new PropertyChangeSupport(this);
    }

    @Override
    public void setInputString(String inputString) {
        support.firePropertyChange("InputString",this.inputString, inputString);
        this.inputString = inputString;
        String[] inputs = this.inputString.split( " ");
        MapperFactory.setMapper(new IntSummingMapper());
        IMapper mapper = MapperFactory.getMapper();
        IReducer reducer = ReducerFactory.getReducer();
        List<KeyValue> list = new ArrayList();
        for(String input:inputs){
            KeyValue kv = mapper.map(input);
            this.traceMap(input, kv);
            list.add(kv);
        }
        Map newOutput = reducer.reduce(list);
        this.traceReduce(list, newOutput);
        support.firePropertyChange("Result", output, newOutput);
        output = newOutput;
    }

    public Map<String, Integer> getOutput() {
        return output;
    }


    @Override
    public String toString(){
        return "Model";
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        this.support.addPropertyChangeListener(listener);
    }
}
