package components;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Singletons.TagPriorityHolder;
import interfaces.HasPost;

public class Author implements Comparable<Author> {
	private String author; 
	private int occurance;

     public Author(String author) {
         this.author = author;
         this.occurance = 0;
     }
     
 
     public void AddOccurance() {
         this.occurance++;
     }
     
     public String getAuthor() {
         return author;
     }
     
     public float getOccurance() {
         return occurance;
     }
     
     
     
     @Override
     public boolean equals(Object o) {
         if (this == o) return true;
         if (o == null || getClass() != o.getClass()) return false;
         Author post = (Author) o;
         return author.equals(post.author);
     }

     @Override
     public int hashCode() {
         return Objects.hash(author, occurance);
     }
     
    
   

    

     
     
     
    
     
     
     
    
     
 
  
     
     
     


	@Override
	public int compareTo(Author o) {
		// TODO Auto-generated method stub
		return Float.compare(o.occurance, this.occurance);
	}




}
