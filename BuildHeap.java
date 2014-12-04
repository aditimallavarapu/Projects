import java.util.Scanner;
import java.util.Stack;


public class BuildHeap {

	/**
	 * @param args
	 */
	/*
	 * Bottom up approach
	 * Pushing the root upward
	 */
	public void heapUp(int arr[],int n)
	{
		final long startTime = System.currentTimeMillis();
		int k,v;
		boolean heap= false;
		int last_root=(n/2);
		for(int i=last_root;i>=0;i--)
		{
			k=i;
			v=arr[k];
			heap= false;
			while(!heap && (2*k)+1<=n)
			{
				int j=(2*k)+1;
				if(j<=n)
				{
					if(j+1<=n)
					{
					  if(arr[j] < arr[j+1])
					  {
						j++;
					  }
					}
					if(v>=arr[j])
					{
					    heap=true;	
					}
					else
					{
						arr[k]=arr[j];
						k=j;
					}
					
					
				}
				
			}
			arr[k]=v;
		}
		System.out.println("The heap:");
		for(int i=0;i<=n;i++)
		{
			System.out.println(arr[i]);
		}
		final long endTime = System.currentTimeMillis();
		System.out.println("Total execution time for top down approach: " + (endTime - startTime) +"msec");
	}
	/*
	 * top-down approach
	 * pushing the elements downwards
	 */
	public int[] heapDown(int[] arr, int n)
	{
		final long startTime = System.currentTimeMillis();
		Stack<Integer> s= new Stack<Integer>();
		int root=0;
		s.push(root);
		while(!s.empty())
		{
			root=s.pop();
			if(root<n/2){
			int child=2*root+1;
			int flag=0;			//leaf node
			if(child+1<=n)
			{
				flag=2;			//has two children first is greater
				if(arr[child]<arr[child+1])
				{
					child++;
					flag=1;		//second child greater
					
				}
			}
			else
			{
				flag=3;			//one child
			}
			if(arr[root] < arr[child])
			{
				int temp=arr[child];
				arr[child]=arr[root];
				arr[root]=temp;
				s.push(root);
				
				if(flag==1)
				{
					s.push(child-1);
					s.push(child);
				}
				else if(flag==2)
				{
					s.push(child+1);
					s.push(child);
				}
				else if(flag==3)
				{
					s.push(child);
				}
			}
			}
			
		}
		System.out.println("The heap:");
		for(int i=0;i<=n;i++)
		{
			System.out.println(arr[i]);
		}
		final long endTime = System.currentTimeMillis();
		System.out.println("Total execution time for top-down approach: " + (endTime - startTime) +"msec");
		return arr;
		
	}
	public int[] timeheap()
	{
		int arr[]=new int[100000];
		for(int i=0;i<100000;i++)
		{
			arr[i]=i;
		}
		return arr;
	}
	
	public int[] fifteen()
	{
		int arr[]=new int[15];
		int j=1;
		for(int i=0;i<15;i++)
		{
			arr[i]=j;
			j++;
		}
		return arr;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int[] arr= new int[100000];
		BuildHeap hp= new BuildHeap();
		arr=hp.timeheap();
		int n=100000;
	    hp.heapUp(arr, n-1);
	    sc.next();
	    hp.heapDown(arr,n-1);
	    sc.next();
	    arr=new int[15];
	    arr=hp.fifteen();
	    n=15;
	    hp.heapUp(arr, n-1);
	    hp.heapDown(arr,n-1);
	}

}
