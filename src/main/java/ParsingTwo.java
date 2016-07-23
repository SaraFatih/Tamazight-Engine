

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.json.JSONObject;

public class ParsingTwo {

	private static final String USER_AGENT = "Mozilla/5.0";
	public static StringBuffer otherresponse = new StringBuffer();	
	
	public static List<String> twoParsing(String myChar1,String myChar2) {
		List<String> result = new ArrayList<String>();
		String after;
		String text;
		String teacherURL = "https://docs.google.com/document/d/1zZe4E7a7iiyLHzwYMwax3I0BGcZxLNWWvgncApM9qjA/edit?usp=sharing";
		String teacherURLextracted = teacherURL.substring(teacherURL.indexOf("d/") + 2, teacherURL.indexOf("/edit"));
		String httpURL = "https://www.googleapis.com/drive/v2/files/" + teacherURLextracted + "?key=AIzaSyBj4N7uYMIE5qkDugddrV_fXhgzx-rW4xE";
		try {
			URL obj = new URL(httpURL);
			HttpURLConnection con = (HttpURLConnection) obj.openConnection();
			// optional default is GET
			con.setRequestMethod("GET");
			//add request header
			con.setRequestProperty("User-Agent", USER_AGENT);

			int responseCode = con.getResponseCode();
			System.out.println("\nSending 'GET' request to URL : " + httpURL);
			//System.out.println("Response Code : " + responseCode);

			BufferedReader in = new BufferedReader(
			        new InputStreamReader(con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();
			
			JSONObject newObj = new JSONObject(response.toString());
			String newURL = newObj.getJSONObject("exportLinks").getString("text/plain");
			
			System.out.println(newURL);
			
			URL secondobj = new URL(newURL);
			HttpURLConnection secondcon = (HttpURLConnection) secondobj.openConnection();
			
			secondcon.setRequestMethod("GET");

			//add request header
			secondcon.setRequestProperty("User-Agent", USER_AGENT);

			int secondresponseCode = secondcon.getResponseCode();
			

			BufferedReader otherin = new BufferedReader(
			        new InputStreamReader(secondcon.getInputStream()));
			String otherinputLine;
			//System.out.println("-----------------------First time-------------------------");
			int z=0;
			List<String> myList = new ArrayList<String>();
			int i;
	
			while ((otherinputLine = otherin.readLine()) != null) {
				char [] charInputLine = otherinputLine.toCharArray();
				
				for(i=0;i<charInputLine.length;i++){
					if(charInputLine[i]=='0' || charInputLine[i]=='1' || charInputLine[i]=='2' || charInputLine[i]=='3' || charInputLine[i]=='4' || charInputLine[i]=='5' || charInputLine[i]=='6' || charInputLine[i]=='7' || charInputLine[i]=='8' || charInputLine[i]=='9' || charInputLine[i]=='-' || charInputLine[i]=='/' || charInputLine[i]=='=' || charInputLine[i]=='>' || charInputLine[i]=='!' || charInputLine[i]=='?' || charInputLine[i]==',' || charInputLine[i]=='.' || charInputLine[i]==':' || charInputLine[i]=='|'){
						charInputLine[i]=' ';
					}	
					
				}
				String cleanLine = new String(charInputLine);
				//Now we need to do the character count
				//This is to tokenize the entire line into words
				String[] arrayOfWords = cleanLine.split(" ");
					
				int x;
				for(x=0;x<arrayOfWords.length;x++){
					myList.add(arrayOfWords[x]);
				}
				otherresponse.append(" ");
				otherresponse.append(cleanLine);
			}
			
			after = otherresponse.toString().trim().replaceAll(" +", " ");
			System.out.println("The text after trimming is: \n"+after);
			//System.out.println("The words\n");
			int man=0;
			Pattern p = Pattern.compile("\\w+" + myChar1 + "\\s" + myChar2 + "\\w+");
			Matcher m = p.matcher(after);
			while(m.find()){
				result.add(m.group());
	
			}
		
			return result;
			
			
		} catch (IOException  e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
		
		
	 } 
}
