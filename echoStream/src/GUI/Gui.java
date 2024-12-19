package GUI;
import phaseOne.Phase1;

import javax.swing.*;

import components.Post;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Gui extends JFrame {
 static final long serialVersionUID = 6536891361170925993L;
	private int currentPage = 1;
    private final int postsPerPage = 20;
    private ArrayList<Post> posts;
    private JPanel postsPanel;
    private JScrollPane scrollPane;

    public Gui() {
        setTitle("Social Media App");
        setSize(600, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        Phase1 tempo = new Phase1();
        
        posts = tempo.getRawTempoData();

//        posts = new ArrayList<>();
//      
//        for (int i = 1; i <= 50; i++) {
//            posts.add(new Post("Post " + i, "Caption for post " + i, "HashTag" + i));
//        }

        postsPanel = new JPanel();
        postsPanel.setLayout(new BoxLayout(postsPanel, BoxLayout.Y_AXIS));
        scrollPane = new JScrollPane(postsPanel);

        loadPosts();

        JPanel buttonPanel = new JPanel();
        JButton prevButton = new JButton("Previous");
        JButton nextButton = new JButton("Next");
        prevButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (currentPage > 1) {
                    currentPage--;
                    loadPosts();
                }
            }
        });
        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (currentPage < (posts.size() / postsPerPage)) {
                    currentPage++;
                    loadPosts();
                }
            }
        });
        buttonPanel.add(prevButton);
        buttonPanel.add(nextButton);

        add(scrollPane, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    private void loadPosts() {
        postsPanel.removeAll();
        int start = (currentPage - 1) * postsPerPage;
        int end = Math.min(start + postsPerPage, posts.size());
        for (int i = start; i < end; i++) {
            postsPanel.add(posts.get(i).getPostPanel());
        }
        postsPanel.revalidate();
        postsPanel.repaint();
    }
    
   
    

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Gui().setVisible(true);
            }
        });
    }

    
}