package Singletons;


import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class Tester {
    private static Tester instance = new Tester();
    private PropertyChangeSupport support;
    private String value;

    private Tester() {
        support = new PropertyChangeSupport(this); // Initialize PropertyChangeSupport
        value = "Initial Value";
    }

    public static Tester getInstance() {
        return instance;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String newValue) {
        String oldValue = this.value;
        this.value = newValue;
        support.firePropertyChange("value", oldValue, newValue);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        support.removePropertyChangeListener(listener);
    }
}
