package Singletons;

import java.util.ArrayList;
import java.util.Arrays;


public class TagLevelHolder {
	private static TagLevelHolder instance;
	private ArrayList<String> L1tags = new ArrayList<>(Arrays.asList("esport","movie","TVshows","sport","fitness","trending","photo","art","music","food","travel","fashion","beauty","education","technology","gaming","health","craft","business","parenting","learning"));
	private ArrayList<String> L2tags = new ArrayList<>(Arrays.asList("general","genres","specificTheme","onlinegames","match","atheletics","sportHighlights","workout","gymlife","viral","fyp","photograph","photographer","photoOfTheDay","artist","artwork","musicVideo","musician","foodie","foodporn","travelVlogger","traveller","clothes","style","ootd","makeup","skincare","studyTips","subjects","tech","techNews","gadgets","gamers","gameCommunity","wellness","selfcare","diy","homemade","finance","entrepreneur","family",""));
	private ArrayList<String> authenTags = new ArrayList<>(Arrays.asList("boy","girl", "youth","sport","male","female","other","students","freelancer","workingProfessional","entrepreneur","retiredIndividual","old","news","lifecycle","education","entertainment","teen","youngAdult","adult","middleAgedAdult","olderAdult"));

    private TagLevelHolder() {
    	
       
    } // Private constructor

    public static synchronized TagLevelHolder getInstance() {
        if (instance == null) {
            instance = new TagLevelHolder();
        }
        return instance;
    }

    public ArrayList<String> getL1tags() {
    	return L1tags;
    }
    
    public ArrayList<String> getL2tags() {
    	return L2tags;
    }
    
    public ArrayList<String> getAuthenTags() {
    	return authenTags;
    }
    
    

}
