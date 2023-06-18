package jsonproject.jsonproject;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadDataFromJSON {

	public static void main(String[] args) throws IOException, ParseException {

		JSONParser jsonparser = new JSONParser();
		FileReader reader=new FileReader(".\\jsonfiles\\input.json");
		Object obj= jsonparser.parse(reader);
		JSONArray  inputjsonarr = (JSONArray)obj;
//		JSONArray outputArray = new JSONArray();
		
		List<String> outputList = new ArrayList<>();
		
		for(int i=0;i<inputjsonarr.size();i++)
		{
			JSONObject inputs = (JSONObject) inputjsonarr.get(i);
			
			String type = (String)inputs.get("type");
			String input = (String) inputs.get("input");
			String output;
			
			if (type.equals("first non repeating")) {
                output = findFirstNonRepeating(input);
            } else if (type.equals("first repeating")) {
                output = findFirstRepeating(input);
            } else {
                output = "-";
            }

            outputList.add(output);            
			
			System.out.println("input:"+input);
			System.out.println("type:"+type);
			System.out.println("output:"+output);
			System.out.println();
		}
		
		System.out.println("outputList:"+outputList);
		
		// this method converts a list to JSON Array
	      String outputArray = JSONArray.toJSONString(outputList);


		System.out.println("outputArray:"+outputArray);
		        
        try{    
            FileWriter fw=new FileWriter(".\\jsonfiles\\output.json");    
            fw.write(outputArray);    
            fw.close();    
           }catch(Exception e){System.out.println(e);}    
           System.out.println(outputArray);    
         
        
	}

	private static String findFirstRepeating(String input) {
		 boolean[] visited = new boolean[256];

	        for (char c : input.toCharArray()) {
	            if (visited[c]) {
	                return String.valueOf(c);
	            }
	            visited[c] = true;
	        }

	        return "-";
	}

	private static String findFirstNonRepeating(String input) {
		    int[] count = new int[256];

	        for (char c : input.toCharArray()) {
	            count[c]++;
	        }

	        for (char c : input.toCharArray()) {
	            if (count[c] == 1) {
	                return String.valueOf(c);
	            }
	        }

	        return "-";
	}

}
