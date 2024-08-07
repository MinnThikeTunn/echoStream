package interfaces;

import java.util.ArrayList;

public interface HasPost {
	String getTitle();
	String getCaption();
	String getHashTag();
	float getPriority();
	void setPriority(float newPriority);
	ArrayList<String> getTags();

}
