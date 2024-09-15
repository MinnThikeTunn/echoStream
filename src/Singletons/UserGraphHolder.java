package Singletons;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;



import components.Graph;
import components.Post;
import components.User;      // Assume you have a User class in the package 'Models'
import interfaces.HasPost;
import phaseTwo.UserGraph;  // Assume you have a UserGraph class in the package 'Graph'
import utilities.Builder;
import components.Tag;
public class UserGraphHolder {
    private static UserGraphHolder instance;
    private UserGraph userGraph;
    private static List<String> alternativeInterests = new ArrayList<>();
    private static List<Post> sharedPosts = new ArrayList<>();
    private static boolean hasMorePosts = true;
    private static int lastProcessedUserIndex = 0;
    private static String lastTag = "";
    private static List<String> ageGroups = new ArrayList<>(Arrays.asList("teen","youngAdult","adult","middleAgedAdult","olderAdult"));
    private static List<String> genders = new ArrayList<>(Arrays.asList("male", "female"));
    private static List<String> professions = new ArrayList<>(Arrays.asList("student", "freelancer", "retiredIndividual", "WebDev", "Actor", "workingProfessional"));
    private static List<String> interests = new ArrayList<>(Arrays.asList("art", "gaming", "animals", "food", "anime", "cars", "technology", "sports", "education", "entertainment"));
    
    // Private constructor to prevent instantiation
    private UserGraphHolder() {
        initializeGraph();  // Initialize the UserGraph
    }
    
    // Synchronized method to get the singleton instance
    public static synchronized UserGraphHolder getInstance() {
        if (instance == null) {
            instance = new UserGraphHolder();
        }
        return instance;
    }
    
    // Getter for the UserGraph
    public UserGraph getUserGraph() {
        return userGraph;
    }

    // Clear method to reset the UserGraph by re-initializing it
    public void clearGraph() {
        initializeGraph();  // Reset the graph with a new instance
    }

    // Method to initialize the graph with new users
    private void initializeGraph() {
        userGraph = new UserGraph();  // Create a new UserGraph instance
        List<User> users = generateUserList();  // Generate a new list of users
        
        users.forEach(userGraph::addUser);
    }
    
    // Method to add a new user to the graph
    public void addUser(User user) {
        userGraph.addUser(user);
    }
    
    private static <T> T getRandomElement(List<T> list) {
        return list.get((int) (Math.random() * list.size()));
    }

    // Mock method to generate user list (replace with your actual method)
    private List<User> generateUserList() {
    	Builder build = new Builder();
        build.build();
        Graph<Tag, Post> availablePosts = MainStorageHolder.getInstance().getMainStorage();

        final int TOTAL_USERS = 2000;
        List<User> users = new ArrayList<>();
        List<Tag> keys = new ArrayList<>(availablePosts.getTag());

        if (keys.isEmpty()) {
            System.out.println("Error: No tags available in the system.");
            return users;
        }

        for (int i = 0; i < TOTAL_USERS; i++) {
            String[] userTags = {
                getRandomElement(interests),
                getRandomElement(professions),
                getRandomElement(ageGroups),
                getRandomElement(genders)
            };
            List<Post> posts = new ArrayList<>();
            for (int p = 0; p < (int) (Math.random() * 2) + 3; p++) {
                int randk = (int) (Math.random() * keys.size());
                List<Post> randPostList = availablePosts.getKey((keys.get(randk)).getTitle());

                if (!randPostList.isEmpty()) {
                    int randp = (int) (Math.random() * randPostList.size());
                    posts.add(randPostList.get(randp));
                }
            }
            users.add(new User(userTags, posts));
        }

        return users;
    }
}
