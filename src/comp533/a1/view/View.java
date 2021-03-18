package comp533.a1.view;

import comp533.a1.model.TokenCountingModel;
import gradingTools.comp533s19.assignment0.AMapReduceTracer;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;


/**
 * @author algorithm
 */
public class View extends AMapReduceTracer implements PropertyChangeListener {

    public View(TokenCountingModel TokenCountingModel) {
        TokenCountingModel.addPropertyChangeListener(this);
    }

    @Override
    public String toString(){
        return "View";
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        this.tracePropertyChange(evt);
    }
}
