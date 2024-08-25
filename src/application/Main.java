package application;
	
import java.util.ArrayList;
import java.util.Arrays;

import Singletons.MainStorageHolder;
import Singletons.PercentageHolder;
import components.Graph;
import components.Post;
import components.Tag;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*; 
import javafx.scene.text.Text;
import javafx.stage.Stage;
import utilities.Builder;


public class Main extends Application {
	
	public void fetchL1Tag(int count,PercentageHolder percentage,Graph<Tag,Post> store,VBox newsFeed) {
		
		float percent = percentage.getLevel1Percentage().get(count).getPercent();
		
		if (percent >= 50) {
            System.out.println("A");
        }  else if (percent >= 30) {
            System.out.println("B");
       
        } else {
            System.out.println("F");
        }

		
		for(int i = 0; i < 2; i++) {
			 String level1Tag = percentage.getLevel1Percentage().get(count).getTag();
			 newsFeed.getChildren().add(createPost(store.getKey(level1Tag).get(i)));
		 }
		
	}
	
public void fetchFamousTag(int count,Graph<Tag,Post> store,VBox newsFeed) {
		
		
		
		

		
	for(int i = 0; i < 2; i++) {
		 String FamousTag = store.getTag().get(count).getTitle();
		 newsFeed.getChildren().add(createPost(store.getKey(FamousTag).get(i)));
	 }
		
	}
	
	
	 public void createFeed(VBox newsFeed) {
		 PercentageHolder percentage = PercentageHolder.getInstance();
		 Graph<Tag,Post> store = MainStorageHolder.getInstance().getMainStorage();
		 Builder builder = new Builder();
		 builder.build();
		 
		 
		 
		 fetchL1Tag(0,percentage,store,newsFeed);
		 fetchL1Tag(1,percentage,store,newsFeed);
		 
		 
		 fetchFamousTag(1,store,newsFeed);
		 fetchFamousTag(2,store,newsFeed);
		 
		 
	
		 
		 
//		 System.out.println(percentage.getLevel1Percentage().get(0).getTag());
//		 for (int i = 1; i <= 20; i++) {
//	            newsFeed.getChildren().add(createPost(new Post("Testing post", "Post caption","one", 1f, "speed")));
//	        }
//		 
		 
		 
	 }
	 
	 public void AddPerferenceL1(ArrayList<String> tag,PercentageHolder percentage) {
		 for(String t : tag)  percentage.addPercentage(1, t, 1);
	 }
	  @Override
	    public void start(Stage primaryStage) {
		  
		  //algorithm phase
		  PercentageHolder percentage = PercentageHolder.getInstance();
		  MainStorageHolder storage = MainStorageHolder.getInstance();
		  
		  
		  //
		  
		
	      AddPerferenceL1(new ArrayList<>(Arrays.asList("boy","young","student")),percentage);
	      
	     
		  
	        // Main container (VBox)
	        VBox newsFeed = new VBox(10);
	        newsFeed.setPadding(new Insets(10));
	        
	        
	        // Adding sample posts
	        createFeed(newsFeed);
	        

	        // ScrollPane for scrolling the feed
	        ScrollPane scrollPane = new ScrollPane(newsFeed);
	        scrollPane.setFitToWidth(true);

	        // Navigation Buttons
	        Button nextButton = new Button("Next Feed");
	        
	        
	        nextButton.setOnAction(new EventHandler<ActionEvent>() {
	        	
	            @Override
	            public void handle(ActionEvent event) {
	            	newsFeed.getChildren().clear();
//	            	AddPerferenceL1(new ArrayList<>(Arrays.asList("boy","student","student")),percentage);
	            	createFeed(newsFeed);
	            }
	        });
	      

	        HBox navButtons = new HBox(10, nextButton);
	        navButtons.setPadding(new Insets(10));

	        VBox mainLayout = new VBox(scrollPane, navButtons);

	        Scene scene = new Scene(mainLayout, 600, 800);
	        primaryStage.setScene(scene);
	        primaryStage.setTitle("Social Media Newsfeed");
	        primaryStage.show();
	        
	        
	      
	        
	      
	       
	    }
	  
	  
	

	    // Method to create a post
	    private VBox createPost(Post post) {
	    	
	        
	        
	        
	        
	        //test to take out three post from graph;
	        
	        VBox main = new VBox(5);
	        float plusLike = (float)1e-10;
	        float plusComment = (float)1e-10;
	        PercentageHolder percentage = PercentageHolder.getInstance();
	        float unlike = 1;
	        main.setPadding(new Insets(10));
	        main.setStyle("-fx-border-color: lightgrey; -fx-border-width: 1px; -fx-background-color: #f9f9f9;");

	        // Title
	        
	        Text titleLabel = new Text(post.getTitle());
	        titleLabel.setStyle("-fx-font-size: 16px; -fx-font-weight: bold;");

	        // Image/Video placeholder
//	        ImageView imageView = new ImageView(new Image("https://via.placeholder.com/500x300.png?text=Media"));
	        
	        //In case the starting time took to long in your machine. It took too long because of the https link;
	        Image image = new Image(getClass().getResourceAsStream("datachef_sample_comic (1).png"));
	        ImageView imageView = new ImageView(image);
	        imageView.setFitWidth(500);
	        imageView.setFitHeight(300);

	        // Content Text
	        Text contentLabel = new Text(post.getCaption());

	        // Hashtags and Tags (simple text for example purposes)
	        Text hashtags = new Text("#ExampleHashtag #JavaFX");
	        Text tags = new Text("Tagged: @User1 @User2");

	        // Reactions and Comments
	        HBox reactions = new HBox(10);
	        Button likeButton = new Button("Like");
	        Button unlikeButton = new Button("Unlike");
	        Button commentButton = new Button("Comment");
	        reactions.getChildren().addAll(likeButton, unlikeButton, commentButton);
	        
	        
	        likeButton.setOnAction(new EventHandler<ActionEvent>() {
	            private boolean isRed = false; 
	            

				@Override
	            public void handle(ActionEvent event) {
					System.out.println(event);
	            	 if (isRed) {
	                     likeButton.setStyle(""); // none
	                 } else {
	                     likeButton.setStyle("-fx-background-color: #FF0000;"); // Red color
	                 }
	                 
	                 // Toggle the state
	                 isRed = !isRed;
	                 
	                 float curretPriority = post.getPriority();
	                 System.out.println(post.getL1Tags());
	                 

	                 // Print a message to the console
	                 post.setPriority(curretPriority + plusLike);
	                 System.out.println(post.getPriority());
	                 
	                 
	                 for(String tag : post.getL1Tags()) {
	                	 percentage.addPercentage(1, tag, 1);
	                 }
	                 
	                 percentage.printLevel1Percentage();
	            }
	        });
	        
	        
	        //Interaction part
	        
	        unlikeButton.setOnAction(new EventHandler<ActionEvent>() {
	        	private boolean isRed = false;
	            @Override
	            public void handle(ActionEvent event) {
	            	if (isRed) {
	                     unlikeButton.setStyle(""); // none
	                 } else {
	                     unlikeButton.setStyle("-fx-background-color: #FF0000;"); // Red color
	                 }
	                 
	                 // Toggle the state
	                 isRed = !isRed;
	                 
	                 float curretPriority = post.getPriority();
	                 System.out.println(curretPriority);
	                 

	                 // Print a message to the console
	                 post.setPriority(curretPriority - unlike);
	                 System.out.println(post.getPriority());
	            }
	        });
	        
	        commentButton.setOnAction(new EventHandler<ActionEvent>() {
	        	private boolean isRed = false;
	            @Override
	            public void handle(ActionEvent event) {
	            	
	            	if (isRed) {
	                     commentButton.setStyle(""); // none
	                 } else {
	                     commentButton.setStyle("-fx-background-color: #FF0000;"); // Red color
	                 }
	                 
	                 // Toggle the state
	                 isRed = !isRed;
	                 
	                 float curretPriority = post.getPriority();
	                 System.out.println(curretPriority);
	                 

	                 // Print a message to the console
	                 post.setPriority(curretPriority + plusComment);
	                 System.out.println(post.getPriority());
	            }
	        });

	        // Adding elements to the post
	        main.getChildren().addAll(titleLabel, imageView, contentLabel, hashtags, tags, reactions);

	        return main;
	    }

	    public static void main(String[] args) {
	        launch(args);
	    }
}
