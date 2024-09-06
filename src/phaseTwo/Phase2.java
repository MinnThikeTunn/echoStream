package phaseTwo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import components.Post;
import components.User;

public class Phase2 {
	
	private static class UserGraph {
		
		private final HashMap<String, List<User>> userGraph = new HashMap<>();
		
		public void addUser(User user) {
			userGraph.computeIfAbsent(user.getUserTagString(), k -> new ArrayList<>()).add(user);
		}
		
		public void showGraph() {
		    for (Map.Entry<String, List<User>> entry : userGraph.entrySet()) {
		        String key = entry.getKey();
		        List<User> users = entry.getValue();
		        System.out.println("Key: " + key);
		        for (User u : users) {
		            System.out.print(" id : " + u.getUserId() + ", ");
		        }
		        System.out.println();
		    }
		}

		
		public List<User> getUsersByTag(String tag) {
			return userGraph.getOrDefault(tag, new ArrayList<>());
		}
	}
	
	public static void main(String[] args) {
		UserGraph userGraph = new UserGraph();
		List<User> users = generateUserList();
		String myTag = users.get(0).getUserTagString();
		
		for (User user : users) {
   			 userGraph.addUser(user);
		}

		userGraph.showGraph();
		
		phaseTwo(myTag, userGraph);
	}
	
	public static List<Post> phaseTwo(String myTag, UserGraph userGraph) {
		List<User> users = userGraph.getUsersByTag(myTag);
		List<Post> sharedPosts = new ArrayList<>();
		
		for (User u : users) {
    			u.sharePosts(sharedPosts);
    			if(sharedPosts.size() >= 20) 
    			{
    				break;
    			}
		}
		int c = 0;
		for (Post p : sharedPosts) {
   		 System.out.println(c++ + p.getCaption());
		}
		return sharedPosts;
	}
	
	public static List<User> generateUserList() {
		
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