package utilities;

import components.Tag;
import components.Post;

import java.util.ArrayList;

import Singletons.AuthorHolder;
import Singletons.TagLevelHolder;
import Singletons.TagPriorityHolder;
import components.Graph;



public class CreateMedia {
	

	
	

	
	

	public void createGroup(Graph<Tag,Post> g,ArrayList<String> tags,String postName,String postCaption,float postPriority,String author) {
		Post post = new Post(postName, postCaption, postPriority,author);
		AuthorHolder authors = AuthorHolder.getInstance();
		TagLevelHolder level = TagLevelHolder.getInstance();
		TagPriorityHolder priority = TagPriorityHolder.getInstance();
	 	for(int i = 0; i < tags.size(); i++) {
	 		Tag tag = new Tag(tags.get(i));
            
            
            priority.setTagPriority(tags.get(i),1f);
            if(level.getL1tags().contains(tags.get(i))) {
//            	System.out.println("found in level 1" + ": " + tags.get(i));
            	post.addL1tagsGroup(tags.get(i));
            } else if(level.getL2tags().contains(tags.get(i))) {
//            	System.out.println("found in level 2" + ": " + tags.get(i));
            	post.addL2tagsGroup(tags.get(i));
            } else if(level.getAuthenTags().contains(tags.get(i))) {
            	
            	post.addauthenTagsGroup(tags.get(i));
            }
            else {
            	//System.out.println("found in level 3" + ": " + tags.get(i));
            	post.addTagsGroup(tags.get(i));
            }
           	
            
           
            g.addEdge(tag, post);
	 		
	 	}
	 	
	 	authors.addPostToAuthor(author, post);
	 	
        
    

    
  

}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

	}



	
	
	


}

//Tag name[accepted as array ] and Post-> accepted Post, caption, Hashtag
