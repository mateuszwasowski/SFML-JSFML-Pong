package pong;

import static org.junit.Assert.*;

import org.jsfml.graphics.Color;

import org.junit.Test;

public class RectangleTest {

	@Test
	public void testColor() {
		Rectangle r = new Rectangle(200, 200, Color.WHITE);
        assertSame("Should be same" ,Color.WHITE, r.getObject().getFillColor());
        
	}
	
	@Test
	public void testsetColor() {
		Rectangle r = new Rectangle(200, 200, Color.WHITE);
		r.setColor(Color.RED);
		assertSame("Should be same" ,Color.RED, r.getObject().getFillColor());
        
	}

}
