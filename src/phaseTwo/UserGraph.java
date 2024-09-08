package phaseTwo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import components.User;

public class UserGraph {

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
