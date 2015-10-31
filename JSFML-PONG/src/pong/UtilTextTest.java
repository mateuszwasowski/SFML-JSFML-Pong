package pong;

import static org.junit.Assert.*;

import org.jsfml.graphics.Color;
import org.junit.Test;

public class UtilTextTest {

	@Test
	public void testsetString() {
		UtilText u = new UtilText("Temp Text");
		u.setString("LOL");
		assertSame("Should be same" ,"LOL", u.getObject().getString());
        
	}
	
	@Test
	public void testsetTextColor() {
		UtilText u = new UtilText("Temp Text");
		u.setText(10, 10, 15, Color.BLACK);
		assertSame("Should be same" ,Color.BLACK, u.getObject().getColor());
        
	}
	
	@Test
	public void testsetTextCharSize() {
		UtilText u = new UtilText("Temp Text");
		u.setText(10, 10, 15, Color.BLACK);
		assertSame("Should be same" ,15, u.getObject().getCharacterSize());
        
	}
	
}
