import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream.GetField;
import java.util.Scanner;


public class Max2 {
	int max1;
	int max2;
	
	public int getMax1() {
		return max1;
	}
	public void setMax1(int max1) {
		this.max1 = max1;
	}
	public int getMax2() {
		return max2;
	}
	public void setMax2(int max2) {
		this.max2 = max2;
	}
	
	public void find_max(int arr[],int n)
	{
		int i;
		if(n%2 == 0)
		{
			if(arr[0]>arr[1]){
				setMax1(arr[0]);
				setMax2(arr[1]);
			}
			else
			{
				setMax1(arr[1]);
				setMax2(arr[0]);
			}
			i=2;
		}
		else
		{
			setMax1(arr[0]);
			setMax2(arr[0]);
			i=1;
		}
		while(i<n-1)
		{
			if(arr[i]> arr[i+1])
			{
				if(getMax1()<arr[i])
				{
					int temp=getMax1();
					setMax1(arr[i]);
					setMax2(temp);
				}
				else
				{
					if(getMax2()<arr[i])
					{
						setMax2(arr[i]);
					}
				}
			}
			else
			{
				if(getMax1()<arr[i+1])
				{
					int temp=getMax1();
					setMax1(arr[i+1]);
					setMax2(temp);
				}
				else
				{
					if(getMax2()<arr[i+1])
					{
						setMax2(arr[i+1]);
					}
				}
			}
			i+=2;
		}
	}
	public void find_max_rec(int arr[],int start,int end)
	{
		if(start>=end)
		{
			return;
		}
		if(arr[start]>arr[start+1])
		{
			if(getMax1()<arr[start])
			{
				int temp=getMax1();
				setMax1(arr[start]);
				setMax2(temp);
				
			}
		    else
			{
				if(getMax2()<arr[start])
				{
					setMax2(arr[start]);
				}
			}
		}
		else
		{
			if(getMax1()<arr[start+1])
			{
				int temp=getMax1();
				setMax1(arr[start+1]);
				setMax2(temp);
				
			}
		    else
			{
				if(getMax2()<arr[start+1])
				{
					setMax2(arr[start+1]);
				}
			}
		}
				
		
		start+=2;
		find_max_rec(arr, start, end);
	}
	public static void main(String[] args)
	{
		Max2 m= new Max2();
		FileInput fi= new FileInput();
		Scanner sc= new Scanner(System.in);
		for(int n=10;n<=100000;n*=10)
		{
		 final long startTime = System.currentTimeMillis();
		 int[] arr=fi.writetofile(n);
		 int start;
		 if(n%2 == 0)
		 {
			if(arr[0]>arr[1]){
				m.setMax1(arr[0]);
				m.setMax2(arr[1]);
		 }
		else
		 {
				m.setMax1(arr[1]);
				m.setMax2(arr[0]);
		 }
			start=2;
		}
		else
		{
			m.setMax1(arr[0]);
			m.setMax2(arr[0]);
			start=1;
		}		
		m.find_max_rec(arr, start, n-1);
		System.out.println("Max1:"+ m.getMax1());
		System.out.println("Max2:"+ m.getMax2());
		final long endTime = System.currentTimeMillis();

		System.out.println("Total execution time: " + (endTime - startTime) +"msec");
		System.out.println("Enter an alphabet to continue");
		sc.next();
		}
	}
	}


