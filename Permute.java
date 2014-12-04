import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

import javax.management.Query;


public class Permute {

	/**
	 * @param args
	 */
	
	/*
	 * Q 8 accepts the array, 
	 * number of elements and the number of digits
	 * in the highest number
	 * returns the permutations of the index as in the sorted list
	 * Uses Radix sort to sort the numbers with O(n *k)  k= number of digits in the highest number 
	 * complexity k is approximately equal to log n so the complexity is O(nlog n) 
	 * Then uses the Binary search to find out the required permutation
	 * so O(log n) 
	 * Total Complexity O(nlog n + log n) which is O(nlog n)
	 * 
	 */
	public String perm(int[] arr,int n,int dig)
	{
		String ans=null;
		
		int arr2[]= new int[n];
		for(int i=0;i<n;i++)
		{
			arr2[i]=arr[i];
		}

		LinkedList<Integer>[] queue = new LinkedList[10];

		for(int j=0; j<dig; j++)  
        {  
			for(int i=0; i<10; i++)  
	        {  
	            queue[i] = new LinkedList<Integer>(); 
	        } 
			int exp=(int)Math.pow(10, j);
			for(int i=0; i<n; i++)  
            {  
					int  temp = (arr2[i]/exp)%10; 
	                queue[temp].add(arr2[i]);
            }  
			int k=0;
			for(int i=0;i<10;i++)
		    	{
				  Iterator<Integer> it = queue[i].iterator();
				  while(it.hasNext())
				  {
					  arr2[k]=it.next();
					  k++;
				  }
		    	}
        }
		for(int i=0;i<n;i++)
		{
			System.out.println(arr2[i]);
		}
		for(int i=0;i<n;i++)
		{
			int temp=search(arr2, 0, n, arr[i]);
			if(ans==null)
			{
				ans=Integer.toString(temp+1);
			}
			else
			{
			  ans+=Integer.toString(temp+1);
			} 
		}
		return ans;
	}
	public int search(int[] arr,int start,int end,int x)
	{
		if(start>=end){
			return -1;
		}
		int m = (start+end)/2;
		if(x==arr[m])
		{
			return m;
		}
		else if(x > arr[m])
		{
			return search(arr,m+1,end,x);
		}
		else if(x < arr[m])
		{
			return search(arr,start,m,x);
		}
		else
		{
			return -1;
		}
		

	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("Enter the number of elements:");
		Scanner sc = new Scanner(System.in);
		int n= sc.nextInt();
		int[] arr_one= new int[n];
		Permute ra= new Permute();
		System.out.println("Enter the number of digits in the largest number");
		int dig=sc.nextInt();
		System.out.println("Enter the elements of the array:");
		for(int i=0;i<n;i++)
		{
			arr_one[i]=sc.nextInt();
		}
		String ans= ra.perm(arr_one,n,dig);
		System.out.println("Permutation String:"+ans);
	}

}
