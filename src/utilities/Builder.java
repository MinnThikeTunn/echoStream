package utilities;

import java.util.ArrayList;
import java.util.Arrays;

import Singletons.MainStorageHolder;


public class Builder {
	
	public void build() {
        MainStorageHolder g = MainStorageHolder.getInstance();
        g.setMainStorage(new ArrayList<String>(Arrays.asList("boy", "girl", "sport")), "Ha Ha bel","We love Sushi","sport",1.8f,"john Doe");
        g.setMainStorage(new ArrayList<String>(Arrays.asList("boy", "sport", "gay")), "Sa tar Par","We love Sushi","sport",1.8f,"john Doe");
        g.setMainStorage(new ArrayList<String>(Arrays.asList("funny", "DC", "mavel")), "Mike tel","We love Sushi","sport",1.8f,"Nick");
        g.setMainStorage(new ArrayList<String>(Arrays.asList("girl")), "Mike Mike","We love Sushi","sport",1.8f,"Nick");
        g.setMainStorage(new ArrayList<String>(Arrays.asList("music","pop")), "real Testing","We love Sushi","sport",1.8f,"Nick");

		 
	 	
        
    

    
  

}

}
