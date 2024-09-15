package phaseTwo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import components.User;

public class UserGraph {

	private final Map<String, List<User>> userGraph = new HashMap<>();
	private static List<String> ageGroups = new ArrayList<>(Arrays.asList("teen","youngAdult","adult","middleAgedAdult","olderAdult"));
    private static List<String> genders = new ArrayList<>(Arrays.asList("male", "female"));
    private static List<String> professions = new ArrayList<>(Arrays.asList("student", "freelancer", "retiredIndividual", "WebDev", "Actor", "workingProfessional"));
    private static List<String> interests = new ArrayList<>(Arrays.asList("art", "gaming", "animals", "food", "anime", "cars", "technology", "sports", "education", "entertainment"));
    

    public void addUser(User user) {
        String key = user.getUserTagString();
        userGraph.computeIfAbsent(key, k -> {
            addTagsToLists(user.getUserTags());
            return new ArrayList<>();
        }).add(user);
    }

    private void addTagsToLists(String[] userTags) {
        updateTagList(interests, userTags[0]);
        updateTagList(professions, userTags[1]);
        updateTagList(ageGroups, userTags[2]);
        updateTagList(genders, userTags[3]);
    }

    private void updateTagList(List<String> tagList, String tag) {
        if (!tagList.contains(tag)) {
            tagList.add(tag);
        }
    }


	public List<User> getUsersByTag(String tag) {
		return userGraph.getOrDefault(tag, new ArrayList<>());
	}

}
