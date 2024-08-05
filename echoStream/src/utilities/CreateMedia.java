package utilities;

import components.Tag;
import components.Post;


import components.Graph;



public class CreateMedia {
	
//	public ArrayList<Post> getRawTempoData() {
//        ArrayList<Post> posts = new ArrayList<>();
//        
//        for (int i = 1; i <= 100; i++) {
//            posts.add(new Post("Post " + i, "Caption for post " + i, "HashTag" + i));
//        }
//        
//        return posts;
//    }
	
	
	//create method for adding into the map.
	public void create(Graph<Tag,Post> g,String tags,float popularity,String postName,String postCaption,String hashTag,float postPriority) {
		 
			 	
	            Tag tag = new Tag(tags, popularity);
	            Post post = new Post(postName, postCaption, hashTag, postPriority);
	            g.addEdge(tag, post);
	        

	        // Create Post objects and add edges to the graph
	        
	      
		
	}
	
	
	
	//just like create method, support for creating with a number of tags
	public void createGroup(Graph<Tag,Post> g,String[] tags,float popularity,String postName,String postCaption,String hashTag,float postPriority) {
		 
	 	for(int i = 0; i < tags.length; i++) {
	 		create(g,tags[i],popularity,postName,postCaption,hashTag,postPriority);
	 		
	 	}
        
    

    // Create Post objects and add edges to the graph
    
  

}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		

	}

}

//Tag name[accepted as array ] and Post-> accepted Post, caption, Hashtag
