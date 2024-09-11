package Singletons;

import java.util.HashMap;
import java.util.Map;

public class TagPriorityHolder {
	 private static TagPriorityHolder instance;
	    private Map<String, Float> tagPriority;
	    private int value;

	    private TagPriorityHolder() {
	        tagPriority = new HashMap<>();
	       
	    } // Private constructor

	    public static synchronized TagPriorityHolder getInstance() {
	        if (instance == null) {
	            instance = new TagPriorityHolder();
	        }
	        return instance;
	    }

	    public Float getTagPriority(String key) {
	        return tagPriority.get(key);
	    }
	    
	    public int getValue() {
	        return value;
	    }
	    
	    public void setValue(int key) {
	    	value = key;
	    }

	    public void setTagPriority(String key, Float value) {
	        tagPriority.put(key, value);
	    }

	    public void removeTagPriority(String key) {
	        tagPriority.remove(key);
	    }

	    public boolean containsKey(String key) {
	        return tagPriority.containsKey(key);
	    }

	    public Map<String, Float> getAllTagPriority() {
	        return new HashMap<>(tagPriority);
	    }
}
