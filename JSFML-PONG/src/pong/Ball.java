package pong;

import org.jsfml.graphics.*;
import org.jsfml.system.*;

public class Ball {

	private CircleShape Object = new CircleShape();
	Vector2f currentSpeed = new Vector2f(0.1f, 0.1f);
	Vector2f BallSpeed = new Vector2f(0.3f, 0.3f);

	public Ball(float RADIUS) {
		Object.setRadius(RADIUS);
		Object.setFillColor(Color.WHITE);
	};

	void Init(Vector2f POSITION) {
		Object.setPosition(POSITION);
		currentSpeed = BallSpeed;
	};

	void deflectX() {
		currentSpeed = new Vector2f(-currentSpeed.x, currentSpeed.y);
	};

	void deflectY() {
		currentSpeed = new Vector2f(currentSpeed.x, -currentSpeed.y);
	};

	// move the ball
	void move() {
		Object.move(currentSpeed.x, currentSpeed.y);
	};

	void accelerate(Paddle PLAYER) {
		float a = (Object.getGlobalBounds().top
				+ (Object.getGlobalBounds().height / 2)
				- PLAYER.getObject().getGlobalBounds().top - (PLAYER
				.getObject().getGlobalBounds().height / 2)) / 100f;
		currentSpeed = new Vector2f(currentSpeed.x, a);
	};

	void stopMoving() {
		currentSpeed = new Vector2f(0.0f, 0.0f);
	};

	void resetSpeed(int sign) {
		currentSpeed = BallSpeed;
		BallSpeed = new Vector2f(BallSpeed.x, BallSpeed.y * sign);
		BallSpeed = new Vector2f(BallSpeed.x * sign, BallSpeed.y);
	};

	boolean touches(RectangleShape RECTANGLE) {
		if (Object.getGlobalBounds().intersection(RECTANGLE.getGlobalBounds()) != null)
			return true;
		return false;
	}

	Vector2f getBallPosition() {
		return Object.getPosition();
	}

	float getBallRadius() {
		return Object.getRadius();
	}

	CircleShape getObject() {
		return Object;
	}

}
