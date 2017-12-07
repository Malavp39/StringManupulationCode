package com.challenge;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Test {
	
	private static final String FILE_HEADER = "words,palindrome";
	public static void main(String[] args) throws Exception{
		
		StringManipulator manipulator = new StringManipulator();
		Path path = Paths.get("palindrome_tests.csv");
	    try(BufferedReader reader = Files.newBufferedReader(path, Charset.forName("UTF-8"))){

	      
	      String currentLine = null;
	      reader.readLine();
	      String[] words = new String[9];
			int i = 0;
			boolean isPalindrome= false;
			HashMap<String, Boolean> map = new HashMap<>();
	      while((currentLine = reader.readLine()) != null){
	        words[i] = currentLine;
	        isPalindrome = manipulator.isPalindrome(currentLine);
	        System.out.println(currentLine + " " + isPalindrome );
	        currentLine = StringManipulator.cleanString(currentLine);
			map.put(currentLine, isPalindrome);
			words[i] = currentLine;
			i++;
	      }
	     	    	 
	      words = manipulator.sortStrings(words);
	      
	       PrintWriter writer = new PrintWriter(new File("palindrome_sorted.csv"));
			StringBuilder sb = new StringBuilder();
			sb.append("words");
			sb.append(",");
			sb.append("palindrome");
			sb.append("\n");
	    	
			for(String word:words){
				
				if(map.containsKey(word)){
					System.out.println(word + " "+map.get(word));
					isPalindrome = map.get(word);
					sb.append(word);
					sb.append(",");
					sb.append(String.valueOf(isPalindrome));
					
				}
				sb.append("\n");
			}
			writer.write(sb.toString());
			writer.close();
	    }	
			catch(Exception ee){
				ee.printStackTrace();
			}
	}
	
}
