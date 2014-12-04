import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

import javax.management.Query;


public class RadixApp {

	/**
	 * @param args
	 */
	
	/*
	 *Since the number of digits is constant so the 
	 *time complexity O(n*k) k is a constant 
	 *The time Complexity is O(n) 
	 */
	public void sort(int[] arr,int n,int dig)
	{
    	LinkedList<Integer>[] queue = new LinkedList[n];

		for(int j=0; j<dig; j++)  
        {  
			for(int i=0; i<n; i++)  
	        {  
	            queue[i] = new LinkedList<Integer>(); 
	        } 
			int exp=(int)Math.pow(10, j);
			for(int i=0; i<n; i++)  
            {  
					int  temp = (arr[i]/exp)%n; 
	                queue[temp].add(arr[i]);
            }  
			int k=0;
			for(int i=0;i<n;i++)
		    	{
				  
				  Iterator<Integer> it = queue[i].iterator();
				  while(it.hasNext())
				  {
					  arr[k]=it.next();
					  k++;
				  }
		    		
		    	}
        }
		for(int i=0;i<n;i++)
		{
			System.out.println(arr[i]);
		}
		
	}


public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Enter the number of elements:");
		Scanner sc = new Scanner(System.in);
		int n= sc.nextInt();
		int[] arr_one= new int[n];
		int[] arr_two=new int[n];
		int[] arr_ans=new int[n];
		RadixApp ra= new RadixApp();
		int dig=Integer.toString(n).length();
		System.out.println("Enter the elements of the first array numbers between 1 and " +  n +":");
		for(int i=0;i<n;i++)
		{
			arr_one[i]=sc.nextInt();
		}
		System.out.println("Enter the elements of the second array numbers between 1 and " +  n +":");
		for(int i=0;i<n;i++)
		{
			arr_two[i]=sc.nextInt();
		}
		for(int i=0;i<n;i++)
		{
			arr_ans[i]=arr_one[i]*arr_two[i];
		}
		ra.sort(arr_ans, n, dig*2);
		
	}


}
