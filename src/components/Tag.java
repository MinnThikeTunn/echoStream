package components;

import java.util.*;

import interfaces.HasTag;

public class Tag implements HasTag {
	public String title;
	private float popularity;
//	private int tagId;
	
	public Tag(String title) {
		this.title = title;
		this.popularity = 1f;

  }
	
	public Tag(String title, float popularity) {
	    this.title = title;
	    this.popularity = popularity;
	}
	
    public String getTitle() {
        return this.title;
    }
	
	public float getPopularity() {
		return popularity;
	}
	
	public void setPopularity(float newPriority) {
		this.popularity = newPriority;
		System.out.println("hi");
	}
	
	@Override
	public boolean equals(Object o) {
	    if (this == o) return true;
	    if (o == null || getClass() != o.getClass()) return false;
	    Tag tag = (Tag) o;
	    return Objects.equals(title, tag.title);
	}

	@Override
	public int hashCode() {
	    return Objects.hash(title);
	}

    
    // Comparator for popularity
    public static class PopularityComparator implements Comparator<Tag> {
        @Override
        public int compare(Tag t1, Tag t2) {
            return Float.compare(t1.getPopularity(), t2.getPopularity());
        }
    }
	

}
