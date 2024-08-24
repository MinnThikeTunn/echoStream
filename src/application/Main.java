package application;
	
import Singletons.MainStorageHolder;
import Singletons.PercentageHolder;
import javafx.application.Application;
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
	
	
	 public void createFeed(VBox newsFeed) {
		 for (int i = 1; i <= 20; i++) {
	            newsFeed.getChildren().add(createPost("Post #" + i, "This is the content of post #" + i));
	        }
	 }
	  @Override
	    public void start(Stage primaryStage) {
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
	        Button prevButton = new Button("Previous Feed");

	        HBox navButtons = new HBox(10, prevButton, nextButton);
	        navButtons.setPadding(new Insets(10));

	        VBox mainLayout = new VBox(scrollPane, navButtons);

	        Scene scene = new Scene(mainLayout, 600, 800);
	        primaryStage.setScene(scene);
	        primaryStage.setTitle("Social Media Newsfeed");
	        primaryStage.show();
	        
	        
	        Builder builder = new Builder();
	        builder.build();
	        PercentageHolder holder = PercentageHolder.getInstance();
	      	MainStorageHolder graph = MainStorageHolder.getInstance();
	      	holder.addPercentage(1, "boy", 2);
	        holder.addPercentage(1, "student", 2);
	        
	       String level1Tag = holder.getLevel1Percentage().peek().getTag();
	       //Testing that choosing according to the popularity
	       System.out.println(graph.getMainStorage().getKey(level1Tag).get(0).getCaption());
	       
	    }
	  
	  
	

	    // Method to create a post
	    private VBox createPost(String title, String content) {
	    	
	        
	        
	        
	        
	        //test to take out three post from graph;
	        
	        VBox post = new VBox(5);
	        post.setPadding(new Insets(10));
	        post.setStyle("-fx-border-color: lightgrey; -fx-border-width: 1px; -fx-background-color: #f9f9f9;");

	        // Title
	        
	        Text titleLabel = new Text(title);
	        titleLabel.setStyle("-fx-font-size: 16px; -fx-font-weight: bold;");

	        // Image/Video placeholder
//	        ImageView imageView = new ImageView(new Image("https://via.placeholder.com/500x300.png?text=Media"));
	        
	        //In case the starting time took to long in your machine. It took too long because of the https link;
	        Image image = new Image(getClass().getResourceAsStream("datachef_sample_comic (1).png"));
	        ImageView imageView = new ImageView(image);
	        imageView.setFitWidth(500);
	        imageView.setFitHeight(300);

	        // Content Text
	        Text contentLabel = new Text(content);

	        // Hashtags and Tags (simple text for example purposes)
	        Text hashtags = new Text("#ExampleHashtag #JavaFX");
	        Text tags = new Text("Tagged: @User1 @User2");

	        // Reactions and Comments
	        HBox reactions = new HBox(10);
	        Button likeButton = new Button("Like");
	        Button unlikeButton = new Button("Unlike");
	        Button commentButton = new Button("Comment");
	        reactions.getChildren().addAll(likeButton, unlikeButton, commentButton);

	        // Adding elements to the post
	        post.getChildren().addAll(titleLabel, imageView, contentLabel, hashtags, tags, reactions);

	        return post;
	    }

	    public static void main(String[] args) {
	        launch(args);
	    }
}
