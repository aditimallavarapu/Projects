/*
 * Problem Three: Mars Rovers
 
A squad of robotic rovers are to be landed by NASA on a plateau on Mars.
This plateau, which is curiously rectangular, must be navigated by the rovers so
that their on-board cameras can get a complete view of the surrounding terrain to send back to Earth.
 
A rover's position and location is represented by a combination of x and y co-ordinates
 and a letter representing one of the four cardinal compass points. 
 The plateau is divided up into a grid to simplify navigation. 
 An example position might be 0, 0, N, which means the rover is in the bottom left corner and facing North.
 
In order to control a rover, NASA sends a simple string of letters.
The possible letters are 'L', 'R' and 'M'. 'L' and 'R' makes the rover spin 90 degrees left or right respectively,
without moving from its current spot. 'M' means move forward one grid point, and maintain the same heading.
 
Assume that the square directly North from (x, y) is (x, y+1).
 
INPUT:
The first line of input is the upper-right coordinates of the plateau, the lower-left coordinates are assumed to be 0,0.
 
The rest of the input is information pertaining to the rovers that have been deployed. Each rover has two lines of input. 
The first line gives the rover's position, and the second line is a series of instructions telling the rover how to 
explore the plateau.
 
The position is made up of two integers and a letter separated by spaces, corresponding 
to the x and y co-ordinates and the rover's orientation.
 
Each rover will be finished sequentially, which means that the second rover won't start to 
move until the first one has finished moving.
 
OUTPUT
The output for each rover should be its final co-ordinates and heading.
 
INPUT AND OUTPUT
 
Test Input:
5 5
1 2 N
LMLMLMLMM
3 3 E
MMRMMRMRRM
 
Expected Output:
1 3 N
5 1 E
==========

 */


package marsRover;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
/*
 * Class location defines the triplet that tells the position (x,y coordinate) and the direction of the rover. 
 */
class Location
{
	int x_cor;					//x coordinate
	int y_cor;					//y coordinate
	char dir;					//direction
	
	public Location(int x,int y,char d)
	{
		/*
		 * constructor for location 
		 */
		this.x_cor=x;
		this.y_cor=y;
		this.dir=d;
	}
	
	/* getter and setter
	 * 
	 */
	public void setX_cor(int x_cor) {
		this.x_cor = x_cor;
	}
	public void setYcor(int y_cor) {
		this.y_cor = y_cor;
	}
	public void setDir(char dir) {
		this.dir = dir;
	}
	public int getY_cor() {
		return y_cor;
	}
	public void setY_cor(int y_cor) {
		this.y_cor = y_cor;
	}
	public int getX_cor() {
		return x_cor;
	}
	public char getDir() {
		return dir;
	}
	
}


public class MarsRover_Java {
	/*
	 * limit_x and limit_y are the upper right coordinates of the plateau
	 * 
	 * the method turn_left(char dir) and turn_right(char dir)
	 * takes care of the direction the rover has to point to based upon the previous direction
	 * method and change_cor(int x,int y,char dir) gives the new position for the rover based on the new position 
	 */
	int limit_x;
	int limit_y;
	
	public int getLimit_x() {
		return limit_x;
	}

	public void setLimit_x(int limit_x) {
		this.limit_x = limit_x;
	}

	public int getLimit_y() {
		return limit_y;
	}

	public void setLimit_y(int limit_y) {
		this.limit_y = limit_y;
	}

	public char turn_left(char d)
	{
		/*
		 *  turn_left(char d) if the movements array-element is 'L'
		 */
		if(d=='N')
		{
			d='W';
		}
		else if(d=='S')
		{
			d='E';
		}
		else if(d=='E')
		{
			d='N';
		}
		else if(d=='W')
		{
			d='S';
		}
		char new_dir=d;
		return new_dir;
	}
	
	public char turn_right(char d)
	{
		/*
		 *  turn_right(char d) if the movements array-element is 'R'
		 */
		if(d=='N')
		{
			d='E';
		}
		else if(d=='S')
		{
			d='W';
		}
		else if(d=='E')
		{
			d='S';
		}
		else if(d=='W')
		{
			d='N';
		}
		char new_dir=d;
		return new_dir;
	}
	
	public Location change_cor(int x, int y,char dir)
	{
		/*
		 * change_cor(int x,int y,char dir) if the movement array element is 'M'
		 */
		if(dir=='N' && y+1<=this.getLimit_y())
		{
			y=y+1;
		}
		else if(dir=='S' && y-1 >= 0)
		{
			y=y-1;
		}
		else if(dir=='E' && x+1 <=this.getLimit_x())
		{
			x=x+1;
		}
		else if(dir=='W' && x-1 >= 0)
		{
			x=x-1;
		}
		Location l= new Location(x, y, dir);
		return l;
	}
	
	public void track_rover(Location start,char[] movements)
	{
		/*
		 * the method track_rover() reads the start position of the rover 
		 * and the movements array takes the movements that the rover has to make
		 * it passes the start position and the movements array to the functions turn_left,turn_right, and change_cor
		 * depending upon the input movements
		 */
		for(int i=0;i<movements.length;i++)
		{
			if(movements[i]=='L')
			{
				char d=turn_left(start.getDir());
				start.setDir(d);
			}
			else if(movements[i]=='R')
			{
				char d=turn_right(start.getDir());
				start.setDir(d);
			}
			else if(movements[i]=='M')
			{
				Location l=change_cor(start.getX_cor(),start.getY_cor(),start.getDir());
				start=l;
			}
			System.out.println(movements[i]+" "+start.getX_cor()+ " "+start.getY_cor()+" "+start.getDir());
		}
		System.out.println("Final Position:"+start.getX_cor()+" "+start.getY_cor()+" "+start.getDir());
		return;
	}
	
	public void readFile()
	{
		/*the method readfile() reads the input file rover.txt and 
		 * sets the upper limit for the rover's traversals
		 */
		try {
			BufferedReader bf= new BufferedReader(new FileReader(".\\rover.txt"));
			String line= new String();
			if((line=bf.readLine())!=null)
			{
				int limits_x= Integer.parseInt(line.split(" ")[0]);
				this.setLimit_x(limits_x);
				int limits_y= Integer.parseInt(line.split(" ")[1]);
				this.setLimit_y(limits_y);
				while((line=bf.readLine())!=null)
				{
					System.out.println(line);
					String[] temp= line.split(" ");
					int x=Integer.parseInt(temp[0]);
					int y=Integer.parseInt(temp[1]);
					char dir=temp[2].charAt(0);
					Location l= new Location(x, y, dir);
					line=bf.readLine();
					char[] movements=line.toCharArray();
					track_rover(l,movements);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	public static void main(String[] args) 
	{
		MarsRover_Java rover= new MarsRover_Java();
		rover.readFile();
	}

}
