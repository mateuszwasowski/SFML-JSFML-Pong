package pong;

import org.jsfml.graphics.*;
import org.jsfml.window.*;
import org.jsfml.window.Keyboard.Key;
import org.jsfml.window.event.Event;
import org.jsfml.system.*;

public class pong_main {

	static final int TOP_RECT_WIDTH = 800;
	static final int TOP_RECT_HEIGHT = 2;
	static Color TOP_RECT_COLOR = Color.WHITE;

	static final int BOTTOM_RECT_WIDTH = 800;
	static final int BOTTOM_RECT_HEIGHT = 2;
	static Color BOTTOM_RECT_COLOR = Color.WHITE;

	static final int LEFT_RECT_WIDTH = 2;
	static final int LEFT_RECT_HEIGHT = 600;
	static Color LEFT_RECT_COLOR = Color.WHITE;

	static final int RIGHT_RECT_WIDTH = 2;
	static final int RIGHT_RECT_HEIGHT = 600;
	static Color RIGHT_RECT_COLOR = Color.WHITE;

	static final int DIVIDER_WIDTH = 5;
	static final int DIVIDER_HEIGHT = 500;
	static Color DIVIDER_COLOR = new Color(255, 255, 255, 130);

	static final int PLAYER_WIDTH = 10;
	static final int PLAYER_HEIGHT = 80;

	static Color PLAYER_1_COLOR = Color.WHITE;
	static Color PLAYER_2_COLOR = Color.WHITE;

	static final float BALL_RADIUS = 5.0f;
	static Color BALL_COLOR = Color.WHITE;
	static Vector2f DEFAULT_POSITION = new Vector2f(398, 300);

	static Clock Clock = new Clock();
	static Time currentTime;

	static int p1score = 0, p2score = 0;

	public static void main(String[] args) {


		Gameslot slot1 = new Gameslot("game_slot1");
		Gameslot slot2 = new Gameslot("game_slot2");

		Ball ball = new Ball(BALL_RADIUS);
		ball.Init(DEFAULT_POSITION);

		boolean ballMoving = false;
		boolean ballStopped = true;

		int select = 1;

		int ballRandomDirection = 1;

		Paddle player2 = new Paddle(PLAYER_WIDTH, PLAYER_HEIGHT, PLAYER_2_COLOR);
		player2.setPosition(new Vector2f(780, 260));
		Paddle player1 = new Paddle(PLAYER_WIDTH, PLAYER_HEIGHT, PLAYER_1_COLOR);
		player1.setPosition(new Vector2f(10, 260));

		// ////////////SELECTION SCREEN///////////////////////

		Rectangle left1 = new Rectangle(10, 160, Color.RED);
		left1.setPosition(new Vector2f(100, 100));
		Rectangle right1 = new Rectangle(10, 160, Color.RED);
		right1.setPosition(new Vector2f(700, 100));

		Rectangle top1 = new Rectangle(600, 10, Color.RED);
		top1.setPosition(new Vector2f(100, 100));
		Rectangle bottom1 = new Rectangle(600, 10, Color.RED);
		bottom1.setPosition(new Vector2f(100, 250));

		Rectangle left2 = new Rectangle(10, 160, LEFT_RECT_COLOR);
		left2.setPosition(new Vector2f(100, 300));
		Rectangle right2 = new Rectangle(10, 160, RIGHT_RECT_COLOR);
		right2.setPosition(new Vector2f(700, 300));

		Rectangle top2 = new Rectangle(600, 10, TOP_RECT_COLOR);
		top2.setPosition(new Vector2f(100, 300));
		Rectangle bottom2 = new Rectangle(600, 10, BOTTOM_RECT_COLOR);
		bottom2.setPosition(new Vector2f(100, 450));

		UtilText select1 = new UtilText("GAME SLOT 1");
		select1.setText(170, 130, 70, Color.WHITE);
		UtilText select2 = new UtilText("GAME SLOT 2");
		select2.setText(170, 330, 70, Color.WHITE);
		UtilText pressnum = new UtilText("PRESS 1 OR 2 TO SELECT GAME SLOT");
		pressnum.setText(130, 500, 30, Color.WHITE);
		UtilText pressspace = new UtilText("PRESS SPACE TO CONFIRM");
		pressspace.setText(200, 550, 30, Color.WHITE);

		Rectangle leftRect = new Rectangle(LEFT_RECT_WIDTH, LEFT_RECT_HEIGHT,
				LEFT_RECT_COLOR);
		leftRect.setPosition(new Vector2f(0, 0));
		Rectangle rightRect = new Rectangle(RIGHT_RECT_WIDTH,
				RIGHT_RECT_HEIGHT, RIGHT_RECT_COLOR);
		rightRect.setPosition(new Vector2f(798, 0));

		Rectangle topRect = new Rectangle(TOP_RECT_WIDTH, TOP_RECT_HEIGHT,
				TOP_RECT_COLOR);
		topRect.setPosition(new Vector2f(0, 0));
		Rectangle bottomRect = new Rectangle(BOTTOM_RECT_WIDTH,
				BOTTOM_RECT_HEIGHT, BOTTOM_RECT_COLOR);
		bottomRect.setPosition(new Vector2f(0, 598));

		Rectangle podzial = new Rectangle(DIVIDER_WIDTH, DIVIDER_HEIGHT,
				DIVIDER_COLOR);
		podzial.setPosition(new Vector2f(400, 50));

		UtilText text7 = new UtilText("YOU LOST!");
		text7.setText(200, 400, 80, Color.WHITE);
		UtilText text8 = new UtilText("YOU WON!");
		text8.setText(200, 400, 80, Color.WHITE);

		UtilText text4 = new UtilText("PRESS ENTER TO INSERT COIN");
		text4.setText(170, 400, 30, Color.WHITE);
		UtilText text5 = new UtilText("ULTIMATE");
		text5.setText(200, 180, 80, Color.WHITE);
		text5.getObject().setStyle(Text.BOLD);
		UtilText text6 = new UtilText("PONG 2000");
		text6.setText(230, 280, 60, Color.WHITE);
		text6.getObject().setStyle(Text.BOLD);

		UtilText text1 = new UtilText(Integer.toString(p1score));
		text1.setText(300, 20, 50, Color.WHITE);
		UtilText text2 = new UtilText(Integer.toString(p2score));
		text2.setText(480, 20, 50, Color.WHITE);

		UtilText text3 = new UtilText("");
		text3.setText(20, 20, 50, new Color(255, 255, 255, 130));

		boolean start = false;
		slot1.open();
		slot2.open();

		RenderWindow window = new RenderWindow(new VideoMode(800, 600),
				"Ultimate Pong 2000");

		while (window.isOpen()) {

			while (start == false && window.isOpen()) {

				if (Keyboard.isKeyPressed(Key.RETURN)) {
					start = true;
					break;
				}

				for (Event event : window.pollEvents()) {
					if (event.type == Event.Type.CLOSED) {
						// The user pressed the close button
						window.close();
					}
				}

				window.clear();
				window.draw(text4.getObject());
				window.draw(text5.getObject());
				window.draw(text6.getObject());
				window.display();

			}

			if (Keyboard.isKeyPressed(Key.NUM1)) {
				left1.setColor(Color.RED);
				right1.setColor(Color.RED);
				bottom1.setColor(Color.RED);
				top1.setColor(Color.RED);
				left2.setColor(Color.WHITE);
				right2.setColor(Color.WHITE);
				bottom2.setColor(Color.WHITE);
				top2.setColor(Color.WHITE);
				select = 1;
			}
			if (Keyboard.isKeyPressed(Key.NUM2)) {

				left1.setColor(Color.WHITE);
				right1.setColor(Color.WHITE);
				bottom1.setColor(Color.WHITE);
				top1.setColor(Color.WHITE);
				left2.setColor(Color.RED);
				right2.setColor(Color.RED);
				bottom2.setColor(Color.RED);
				top2.setColor(Color.RED);
				select = 2;

			}
			if (Keyboard.isKeyPressed(Key.SPACE)) {
				/*
				 * TODO if(select == 1) slot2.close(); else{ slot1.close(); }
				 */
				break;

			}

			window.clear();
			window.draw(left1.getObject());
			window.draw(right1.getObject());
			window.draw(bottom1.getObject());
			window.draw(top1.getObject());
			window.draw(left2.getObject());
			window.draw(right2.getObject());
			window.draw(bottom2.getObject());
			window.draw(top2.getObject());
			window.draw(select1.getObject());
			window.draw(select2.getObject());
			window.draw(pressnum.getObject());
			window.draw(pressspace.getObject());
			window.display();

			for (Event event : window.pollEvents()) {
				if (event.type == Event.Type.CLOSED) {
					// The user pressed the close button
					window.close();
				}
			}

		}

		// MAIN GAME ////////////////////////////////////////////////////

		while (window.isOpen()) {
			currentTime = Clock.getElapsedTime();
			text3.setString("time : "
					+ Integer.toString((int) currentTime.asSeconds()));

			if (Keyboard.isKeyPressed(Key.UP))
				player1.goUp();
			if (Keyboard.isKeyPressed(Key.DOWN))
				player1.goDown();

			if (Keyboard.isKeyPressed(Key.SPACE))
				if (!ballMoving && ballStopped) {
					ballMoving = true;
					ballStopped = false;
				}

			if (topRect.touches(player1.getObject()))
				player1.setPosition(new Vector2f(player1.getObject()
						.getPosition().x,
						topRect.getObject().getPosition().y + 2));

			if (bottomRect.touches(player1.getObject()))
				player1.setPosition(new Vector2f(player1.getObject()
						.getPosition().x,
						bottomRect.getObject().getPosition().y - 80));

			if (topRect.touches(player2.getObject()))
				player2.setPosition(new Vector2f(player2.getPosition().x,
						topRect.getObject().getPosition().y + 2));

			if (bottomRect.touches(player2.getObject()))
				player2.setPosition(new Vector2f(player2.getPosition().x,
						bottomRect.getObject().getPosition().y - 80));

			for (Event event : window.pollEvents()) {
				if (event.type == Event.Type.CLOSED) {
					// The user pressed the close button
					window.close();
				}
			}
			// BALL KOLIZJA

			if (ball.touches(bottomRect.getObject()))
				ball.deflectY();

			if (ball.touches(topRect.getObject()))
				ball.deflectY();

			if (ball.touches(player1.getObject())) {
				
				ball.deflectX();
				ball.accelerate(player1);
			}

			if (ball.touches((player2.getObject()))) {
				ball.deflectX();
				ball.accelerate(player2);
			}

			if (ball.touches(leftRect.getObject())) {
				p2score++;
				text2.setString(Integer.toString(p2score));
				ball.Init(DEFAULT_POSITION);
				player1.setPosition(new Vector2f(10, 260));
				player2.setPosition(new Vector2f(780, 260));
				ballMoving = false;
				ballStopped = true;
				ball.resetSpeed(ballRandomDirection * (-1));
			}

			if (ball.touches(rightRect.getObject())) {
				p1score++;
				text1.setString(Integer.toString(p1score));
				ball.Init(DEFAULT_POSITION);
				player1.setPosition(new Vector2f(10, 260));
				player2.setPosition(new Vector2f(780, 260));
				ballMoving = false;
				ballStopped = true;
				ball.resetSpeed(ballRandomDirection * (-1));
			}
			if (ballMoving && !ballStopped)
				ball.move();

			// AI PLAYER2

			if (ball.getBallPosition().y < player2.getPosition().y)
				player2.goUp();

			if (ball.getBallPosition().y + 2 * ball.getBallRadius() > player2
					.getPosition().y + player2.getObject().getSize().y)
				player2.goDown();

			window.clear();
			window.draw(text1.getObject());
			window.draw(text2.getObject());
			window.draw(text3.getObject());
			window.draw(ball.getObject());
			window.draw(podzial.getObject());
			window.draw(topRect.getObject());
			window.draw(leftRect.getObject());
			window.draw(rightRect.getObject());
			window.draw(bottomRect.getObject());
			window.draw(player1.getObject());
			window.draw(player2.getObject());
			window.display();

			if (p1score == 10) {

				break;
			} else if (p2score == 10) {

				break;
			}
		}

		if (select == 1)
			slot1.save(Integer.toString((int) currentTime.asSeconds()),
					p1score, p2score);
		else
			slot2.save(Integer.toString((int)currentTime.asSeconds()),
					p1score, p2score);

		if (p1score == 10) {
			while (window.isOpen()) {

				window.clear();
				window.draw(text8.getObject());
				window.display();

				for (Event event : window.pollEvents()) {
					if (event.type == Event.Type.CLOSED) {
						// The user pressed the close button
						window.close();
					}
				}
			}

		} else if (p2score == 10) {

			while (window.isOpen()) {

				window.clear();
				window.draw(text7.getObject());
				window.display();

				for (Event event : window.pollEvents()) {
					if (event.type == Event.Type.CLOSED) {
						// The user pressed the close button
						window.close();
					}
				}
			}
		}
		
		/*  slot1.close();
    slot2.close();*/

	}
}
