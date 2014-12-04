import java.util.Iterator;
import java.util.Scanner;


public class BinarySearch {

	/**
	 * @param args
	 */
	public int search(int[] arr,int start,int end,int x)
	{
		
		if(start>=end){
			return -1;
		}
		int m = (start+end)/2;
		if(arr[m]==0)
		{
			end=m-1;
			return search(arr,start,end,x);
		}
		else if(x==arr[m])
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
		BinarySearch bs= new BinarySearch();
		int x;
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter the number to be searched:");
		x=sc.nextInt();

		System.out.println("Enter the elements:(Enter 0 to terminate)");
		int[] arr= new int[100];
		int i=0;
		for(i=0;i<100;i++)
		{
			int temp=sc.nextInt();
			if(temp!=0)
			{
				arr[i]=temp;
			}
			else
				break;
		}
		for(int j=i;j<100;j++)
		{
			arr[i]=0;
		}
		int ret=bs.search(arr, 0, 99, x);
		if(ret==-1)
		{
			System.out.println("The number could not be found");
		}
		else
		{
			System.out.println("The number was found at:"+ret);
		}

	}

}
