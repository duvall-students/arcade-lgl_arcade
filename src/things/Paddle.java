package things;

import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

public class Paddle extends Player {

	private final Paint PADDLE_COLOR = Color.BLACK;

	public static final int PADDLE_WIDTH = 50;
	public static final int PADDLE_HEIGHT = 10;
	public static final int PADDLE_SPEED = 20;
	private final Rectangle PADDLE;
	
	public static final int REMOVAL_LOCATION = -5000;
	
	public Paddle(int x, int y) {
		PADDLE = new Rectangle(x,y,PADDLE_WIDTH,PADDLE_HEIGHT);
	}
	
	public Paint getColor() {
		return PADDLE_COLOR;
	}
	
	public Rectangle getRectangle() {
		return PADDLE;
	}
	
	public void handleKeyInput (KeyCode code) {
		if (code == KeyCode.LEFT) {
			PADDLE.setX(PADDLE.getX() - PADDLE_SPEED);
		}
		else if (code == KeyCode.RIGHT) {
			PADDLE.setX(PADDLE.getX() + PADDLE_SPEED);
		}
	}
	
	@Override
	public double getXCoordinate() {
		return PADDLE.getX();
	}
	
	@Override
	public double getYCoordinate() {
		return PADDLE.getY();
	}

	@Override
	public Rectangle getHitBox() {
		return new Rectangle(PADDLE.getX(), PADDLE.getY(), PADDLE.getWidth(), PADDLE.getHeight());
	}

	@Override
	public void handleCollision(Collidable collidable) {
		remove();
	}

	@Override
	public Rectangle getSelf() {
		return PADDLE;
	}
	
	@Override
	public void remove() {
		PADDLE.setX(REMOVAL_LOCATION);
	}
}

