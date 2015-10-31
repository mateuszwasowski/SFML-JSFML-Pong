package pong;

import static org.junit.Assert.*;

import org.junit.Test;

public class BallTest {

	@Test
	public void testBallRadius() {
		Ball b = new Ball(1f);
		assertEquals(1.0f, b.getBallRadius(), 0.0);

	}

}
