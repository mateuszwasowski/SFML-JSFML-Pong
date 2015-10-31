package pong;

import org.jsfml.graphics.*;
import org.jsfml.system.*;

public class Rectangle {

	protected RectangleShape Object = new RectangleShape();

	public// Konstruktor
	Rectangle(int WIDTH, int HEIGHT, Color COLOR) {
		Object.setSize(new Vector2f(WIDTH, HEIGHT));
		Object.setFillColor(COLOR);

	};

	// set position
	void setPosition(Vector2f POSITION) {
		Object.setPosition(POSITION);
	};

	void setColor(Color color) {
		Object.setFillColor(color);
	};

	// sprawdza czy dwa obiekty sie dotykaja
	boolean touches(RectangleShape RECTANGLE) {
		if (Object.getGlobalBounds().intersection(RECTANGLE.getGlobalBounds()) != null)
			return true;
		return false;
	};

	Vector2f getPosition() {
		return Object.getPosition();
	};

	Vector2f getSize() {
		return Object.getSize();
	};

	RectangleShape getObject() {
		return Object;
	};

}
