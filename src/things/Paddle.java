package things;

import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;

public class Paddle {

	private final Paint PADDLE_COLOR = Color.BLACK;

	public static final int PADDLE_WIDTH = 50;
	public static final int PADDLE_HEIGHT = 10;
	public static final int PADDLE_SPEED = 20;
	private final Rectangle PADDLE;
	
	
	public Paddle(int x, int y) {
		PADDLE = new Rectangle(x,y,PADDLE_WIDTH,PADDLE_HEIGHT);
	}
	
	public Paint getColor() {
		return PADDLE_COLOR;
	}
	
	public Rectangle getRectangle() {
		return PADDLE;
	}
	
	protected double getXCoordinate() {
		return PADDLE.getX();
	}
	
	protected double getYCoordinate() {
		return PADDLE.getY();
	}
	
	public void handleKeyInput (KeyCode code) {

		if (code == KeyCode.LEFT) {
			PADDLE.setX(PADDLE.getX() - PADDLE_SPEED);
		}
		else if (code == KeyCode.RIGHT) {
			PADDLE.setX(PADDLE.getX() + PADDLE_SPEED);
		}
	}

}

