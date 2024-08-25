package Singletons;


import java.util.ArrayList;

import java.util.PriorityQueue;


import components.Percentage;


public class PercentageHolder  {
	 private static PercentageHolder instance;
	 private ArrayList<String> level1Tags,level2Tags,tags;
	 PriorityQueue<Percentage> level1Percentage,level2Percentage, level3Percentage;
	 
	 private int count = 0;
	    
	 
	 //for calculating Percentage
	    public void addCount(int interActionType) {
	        count += interActionType;
	    }
	    
	    
	    public ArrayList<Percentage> getLevel1Percentage() {
	    
	    	
	    	ArrayList<Percentage> tagsList = new ArrayList<>(level1Percentage);
	        
	        return tagsList;
	    }
	    
	    public int getCount() {
	    	return count;
	    }

	    private PercentageHolder() {
	    	level1Percentage = level2Percentage = level3Percentage =  new PriorityQueue<>();
	    	level1Tags = level2Tags = tags = new ArrayList<>();
	    } // Private constructor

	    public static synchronized PercentageHolder getInstance() {
	        if (instance == null) {
	            instance = new PercentageHolder();
	        }
	        return instance;
	    }
	    
	    
	    public void addTags(ArrayList<String> levelTags, String tag) {
	    	

	    	if(!level1Tags.contains(tag))
	    		levelTags.add(tag);
	    	
	    	
	        
	        
	    } 
	    
	    
	    public void insertPercent(ArrayList<String> levelTag,Percentage nameCheck, PriorityQueue<Percentage> tempoQueue,String tag) {
	    	if (!levelTag.contains(nameCheck.getTag())) {
	            Percentage p = new Percentage(tag,(0/getCount()) * 100);
	 
	            tempoQueue.offer(p);
	           
	        } 
	    }
	    
	   
	    
	    public void addPercentage(int level, String tag,int interactionType) {
	    	
	    	 PriorityQueue<Percentage> tempoQueue;
	    	 PriorityQueue<Percentage> resultStore = new PriorityQueue<>();
	    	 Percentage nameCheck = new Percentage(tag, 0f);
	    	 ArrayList<String> tempoLevelTag;
	    	
	    	 
	    	 addCount(interactionType);
	    	 
	    	if (level == 1) {
	    		tempoQueue = level1Percentage;
	    	    tempoLevelTag = level1Tags;
	    	    insertPercent(tempoLevelTag, nameCheck, tempoQueue,tag);

	    	    addTags(level1Tags, tag);
	    	    
	    	   
	    	} else if (level == 2) {
	    	    addTags(level2Tags, tag);
	    	    tempoQueue = level2Percentage;
	    	    tempoLevelTag = level2Tags;
	    	} else {
	    	    addTags(tags, tag);
	    	    tempoQueue = level3Percentage;
	    	    tempoLevelTag = tags;
	    	}
	    	
	    	
	    	
	    	
	    	
	    	
	    	
	    	for(Percentage sample : tempoQueue) {
	    		
	    		if(sample.getTag() == tag) {
	    			
	    		
	    			sample.addOccurance(interactionType);
	    			
	    			float data = ((float)sample.getOccurance()/getCount()) * 100;   	
	    			sample.setPercent(data);
	    			resultStore.offer(sample);
	    			
	    			
	    		} else {
	    			
	    			float data = ((float)sample.getOccurance()/getCount()) * 100;
	    			sample.setPercent(data);
	    			resultStore.offer(sample);
	    		
	    			
	    		}
	    		
	    		
	    		
	    		
	    	}
	    	
	    	if (level == 1) {
	    	    
	    	    level1Percentage = resultStore;
	    	} else if (level == 2) {
	    	    level2Percentage = resultStore;
	    	} else {
	 
	    		level3Percentage = resultStore;
	    	}
	    	
	    	
	    	getLevel1Percentage();
	    	
	    	
	    	
	    	
	    	
	    	
	    	
    		
    	
    	
        
        
    } 
	    
	    
	   //for testing
	    
	    
	   public void getlevel1Tags() {
		   System.out.println(level1Tags);
		   
	   }
	   
	   public void printLevel1Percentage() {
		   for(Percentage p : level1Percentage) {
			   System.out.println(p.getTag() + " occurance = " + p.getOccurance() + " percent = " + p.getPercent());
		   }
	   }


	

	   
	    
	   
	    
	   
}
