package tasks.a1;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.HashMap;
import java.util.Map;


public class Model {
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
        for(String input:inputs){
            newOutput.put(input, output.get(input)==null?1:output.get(input)+1);
        }
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
