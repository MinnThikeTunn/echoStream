package components;

import java.util.ArrayList;
import java.util.List;

public class User {
	
	private  String[] userTags;
	private  String userTagString;
	private  List<Post> activePosts;
	private final int userId;
	private static int userCount = 0;
	
	public User(String[] tags, List<Post> posts) {
		this.userId = userCount++;
		this.userTags = tags;
		this.userTagString = String.join("", tags);
		this.activePosts = posts;
	}
	
	public String getUserTagString() {
		return userTagString;
	}

	public int getUserId() {
		return userId;
	}
	
	public void sharePosts(List<Post> sharedPosts) {
	    int limit = Math.min(activePosts.size(), 4);
	    for (int i = 0; i < limit; i++) {
	        Post post = activePosts.get(i);
	        if (!post.isShared()) {
	            sharedPosts.add(post);
	            post.setShared(true);
	        }
	    }
	}

}

