package utilities;

import components.Tag;
import components.Post;

import java.util.ArrayList;

import Singletons.AuthorHolder;
import Singletons.TagPriorityHolder;
import components.Graph;



public class CreateMedia {
	

	
	

	
	

	public void createGroup(Graph<Tag,Post> g,ArrayList<String> tags,String postName,String postCaption,String hashTag,float postPriority,String author) {
		Post post = new Post(postName, postCaption, hashTag, postPriority, tags,author);
	 	for(int i = 0; i < tags.size(); i++) {
	 		Tag tag = new Tag(tags.get(i));
            
            
            TagPriorityHolder.getInstance().setTagPriority(tags.get(i),1f);
            g.addEdge(tag, post);
	 		
	 	}
	 	
	 	AuthorHolder.getInstance().addPostToAuthor(author, post);
	 	
        
    

    
  

}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

	}



	
	
	


}

//Tag name[accepted as array ] and Post-> accepted Post, caption, Hashtag
