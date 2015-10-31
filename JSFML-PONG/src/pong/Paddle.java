package pong;

import org.jsfml.graphics.Color;

public class Paddle extends Rectangle {

	public Paddle(int WIDTH, int HEIGHT, Color COLOR) {
		super(WIDTH, HEIGHT, COLOR);
	}

	void goUp() {
		Object.move(0, -0.2f);
	}

	void goDown() {
		Object.move(0, 0.2f);
	}

}
