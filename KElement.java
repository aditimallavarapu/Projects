import java.awt.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Stack;


public class KElement {

	/**
	 * @param args
	 * Complexity gets added due to rebuilding heap and also shifting
	 * the array elements one position to make it smaller
	 */
	public void deletek(int[] heap_arr,int k,int n)
	{
	    BuildHeap bp=new BuildHeap();
		for(int i=0;i<k;i++)
		{
			int x=heap_arr[0];
			System.out.println(i+" "+x);
			for(int j=0;j<n;j++)
			{
				heap_arr[j]=heap_arr[j+1];
			}
			heap_arr=bp.heapDown(heap_arr,n-(i+1));
		}
		
	}
	
	public void new_heap(int[] heap_arr,int k,int n)
	{
		
		LinkedHashMap<Integer,Integer> h= new LinkedHashMap<Integer,Integer>();
		int root=0;
		h.put(root, heap_arr[root]);
		for(int i=0;i<k && !h.isEmpty();i++)
		{
			Map.Entry<Integer,Integer> entry = h.entrySet().iterator().next();
			h.remove(entry.getKey());
			System.out.println("        "+entry.getValue());
			root=entry.getKey();
			int child=root*2+1;
			if(child<=n){
				if(child+1<=n)
				{
					    h.put(child+1, heap_arr[child+1]);
					    h.put(child, heap_arr[child]);
				}

				
				else
				{
				    h.put(child, heap_arr[child]);
				}
			}
			LinkedHashMap<Integer,Integer> hm = sortByComparator(h);
			h=hm;
			Scanner sc= new Scanner(System.in);
			sc.next();
	        
		}
		
		
	}
	
	public LinkedHashMap<Integer, Integer> sortByComparator(LinkedHashMap<Integer, Integer> h) 
	{
		  LinkedList<Entry<Integer, Integer>> list = new LinkedList<Entry<Integer, Integer>>(h.entrySet());
		  Collections.sort(list, new Comparator<Entry<Integer, Integer>>()
			        {
			            public int compare(Entry<Integer, Integer> o1,Entry<Integer, Integer> o2)
			            {
			                    return o2.getValue().compareTo(o1.getValue());
			            }
			        });

			        // Maintaining insertion order with the help of LinkedList
			        LinkedHashMap<Integer, Integer> sortedMap = new LinkedHashMap<Integer, Integer>();
			        for (Entry<Integer, Integer> entry : list)
			        {
			            sortedMap.put(entry.getKey(), entry.getValue());
			            System.out.println(entry.getKey()+","+entry.getValue());
			        }

			        return sortedMap;
	}

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		BuildHeap bh= new BuildHeap();
		int[] arr=bh.fifteen();
		int n=15;
		int[] heap_arr=bh.heapDown(arr, n-1);
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter the value of k:");
		KElement ke= new KElement();
		int k=sc.nextInt();
		//ke.deletek(heap_arr,k,n-1);
		//sc.next();
		ke.new_heap(heap_arr,k,n-1);
		

	}

}
