package components;

import java.util.HashMap;
import java.util.Map;

public class GlobalHolder {
	 private static GlobalHolder instance;
	    private Map<String, Float> sharedValues;

	    private GlobalHolder() {
	        sharedValues = new HashMap<>();
	    } // Private constructor

	    public static GlobalHolder getInstance() {
	        if (instance == null) {
	            instance = new GlobalHolder();
	        }
	        return instance;
	    }

	    public Float getSharedValue(String key) {
	        return sharedValues.get(key);
	    }

	    public void setSharedValue(String key, Float value) {
	        sharedValues.put(key, value);
	    }

	    public void removeSharedValue(String key) {
	        sharedValues.remove(key);
	    }

	    public boolean containsKey(String key) {
	        return sharedValues.containsKey(key);
	    }

	    public Map<String, Float> getAllSharedValues() {
	        return new HashMap<>(sharedValues);
	    }
}
