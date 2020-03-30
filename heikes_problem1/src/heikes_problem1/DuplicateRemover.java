package heikes_problem1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;

public class DuplicateRemover {
	
	private Set<String> uniqueWords = new HashSet<String>();
	
	public void remove(String dataFile)
	{
		Set<String> duplicates = new HashSet<String>();
		
		try 
		{
			try (Scanner in = new Scanner(new File(dataFile)))
			{
				String holdWord;
				while (in.hasNext())
				{
					holdWord = in.next();
					if (!uniqueWords.contains(holdWord))
					{
						uniqueWords.add(holdWord);
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
			for (String string : uniqueWords) 
			{
				output += string + " ";
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
