import java.sql.*;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Map;
import java.util.List;
import javax.swing.JOptionPane;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import java.net.URI;
import java.net.URISyntaxException;

import static spark.Spark.*;
import spark.template.freemarker.FreeMarkerEngine;
import spark.ModelAndView;
import static spark.Spark.get;


import com.heroku.sdk.jdbc.DatabaseUrl;

public class Main {

  public static void main(String[] args) {

    port(Integer.valueOf(System.getenv("PORT")));
    staticFileLocation("/public");

    get("/", (request, response) -> {
            Map<String, Object> attributes = new HashMap<>();
            Parsing parsing = new Parsing();

            int resultCount = 0; 
            attributes.put("count", resultCount);
            

            return new ModelAndView(attributes, "index.ftl");
        }, new FreeMarkerEngine());

    post("/parse", (request, response) -> {
            Map<String, Object> attributes = new HashMap<>();

            String selectedCharacter = request.queryParams("character");
            String selectedPosition =  request.queryParams("position");

           Parsing parsing = new Parsing();
          List<String> myResult = new ArrayList<String>(); 
          myResult=parsing.funct(selectedCharacter,selectedPosition);
          if(myResult.isEmpty()){
            //JOptionPane.showMessageDialog(frame, "No results found");
            return new ModelAndView(attributes, "noResult.ftl");
          }
          else{
            java.util.Collections.sort(myResult);
            Set<String> set = new TreeSet<String>(myResult);
            //Set<String> uniqueSet = new HashSet<String>(myResult);
            List<Integer> numbers = new ArrayList<Integer>();

            for (String temp : set) {
              
              System.out.println(temp + ": " + Collections.frequency(myResult, temp));
              numbers.add(Collections.frequency(myResult, temp));

           }
            attributes.put("numbers",numbers);
            attributes.put("results", set);
    
            return new ModelAndView(attributes, "parse.ftl");
          }
        }, new FreeMarkerEngine());
    post("/count", (request, response) -> {
            Map<String, Object> attributes = new HashMap<>();

            String selectedCharacter = request.queryParams("characterOne");

           ParsingOne parsing = new ParsingOne();
          int resultCount = 0; 
          resultCount=parsing.count(selectedCharacter);
         
            attributes.put("count", resultCount);
            System.out.println("The character chosen is: "+selectedCharacter);

            attributes.put("characterChosen", selectedCharacter);

            return new ModelAndView(attributes, "count.ftl");
        }, new FreeMarkerEngine());
    post("/secondParse", (request, response) -> {
      //names of the first word dropdown lists: characterFirstOne, characterFirstTwo,characterFirstThree
      //names of the second word dropdown lists: characterSecondOne, characterSecondTwo, characterSecondThree
            /* WebDriver driver;
            boolean chk = false;
            try {

                    chk=driver.findElement(By.name(characterFirstOne)).isDisplayed();
                    return chk;
                }  catch (NoSuchElementException e)
                    {
                    return false;//Control should go to catch but exception is not getting handled properly.
                    }
                    System.out.println(chk);
                    */
            Map<String, Object> attributes = new HashMap<>();
            String firstCharacter = request.queryParams("characterFirstOne");
            String secondCharacter = request.queryParams("characterFirstTwo");
            String thirdCharacter = request.queryParams("characterFirstThree");
            String fourthCharacter = request.queryParams("characterSecondOne");
            String fifthCharacter = request.queryParams("characterSecondTwo");
            String sixthCharacter = request.queryParams("characterSecondThree");
            String firstWord = firstCharacter+secondCharacter+thirdCharacter;
            String secondWord = fourthCharacter+fifthCharacter+sixthCharacter;
            ParsingTwo parsing = new ParsingTwo();
            List<String> myResult = new ArrayList<String>(); 
            myResult=parsing.twoParsing(firstWord,secondWord);
            attributes.put("resultsOne", myResult);
            
            return new ModelAndView(attributes, "parseTwo.ftl");
        }, new FreeMarkerEngine());
   


  }

}
