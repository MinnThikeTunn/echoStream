package Singletons;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

import components.Post;


public class AuthorHolder {
	 private static AuthorHolder instance;
	 private Map<String, PriorityQueue<Post>> authorPost;

	    private AuthorHolder() {
	    	authorPost = new HashMap<>();
	       
	    } // Private constructor

	    public static synchronized AuthorHolder getInstance() {
	        if (instance == null) {
	            instance = new AuthorHolder();
	        }
	        return instance;
	    }
	    
	    public ArrayList<Post> getAuthorPosts(String author) {
	        PriorityQueue<Post> queue = authorPost.get(author);
	        if (queue != null) {
	            return new ArrayList<>(queue);
	        } else {
	            return new ArrayList<>(); // Return an empty list if no posts are found
	        }
	    }

	    
	    
	    public void addPostToAuthor(String author, Post post) {
	        PriorityQueue<Post> posts = authorPost.get(author);
	        if (posts == null) {
	            posts = new PriorityQueue<>((a1, a2) -> Float.compare(a1.getPriority(), a2.getPriority())); // Create a new PriorityQueue if it doesn't exist
	            authorPost.put(author, posts);
	        }
	        posts.add(post); // Add the post to the PriorityQueue
	    }
	    
	    
	    public void setPriority(String source, String element, float newPriority) {
	        PriorityQueue<Post> collection = authorPost.get(source);
	        if (collection == null) {
	            System.out.println("No such priority queue for the given source.");
	            return;
	        }

	        // Create a temporary priority queue to hold the updated elements
	        PriorityQueue<Post> updatedQueue = new PriorityQueue<>((a1, a2) -> Float.compare(a1.getPriority(), a2.getPriority()));
	        boolean found = false;

	        // Iterate through the original queue to find and update the element
	        for (Post e : collection) {
	            if (e.getTitle().equals(element)) {
	              
	            	e.setPriority(newPriority);
//	            	AuthorHolder.getInstance().setPriority(e.getAuthor(),e.getTitle(),newPriority);
	            
	                found = true;
	            }
	            updatedQueue.add(e);
	        }

	        if (!found) {
	        	System.out.println("Element not found in the priority queue.");
	            return;
	        }

	        // Replace the old priority queue with the updated one
	        
	        authorPost.put(source, updatedQueue);
	    }
	    
	    
	    @Override
	    public String toString() {
	        StringBuilder builder = new StringBuilder();
	        for (String v : authorPost.keySet()) {
	            builder.append(v).append(": ");
	            for (Post w : authorPost.get(v)) {
	                builder.append(w.getTitle()).append(" <-> ");
	            }
	            builder.append("\n");
	        }
	        return builder.toString();
	    }

	   
	    
	   
	    
	   
}
