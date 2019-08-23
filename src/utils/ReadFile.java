package utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ReadFile {

    static String line = null;
    static int lineNum = 0;
    
    public static ArrayList<String> readDialougue(String name) {
    	ArrayList<String> strings = new ArrayList<String>();
	    String fileName = "res/dialougue" + name;
	    try
	    {
	        FileReader fileReader = new FileReader(fileName);
	        BufferedReader bufferedReader = new BufferedReader(fileReader);
	        while((line = bufferedReader.readLine()) != null) 
	        {
	        	strings.add(line);
	        }
	        bufferedReader.close();
	    }
	    catch(FileNotFoundException ex)
	    {
	        System.out.println((new StringBuilder("Unable to open file '")).append(fileName).append("'").toString());
	    }
	    catch(IOException ex)
	    {
	        System.out.println((new StringBuilder("Error reading file '")).append(fileName).append("'").toString());
	    }
        return strings;
    }
}
