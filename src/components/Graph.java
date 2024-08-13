package components;

import java.util.ArrayList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.TreeMap;

import Singletons.AuthorHolder;
import Singletons.TagPriorityHolder;
import interfaces.HasPost;
import interfaces.HasTag;
import utilities.TagComparator;

public class Graph<T extends HasTag, A extends HasPost> {

    @SuppressWarnings({ "unchecked", "rawtypes" })
	private Map<T, PriorityQueue<A>> map = new TreeMap<>(new TagComparator());

    // This function adds a new vertex to the graph
    public void addVertex(T s) {
        if (!map.containsKey(s)) {
            map.put(s, new PriorityQueue<>((a1, a2) -> Float.compare(a1.getPriority(), a2.getPriority())));
        } else {
            System.out.println("Vertex already exists: " + s.getTitle());
        }
    }

    // This function adds the edge between source and destination
    public void addEdge(T source, A destination) {
        if (!map.containsKey(source)) {
            addVertex(source);
        }
        map.get(source).offer(destination); // Using offer to add elements to the priority queue
    }
    
   
    
    
    
    //just for testing
    @SuppressWarnings("unchecked")
	public ArrayList<Post> getKey(String source) {
        // Ensure map keys are of type T, not directly an ArrayList
        Set<T> keys = map.keySet();

        // Iterate over the keys
        for (T key : keys) {
            if (key instanceof Tag && ((Tag) key).getTitle().equals(source)) {
                PriorityQueue<A> collection = map.get(key);

                if (collection == null) {
                    System.out.println("No collection found for key: " + key);
                   
                }

               

                ArrayList<A> list = new ArrayList<>(collection);
                if (list.size() > 0) {
//                    System.out.println("element tags: " + list.toString());
                    return (ArrayList<Post>) list;
                } else {
                    System.out.println("List does not have enough elements.");
                }
               // Exit after processing the found key
            }
        }

        System.out.println("No matching key found for source: " + source);
		return null;
    }
    
    
    //setting TagPopularity Dynamically
    @SuppressWarnings("unchecked")
	public void setTagPopularity(T vertex, float newPopularity) {
    	
        if (!map.containsKey(vertex)) {
            System.out.println("Vertex not found.");
            return;
        }
        
        PriorityQueue<A> edges = map.remove(vertex);
        
        Tag tempoTag = new Tag(vertex.getTitle());
        tempoTag.setPopularity(newPopularity);
        TagPriorityHolder.getInstance().setTagPriority(tempoTag.getTitle(),newPopularity);
        
        
        

        // Create a new vertex with updated priority
       
      

        // Replace the old vertex in the map with the new one
        map.put((T) tempoTag, edges);
    }

  
  //setting Post Priority Dynamically
    public void setPriority(T source, String element, float newPriority) {
        PriorityQueue<A> collection = map.get(source);
        if (collection == null) {
            System.out.println("No such priority queue for the given source.");
            return;
        }

        // Create a temporary priority queue to hold the updated elements
        PriorityQueue<A> updatedQueue = new PriorityQueue<>((a1, a2) -> Float.compare(a1.getPriority(), a2.getPriority()));
        
        boolean found = false;

        // Iterate through the original queue to find and update the element
        for (A e : collection) {
        	

            if (e.getTitle().equals(element)) {
            	System.out.print("hifff");
              
            	e.setPriority(newPriority);
            	AuthorHolder.getInstance().setPriority(((Post) e).getAuthor(),e.getTitle(),newPriority);
                found = true;
            }
            updatedQueue.add(e);
        }

        if (!found) {
        	System.out.println("Element not found in the priority queue.");
            return;
        }

        // Replace the old priority queue with the updated one
        
        map.put(source, updatedQueue);
    }

    // This function gives the count of vertices
    public void getVertexCount() {
        System.out.println("The graph has " + map.keySet().size() + " vertices.");
    }

    // This function gives the count of edges
    public void getEdgesCount() {
        int count = 0;
        for (PriorityQueue<A> neighbors : map.values()) {
            count += neighbors.size();
        }
        System.out.println("The graph has " + count + " edges.");
    }

    // This function gives whether a vertex is present or not
    public void hasVertex(T s) {
        if (map.containsKey(s)) {
            System.out.println("The graph contains " + s.getTitle() + " as a vertex.");
        } else {
            System.out.println("The graph does not contain " + s.getTitle() + " as a vertex.");
        }
    }

    // This function gives whether an edge is present or not
    public void hasEdge(T s, A d) {
        if (map.containsKey(s)) {
            PriorityQueue<A> queue = map.get(s);
            // Check if the destination exists in the queue
            if (queue.contains(d)) {
                System.out.println("The graph has an edge between " + s.getTitle() + " and " + d.getTitle() + ".");
            } else {
                System.out.println("The graph has no edge between " + s.getTitle() + " and " + d.getTitle() + ".");
            }
        } else {
            System.out.println("The graph has no edge between " + s.getTitle() + " and " + d.getTitle() + ".");
        }
    }

    // This function prints the neighbors of a vertex
    public void neighbours(T s) {
        if (!map.containsKey(s)) {
            System.out.println("Vertex " + s.getTitle() + " not found.");
            return;
        }
        System.out.print("The neighbors of " + s.getTitle() + " are: ");
        for (A w : map.get(s)) {
            System.out.print(w.getTitle() + " ");
        }
        System.out.println();
    }

    // Prints the adjacency list of each vertex
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (T v : map.keySet()) {
            builder.append(v.getTitle()).append(": ");
            for (A w : map.get(v)) {
                builder.append(w.getTitle()).append(" <-> ");
            }
            builder.append("\n");
        }
        return builder.toString();
    }
}
