package utilities;

import components.Tag;
import components.Post;

import java.util.ArrayList;

import components.GlobalHolder;
import components.Graph;



public class CreateMedia {
	

	
	//create method for adding into the map.
	public void create(Graph<Tag,Post> g,String tags,String postName,String postCaption,String hashTag,float postPriority,ArrayList<String> tagsGroup) {
		 
			 	
	            Tag tag = new Tag(tags );
	            Post post = new Post(postName, postCaption, hashTag, postPriority, tagsGroup);
	            GlobalHolder.getInstance().setSharedValue(tags,1f);
	            g.addEdge(tag, post);
	        

	        
	      
		
	}
	
	
	
	//just like create method, support for creating with a number of tags
	public void createGroup(Graph<Tag,Post> g,ArrayList<String> tags,String postName,String postCaption,String hashTag,float postPriority) {
		 
	 	for(int i = 0; i < tags.size(); i++) {
	 		create(g,tags.get(i),postName,postCaption,hashTag,postPriority,tags);
	 		
	 	}
        
    

    
  

}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

	}



	
	
	


}

//Tag name[accepted as array ] and Post-> accepted Post, caption, Hashtag
