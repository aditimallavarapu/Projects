import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Random;
import java.util.Scanner;


public class FileInput {

	/**
	 * @param args
	 * Generates random numbers and writes them into a file and then reads them
	 */
	public int[] writetofile(int n)
	{		
	  int arr[]= new int[n];	
	  try
	  {
		BufferedWriter bw= new BufferedWriter(new FileWriter("Input.txt"));  
		Random r= new Random();
		for(int i=0;i<n;i++)
		{
			Integer temp=r.nextInt(500);
			String tempstr=temp.toString();
			bw.write(temp+"\n");
		}
		bw.close();
		BufferedReader br = new BufferedReader(new FileReader("Input.txt"));
	    String line=new String();
	    
	    int i=0;
	    while ((line = br.readLine())!=null) {
	    	arr[i]=Integer.parseInt(line);
	    	System.out.println(arr[i]);
	    	i++;
	    }
	    br.close();
	    
	   }
	  catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  return arr;
	}
	

}
