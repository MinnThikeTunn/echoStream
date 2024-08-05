package components;

import java.util.HashMap;

//import interfaces.HasPopularity;

public class popularityHolder  {
	private static HashMap<String, Float> map = new HashMap<>();
	
	
	public popularityHolder() {
//		float popularity = 1f;
//		 if (map.containsKey(tag)) {
//			 	map.put(tag, popularity);
//	        } 
	
		
	}
	
	
	public float getPopularity(String tag) {
		return map.get(tag);
	}
	
	
	public void  setPopularity(String tag,float popularity) {
		 if (!map.containsKey(tag)) {
			 	map.put(tag, popularity);
	        } 
	}
	
	
	public static void main(String args[]) {
	}

	
	
	
}
