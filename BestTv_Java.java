package intuit;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
/*
 * given filenames find the common tv in those files (find intersection set)
 */
public class BestTv_Java {
	
	public HashMap<String,Integer> pushHash(String website)
	{
		HashMap<String,Integer> hm= new HashMap<String, Integer>();
		try
		{
			String filename="./tv_sample_data/";
			filename=filename.concat(website);
			filename=filename.concat(".txt");
			BufferedReader bf= new BufferedReader(new FileReader(filename));
			String tv_model=new String();
			while((tv_model=bf.readLine())!=null)
			{
				hm.put(tv_model, 1);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return hm;
	}

	public void readNames(String names)
	{
		String[] list_websites=names.split(" ");
		try
		{
			HashMap<String,Integer> hash1=pushHash(list_websites[0]);
			for(int i=1;i<list_websites.length;i++)
			{
				HashMap<String,Integer> hash2=pushHash(list_websites[i]);
				/*
				 * using a second hash map makes sense because it may eliminate repetitions
				 * otherwise we may have little longer loop
				 * can be optimised by making hash1 as the shortest list but to know number of contents
				 * we have to traverse the whole list
				 * complexity O(n)  traverse only one has map at a time no nesting 
				 */
				Iterator it2= hash2.entrySet().iterator();
				while(it2.hasNext())
				{
					Map.Entry<String, Integer> tv=(Map.Entry<String, Integer>)it2.next();
					if(hash1.containsKey(tv.getKey()))
					{
						int freq=hash1.get(tv.getKey());
						System.out.println(list_websites[i]+"  "+tv.getKey());
						hash1.replace(tv.getKey(),freq,freq+1);
					}
				}
			}
		
		print_names(hash1,list_websites.length);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void print_names(HashMap<String, Integer> common_tv,int n)
	{
			System.out.println(n);
		    Iterator it= common_tv.entrySet().iterator();
		    int flag=0;
		    while(it.hasNext())
		    {
		        Map.Entry tv=(Map.Entry) it.next();
		       if((Integer)tv.getValue()==n)
		        {
		        	System.out.println(tv.getKey()+"\n");
		        	flag=1;
		        }
		    }
		    if(flag==0)
		    {
		    	System.out.println("no same");
		    }
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BestTv_Java tv= new BestTv_Java();
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter the names of the websites separated by enter (0 as the last website name):");
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
		tv.readNames(names);
	}

}
