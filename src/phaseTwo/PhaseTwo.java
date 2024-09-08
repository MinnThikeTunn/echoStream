package phaseTwo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Singletons.UserGraphHolder;
import components.Post;
import components.User;

public class PhaseTwo {

	

	public static void main(String[] args) {
//		UserGraph userGraph = new UserGraph();
//		List<User> users = generateUserList();
//		String myTag = users.get(0).getUserTagString();
		String myTag = "FoodFreelancerAdultFemale";
//
//		for (User user : users) {
//   			 userGraph.addUser(user);
//		}
//
//		userGraph.showGraph();
		UserGraph test = UserGraphHolder.getInstance().getUserGraph();
		List<Post> share = phaseTwo(myTag, test);
		System.out.println(share);
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