package comp533.a2.model;

import java.beans.PropertyChangeListener;

public interface IModel {
    void setInputString(String str);
    void addPropertyChangeListener(PropertyChangeListener listener);
    void setNumThreads(int numThreads);
}
