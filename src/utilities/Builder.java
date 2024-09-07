package utilities;

import java.util.ArrayList;
import java.util.Arrays;

import Singletons.MainStorageHolder;


public class Builder {
	
	public void build() {
        MainStorageHolder g = MainStorageHolder.getInstance();
//        g.setMainStorage(new ArrayList<String>(Arrays.asList("boy", "girl", "old")), "Boy,Girl,Old","We love Sushi","sport",1.8f,"john Doe");
//        g.setMainStorage(new ArrayList<String>(Arrays.asList("boy", "girl", "young")), "Boy,Girl,Young","We love Sushi","sport",1.8f,"john Doe");
//        g.setMainStorage(new ArrayList<String>(Arrays.asList("boy", "girl", "old")), "OldOld","We love Sushi","sport",1.8f,"john Doe");
//        g.setMainStorage(new ArrayList<String>(Arrays.asList("boy", "girl", "young")), "YOungYoung","We love Sushi","sport",1.8f,"john Doe");
//        g.setMainStorage(new ArrayList<String>(Arrays.asList("boy", "girl", "old")), "Oooold","We love Sushi","sport",1.8f,"john Doe");
//        g.setMainStorage(new ArrayList<String>(Arrays.asList("boy", "girl", "young")), "Yooong","We love Sushi","sport",1.8f,"john Doe");
//        g.setMainStorage(new ArrayList<String>(Arrays.asList("gay")), "ggggggggay","We love Sushi","sport",1.8f,"john Doe");
//        g.setMainStorage(new ArrayList<String>(Arrays.asList("gay")), "gaaaaaaaaaaay","We love Sushi","sport",1.8f,"john Doe");
//        g.setMainStorage(new ArrayList<String>(Arrays.asList("gay")), "gayyyyyyyy","We love Sushi","sport",1.8f,"john Doe");
//        g.setMainStorage(new ArrayList<String>(Arrays.asList("boy","student")), "student","We love Sushi","sport",1.8f,"john Doe");
//        g.setMainStorage(new ArrayList<String>(Arrays.asList("boy","student")), "scholar","We love Sushi","sport",1.8f,"john Doe");
//        g.setMainStorage(new ArrayList<String>(Arrays.asList("boy","student")), "uni","We love Sushi","sport",1.8f,"john Doe");
//        g.setMainStorage(new ArrayList<String>(Arrays.asList("girl","student")), "girlStudent","We love Sushi","sport",1.8f,"john Doe");
//        g.setMainStorage(new ArrayList<String>(Arrays.asList("girl","student")), "GirllStu","We love Sushi","sport",1.8f,"john Doe");
//        g.setMainStorage(new ArrayList<String>(Arrays.asList("girl","student")), "GirlScholar","We love Sushi","sport",1.8f,"john Doe");
//        g.setMainStorage(new ArrayList<String>(Arrays.asList("girl","student")), "stttudentLady","We love Sushi","sport",1.8f,"john Doe");
//        g.setMainStorage(new ArrayList<String>(Arrays.asList("Worker")), "SE","We love Sushi","sport",1.8f,"john Doe");
//        g.setMainStorage(new ArrayList<String>(Arrays.asList("Worker")), "SEEE","We love Sushi","sport",1.8f,"john Doe");
//        g.setMainStorage(new ArrayList<String>(Arrays.asList("Worker")), "worker","We love Sushi","sport",1.8f,"john Doe");
//        g.setMainStorage(new ArrayList<String>(Arrays.asList("boy", "girl", "sport")), "Ha Ha bel","We love Sushi","sport",1.8f,"john Doe");
//        g.setMainStorage(new ArrayList<String>(Arrays.asList("funny", "DC", "mavel")), "Mike tel","We love Sushi","sport",1.8f,"Nick");
//        g.setMainStorage(new ArrayList<String>(Arrays.asList("girl")), "Mike Mike","We love Sushi","sport",1.8f,"Nick");
//        g.setMainStorage(new ArrayList<String>(Arrays.asList("music","pop")), "real Testing","We love Sushi","sport",1.8f,"Nick");
        
        
        g.setMainStorage(new ArrayList<String>(Arrays.asList("sport","football","boy","young","goal")), "Man United","Sport",1.8f,"Nick");
        g.setMainStorage(new ArrayList<String>(Arrays.asList("sport","football","young","goal")), "Chelsea","Sport.2",1.8f,"Nick");
        g.setMainStorage(new ArrayList<String>(Arrays.asList("sport","football","boy","girl","young","nice")), "Sheffield","Sport.3",1.8f,"Nick");
        g.setMainStorage(new ArrayList<String>(Arrays.asList("sport","maleSport","boy","onlyFor")), "Swimming","Sport2.1",1.8f,"Nick");
        g.setMainStorage(new ArrayList<String>(Arrays.asList("sport","maleSport","young","Man united")), "Running","Sport2.2",1.8f,"Nick");
        g.setMainStorage(new ArrayList<String>(Arrays.asList("sport","maleSport","boy","Haaa")), "Tennis","Sport2.3",1.8f,"Nick");
        g.setMainStorage(new ArrayList<String>(Arrays.asList("sport","femaleSport","girl","so beautiful")), "Swimming(female)","Sport3.1",1.8f,"Nick");
        g.setMainStorage(new ArrayList<String>(Arrays.asList("sport","femaleSport","girl","Whyy")), "Running(female)","Sport3.2",1.8f,"Nick");
        g.setMainStorage(new ArrayList<String>(Arrays.asList("sport","femaleSport","girl","Haaaa")), "Tennis(female)","Sport3.3",1.8f,"Nick");
//        
        g.setMainStorage(new ArrayList<String>(Arrays.asList("science","physics","boy","young","quantum")), "Eistein","Science",1.8f,"Nickee");
        g.setMainStorage(new ArrayList<String>(Arrays.asList("science","physics","young","relativity")), "Eistein2","Science.1",1.8f,"Nickee");
        g.setMainStorage(new ArrayList<String>(Arrays.asList("science","chemistry","boy","girl","young","Domain")), "Furry","Science2",1.8f,"Nickee");
        g.setMainStorage(new ArrayList<String>(Arrays.asList("science","chemistry","boy","Organic")), "Organic Chemistry","Science2.1",1.8f,"Nick");
        g.setMainStorage(new ArrayList<String>(Arrays.asList("science","technology","young","computer")), "Java","Science3",1.8f,"Nick");
        g.setMainStorage(new ArrayList<String>(Arrays.asList("science","technology","boy","hacking")), "Hacker","Science3.1",1.8f,"Nick");
        g.setMainStorage(new ArrayList<String>(Arrays.asList("science","technology","girl","hacking","OMG")), "WTX","Science3.2",1.8f,"Nick");
        g.setMainStorage(new ArrayList<String>(Arrays.asList("art","digitalArt","girl","onePaint")), "aRTIST","Art1",1.8f,"Nick");
        g.setMainStorage(new ArrayList<String>(Arrays.asList("art","digitalArt","girl","twoPaint")), "CREATIVEIY","Art2",1.8f,"Nick");
        
        
//        g.setMainStorage(new ArrayList<String>(Arrays.asList("movie","general","genres","films","drama")), "Darma Home","movie",1.8f,"Hallon");
//        g.setMainStorage(new ArrayList<String>(Arrays.asList("movie","genres","boylove","love","drama")), "Sweeties","movie",1.9f,"Loral");
//        g.setMainStorage(new ArrayList<String>(Arrays.asList("movie","general","girllove","love","drama")), "Sweeties Heart","movie",1.7f,"Frad");
//        g.setMainStorage(new ArrayList<String>(Arrays.asList("movie","genres","horror","sadending","film")), "Big Home","movie",2.0f,"Fred");
//        g.setMainStorage(new ArrayList<String>(Arrays.asList("movie","genres","action","love","film")), "Collector Skill","movie",1.9f,"Nial");
//        g.setMainStorage(new ArrayList<String>(Arrays.asList("movie","general","supernatural","space","science_drama")), "Super Power","movie",2.0f,"Loki");
//        g.setMainStorage(new ArrayList<String>(Arrays.asList("TVshows","general","boylove","love","varietyshow")), "Behind the Scene","TVshows",1.5f,"Bronkie");
//        g.setMainStorage(new ArrayList<String>(Arrays.asList("TVshows","general","horror","scary","varietyshow")), "Behind the Scene","TVshows",1.8f,"Bronkie");
//        g.setMainStorage(new ArrayList<String>(Arrays.asList("TVshows","general","questiontimes","relax","varietyshow")), "Answer within 5 mins","TVshows",1.9f,"Luwis");
//        g.setMainStorage(new ArrayList<String>(Arrays.asList("TVshows","general","humor","talkshow","varietyshow")), "Talking with Idols","TVshows",2.0f,"Luwis");
//        g.setMainStorage(new ArrayList<String>(Arrays.asList("TVshows","general","sport","atheletic","varietyshow")), "Show Your Skills","TVshows",1.9f,"Boran");
//        g.setMainStorage(new ArrayList<String>(Arrays.asList("sport","football","boy","youth","goal")), "Man United","sport",1.5f,"Nick");
//        g.setMainStorage(new ArrayList<String>(Arrays.asList("sport","badminon","boy","youth","serving")), "Felix","sport",1.2f,"Wiz");
//        g.setMainStorage(new ArrayList<String>(Arrays.asList("sport","football","girl","youth","goal")), "U20","sport",1.6f,"Rick");
//        g.setMainStorage(new ArrayList<String>(Arrays.asList("sport","basketball","boy","youth","goal")), "Hits","sport",1.5f,"Waltor");
//        g.setMainStorage(new ArrayList<String>(Arrays.asList("sport","arrow","girl","youth","target")), "Outstanding","sport",1.4f,"Bot");
//        g.setMainStorage(new ArrayList<String>(Arrays.asList("esport","football","boy","youth","gaming")), "Live Stream","esport",1.7f,"Speed");
//        g.setMainStorage(new ArrayList<String>(Arrays.asList("esport","mobilelegend","boy","youth","gaming")), "Live Stream with","esport",1.9f,"Speed");
//        g.setMainStorage(new ArrayList<String>(Arrays.asList("esport","onlinegames","girl","youth","gaming")), "Stream with Victoria","esport",1.9f,"Victoria");
//        g.setMainStorage(new ArrayList<String>(Arrays.asList("esport","match","boy","youth","gaming")), "Esport Shows","esport",1.8f,"Iris");


		 
	 	
        
    

    
  

}

}
