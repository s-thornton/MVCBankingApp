package model;
import java.util.ArrayList;
//Generalized Model for getting models, updating changes and setting listeners
public abstract class AbstractModel implements Model {
    private ArrayList listeners = new ArrayList(5);

    public void notifyChanged(ModelEvent event){
        ArrayList list = (ArrayList)listeners.clone();
        for (Object aList : list) {
            ModelListener ml = (ModelListener) aList;
            ml.modelChanged(event);
        }
    }
    public void addModelListener(ModelListener l){ listeners.add(l); }
    public void removeModelListener(ModelListener l){ listeners.remove(l); }
}