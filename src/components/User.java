package components;


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
	        int postCount = 0;
	        for (Post post : activePosts) {
	            if (!post.getShare()) {
	                sharedPosts.add(post);
	                post.setShare();
	                if (++postCount == 3) {
	                    break;
	                }
	            } else {
	                post.setShare();
	            }
	        }
	    }

	    public String[] getUserTags() {
	        return userTags;
	    }

	    public void setUserTags(String[] userTags) {
	        this.userTags = userTags;
	        this.userTagString = String.join("", userTags); // Update the tag string when tags change
	    }

}