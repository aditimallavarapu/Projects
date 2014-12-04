import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/*
 * Given the number of strings and the strings finds the alphabets that are common (interscetion set) in all the strings
 */
public class Interscetion {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        System.out.println("Enter number of rocks: (Strings)");
    	Scanner sc= new Scanner(System.in);
        int num_rocks=sc.nextInt();		//accept number of rocks (strings)
        
        String[] rocks= new String[num_rocks];
        System.out.println("Enter the names of the rocks: (Strings)");
        for(int i=0;i<num_rocks;i++)
            {
                rocks[i]=sc.next();				//accept the strings
            }
        HashMap<Character,Integer> hm= new  HashMap<Character,Integer>(); 
        HashMap<Character,Integer> dummy= new  HashMap<Character,Integer>();
        char[] new_str=rocks[0].toCharArray();		//convert the first string as character array
        for(char r:new_str)
            {
                hm.put(r, 1);								//put it in the hashmap for comparison later
            }
        for(int i=1;i<num_rocks;i++)					//for rest of the strings
            {
        		dummy=new HashMap<Character, Integer>();
                new_str=rocks[i].toCharArray();			//convert each string to character array
                for(int j=0;j<new_str.length;j++)
                {
                	if(hm.containsKey(new_str[j]))
                	{
                		dummy.put(new_str[j],1);
                	}
                }
                hm=new HashMap();
                hm=dummy;
            }
        Iterator i=hm.keySet().iterator();
        while(i.hasNext())
        {
        	System.out.println(i.next());
        }
            }
}