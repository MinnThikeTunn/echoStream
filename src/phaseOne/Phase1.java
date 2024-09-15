package phaseOne;

import java.util.ArrayList;


import Singletons.AuthorHolder;
import Singletons.FavoriteAuthorHolder;
import Singletons.TagPriorityHolder;
import Singletons.MainStorageHolder;
import Singletons.PercentageHolder;
import components.Graph;
import components.Post;
import components.Tag;
import utilities.Builder;



// Driver Code
public class Phase1 {
	
	 	
	    
	    
	 
	public ArrayList<Post> getRawTempoData() {
		
//		  g.getKey("boy");
//		MainStorage.getInstance().setMainStorage(new ArrayList<String>(Arrays.asList("boy", "girl", "sport")), "Ha Ha bel","We love Sushi","sport",1.8f);
		Builder builder = new Builder();
		builder.build();
		
        ArrayList<Post> posts = MainStorageHolder.getInstance().getMainStorage().getKey("boy");
        System.out.println(posts);
        System.out.println(MainStorageHolder.getInstance().getMainStorage());
        
//        for (int i = 1; i <= 100; i++) {
//            posts.add(new Post("Post " + i, "Caption for post " + i, "HashTag" + i,1,new ArrayList<String>(Arrays.asList("boy", "gay", "sport")) ));
//        }
        
        return posts;
    }
	
	
	
	 public void printValue() {
	        System.out.println("Shared Value: " + TagPriorityHolder.getInstance().getAllTagPriority());
	    }
	

    public static void main(String args[]) {
    	
    	
    	
    	Phase1 a = new Phase1();
    	Builder builder = new Builder();
      	
    	
    	
    	
    	
//	    a.setSharedValue("hi",1);
	    
    	
    	

        // Object of graph is created.
        Graph<Tag,Post> g = MainStorageHolder.getInstance().getMainStorage();
        AuthorHolder sample = AuthorHolder.getInstance();
     
//        popularityHolder popularList = new popularityHolder();
         
        
        
        
        

        // Edges are added.
        // Since the graph is bidirectional,
        // so boolean bidirectional is passed as true.
        
        
        
      
        
       
//        //function( graph, tag, tagPriority, postName, postTitle, tags , postPriority
//        //tag and tagPriority are composite key,(e.g, if girl tag is 1f it always 1f)
//        createInstance.create(g, "girl", "We love Sushi","We love Sushi","girl",2.8f);
//        
//        
//        createInstance.create(g, "boy", "Wtf","We love Sushi","boy",2.8f);
//        createInstance.create(g, "boy", "Sorry","We love Sushi","boy",2.8f);
//        createInstance.create(g,"boy" , "Ha Ha","We love Sushi","boy",1.8f);
//        createInstance.create(g,"girl" , "Ha Ha","We love Sushi","girl",1.8f);
//        createInstance.create(g,"sport" , "HaddHa","We love Sushi","girl",1.8f);
        
        
        
        
        //jsut like create method , createGroup can be invoked to create with a group of tags
//        createInstance.createGroup(g,new ArrayList<String>(Arrays.asList("boy", "girl", "sport")), "Ha Ha bel","We love Sushi","sport",1.8f);
//        MainStorage.getInstance().setMainStorage(new ArrayList<String>(Arrays.asList("boy", "girl", "sport")), "Ha Ha bel","We love Sushi","sport",1.8f);
//        System.out.println(MainStorage.getInstance().getMainStorage() + "ha ha");
//        createInstance.createGroup(g,new ArrayList<String>(Arrays.asList("boy", "sport", "gay")), "Sa tar par","We love Sushi","sport",1.8f);
//        createInstance.createGroup(g,new ArrayList<String>(Arrays.asList("Funny", "DC", "Mavel")), "Mike tel","We love Sushi","sport",1.8f);
//        
//        
//        createInstance.create(g, new String[] {"sport","boy"},1.5f, "Really, Yeah","Really, Yeah","sport",2.5f);
        


//        g.getKey(new Tag("bo  y", 3f));
//        g.setPriority(new Tag("boy", 3f), "Sorry", 3f);
        
        builder.build();
        MainStorageHolder.getInstance().getMainStorage().setTagPopularity(new Tag("girl"),2f);
        MainStorageHolder.getInstance().getMainStorage().setPriority(new Tag("girl",TagPriorityHolder.getInstance().getTagPriority("girl")), "Ha Ha bel", 3f);
        
        System.out.println("heeeeeeeeeeeeeeeeeeeeeeeeeeeee");
        System.out.println(MainStorageHolder.getInstance().getMainStorage());
        System.out.println("heeeeeeeeeeeeeeeeeeeeeeeeeeeee");
        
//        g.getKey(new Tag("boy", 3f));
        // Printing the graph
        System.out.println("Graph:\n" + g.toString());
        
        
        
        System.out.println(sample.getAuthorPosts("Nick").get(0).getPriority() + "author");
        System.out.println(sample.toString());
        // Gives the no of vertices in the graph.
        
        System.out.println(MainStorageHolder.getInstance().getMainStorage().getKey("boy") + "yep");
        System.out.println(g.getKey("boy").get(0).getL2Tags() + "new feature");
        g.getVertexCount();

        // Gives the no of edges in the graph.
        g.getEdgesCount();
        
        
        System.out.println("Testingggggggggggggggggggggggggggggggg");
        PercentageHolder holder = PercentageHolder.getInstance();
       
        holder.addPercentage(1, "ausic", 2);
        holder.addPercentage(1, "walar", 2);
        holder.addPercentage(1, "mushi", 3);
        holder.addPercentage(1, "sport", 2);
        holder.addPercentage(1, "blaBla", 3);
        holder.addPercentage(1, "blaBla", 3);
        holder.addPercentage(1, "sport", 2);
        holder.addPercentage(1, "zushi", 3);
        holder.addPercentage(1, "blaBla", 3);
        holder.addPercentage(1, "blaBla", 3);
        holder.addPercentage(2, "authen 1", 2);
        holder.addPercentage(2, "authen 2", 3);
        holder.addPercentage(1, "authen 3", 3);
        holder.addPercentage(1, "authen 4", 3);	
        
    
        
     
      
        holder.printLevel1Percentage();
        holder.printLevel2Percentage();
        
        System.out.println("Testingggggggggggggggggggggggggggggggg");
        

        

//         Tells whether the edge is present or not.
//        g.hasEdge("sport", 4);
//
//        // Tells whether vertex is present or not
//        g.hasVertex("sport");
//
//        // Prints the neighbors of a vertex
//        g.neighbours("sport");
        a.printValue();
        
        System.out.println(TagPriorityHolder.getInstance().getValue() + "me");
        
        FavoriteAuthorHolder favorite = FavoriteAuthorHolder.getInstance();
        favorite.addAuthor("Minn Thike");
        favorite.addAuthor("Minn");
        favorite.addAuthor("John Doe");
        favorite.addAuthor("John Doe");
        favorite.addAuthor("Minn");
        favorite.addAuthor("ha");
        favorite.outPut();
    }
}




