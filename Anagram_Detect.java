import java.io.*;
import java.util.HashMap;
import java.util.Scanner;


public class Anagram_Detect {
    /*
    *  1 check length
        2 check if all letters are present
    */
    public boolean anagram(String s)
        {
            String[] words= s.split(" ");
            int len= words[0].length();
            for(String w: words)
                {
                    if(len!=w.length())
                        return false;
                }
            char[] temp= words[0].toCharArray();
            HashMap<Character,Integer> hash= new HashMap<Character,Integer>();
            for(char c:temp)
                {
            		if(hash.containsKey(c))
            		{
            			int freq= hash.get(c);
            			hash.replace(c,freq,freq+1);
            		}
            		else
            			hash.put(c, 1);
                }
            for(int i=1;i<words.length;i++)
                {
                    temp = words[i].toCharArray();
                    HashMap<Character,Integer> h=pushHash(words[i]);
                    for(char ch: temp)
                    {
                    	if(hash.containsKey(ch))
                    	{
                    		if(!h.containsKey(ch))
                    			return false;
                    		else
                    		{
                    			int freq1=hash.get(ch);
                    			int freq2=h.get(ch);
                    			if(freq1!=freq2)
                    			{
                    				return false;
                    			}
                    		}
                    	}
                    	
                    }
                }
            return true;            
        }
    
    public HashMap pushHash(String s)
    {
    	HashMap<Character,Integer> hp= new HashMap<Character, Integer>();
    	char[] temp= s.toCharArray();
    	for(char c: temp)
    	{
    		if(!hp.containsKey(c))
    		{
    			hp.put(c, 1);
    		}
    		else
    		{
    			int freq= hp.get(c);
    			hp.replace(c, freq,freq+1);
    		}
    	}
    	return hp;
    }
    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        
        System.out.println("Enter the words to be checked separated by enter:");
        Scanner sc= new Scanner(System.in);
		String names=new String();
		while(true)
		{
			String temp=sc.next();
			if(!temp.equals("0"))
			{
				names=names.concat(temp+" ");
			}
			else
			{
				break;
			}
		}
        Anagram_Detect sol= new Anagram_Detect();
        boolean b=sol.anagram(names);
        System.out.println("The words are anagram:"+ b );
        
    }
}