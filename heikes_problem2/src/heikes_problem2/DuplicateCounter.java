package heikes_problem2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class DuplicateCounter 
{
	HashMap<String, Integer> wordCounter = new HashMap<String, Integer>();
	
	public void count(String dataFile)
	{
		Set<String> duplicates = new HashSet<String>();
		
		try 
		{
			try (Scanner in = new Scanner(new File(dataFile)))
			{
				String holdWord;
				Integer counter;
				while (in.hasNext())
				{
					holdWord = in.next();
					counter = wordCounter.putIfAbsent(holdWord, 1);
					if (counter != null)
					{
						wordCounter.replace(holdWord, ++counter);
					}
				}
			}
		} 
		catch (FileNotFoundException e) 
		{
			System.out.println("FileNotFoundException - That file does not exist.");
			return;
		}
	}
	
	public void write(String dataFile)
	{
		try {
			
			String output = "";
			for (String string : wordCounter.keySet()) 
			{
				output += "Key: \"" + string + "\", Count: " + wordCounter.get(string) + " \n";
			}
			
			output.trim();
			
		    try (FileOutputStream outputStream = new FileOutputStream(dataFile))
		    {
		    	outputStream.write(output.getBytes());
		    }
		    
		}
		catch (IOException e)
		{
			System.out.println("IOException - the program will now stop.");
			return;
		}
	}
}
