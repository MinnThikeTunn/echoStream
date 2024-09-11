package Singletons;


import java.util.ArrayList;

import java.util.PriorityQueue;


import components.Percentage;


public class PercentageHolder  {
	 private static PercentageHolder instance;
	 private ArrayList<String> authenTags,level1Tags,level2Tags,tags;
	 PriorityQueue<Percentage> authenPercentage,level1Percentage,level2Percentage, level3Percentage;
	 
	 private int count = 0;
	 private int count1 = 0;
	 private int count2 = 0;
	 private int countAuthen = 0;
	    
	 
	 //for calculating Percentage
	    public void addCount(int interActionType) {
	        count += interActionType;
	    }
	    
	    public void addCount1(int interActionType) {
	        count1 += interActionType;
	    }
	    
	    public void addCount2(int interActionType) {
	        count2 += interActionType;
	    }
	    
	    public void addCountAuthen(int interActionType) {
	        countAuthen += interActionType;
	    }
	    
	    public int getCount() {
	    	return count;
	    }
	    public int getCount1() {
	    	return count1;
	    }
	    public int getCount2() {
	    	return count2;
	    }
	    public int getCountAuthen() {
	    	return countAuthen;
	    }
	    
	    public ArrayList<Percentage> getLevel1Percentage() {
	    
	    	
	    	ArrayList<Percentage> tagsList = new ArrayList<>(level1Percentage);
	        
	        return tagsList;
	    }
	    
	    public ArrayList<Percentage> getLevel2Percentage() {
	    
	    	
	    	ArrayList<Percentage> tagsList = new ArrayList<>(level2Percentage);
	        
	        return tagsList;
	    }

	    public ArrayList<Percentage> getLevel3Percentage() {
    
	
	ArrayList<Percentage> tagsList = new ArrayList<>(level3Percentage);
    
    return tagsList;
}

public ArrayList<Percentage> getAuthenPercentage() {
    
	
	ArrayList<Percentage> tagsList = new ArrayList<>(authenPercentage);
    
    return tagsList;
}
	    
	    

	    private PercentageHolder() {
	    	level1Percentage  =  new PriorityQueue<>();
	    	level2Percentage = new PriorityQueue<>();
	    	level3Percentage = new PriorityQueue<>();
	    	authenPercentage = new PriorityQueue<>();
	    	
	    	level1Tags =  new ArrayList<>();
	    	authenTags = new ArrayList<>();
	    	tags = new ArrayList<>();
	    	level2Tags =  new ArrayList<>();
	    } // Private constructor

	    public static synchronized PercentageHolder getInstance() {
	        if (instance == null) {
	            instance = new PercentageHolder();
	        }
	        return instance;
	    }
	    
	    
	    public void addTags(ArrayList<String> levelTags, String tag) {
	    	
	    	

	    	if(!levelTags.contains(tag))
	    		levelTags.add(tag);
	    	
	    	
	        
	        
	    } 
	    
	    
	    public void insertPercent(ArrayList<String> levelTag,Percentage nameCheck, PriorityQueue<Percentage> tempoQueue,String tag,int minusThing) {
	    	if (!levelTag.contains(nameCheck.getTag())) {
	            Percentage p = new Percentage(tag,(0/minusThing) * 100);
	 
	            tempoQueue.offer(p);
	           
	        } 
	    }
	    
	   
	    
	    public void addPercentage(int level, String tag,int interactionType) {
	    	
	    	 PriorityQueue<Percentage> tempoQueue;
	    	 PriorityQueue<Percentage> resultStore = new PriorityQueue<>();
	    	 Percentage nameCheck = new Percentage(tag, 0f);
	    	 ArrayList<String> tempoLevelTag;
	    	 int minusThing;
	    	 
	    	
	    	 
	    	if (level == 1) {
	    		tempoQueue = level1Percentage;
	    	    tempoLevelTag = level1Tags;
	    	    addCount(interactionType);
	    	    minusThing = getCount();
	    	    insertPercent(tempoLevelTag, nameCheck, tempoQueue,tag,minusThing);
	    	   
	    	    addTags(level1Tags, tag);
	    	    
	    	   
	    	} else if (level == 2) {
	    	    
	    	    tempoQueue = level2Percentage;
	    	    tempoLevelTag = level2Tags;
	    	    addCount1(interactionType);
	    	    minusThing = getCount1();
	    	    insertPercent(tempoLevelTag, nameCheck, tempoQueue,tag,minusThing);
	    	    
	    	    addTags(level2Tags, tag);
	    	} else if (level == 3) {
	    	    
	    	    tempoQueue = level3Percentage;
	    	    tempoLevelTag = tags;
	    	    addCount2(interactionType);
	    	    minusThing = getCount2();
	    	    insertPercent(tempoLevelTag, nameCheck, tempoQueue,tag,minusThing);
	    	    addTags(tags, tag);
	    	    
	    	} else {
	    		tempoQueue = authenPercentage;
	    	    tempoLevelTag = authenTags;
	    	    addCountAuthen(interactionType);
	    	    minusThing = getCountAuthen();
	    	    insertPercent(tempoLevelTag, nameCheck, tempoQueue,tag,minusThing);
	    	    
	    	    addTags(authenTags, tag);
	    	}
	    	
	    	
	    	
	    	
	    	
	    	
	    	
	    	for(Percentage sample : tempoQueue) {
	    		
	    		if(sample.getTag() == tag) {
	    			
	    		
	    			sample.addOccurance(interactionType);
	    			
	    			float data = ((float)sample.getOccurance()/minusThing) * 100;   	
	    			sample.setPercent(data);
	    			resultStore.offer(sample);
	    			
	    			
	    		} else {
	    			
	    			float data = ((float)sample.getOccurance()/minusThing) * 100;
	    			sample.setPercent(data);
	    			resultStore.offer(sample);
	    		
	    			
	    		}
	    		
	    		
	    		
	    		
	    	}
	    	
	    	if (level == 1) {
	    	    
	    	    level1Percentage = resultStore;
	    	} else if (level == 2) {
	    	    level2Percentage = resultStore;
	    	} else if(level == 3) {
	 
	    		level3Percentage = resultStore;
	    	} else {
	    		authenPercentage = resultStore;
	    	}
	    	
	    	
//	    	getLevel1Percentage();
	    	
	    	
	    	
	    	
	    	
	    	
	    	
    		
    	
    	
        
        
    } 
	    
	    
	   //for testing
	    
	    

	   
	   public void printLevel1Percentage() {
		   for(Percentage p : level1Percentage) {
			   System.out.println(p.getTag() + " occurance = " + p.getOccurance() + " percent = " + p.getPercent());
		   }
	   }
	   
	   public void printLevel2Percentage() {
		   for(Percentage p : level2Percentage) {
			   System.out.println(p.getTag() + " occurance = " + p.getOccurance() + " percent = " + p.getPercent());
		   }
	   }
	   
	   public void printLevel3Percentage() {
		   for(Percentage p : level3Percentage) {
			   System.out.println(p.getTag() + " occurance = " + p.getOccurance() + " percent = " + p.getPercent());
		   }
	   }
	   
	   public void printAuthenPercentage() {
		   for(Percentage p : authenPercentage) {
			   System.out.println(p.getTag() + " occurance = " + p.getOccurance() + " percent = " + p.getPercent());
		   }
	   }


	

	   
	    
	   
	    
	   
}
