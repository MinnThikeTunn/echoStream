package phaseOne;
import java.util.ArrayList;

import components.Graph;
import components.Post;
import components.Tag;
import utilities.CreateMedia;



// Driver Code
public class Phase1 {
	
	public ArrayList<Post> getRawTempoData() {
        ArrayList<Post> posts = new ArrayList<>();
        
        for (int i = 1; i <= 100; i++) {
            posts.add(new Post("Post " + i, "Caption for post " + i, "HashTag" + i,1));
        }
        
        return posts;
    }

    public static void main(String args[]) {

        // Object of graph is created.
        Graph<Tag,Post> g = new Graph<Tag,Post>();
        CreateMedia createInstance = new CreateMedia();
        
        

        // Edges are added.
        // Since the graph is bidirectional,
        // so boolean bidirectional is passed as true.
        
        
        
      
        
       
//        createInstance.create(g, new String[] {"girl"},1.2f, "Wow, it's great","Wow, it's great","sport",1);
        createInstance.create(g, "girl",1f, "We love Sushi","We love Sushi","sport",2.8f);
        
        createInstance.create(g, "boy",3f, "Wtf","We love Sushi","sport",2.8f);
        createInstance.create(g, "boy",3f, "Sorry","We love Sushi","sport",2.8f);
        
        
//        createInstance.create(g, new String[] {"sport","boy"},1.5f, "Really, Yeah","Really, Yeah","sport",2.5f);
        


//        g.getKey(new Tag("boy", 3f));
//        g.setPriority(new Tag("boy", 3f), "Sorry", 3f);
        g.setTagPriority(new Tag("boy", 3f),0f);
//        g.getKey(new Tag("boy", 3f));
        // Printing the graph
        System.out.println("Graph:\n" + g.toString());

        // Gives the no of vertices in the graph.
        g.getVertexCount();

        // Gives the no of edges in the graph.
        g.getEdgesCount();

//         Tells whether the edge is present or not.
//        g.hasEdge("sport", 4);
//
//        // Tells whether vertex is present or not
//        g.hasVertex("sport");
//
//        // Prints the neighbors of a vertex
//        g.neighbours("sport");
    }
}




