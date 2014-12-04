import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;


public class Tournament {

	/**
	 * @param args
	 */
	
	
	public int get2max(List[] ll, int start,int end)
	{		   
		   if (start == end)  
		   {
			   Iterator<Integer> it=ll[start].iterator();
		       return start;
		   }
		    int m = (start+end)/2;
		    int u = get2max(ll,start,m);
		    int v = get2max(ll,m+1,end);
		    int one=(int)ll[u].iterator().next();
		    int two=(int)ll[v].iterator().next();
		    if(one>two)
		    {
		    	ll[u].add(two);
		    	return u;
		    }
		    else
		    {
		    	ll[v].add(one);
		    	return v;
		    }
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Tournament t= new Tournament();
		for(int n=10;n<=100000;n*=10)
		{
		final long startTime = System.currentTimeMillis();
		FileInput fi= new FileInput();
		int[] arr=fi.writetofile(n);
		List<Integer>[] ll=new List[n];
		for(int i=0;i<n;i++)
			{
				ll[i]=new LinkedList<Integer>();
				ll[i].add(arr[i]);  
			}
		int max= t.get2max(ll, 0, n-1);
		Iterator<Integer> outer= ll[max].iterator();
		int high=outer.next();
		int second=outer.next();
		for(int i=2;i<ll[max].size();i++)
		{
			if(outer.hasNext())
			{
				int temp=outer.next();
				if(second < temp)
				{
					second=temp;
				}
			}
			
		}
		System.out.println("second:"+second);
		System.out.println("max:"+high);
		outer= ll[max].iterator();
		final long endTime = System.currentTimeMillis();
		System.out.println("Total execution time: " + (endTime - startTime) +"msec");
		System.out.println("Enter an alphabet to continue");
		Scanner sc= new Scanner(System.in);
		sc.next();
		}
		
	}
	}


