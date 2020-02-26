import java.util.*;
	

public class StringMatch
{
	
	public static int [] CheckStringMatch(char [] text, char [] pattern)
	{
		// Bogus input
		if (text == null || pattern == null)
			return null;
		
		// length of arrays
		int n = text.length;
		int m = pattern.length;
		
		// emptyset
		int [] empty = new int[] {};
		
		if (n == 0 || m == 0)
			return empty;
		if (n < m)
			return empty;
		
		// array list to hold matching
		ArrayList<Integer> match = new ArrayList<Integer>();
		
		// hash tables
		Hashtable<Integer, Character>thash = new Hashtable<Integer, Character>();
		Hashtable<Integer, Character>phash = new Hashtable<Integer, Character>();
		
		// intialize the table for pattern
		for (int i = 0; i < m; i++)
		{
			phash.put(i, pattern[i]);

		}
		
		// loop through the length of text
		// (excluding the end we don't need to check)
		// rolling hash
		for (int j = 0; j <= n-m; j++)
		{
			
			// reset table remove from the start and adding the next value
			for (int i = 0; i < m; i++)
			{
				thash.put(i, text[i+j]);

			}
			// if they equal then add the index
			if (phash.equals(thash)) 
			{
				match.add(j);
			}
			
		}
		// converting the array list to array
		int msize = match.size();
		int[] Array = new int[msize];
		for (int i = 0; i < msize; i++)
        {
           Array[i] = match.get(i);
        }
		return Array;
		
	}
}