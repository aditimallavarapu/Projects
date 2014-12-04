package intuit;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;
import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils.Collections;
/* 
 * implement a deck with shuffle and deal
 * shuffle- shuffles the deck
 * deal- draws the number of cards specofied from the deck
 */

class Cards
{
	String Shape;
	String rank;
	public String getShape() {
		return Shape;
	}
	public void setShape(String shape) {
		Shape = shape;
	}
	public String getRank() {
		return rank;
	}
	public void setRank(String rank) {
		this.rank = rank;
	}
	
}
public class Deck {
	
	ArrayList<Cards> deck;
	

	public ArrayList<Cards> getDeck() {
		return deck;
	}

	public void setDeck(ArrayList<Cards> deck) {
		this.deck = deck;
	}

	public void init()
	{
		ArrayList<Cards> new_deck=new ArrayList<Cards>();
		int j=1,k=1;
			while(j<=4)
			{
				while(k<=13)
				{
					Cards a_card=assign_shape_rank(j,k);
					new_deck.add(a_card);
					k++;
				}
				k=1;
				j++;
			}
		this.setDeck(new_deck);	
	}
	
	public ArrayList<Cards> shuffle(ArrayList<Cards> new_deck)
	{
		ArrayList<Cards> deck= new_deck;
		java.util.Collections.shuffle(deck);
		for(Cards c:deck)
		{
			print(c);
		}
		return deck;
	}
	
	public void shuffle2(ArrayList<Cards> deck)
	{
		ArrayList<Cards> new_deck= new ArrayList<Cards>();
		int present[]= new int[52];
		for(int i=0;i<52;i++)
		{
			present[i]=0;
		}
		int count=1;
		while(count<=52)
		{
			int index=(int)(Math.random()*52);
			if(present[index]==0)
				{
					present[index]=1;
					count++;
				}
			else
				{
					continue;
				}
			Cards c= deck.get(index);
			new_deck.add(c);
			print(c);
		}
		this.setDeck(new_deck);
	}
	
	public ArrayList<Cards> deal(int n,ArrayList<Cards> deck)
	{
		ArrayList<Cards> ret_cards= new ArrayList<Cards>();
		int i=0;
		while(i<n && deck.size()>=n)
			{
				Cards a_card=deck.remove(0);
				ret_cards.add(a_card);
				i++;
				print(a_card);
			}
		this.setDeck(deck);				//returning the deck modified after the cards are drawn
		return ret_cards;
		
	}
	
	public void print(Cards c)
	{
		System.out.println(c.getRank()+ " "+c.getShape());
	}
	
	public Cards assign_shape_rank(int shape,int rank)
	{
		Cards a_card= new Cards();
		//the variable shape can take value 1 to 4 representing each of the shapes
		if(shape==1)
		{
			a_card.setShape("Spade");
		}
		else if(shape==2)
		{
			a_card.setShape("clubs");
		}
		else if(shape==3)
		{
			a_card.setShape("diamond");
		}
		else if(shape==4)
		{
			a_card.setShape("hearts");
		}
		
		//the variable rank can take value 1 to 13 representing denomination 1 to 10, 11 for jack, 12 for queen, 13 for king
		if(rank>=1&& rank<=10)
		{
			a_card.setRank(Integer.toString(rank));
		}
		else if(rank==11)
		{
			a_card.setRank("Jack");
		}
		else if(rank==12)
		{
			a_card.setRank("Queen");
		}
		else if(rank==13)
		{
			a_card.setRank("King");
		}
		return a_card;
	}
	public static void main(String[] args) {
		Deck d= new Deck();
		d.init();
		d.shuffle2(d.getDeck());
		System.out.println("dfghjkl");
		if(d.getDeck().size()>=53)
		{
			d.deal(53, d.getDeck());
		}
		else
		{
			System.out.println("not enough Cards!!");
		}

	}

}
