import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Scanner;


public class Maxsort_Strings implements Comparator<String>{

	/**
	 * @param args
	 */
	public String[] maxsort(String[] arrStr,int n)
	{
		int last=n-1;
		
		int max=0;
		
		while(last!=0)
		{
		 String one=arrStr[0];
		 for(int i=0;i<=last;i++)
		 {
			//String one=arrStr[i];
			String two=arrStr[i];
			int ret=compare(one,two);
			if(ret < 0)
			{
				max=i;
				one=arrStr[i];
				
			}
		 }
		 String temp=arrStr[last];
		 arrStr[last]=one;
		 arrStr[max]=temp;
		 last--;
		}
		
		return arrStr;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Maxsort_Strings m= new Maxsort_Strings();
		int n;
		System.out.println("Enter the number of elements:");
		Scanner sc= new Scanner(System.in);
		n=sc.nextInt();
		String[] arrStr=new String[n];
		System.out.println("Enter the strings:");
		for(int i=0;i<n;i++)
		{
			arrStr[i]=sc.next();
		}
		String[] arrStr_new=m.maxsort(arrStr,n);
		for(int i=0;i<n;i++)
		{
			System.out.println(arrStr_new[i]);
		}
	}
	
	@Override
	public int compare(String arg0, String arg1) {
		// TODO Auto-generated method stub
		int ret=arg0.compareTo(arg1);
		System.out.println(ret);
		return ret;
	}

}
