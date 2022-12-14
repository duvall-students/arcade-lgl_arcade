package things;

import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

public class Ship extends Player {

	private final Paint SHIP_COLOR = Color.BLACK;

	public static final int SHIP_WIDTH = 20;
	public static final int SHIP_HEIGHT = 30;
	public static final int SHIP_SPEED = 20;
	private final Rectangle SHIP;
	
	public static final int REMOVAL_LOCATION = -5000;
	
	public Ship(int x, int y) {
		SHIP = new Rectangle(x,y,SHIP_WIDTH,SHIP_HEIGHT);
	}
	
	public boolean wasHit() {
		return false;
	}
	
	@Override
	public void handleKeyInput (KeyCode code) {
		if (code == KeyCode.LEFT) {
			SHIP.setX(SHIP.getX() - SHIP_SPEED);
		}
		else if (code == KeyCode.RIGHT) {
			SHIP.setX(SHIP.getX() + SHIP_SPEED);
		}
	}
	
	@Override
	public Rectangle getHitBox() {
		return new Rectangle(SHIP.getX(), SHIP.getY(), SHIP.getWidth(), SHIP.getHeight());
	}

	@Override
	public double getXCoordinate() {
		return SHIP.getX();
	}

	@Override
	public double getYCoordinate() {
		return SHIP.getY();
	}

	@Override
	public Rectangle getSelf() {
		return SHIP;
	}
	
	@Override
	public void handleCollision(Collidable collidable) {
		remove();
	}
	
	@Override
	public void remove() {
		SHIP.setX(REMOVAL_LOCATION);
	}
	
}
