package Singletons;

import java.util.ArrayList;
import java.util.Arrays;


public class DupliHolder {
	private static DupliHolder instance;
	private ArrayList<String> dupliTags;
	
    private DupliHolder() {
    	dupliTags = new ArrayList<>(Arrays.asList());
       
    } // Private constructor

    public static synchronized DupliHolder getInstance() {
        if (instance == null) {
            instance = new DupliHolder();
        }
        return instance;
    }

    public ArrayList<String> getdupliTags() {
    	return dupliTags;
    }
    
    public void addDupliTags(String e) {
    	dupliTags.add(e);
    }
    
    public void clearDupliTags() {
    	dupliTags.clear();
    }
    
   
    
    

}
