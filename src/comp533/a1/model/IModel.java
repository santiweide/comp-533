package comp533.a1.model;

import java.beans.PropertyChangeListener;

public interface IModel {
    void setInputString(String str);
    void addPropertyChangeListener(PropertyChangeListener listener);
}
