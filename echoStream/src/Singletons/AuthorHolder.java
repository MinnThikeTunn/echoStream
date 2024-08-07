package Singletons;


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
	    
	    public PriorityQueue<Post> getAuthorPosts(String author) {
	        return authorPost.get(author);
	    }
	    
	    
	    public void addPostToAuthor(String author, Post post) {
	        PriorityQueue<Post> posts = authorPost.get(author);
	        if (posts == null) {
	            posts = new PriorityQueue<>((a1, a2) -> Float.compare(a1.getPriority(), a2.getPriority())); // Create a new PriorityQueue if it doesn't exist
	            authorPost.put(author, posts);
	        }
	        posts.add(post); // Add the post to the PriorityQueue
	    }

	   
	    
	   
	    
	   
}
