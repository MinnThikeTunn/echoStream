package Singletons;

import java.util.ArrayList;
import java.util.List;

import components.Author;

public class FavoriteAuthorHolder {
    private static FavoriteAuthorHolder instance;
    private List<Author> authors;

    private FavoriteAuthorHolder() {
        authors = new ArrayList<>();
    } // Private constructor

    public static synchronized FavoriteAuthorHolder getInstance() {
        if (instance == null) {
            instance = new FavoriteAuthorHolder();
        }
        return instance;
    }

    public String getAuthor() {
        if (authors.isEmpty()) {
            return null; // Handle case where no authors exist
        }
        // Return the first author (highest occurrence) by sorting temporarily
        return authors.get(0).getAuthor();
    }
    
    
    public String getAuthor2() {
        // Check if the list is empty or has less than 2 elements
        if (authors.isEmpty() || authors.size() < 2) {
            return null; // Handle case where there aren't enough authors
        }
        // Return the second author (authors are 0-indexed)
        return authors.get(authors.size() - 1).getAuthor();
    }


    public void addAuthor(String author) {
        boolean found = false;
        for (Author main : authors) {
            if (main.getAuthor().equals(author)) {
                main.AddOccurance();
                found = true;
                break;
            }
        }

        if (!found) {
            // Add the new author at the end of the list
            authors.add(new Author(author));
        }
    }

    public void outPut() {
        for (Author v : authors) {
            System.out.println("Author = " + v.getAuthor() + " Occurance = " + v.getOccurance());
        }
    }
}
