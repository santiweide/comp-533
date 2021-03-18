package tasks.a1;

import gradingTools.comp533s19.assignment0.AMapReduceTracer;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Model extends AMapReduceTracer {
    private String inputString;
    private Map<String, Integer> output;
    private PropertyChangeSupport support;

    public Model() {
        output = new HashMap<>();
        support = new PropertyChangeSupport(this);
    }

    public void setInputString(String inputString) {
        support.firePropertyChange("InputString",this.inputString, inputString);
        this.inputString = inputString;
        String[] inputs = this.inputString.split( " ");
        Map<String, Integer> newOutput = new HashMap<>(inputs.length);
        List<KeyValue> list = new ArrayList<>();
        for(String input:inputs){

            KeyValue<String, Integer> kv = new KeyValue<>(input, 1);
            this.traceMap(input, kv);
            list.add(kv);
            newOutput.put(input, output.get(input)==null?1:output.get(input)+1);
        }
        this.traceReduce(list, newOutput);
        support.firePropertyChange("Result", output, newOutput);
        output = newOutput;
    }

    public Map<String, Integer> getOutput() {
        return output;
    }


    @Override
    public String toString(){
        return "MODEL";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        this.support.addPropertyChangeListener(listener);
    }

}
