package phaseTwo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Singletons.MainStorageHolder;
import Singletons.UserGraphHolder;
import components.Graph;
import components.Post;
import components.Tag;
import components.User;

public class PhaseTwo {

	private static List<String> alternativeInterests = new ArrayList<>();
    private static List<Post> sharedPosts = new ArrayList<>();
    private static boolean hasMorePosts = true;
    private static int lastProcessedUserIndex = 0;
    private static String lastTag = "";
    private static List<String> ageGroups = new ArrayList<>(Arrays.asList("teen","youngAdult","adult","middleAgedAdult","olderAdult"));
    private static List<String> genders = new ArrayList<>(Arrays.asList("male", "female"));
    private static List<String> professions = new ArrayList<>(Arrays.asList("student", "freelancer", "retiredIndividual", "WebDev", "Actor", "workingProfessional"));
    private static List<String> interests = new ArrayList<>(Arrays.asList("art", "gaming", "animals", "food", "anime", "cars", "technology", "sports", "education", "entertainment"));
    

	public static void main(String[] args) {
//		UserGraph userGraph = new UserGraph();
//		List<User> users = generateUserList();
//		String myTag = users.get(0).getUserTagString();
		Graph<Tag, Post> availablePosts = MainStorageHolder.getInstance().getMainStorage();

        String[] myTag = {interests.get(0), professions.get(0), ageGroups.get(0), genders.get(0)};
        User hostUser = new User(myTag, new ArrayList<>());
        
        
        int userCountLimit = 20;
//
//		for (User user : users) {
//   			 userGraph.addUser(user);
//		}
//
//		userGraph.showGraph();
		UserGraph test = UserGraphHolder.getInstance().getUserGraph();
		
		
		
            phaseTwo(hostUser, test, userCountLimit);
        
	
	}

	public static List<Post> phaseTwo(User host, UserGraph userGraph, int userCountLimit) {
//		List<User> users = userGraph.getUsersByTag(myTag);
//		List<Post> sharedPosts = new ArrayList<>();
//
//		for (User u : users) {
//    			u.sharePosts(sharedPosts);
//    			if(sharedPosts.size() >= 20) 
//    			{
//    				break;
//    			}
//		}
//		int c = 0;
//		for (Post p : sharedPosts) {
//   		 System.out.println(c++ + p.getCaption());
//		}
//		return sharedPosts;
		
		alternativeInterests.clear();
        alternativeInterests.addAll(interests);

        if (!lastTag.equals(host.getUserTagString())) {
            lastProcessedUserIndex = 0;
        }

        sharedPosts.clear();
        String[] userPreferences = host.getUserTags();
        hasMorePosts = true;

        while (hasMorePosts) {
            String tag = String.join("", userPreferences);
            List<User> users = userGraph.getUsersByTag(tag);

            for (int i = lastProcessedUserIndex; i < users.size(); i++) {
                User user = users.get(i);
                user.sharePosts(sharedPosts);
                if (sharedPosts.size() >= userCountLimit) {
                    lastProcessedUserIndex = i; // Update the last processed index
                    hasMorePosts = false;
                    int index = 0;
                    for (Post post : sharedPosts) {
                        System.out.println(index++ + ": " + post.getTitle() + " " + post.getCaption() + " " + post.getShare());
                    }
                    return sharedPosts;
                }
            }

            if (sharedPosts.size() < userCountLimit && alternativeInterests.size() > 1) {
                alternativeInterests.remove(userPreferences[0]);
                userPreferences[0] = getRandomElement(alternativeInterests);
            } else {
                break;
            }
        }
       
        
        return sharedPosts;
	}

	
	 private static <T> T getRandomElement(List<T> list) {
	        return list.get((int) (Math.random() * list.size()));
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