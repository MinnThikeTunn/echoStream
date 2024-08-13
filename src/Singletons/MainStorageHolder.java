package Singletons;

import java.util.ArrayList;

import components.Graph;
import components.Post;
import components.Tag;
import utilities.CreateMedia;

public class MainStorageHolder {
	 private static MainStorageHolder instance;
	    private Graph<Tag,Post> g;

	    private MainStorageHolder() {
	    	 g = new Graph<Tag,Post>();
	       
	    } // Private constructor

	    public static synchronized MainStorageHolder getInstance() {
	        if (instance == null) {
	            instance = new MainStorageHolder();
	        }
	        return instance;
	    }

	    public Graph<Tag,Post> getMainStorage() {
	        return g;
	    }
	    
	    public void setMainStorage(ArrayList<String> tags,String postName,String postCaption,String hashTag,float postPriority,String author) {
	    	CreateMedia createInstance = new CreateMedia();
	        createInstance.createGroup(this.g,tags, postName, postCaption, hashTag, postPriority,author);

	    }
	    
	   
	    
	   
}
