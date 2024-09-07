package application;
	
import java.util.ArrayList;
import java.util.Arrays;

import Singletons.AuthorHolder;
import Singletons.DupliHolder;
import Singletons.FavoriteAuthorHolder;
import Singletons.MainStorageHolder;
import Singletons.PercentageHolder;
import Singletons.TagPriorityHolder;
import components.Graph;
import components.Percentage;
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
	
	public void fetchAuthenTag(int count, PercentageHolder percentage, Graph<Tag, Post> store, VBox newsFeed) {
	    float percent = percentage.getAuthenPercentage().get(count).getPercent();
	    int number = 0;

	    if (percent >= 50) {
	        number = 3;
	    } else if (percent >= 30) {
	        number = 2;
	    } else {
	        number = 1;
	    }

	    // Fetch posts based on the calculated number
	    while (number > 0) {
	        // Calculate the index to fetch the tag
	        int index = number - 1;
	        String authenTag = percentage.getAuthenPercentage().get(count).getTag();
	        
	        // Check if the store has the key and if it has enough elements
	        if (store.getKey(authenTag).size() > index) {
	            // Add the post to the newsFeed
	            newsFeed.getChildren().add(createPost(store.getKey(authenTag).get(index)));
	        } else {
	            // Exit the loop if there's not enough data for the current index
	            break;
	        }
	        
	        // Move to the next index
	        number--;
	    }
	}
	
	
	
	
	
	


public void tagfetch(ArrayList<Percentage> levelpercent,PercentageHolder percentage,Graph<Tag,Post> store,ArrayList<Post> feeds,ArrayList<Percentage> tagLevel) {
	int number = 0;
	DupliHolder dupli = DupliHolder.getInstance();
	
	 for(int i = 0; i < levelpercent.size()/2; i++) {
		 float percent = levelpercent.get(i).getPercent();
		 int finish = 0;
	 
		 if (percent >= 50) {
		        number = 3;
		    } else if (percent >= 30) {
		        number = 2;
		    } else {
		        number = 1;
		    }
		 
		 while(number > finish) {
			 
		       String LevelTag = tagLevel.get(i).getTag();
		        
		        // Check if the store has the key and if it has enough elements
		        if (store.getKey(LevelTag).size() > 0 && finish <= store.getKey(LevelTag).size() - 1) {
		            // Add the post to the newsFeed
		        	if (!dupli.getdupliTags().contains(store.getKey(LevelTag).get(finish).getTitle())) {
		        		if(store.getKey(LevelTag).get(finish).getBlind() == 0) {
		        			feeds.add(store.getKey(LevelTag).get(finish));
		        			store.getKey(LevelTag).get(finish).plusBlind();
		        		} else {
		        			store.getKey(LevelTag).get(finish).minusBlindPerOne();
		        			number++;
		        		}
		        		dupli.addDupliTags(store.getKey(LevelTag).get(finish).getTitle());
		        	}
		        	finish++;
		            
		        } else {
		            // Exit the loop if there's not enough data for the current index
		            break;
		        }
		        
		        // Move to the next index
		        
//		        if (!dupli.getdupliTags().contains(manipulate.getTitle())) {
//			    	System.out.println(manipulate.getBlind());
//			    	if(manipulate.getBlind() == 0) {
//			    		feeds2.add(manipulate);
//			    		manipulate.plusBlind();
//			    	} else {
//			    		manipulate.minusBlindPerOne();
//			    		number++;
//			    	}
//			        
//			        dupli.addDupliTags(manipulate.getTitle());
//			       
//			    }
		        finish++;
		 
		 
		 
	 }
}
}

public void popularFetch(ArrayList<Post> feeds,Graph<Tag,Post> store,ArrayList<Post> feeds2) {
	// TODO Auto-generated method stub
	int number = (20 - feeds.size())/4;
	DupliHolder dupli = DupliHolder.getInstance();
	
	for(int i = 0; i < 2; i++) { 
		String FamousTag = store.getTag().get(i).getTitle();
		 
		int j = 0;
		while (j < number && store.getKey(FamousTag).size() > 0 && j <= store.getKey(FamousTag).size() - 1) {
		    // Add the post to the newsFeed
		    Post manipulate = store.getKey(FamousTag).get(j);
		    if (!dupli.getdupliTags().contains(manipulate.getTitle())) {
		    	System.out.println(manipulate.getBlind());
		    	if(manipulate.getBlind() == 0) {
		    		feeds2.add(manipulate);
		    		manipulate.plusBlind();
		    	} else {
		    		manipulate.minusBlindPerOne();
		    		number++;
		    	}
		        
		        dupli.addDupliTags(manipulate.getTitle());
		       
		    }
		    
		    j++;
		}
		
	}
		
        
        // Check if the store has the key and if it has enough elements
        
}

public void appenFetch(ArrayList<Post> feeds,Graph<Tag,Post> store,ArrayList<Post> feeds2,PercentageHolder percentage) {
	// TODO Auto-generated method stub
	int number = (20 - feeds.size())/4;
	DupliHolder dupli = DupliHolder.getInstance();
	
	for(int i = 0; i < 2; i++) { 
		String appenTag = percentage.getAuthenPercentage().get(i).getTag();
		 
		int j = 0;
		while (j < number) {
			
		    if (store.getKey(appenTag).size() > 0 && j <= store.getKey(appenTag).size() - 1) {
		        Post manipulate = store.getKey(appenTag).get(j);

		        // Check if the post is already in feeds2
		        System.out.println(dupli.getdupliTags());
		        if (!dupli.getdupliTags().contains(manipulate.getTitle())) {
		            // Add the post to feeds2 if it's not already present
		        	if(manipulate.getBlind() == 0) {
		        		feeds2.add(manipulate);
			    		manipulate.plusBlind();
			    	} else {
			    		manipulate.minusBlindPerOne();
			    		number++;
			    	}
			        
			        dupli.addDupliTags(manipulate.getTitle());
		            
		        }

		        j++; // Increment the index after processing the current element
		    } else {
		        // Exit the loop if there's not enough data for the current index
		        break;
		    }
		}
		
		System.out.println(store.toString());
		FavoriteAuthorHolder author = FavoriteAuthorHolder.getInstance();
		AuthorHolder au = AuthorHolder.getInstance();
		
//		author.outPut();
//		for(int z = 0; z < 2; z++) {
//			feeds2.add(au.getAuthorPosts(author.getAuthor()).get(z));
//		}
		
		
//		System.out.println(au.toString());
//		System.out.println(author.getAuthor());
	}
		
        
        // Check if the store has the key and if it has enough elements
        
}



 public void fetchFromtags(PercentageHolder percentage,Graph<Tag,Post> store,ArrayList<Post> feeds) {
	 ArrayList<Percentage> l3percent = percentage.getLevel3Percentage();
	 ArrayList<Percentage> l2percent = percentage.getLevel2Percentage();
	 ArrayList<Percentage> l1percent = percentage.getLevel1Percentage();
	 
	tagfetch(l3percent,percentage,store,feeds,percentage.getLevel3Percentage());
	tagfetch(l2percent,percentage,store,feeds,percentage.getLevel2Percentage());
	tagfetch(l1percent,percentage,store,feeds,percentage.getLevel1Percentage());
	
	 
	
	 
	 System.out.println(feeds);
	 
	 
//	    int number = 0;
//
//	    if (percent >= 50) {
//	        number = 3;
//	    } else if (percent >= 30) {
//	        number = 2;
//	    } else {
//	        number = 1;
//	    }
 }
	
	
	

	public void createFeed(VBox newsFeed) {
		 PercentageHolder percentage = PercentageHolder.getInstance();
		 Graph<Tag,Post> store = MainStorageHolder.getInstance().getMainStorage();
		 Builder builder = new Builder();
		 ArrayList<Post> feeds = new ArrayList<>();
		 ArrayList<Post> feeds2 = new ArrayList<>();
		 
		 if(store.getVertexCount() == 0) {
			 builder.build();
		 }
		 
		 
		 
		 fetchFromtags(percentage,store,feeds);
		 popularFetch(feeds,store,feeds2);
		 appenFetch(feeds,store,feeds2,percentage);
		 for(Post feed: feeds) {
			 newsFeed.getChildren().add(createPost(feed));
		 }
		 
		 for(Post feed: feeds2) {
			 newsFeed.getChildren().add(createPost(feed));
		 }
//		 fetchAuthenTag(0,percentage,store,newsFeed);
//		 fetchAuthenTag(1,percentage,store,newsFeed);
		 
		 
//		 fetchFamousTag(1,store,newsFeed);
//		 fetchFamousTag(2,store,newsFeed);
		 
		 
	
		 
		 
//		 System.out.println(percentage.getLevel1Percentage().get(0).getTag());
//		 for (int i = 1; i <= 20; i++) {
//	            newsFeed.getChildren().add(createPost(new Post("Testing post", "Post caption","one", 1f, "speed")));
//	        }
//		 
		 
		 
	 }
	 
	 public void AuthFetch(PercentageHolder percentage,Graph<Tag,Post> store,VBox newsFeed) {
		 int number = 10;
		 Builder builder = new Builder();
		 builder.build();
		 ArrayList<Post> feeds = new ArrayList<>();
		 ArrayList<Percentage> authenpercent = percentage.getAuthenPercentage();
		 int finish = number/authenpercent.size();
		 for(int i = 0; i < authenpercent.size(); i++) {
			 String LevelTag = authenpercent.get(i).getTag();
			 for(int j = 0; j < finish; j++) {
				 if (store.getKey(LevelTag).size() > 0 && finish <= store.getKey(LevelTag).size() - 1) {
			            // Add the post to the newsFeed
					 if (!feeds.contains(store.getKey(LevelTag).get(j))) {
						 feeds.add(store.getKey(LevelTag).get(j));
					 }
			            
			        } else {
			            // Exit the loop if there's not enough data for the current index
			            break;
			        }
			 }
		 }
		 
		 for(Post feed: feeds) {
			 newsFeed.getChildren().add(createPost(feed));
		 }
		 
		 
		 
		 
		 
	 
		 
	 }
	 
	 public void AddPerferenceAuthen(ArrayList<String> tag,PercentageHolder percentage,Graph<Tag,Post> store,VBox newsFeed) {
		 for(String t : tag)  percentage.addPercentage(4, t, 1);
		 AuthFetch(percentage,store,newsFeed);
//		 fetchAuthenTag(0,percentage,store,newsFeed);
//		 fetchAuthenTag(1,percentage,store,newsFeed);
	 }
	  @Override
	    public void start(Stage primaryStage) {
		  
		  //algorithm phase
		  PercentageHolder percentage = PercentageHolder.getInstance();
		  MainStorageHolder storage = MainStorageHolder.getInstance();
		  Graph<Tag,Post> store = MainStorageHolder.getInstance().getMainStorage();
		  VBox newsFeed = new VBox(10);
		  
		  //
		  
		
	      AddPerferenceAuthen(new ArrayList<>(Arrays.asList("girl","boy","young")),percentage,store,newsFeed);
	      
	     
		  
	        // Main container (VBox)
	       
	        newsFeed.setPadding(new Insets(10));
	        
	        
	        // Adding sample posts
//	        createFeed(newsFeed);
	        

	        // ScrollPane for scrolling the feed
	        ScrollPane scrollPane = new ScrollPane(newsFeed);
	        scrollPane.setFitToWidth(true);

	        // Navigation Buttons
	        Button nextButton = new Button("Next Feed");
	        
	        
	        nextButton.setOnAction(new EventHandler<ActionEvent>() {
	        	
	            @Override
	            public void handle(ActionEvent event) {
	            	DupliHolder dupli = DupliHolder.getInstance();
	            	newsFeed.getChildren().clear();
	            	dupli.clearDupliTags();
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
//	        float plusLike = (float)1e-10;
	        float plusLike = 1;
	        float plusComment = (float)5e-10;
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
	            MainStorageHolder holder = MainStorageHolder.getInstance();
	            TagPriorityHolder tagPriority = TagPriorityHolder.getInstance();
	            FavoriteAuthorHolder author = FavoriteAuthorHolder.getInstance();

				@Override
	            public void handle(ActionEvent event) {
				
	            	 if (isRed) {
	                     likeButton.setStyle(""); // none
	                 } else {
	                     likeButton.setStyle("-fx-background-color: #FF0000;"); // Red color
	                 }
	                 
	                 // Toggle the state
	                 isRed = !isRed;
	                 
	                 float curretPriority = post.getPriority();
	                 ArrayList<String> currentTagL1Priority = post.getL1Tags();
	                 ArrayList<String> currentTagL2Priority = post.getL2Tags();
	                 ArrayList<String> currentTagPriority = post.getTags();
	                 
	                 for(String tag: currentTagL1Priority) {
	                	 holder.getMainStorage().setTagPopularity(new Tag(tag),tagPriority.getTagPriority(tag) + plusLike);
	                	
	                	 holder.getMainStorage().setPriority(new Tag(tag,TagPriorityHolder.getInstance().getTagPriority(tag)), post.getTitle(), curretPriority + plusLike);

	                	 
	                	 percentage.addPercentage(1, tag, 1);
	                
	                 }
	                 
	                 for(String tag: currentTagL2Priority) {
	                	 holder.getMainStorage().setTagPopularity(new Tag(tag),tagPriority.getTagPriority(tag) + plusLike);
	                	 
	                	 holder.getMainStorage().setPriority(new Tag(tag,TagPriorityHolder.getInstance().getTagPriority(tag)), post.getTitle(), curretPriority + plusLike);

	                	 percentage.addPercentage(2, tag, 1);
	                
	                 }
	                 
	                 for(String tag: currentTagPriority) {
	                	 holder.getMainStorage().setTagPopularity(new Tag(tag),tagPriority.getTagPriority(tag) + plusLike);
	                	 holder.getMainStorage().setPriority(new Tag(tag,TagPriorityHolder.getInstance().getTagPriority(tag)), post.getTitle(), curretPriority + plusLike);

	                	 percentage.addPercentage(3, tag, 1);                	 
	                 }
	                 
	                 author.addAuthor(post.getAuthor());
	                 
//	                 System.out.println(holder.getMainStorage().toString());
//	                 System.out.println("level 1 tag is" + post.getL1Tags());
//	                 System.out.println("level 1 tag is" + post.getL2Tags());
//	                
	                 

	                 // Print a message to the console
//	                 System.out.println(post.getTitle());
//	                
//
//	                 post.setPriority(curretPriority + plusLike);
//	                 System.out.println(post.getPriority());
//	                 MainStorageHolder.getInstance().getMainStorage().setPriority(new Tag("young",TagPriorityHolder.getInstance().getTagPriority("young")), "real real", 100f);

	                 
	                
	                 
	                 percentage.printLevel2Percentage();
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
	            MainStorageHolder holder = MainStorageHolder.getInstance();
	            TagPriorityHolder tagPriority = TagPriorityHolder.getInstance();
	            FavoriteAuthorHolder author = FavoriteAuthorHolder.getInstance();
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
	                 ArrayList<String> currentTagL1Priority = post.getL1Tags();
	                 ArrayList<String> currentTagL2Priority = post.getL2Tags();
	                 ArrayList<String> currentTagPriority = post.getTags();
	                 
	                 for(String tag: currentTagL1Priority) {
	                	 holder.getMainStorage().setTagPopularity(new Tag(tag),tagPriority.getTagPriority(tag) + plusComment);
	                	
	                	 holder.getMainStorage().setPriority(new Tag(tag,TagPriorityHolder.getInstance().getTagPriority(tag)), post.getTitle(), curretPriority + plusComment);

	                	 
	                	 percentage.addPercentage(1, tag, 2);
	                
	                 }
	                 
	                 for(String tag: currentTagL2Priority) {
	                	 holder.getMainStorage().setTagPopularity(new Tag(tag),tagPriority.getTagPriority(tag) + plusComment);
	                	 
	                	 holder.getMainStorage().setPriority(new Tag(tag,TagPriorityHolder.getInstance().getTagPriority(tag)), post.getTitle(), curretPriority + plusComment);

	                	 percentage.addPercentage(2, tag, 2);
	                
	                 }
	                 
	                 for(String tag: currentTagPriority) {
	                	 holder.getMainStorage().setTagPopularity(new Tag(tag),tagPriority.getTagPriority(tag) + plusComment);
	                	 holder.getMainStorage().setPriority(new Tag(tag,TagPriorityHolder.getInstance().getTagPriority(tag)), post.getTitle(), curretPriority + plusComment);

	                	 percentage.addPercentage(3, tag, 2);                	 
	                 }
	                 author.addAuthor(post.getAuthor());
	                 System.out.println(holder.getMainStorage().toString());
//	                 System.out.println("level 1 tag is" + post.getL1Tags());
//	                 System.out.println("level 1 tag is" + post.getL2Tags());
//	                
	                 

	                 // Print a message to the console
//	                 System.out.println(post.getTitle());
//	                
//
//	                 post.setPriority(curretPriority + plusLike);
//	                 System.out.println(post.getPriority());
//	                 MainStorageHolder.getInstance().getMainStorage().setPriority(new Tag("young",TagPriorityHolder.getInstance().getTagPriority("young")), "real real", 100f);

	                 
	                
	                 
	                 percentage.printLevel2Percentage();
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
