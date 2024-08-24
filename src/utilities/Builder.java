package utilities;

import java.util.ArrayList;
import java.util.Arrays;

import Singletons.MainStorageHolder;


public class Builder {
	
	public void build() {
        MainStorageHolder g = MainStorageHolder.getInstance();
        g.setMainStorage(new ArrayList<String>(Arrays.asList("boy", "girl", "old")), "Boy,Girl,Old","We love Sushi","sport",1.8f,"john Doe");
        g.setMainStorage(new ArrayList<String>(Arrays.asList("boy", "girl", "young")), "Boy,Girl,Young","We love Sushi","sport",1.8f,"john Doe");
        g.setMainStorage(new ArrayList<String>(Arrays.asList("boy", "girl", "old")), "OldOld","We love Sushi","sport",1.8f,"john Doe");
        g.setMainStorage(new ArrayList<String>(Arrays.asList("boy", "girl", "young")), "YOungYoung","We love Sushi","sport",1.8f,"john Doe");
        g.setMainStorage(new ArrayList<String>(Arrays.asList("boy", "girl", "old")), "Oooold","We love Sushi","sport",1.8f,"john Doe");
        g.setMainStorage(new ArrayList<String>(Arrays.asList("boy", "girl", "young")), "Yooong","We love Sushi","sport",1.8f,"john Doe");
        g.setMainStorage(new ArrayList<String>(Arrays.asList("gay")), "ggggggggay","We love Sushi","sport",1.8f,"john Doe");
        g.setMainStorage(new ArrayList<String>(Arrays.asList("gay")), "gaaaaaaaaaaay","We love Sushi","sport",1.8f,"john Doe");
        g.setMainStorage(new ArrayList<String>(Arrays.asList("gay")), "gayyyyyyyy","We love Sushi","sport",1.8f,"john Doe");
        g.setMainStorage(new ArrayList<String>(Arrays.asList("boy","student")), "student","We love Sushi","sport",1.8f,"john Doe");
        g.setMainStorage(new ArrayList<String>(Arrays.asList("boy","student")), "scholar","We love Sushi","sport",1.8f,"john Doe");
        g.setMainStorage(new ArrayList<String>(Arrays.asList("boy","student")), "uni","We love Sushi","sport",1.8f,"john Doe");
        g.setMainStorage(new ArrayList<String>(Arrays.asList("girl","student")), "girlStudent","We love Sushi","sport",1.8f,"john Doe");
        g.setMainStorage(new ArrayList<String>(Arrays.asList("girl","student")), "GirllStu","We love Sushi","sport",1.8f,"john Doe");
        g.setMainStorage(new ArrayList<String>(Arrays.asList("girl","student")), "GirlScholar","We love Sushi","sport",1.8f,"john Doe");
        g.setMainStorage(new ArrayList<String>(Arrays.asList("girl","student")), "stttudentLady","We love Sushi","sport",1.8f,"john Doe");
        g.setMainStorage(new ArrayList<String>(Arrays.asList("Worker")), "SE","We love Sushi","sport",1.8f,"john Doe");
        g.setMainStorage(new ArrayList<String>(Arrays.asList("Worker")), "SEEE","We love Sushi","sport",1.8f,"john Doe");
        g.setMainStorage(new ArrayList<String>(Arrays.asList("Worker")), "worker","We love Sushi","sport",1.8f,"john Doe");
        g.setMainStorage(new ArrayList<String>(Arrays.asList("boy", "girl", "sport")), "Ha Ha bel","We love Sushi","sport",1.8f,"john Doe");
        g.setMainStorage(new ArrayList<String>(Arrays.asList("funny", "DC", "mavel")), "Mike tel","We love Sushi","sport",1.8f,"Nick");
        g.setMainStorage(new ArrayList<String>(Arrays.asList("girl")), "Mike Mike","We love Sushi","sport",1.8f,"Nick");
        g.setMainStorage(new ArrayList<String>(Arrays.asList("music","pop")), "real Testing","We love Sushi","sport",1.8f,"Nick");

		 
	 	
        
    

    
  

}

}
