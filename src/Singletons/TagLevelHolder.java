package Singletons;

import java.util.ArrayList;
import java.util.Arrays;


public class TagLevelHolder {
	private static TagLevelHolder instance;
	private ArrayList<String> L1tags = new ArrayList<>(Arrays.asList("sport","art","movie","science","politics"));
	private ArrayList<String> L2tags = new ArrayList<>(Arrays.asList("football","maleSport","femaleSport","physics","chemistry","technology","digitalArt","inkArt","waterColor","horror","humour"));
	private ArrayList<String> authenTags = new ArrayList<>(Arrays.asList("boy","girl", "young", "old" , "student"));

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
    
    public ArrayList<String> getAuthenTags() {
    	return authenTags;
    }
    
    

}
