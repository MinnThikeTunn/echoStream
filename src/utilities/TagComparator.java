package utilities;

import java.util.Comparator;
import interfaces.HasTag;

public class TagComparator<T extends HasTag> implements Comparator<T> {
    @Override
    public int compare(T t1, T t2) {
        // First compare by popularity
        int popularityComparison = Float.compare(t2.getPopularity(), t1.getPopularity());
        
        // If the popularity is the same, compare alphabetically by title
//        if (popularityComparison == 0) {
//            return t1.getTitle().compareTo(t2.getTitle());
//        }
        if (popularityComparison == 0) {
            return t1.getTitle().compareTo(t2.getTitle());
        }
        return popularityComparison;
    }
}
