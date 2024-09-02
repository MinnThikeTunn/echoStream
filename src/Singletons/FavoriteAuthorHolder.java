package Singletons;



import java.util.PriorityQueue;

import components.Author;



public class FavoriteAuthorHolder {
	 private static FavoriteAuthorHolder instance;
	 private PriorityQueue<Author> posts;
	 

	    private FavoriteAuthorHolder() {
	    	posts = new PriorityQueue<>((a1, a2) -> Float.compare(a2.getOccurance(), a1.getOccurance()));
	       
	    } // Private constructor

	    public static synchronized FavoriteAuthorHolder getInstance() {
	        if (instance == null) {
	            instance = new FavoriteAuthorHolder();
	        }
	        return instance;
	    }
	    
	    public String getAuthor() {
	        return posts.peek().getAuthor();
	    }

	    
	    
	    public void addAuthor(String author) {
	    	
	    	if(posts.contains(new Author(author))) {
	    		
	    		PriorityQueue<Author> Tempoposts = new PriorityQueue<>((a1, a2) -> Float.compare(a2.getOccurance(), a1.getOccurance()));
	    		 for (Author main : posts) {
	    	            if(main.getAuthor() == author) { 
	    	            	main.AddOccurance();
	    	            	
	    	            }
	    	            Tempoposts.offer(main);
	    	            
	    	        }
	    		 posts = Tempoposts;
	    		 
	    		 
	    	} else {
	    		
	    		posts.offer(new Author(author));
	    }
	    }
	       
	    
	    
	    
	    
	   
	    public void outPut() {
	      
	        for (Author v : posts) {
	        	System.out.println("Author = " + v.getAuthor() + "Occurance = "+ v.getOccurance());
	            
	        }
	        
	    }

	   
	    
	   
	    
	   
}
