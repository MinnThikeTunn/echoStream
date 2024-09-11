/*
	This Class is used for Storing the Percentage of each interactions the user made.
 */

package components;

import java.util.*;





public class Percentage implements Comparable<Percentage>  {

    private String tag;
    private float percent;
    private int occurance;
//	private int tagId;
	
	
	
	public Percentage(String tag, float percent)  {
	    this.tag = tag;
	    this.percent = percent;
	    occurance = 0;
	}
	
	public float getPercent() {
		return percent;
	}
	
	public void setPercent(float percent) {
		this.percent = percent;
	}
	
	public String getTag() {
		return tag;
	}
	
	public void addOccurance(int val) {
		occurance += val;
	}
	
	public int getOccurance() {
		return occurance;
	}
	
	
	
	 // Parameterized constructor

	
	
	
	@Override
	public boolean equals(Object o) {
	    if (this == o) return true;
	    if (o == null || getClass() != o.getClass()) return false;
	    Percentage other = (Percentage) o;  // Change to 'other'
	    return Objects.equals(percent, other.percent);  // Compare 'this.tag' with 'other.tag'
	}

	@Override
	public int hashCode() {
	    return Objects.hash(tag);
	}
	

	public int compareTo(Percentage o) {
		// You were comparing based on occurance. Change this to percent if you want it ordered by percentage.
		int comparison = Float.compare(o.percent, this.percent); // Compare by percent (descending order)
	    
	    // If the percentages are equal, compare by another field, e.g., `occurance` (optional)
	    if (comparison == 0) {
	        comparison = Integer.compare(o.occurance, this.occurance); // Second comparison criterion (e.g., by occurance)
	    }
	    
	    return comparison; // Descending order by percent
	}

    

	

}
