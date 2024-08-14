package Singletons;

import java.util.ArrayList;
import java.util.Arrays;


public class TagLevelHolder {
	private static TagLevelHolder instance;
	private ArrayList<String> L1tags = new ArrayList<>(Arrays.asList("sport","music","movie"));
	private ArrayList<String> L2tags = new ArrayList<>(Arrays.asList("active","pop","drama"));

    private TagLevelHolder() {
    	
       
    } // Private constructor

    public static synchronized TagLevelHolder getInstance() {
        if (instance == null) {
            instance = new TagLevelHolder();
        }
        return instance;
    }

    public ArrayList<String> getL1tags() {
    	return L1tags;
    }
    
    public ArrayList<String> getL2tags() {
    	return L2tags;
    }
    
    

}
