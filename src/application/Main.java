package application;
	
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import Singletons.AuthorHolder;
import Singletons.DupliHolder;
import Singletons.FavoriteAuthorHolder;
import Singletons.MainStorageHolder;
import Singletons.PercentageHolder;
import Singletons.TagPriorityHolder;
import Singletons.UserGraphHolder;
import components.Graph;
import components.Percentage;
import components.Post;
import components.Tag;
import components.User;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import phaseTwo.PhaseTwo;
import phaseTwo.UserGraph;
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
	
	 for(int i = 0; i < levelpercent.size(); i++) {
		 float percent = levelpercent.get(i).getPercent();
		 int finish = 0;
	 
		 if (percent >= 50) {
		        number = 3;
		    } else if (percent >= 30) {
		        number = 2;
		    } else {
		        number = 1;
		    }
		 
		int increment = finish; // Start increment from j
		Random random = new Random();
		 
		 while(number > finish) {
			 
			 	
		       String LevelTag = tagLevel.get(i).getTag();
		       increment = (finish < number - 1 && number > 2) ? finish : random.nextInt(store.getKey(LevelTag).size());
		        // Check if the store has the key and if it has enough elements
		        if (store.getKey(LevelTag).size() > 0 && finish <= store.getKey(LevelTag).size() - 1) {
		            // Add the post to the newsFeed
		        	if (!dupli.getdupliTags().contains(store.getKey(LevelTag).get(increment).getTitle())) {
		        		if(store.getKey(LevelTag).get(increment).getBlind() == 0) {
		        			feeds.add(store.getKey(LevelTag).get(increment));
		        			store.getKey(LevelTag).get(increment).plusBlind();
		        		} else {
		        			store.getKey(LevelTag).get(increment).minusBlindPerOne();
		        			number++;
		        		}
		        		dupli.addDupliTags(store.getKey(LevelTag).get(increment).getTitle());
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
//		        finish++;
		 
		 
		 
	 }
}
}

public void popularFetch(ArrayList<Post> feeds,Graph<Tag,Post> store,ArrayList<Post> feeds2) {
	// TODO Auto-generated method stub
	int number = (20 - feeds.size())/4;
	DupliHolder dupli = DupliHolder.getInstance();
	
	for(int i = 0; i < 3; i++) { 
		String FamousTag = store.getTag().get(i).getTitle();
		 
		int j = 0;
		Random random = new Random();
		int increment = j; // Start increment from j

		while (j < number && store.getKey(FamousTag).size() > 0 && j <= store.getKey(FamousTag).size() - 1) {
		    // Check if j is less than number - 1, else fetch from the middle
		    increment = (j < number - 1) ? j : random.nextInt(store.getKey(FamousTag).size());

		    // Add the post to the newsFeed
		    Post manipulate = store.getKey(FamousTag).get(increment);

		    if (!dupli.getdupliTags().contains(manipulate.getTitle())) {
		        // Add to feed and increment blind count if applicable
		        if (manipulate.getBlind() == 0) {
		            feeds2.add(manipulate);
		            manipulate.plusBlind();
		        } else {
		            manipulate.minusBlindPerOne();
		            number++; // Adjust number to process one more post if necessary
		        }

		        // Mark this post as processed by adding to duplicate tags
		        dupli.addDupliTags(manipulate.getTitle());
		    }

		    // Increment j (which controls the loop)
		    j++;
		}

		
	}
		
        
        // Check if the store has the key and if it has enough elements
        
}

public void appenFetch(ArrayList<Post> feeds,Graph<Tag,Post> store,ArrayList<Post> feeds2,PercentageHolder percentage) {
	// TODO Auto-generated method stub
//	int number = (20 - feeds.size())/4;
	int number = 5;
	DupliHolder dupli = DupliHolder.getInstance();
	
	for(int i = 0; i < percentage.getAuthenPercentage().size(); i++) { 
		String appenTag = percentage.getAuthenPercentage().get(i).getTag();
		 
		int j = 0;
		while (j < number) {
			
		    if (store.getKey(appenTag).size() > 0 && j <= store.getKey(appenTag).size() - 1) {
		        Post manipulate = store.getKey(appenTag).get(j);

		        // Check if the post is already in feeds2
//		        System.out.println(dupli.getdupliTags());
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
	}
		
		
		FavoriteAuthorHolder author = FavoriteAuthorHolder.getInstance();
		AuthorHolder au = AuthorHolder.getInstance();
		
		author.outPut();
		int z = 0;
		int w = 2;
		while (z < w) {
//			if (au.getAuthorPosts(author.getAuthor()).size() > 0 && z <= au.getAuthorPosts(author.getAuthor()).size() - 1) {
//				if (!dupli.getdupliTags().contains(au.getAuthorPosts(author.getAuthor()).get(z).getTitle())) {
//					feeds2.add(au.getAuthorPosts(author.getAuthor()).get(z));
//					
//				} else {
//					w++;
//				}
//			}
//			
//			
//			if (au.getAuthorPosts(author.getAuthor2()).size() > 0 && z <= au.getAuthorPosts(author.getAuthor2()).size() - 1) {
//				if(!dupli.getdupliTags().contains(au.getAuthorPosts(author.getAuthor2()).get(z).getTitle())) {
//					feeds2.add(au.getAuthorPosts(author.getAuthor2()).get(z));
//				} else {
//					w++;
//				}
//			}
			
			if (z >= 0 && z <= au.getAuthorPosts(author.getAuthor()).size() - 1) {
			    if (!dupli.getdupliTags().contains(au.getAuthorPosts(author.getAuthor()).get(z).getTitle())) {
			        feeds2.add(au.getAuthorPosts(author.getAuthor()).get(z));
			    } else {
			        w++;
			    }
			}

			if (z >= 0 && z <= au.getAuthorPosts(author.getAuthor2()).size() - 1) {
			
			    if (!dupli.getdupliTags().contains(au.getAuthorPosts(author.getAuthor2()).get(z).getTitle())) {
			        feeds2.add(au.getAuthorPosts(author.getAuthor2()).get(z));
			    } else {
			        w++;
			    }
			}


			
		    
		    z++;
		}
		
		
//		System.out.println(au.toString());
//		author.outPut();
	
		
        
        // Check if the store has the key and if it has enough elements
        
}



 public void fetchFromtags(PercentageHolder percentage,Graph<Tag,Post> store,ArrayList<Post> feeds) {
	 ArrayList<Percentage> l3percent = percentage.getLevel3Percentage();
	 ArrayList<Percentage> l2percent = percentage.getLevel2Percentage();
	 ArrayList<Percentage> l1percent = percentage.getLevel1Percentage();
	 
	tagfetch(l3percent,percentage,store,feeds,percentage.getLevel3Percentage());
	tagfetch(l2percent,percentage,store,feeds,percentage.getLevel2Percentage());
	tagfetch(l1percent,percentage,store,feeds,percentage.getLevel1Percentage());
	
	 
	
	 
//	 System.out.println(feeds);
	 
	 
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
		 PhaseTwo phaseTwo = new PhaseTwo();
		 UserGraphHolder.getInstance().clearGraph();
		 UserGraph phase2 = UserGraphHolder.getInstance().getUserGraph();
		 int userCountLimit = 20;
		 List<String> ageGroups = new ArrayList<>(Arrays.asList("teen","youngAdult","adult","middleAgedAdult","olderAdult"));
		 List<String> genders = new ArrayList<>(Arrays.asList("male", "female"));
		 List<String> professions = new ArrayList<>(Arrays.asList("student", "freelancer", "retiredIndividual", "WebDev", "Actor", "workingProfessional"));
		 List<String> interests = new ArrayList<>(Arrays.asList("art", "gaming", "animals", "food", "anime", "cars", "technology", "sports", "education", "entertainment"));
		    
		    
		 String[] myTag = {interests.get(0), professions.get(0), ageGroups.get(0), genders.get(0)};
	     User hostUser = new User(myTag, new ArrayList<>());
	        
		 List<Post> share = phaseTwo.phaseTwo(hostUser, phase2, userCountLimit);
		 
		 if(store.getVertexCount() == 0) {
			 builder.build();
		 }
		 
		 
		 
		 fetchFromtags(percentage,store,feeds);
		 popularFetch(feeds,store,feeds2);
		 appenFetch(feeds,store,feeds2,percentage);
		 
		 Collections.shuffle(feeds);
		 Collections.shuffle(feeds2);
		 for(Post feed: feeds) {
			 newsFeed.getChildren().add(createPost(feed));
		 }
		 
		 for(Post feed: feeds2) {
			 newsFeed.getChildren().add(createPost(feed));
		 }
		 int minus = 30 - (feeds.size() + feeds2.size());
		 
		 for(int i = 0; i < minus; i++) {
			 if (share.size() > 0 && i <= share.size() - 1) {
			 newsFeed.getChildren().add(createPost(share.get(i)));
			 }
		 }
		 
//		 System.out.println(feeds.size() + feeds2.size());
//		 System.out.println(AuthorHolder.getInstance().toString());
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
		  newsFeed.setAlignment(Pos.CENTER);
		  
		  //
		  
		
	      AddPerferenceAuthen(new ArrayList<>(Arrays.asList("male","teen","student","sport")),percentage,store,newsFeed);
	      
	     
		  
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
	            	scrollPane.setVvalue(0.0);
	            }
	        });
	      

	        HBox navButtons = new HBox(10, nextButton);
	        navButtons.setPadding(new Insets(10));
	        navButtons.setAlignment(Pos.CENTER);

	        VBox mainLayout = new VBox(scrollPane, navButtons);
	        mainLayout.setAlignment(Pos.CENTER);
	        Scene scene = new Scene(mainLayout, 600, 800);
	        primaryStage.setScene(scene);
	        primaryStage.setTitle("Social Media Newsfeed");
	        primaryStage.show();
	        
	        
	      
	        
	      
	       
	    }
	  
	  
	 
	  
	  
	

	    // Method to create a post
	    private VBox createPost(Post post) {
	    	
	        
	        
	        
	        
	        //test to take out three post from graph;
	        
	        VBox main = new VBox(5);
	        
	        main.setMinWidth(600);  // Set minimum width
	     
	        main.setMaxWidth(600);  // Set maximum width
	        
	      
	       
	        
//	        float plusLike = (float)1e-10;
	        float plusLike = 1;
	        float plusComment = 0.5f;
	        PercentageHolder percentage = PercentageHolder.getInstance();
	        
	        main.setPadding(new Insets(10));
	        main.setStyle("-fx-border-color: lightgrey; -fx-border-width: 1px; -fx-background-color: #ffffff;");

	        // Title
	        
	        Text titleLabel = new Text(post.getTitle());
	        titleLabel.setStyle("-fx-font-size: 16px; -fx-font-weight: bold;");

	        // Image/Video placeholder
//	        ImageView imageView = new ImageView(new Image("https://via.placeholder.com/500x300.png?text=Media"));
	        
	        //In case the starting time took to long in your machine. It took too long because of the https link;
//	        Image image = new Image(getClass().getResourceAsStream("datachef_sample_comic (1).png"));
//	        ImageView imageView = new ImageView(image);
//	        imageView.setFitWidth(500);
//	        imageView.setFitHeight(300);
	        
	        ArrayList<Color> neonColors = new ArrayList<>();
	        neonColors.add(Color.LIME); // Neon Green
	        neonColors.add(Color.MAGENTA); // Neon Magenta
	        neonColors.add(Color.CYAN); // Neon Cyan
	        neonColors.add(Color.YELLOW); // Neon Yellow
	        neonColors.add(Color.PINK); // Neon Pink
	        neonColors.add(Color.ORANGE); // Neon Orange
	        neonColors.add(Color.FUCHSIA); // Neon Fuchsia

	        // Create a Random instance
	        Random random = new Random();

	        // Select a random color from the list
	        Color randomColor = neonColors.get(random.nextInt(neonColors.size()));

	        // Create a Rectangle and set its color
	        Rectangle rectangle = new Rectangle(570, 300);
	        rectangle.setFill(randomColor);
	        rectangle.setStroke(randomColor); // Border color
	        rectangle.setStrokeWidth(3); // Border width
	        rectangle.setArcWidth(16); // Horizontal radius of the arc for the rounded corners
	        rectangle.setArcHeight(16); // Vertical radius of the arc for the rounded corners

	        // Create a StackPane and add the Rectangle to it
	        StackPane stackPane = new StackPane(rectangle);
	        
	        
	        

//	         Content Text
	        Text contentLabel = new Text("");
	        Text authorss = new Text("Created By ... " + post.getAuthor());

	        // Hashtags and Tags (simple text for example purposes)
	        
	        
//
//	        // Create a Text node with the concatenated hashtags
//	        Text hashtags = new Text(hashtagsBuilder.toString());
	        ArrayList<String> combinedList = new ArrayList<>();
	        combinedList.addAll(post.getL1Tags());
	        combinedList.addAll(post.getL2Tags());
	        combinedList.addAll(post.getTags());
	        
	        StringBuilder hashtagsBuilder = new StringBuilder();

	        // Use a for loop to concatenate the hashtags into a single string
	        for (int i = 0; i < combinedList.size(); i++) {
	            hashtagsBuilder.append("#" + combinedList.get(i) + "        ");
	            if (i < combinedList.size() - 1) {
	                hashtagsBuilder.append(" "); // Add a space between hashtags
	            }
	        }
	        
	        Text hashtags = new Text(hashtagsBuilder.toString());
	      

	        // Reactions and Comments
	        HBox reactions = new HBox(100);
	        Button likeButton = new Button("Like");
	        likeButton.setMaxWidth(70);
	        likeButton.setMinWidth(70);
	        likeButton.setAlignment(Pos.BASELINE_LEFT);
	        likeButton.setAlignment(Pos.CENTER);
	        Button commentButton = new Button("Comment");
	        commentButton.setMaxWidth(70);
	        commentButton.setMinWidth(70);
	        commentButton.setAlignment(Pos.BASELINE_RIGHT);
	        commentButton.setAlignment(Pos.CENTER);
	        reactions.getChildren().addAll(likeButton, commentButton);
	        reactions.setAlignment(Pos.CENTER);
	        
	        
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

	                 
	                
	            
	                 System.out.println("level1 calculator=--------------------------------------------------------------");
	                 percentage.printLevel1Percentage();
	                 System.out.println("level1 calculator=--------------------------------------------------------------");

	                 
	                 System.out.println("level2 calculator---------------------------------------------------------------");
	                 percentage.printLevel2Percentage();
	                 System.out.println("level2 calculator---------------------------------------------------------------");

	                 System.out.println("level3 calculator---------------------------------------------------------------");
	                 percentage.printLevel3Percentage();
	                 System.out.println("level3 calculator---------------------------------------------------------------");
	                 
	                 
	                 System.out.println("Echo -------------------------------------------------------------------------");
	                
	                 System.out.println(holder.getMainStorage().toString());
	                 System.out.println("Echo -------------------------------------------------------------------------");
	            }
	        });
	        
	        
	        //Interaction part
	        
	       
	        
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

	        // Adding elements to the post
	        main.getChildren().addAll(titleLabel, rectangle, contentLabel, hashtags, reactions,authorss);

	        return main;
	    }

	    public static void main(String[] args) {
	        launch(args);
	    }
}
