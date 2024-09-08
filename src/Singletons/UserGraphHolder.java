package Singletons;

import java.util.ArrayList;
import java.util.List;
import phaseTwo.UserGraph;  // Assume you have a UserGraph class in the package 'Graph'
import components.Post;
import components.User;      // Assume you have a User class in the package 'Models'

public class UserGraphHolder {
    private static UserGraphHolder instance;
    private UserGraph userGraph;
    
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
        
        for (User user : users) {
            userGraph.addUser(user);  // Add each user to the graph
        }
    }
    
    // Method to add a new user to the graph
    public void addUser(User user) {
        userGraph.addUser(user);
    }

    // Mock method to generate user list (replace with your actual method)
    private List<User> generateUserList() {
        String[] ageGroups = {"Teens", "YoungAdult", "Adult", "MiddleAge", "Older"};
        String[] genders = {"Male", "Female"};
        String[] professions = {"Student", "Freelancer", "Retired", "WebDev", "Actor", "Shopkeeper"};
        String[] interests = {"Art", "Gaming", "Animals", "Food", "Anime", "Cars", "IT", "Sports", "Education", "Entertainment"};

        int totalUsers = 1800;
        List<User> users = new ArrayList<>();

        for (int i = 0; i < totalUsers; i++) {
            String[] userTags = {
                interests[(int) (Math.random() * interests.length)],
                professions[(int) (Math.random() * professions.length)],
                ageGroups[(int) (Math.random() * ageGroups.length)],
                genders[(int) (Math.random() * genders.length)]
            };

            List<Post> posts = new ArrayList<>();

            for (int j = 0; j < 3; j++) {
                posts.add(new Post("Post " + j, "Caption for post " + j, 1, "Author"));
            }

            users.add(new User(userTags, posts));
        }

        return users;
    }
}
