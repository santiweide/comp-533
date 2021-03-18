package tasks.a1;

import gradingTools.comp533s19.assignment0.AMapReduceTracer;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;


/**
 * @author algorithm
 */
public class View extends AMapReduceTracer implements PropertyChangeListener {

    public View(Model model) {
        model.addPropertyChangeListener(this);
    }

    @Override
    public String toString(){
        return "VIEW";
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        this.tracePropertyChange(evt);
    }
}
