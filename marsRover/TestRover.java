package marsRover;

import org.junit.runner.Result;

import junit.framework.TestCase;

public class TestRover extends TestCase {

	public void testTurn_left() {
		/*
		 * testTurn_left() is a test case to test given a direction
		 * is the rover turning in the correct direction
		 */
		MarsRover_Java m= new MarsRover_Java();
		char result=m.turn_left('N');
		assertEquals('W', result);
		result=m.turn_left('S');
		assertEquals('E', result);
		result=m.turn_left('E');
		assertEquals('N', result);
		result=m.turn_left('W');
		assertEquals('S', result);
		
	}

	public void testTurn_right() 
	{
		/*
		 * testTurn_right() is a test case to test given a direction
		 * is the rover turning in the correct direction
		 */
		MarsRover_Java m= new MarsRover_Java();
		char result=m.turn_right('N');
		assertEquals('E', result);
		result=m.turn_right('S');
		assertEquals('W', result);
		result=m.turn_right('E');
		assertEquals('S', result);
		result=m.turn_right('W');
		assertEquals('N', result);
	}

	public void testChange_cor() 
	{
		/*
		 * testChange_cor() is a test case to test given coordinates and direction 
		 * checks if the rover is moving to the correct position 
		 */
		MarsRover_Java m= new MarsRover_Java();
		Location result=m.change_cor(0, 0, 'S');
		Location l= new Location(0, 0, 'S');
		assertEquals(l.getY_cor(), result.getY_cor());
		result=m.change_cor(5, 5, 'N');
		l= new Location(5, 5, 'N');
		assertEquals(l.getY_cor(), result.getY_cor());
		result=m.change_cor(0, 5, 'E');
		l= new Location(0, 5, 'E');
		assertEquals(l.getX_cor(), result.getX_cor());
		result=m.change_cor(0, 5, 'W');
		l= new Location(0, 5, 'W');
		assertEquals(l.getX_cor(), result.getX_cor());
	}

	

}
