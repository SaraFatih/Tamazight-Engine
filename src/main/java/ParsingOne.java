

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

public class ParsingOne {

	private static final String USER_AGENT = "Mozilla/5.0";
	public static StringBuffer otherresponse = new StringBuffer();	
	
	public static int count(String myChar) {
		List<String> result = new ArrayList<String>();
		int characterCount=0;
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
			
			int z=0;
			List<String> myList = new ArrayList<String>();
			int i;
			int j;
			int count=0;
			int first=0;
			int second=0;
			int third=0;
			int fourth=0;
			int fifth=0;
			int sixth=0;
			int seventh=0;
			int eigth=0;
			int ninth=0;
			int tenth=0;
			int eleventh=0;
			int twelve=0;
			int thirteen=0;
			int fourteen=0;
			int fifteenth=0;
			int sixteen=0;
			int seventeen=0;
			int eighteen=0;
			int nineteen=0;
			int twenty=0;
			int twentyOne=0;
			int twentyTwo=0;
			int twentyThree=0;
			int twentyFour=0;
			int twentyFive=0;
			int twentySix=0;
			int twentySeven=0;
			int twentyEight=0;
			int twentyNine=0;
			int thirty=0;
			int thirtyOne=0;
			int thirtyTwo=0;
			int thirtyThree=0;
			while ((otherinputLine = otherin.readLine()) != null) {
				char [] charInputLine = otherinputLine.toCharArray();
				
				for(i=0;i<charInputLine.length;i++){
					if(charInputLine[i]=='0' || charInputLine[i]=='1' || charInputLine[i]=='2' || charInputLine[i]=='3' || charInputLine[i]=='4' || charInputLine[i]=='5' || charInputLine[i]=='6' || charInputLine[i]=='7' || charInputLine[i]=='8' || charInputLine[i]=='9' || charInputLine[i]=='-' || charInputLine[i]=='/' || charInputLine[i]=='=' || charInputLine[i]=='>' || charInputLine[i]=='!' || charInputLine[i]=='?' || charInputLine[i]==',' || charInputLine[i]=='.' || charInputLine[i]==':' || charInputLine[i]=='|'){
						charInputLine[i]=' ';
					}
					else if(charInputLine[i]=='a' && myChar.equals("a")){
						first++;
						characterCount++;
					}
					else if(charInputLine[i]=='b' && myChar.equals("b")){
						second++;
						characterCount++;

					}
					else if(charInputLine[i]=='g' && myChar.equals("g")){
						third++;
						characterCount++;

					}
					else if(charInputLine[i]=='å' && myChar.equals("å")){
						fourth++;
						characterCount++;

					}
					else if(charInputLine[i]=='d' && myChar.equals("d")){
						fifth++;
						characterCount++;

					}
					else if(charInputLine[i]=='ä' && myChar.equals("ä")){
						sixth++;
						characterCount++;

					}
					else if(charInputLine[i]=='e' && myChar.equals("e")){
						seventh++;
						characterCount++;

					}
					else if(charInputLine[i]=='f' && myChar.equals("f")){
						eigth++;
						characterCount++;

					}
					else if(charInputLine[i]=='k' && myChar.equals("k")){
						ninth++;
						characterCount++;

					}
					else if(charInputLine[i]=='æ' && myChar.equals("æ")){
						tenth++;
						characterCount++;

					}
					else if(charInputLine[i]=='h' && myChar.equals("h")){
						eleventh++;
						characterCount++;

					}
					else if(charInputLine[i]=='p' && myChar.equals("p")){
						twelve++;
						characterCount++;

					}
					else if(charInputLine[i]=='o' && myChar.equals("o")){
						thirteen++;
						characterCount++;

					}
					else if(charInputLine[i]=='x' && myChar.equals("x")){
						fourteen++;
						characterCount++;

					}
					else if(charInputLine[i]=='q' && myChar.equals("q")){
						fifteenth++;
						characterCount++;

					}
					else if(charInputLine[i]=='i' && myChar.equals("i")){
						sixteen++;
						characterCount++;

					}
					else if(charInputLine[i]=='j' && myChar.equals("j")){
						seventeen++;
						characterCount++;

					}
					else if(charInputLine[i]=='l' && myChar.equals("l")){
						eighteen++;
						characterCount++;

					}
					else if(charInputLine[i]=='m' && myChar.equals("m")){
						nineteen++;
						characterCount++;

					}
					else if(charInputLine[i]=='n' && myChar.equals("n")){
						twenty++;
						characterCount++;

					}
					else if(charInputLine[i]=='u' && myChar.equals("u")){
						twentyOne++;
						characterCount++;

					}
					else if(charInputLine[i]=='r' && myChar.equals("r")){
						twentyTwo++;
						characterCount++;

					}
					else if(charInputLine[i]=='ë' && myChar.equals("ë")){
						twentyThree++;
						characterCount++;

					}
					else if(charInputLine[i]=='v' && myChar.equals("v")){
						twentyFour++;
						characterCount++;

					}
					else if(charInputLine[i]=='s' && myChar.equals("s")){
						twentyFive++;
						characterCount++;

					}
					else if(charInputLine[i]=='ã' && myChar.equals("ã")){
						twentySix++;
						characterCount++;

					}
					else if(charInputLine[i]=='c' && myChar.equals("c")){
						twentySeven++;
						characterCount++;

					}
					else if(charInputLine[i]=='t' && myChar.equals("t")){
						twentyEight++;
						characterCount++;

					}
					else if(charInputLine[i]=='ï' && myChar.equals("ï")){
						twentyNine++;
						characterCount++;

					}
					else if(charInputLine[i]=='w' && myChar.equals("w")){
						thirty++;
						characterCount++;

					}
					else if(charInputLine[i]=='y' && myChar.equals("y")){
						thirtyOne++;
						characterCount++;

					}
					else if(charInputLine[i]=='z' && myChar.equals("z")){
						thirtyTwo++;
						characterCount++;

					}
					else if(charInputLine[i]=='ç' && myChar.equals("ç")){
						thirtyThree++;
						characterCount++;

					}
					
				}
				
			}
	
			return characterCount;
			
			
		} catch (IOException  e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
		
		
		
	 }
}
