
import java.util.Arrays;
import java.io.*;

/*
 * reverse a number
 */
class Reverse 
{
    public int solution(int N) 
    {
    	
        // write your code in Java SE 8
        int len=(String.valueOf(N).toCharArray()).length;
        int rem[]= new int[len];
        int count=0;
        while(N!=0)
        {
            rem[count]=N%10;
            count++;
            N=N/10;
        }
        Arrays.sort(rem);
        String num= new String();
        for(int i=len-1;i>=0;i--)
        {
            num=num.concat(String.valueOf(rem[i]));
        }
        System.out.println(num);
        int n=0;
        try{
        n=Integer.parseInt(num);
        }
        catch(Exception e)
        {
        	e.printStackTrace();
        }
        if(String.valueOf(n).toCharArray().length >= 9)
            return -1;
        else 
            return n;
        
    }
    public static void main(String args[])
    {
        Reverse sol= new Reverse();
        sol.solution(5678);
    }       
}
