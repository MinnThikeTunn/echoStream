package components;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import interfaces.HasPost;

public class Post implements HasPost, Comparable<Post> {
	 private String title;
     private String caption;
     private String hashTag;
     private int likes;
     private int unlikes;
     private int comments;
     private float priority;

     public Post(String title, String caption, String hashTag,float priority) {
         this.title = title;
         this.caption = caption;
         this.hashTag = hashTag;
         this.priority = priority;
         this.likes = 0;
         this.unlikes = 0;
         this.comments = 0;
     }
     
     @Override
     public void setPriority(float newPriority) {
         this.priority = newPriority;
     }
     
     @Override
     public boolean equals(Object o) {
         if (this == o) return true;
         if (o == null || getClass() != o.getClass()) return false;
         Post post = (Post) o;
         return Float.compare(post.priority, priority) == 0 &&
                 title.equals(post.title);
     }

     @Override
     public int hashCode() {
         return Objects.hash(title, priority);
     }
     public String getTitle() {
    	 return this.title;
     }
     
     public String getCaption() {
    	 return this.caption;
     }
     
     public String getHashTag() {
    	 return this.hashTag;
     }
     
 
     public float getPriority() {
         return this.priority;
     }

     
     //UI part
     public JPanel getPostPanel() {
         JPanel postPanel = new JPanel();
         postPanel.setLayout(new BoxLayout(postPanel, BoxLayout.Y_AXIS));
         postPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
         postPanel.setPreferredSize(new Dimension(550, 100));

         JLabel titleLabel = new JLabel(title);
         JLabel captionLabel = new JLabel(caption);
         JLabel hashTagLabel = new JLabel(hashTag);
         JButton likeButton = new JButton("Like (" + likes + ")");
         JButton unlikeButton = new JButton("Unlike (" + unlikes + ")");
         JButton commentButton = new JButton("Comment (" + comments + ")");

         likeButton.addActionListener(new ActionListener() {

			@Override
             public void actionPerformed(ActionEvent e) {
                 likes++;
                 likeButton.setText("Like (" + likes + ")");
             }
         });
         

unlikeButton.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
                 unlikes++;
                 unlikeButton.setText("Unlike (" + unlikes + ")");
                 
             }
         });

         commentButton.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
                 comments++;
                 commentButton.setText("Comment (" + comments + ")");
             }
         });

         postPanel.add(titleLabel);
         postPanel.add(captionLabel);
         postPanel.add(hashTagLabel);
         postPanel.add(likeButton);
         postPanel.add(unlikeButton);
         postPanel.add(commentButton);

         return postPanel;
     }

	@Override
	public int compareTo(Post o) {
		// TODO Auto-generated method stub
		return Float.compare(o.priority, this.priority);
	}




}
