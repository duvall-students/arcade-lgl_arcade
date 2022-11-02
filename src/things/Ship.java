package things;

import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

public class Ship extends Player {

	private final Paint SHIP_COLOR = Color.BLACK;

	public static final int SHIP_WIDTH = 50;
	public static final int SHIP_HEIGHT = 10;
	public static final int SHIP_SPEED = 20;
	private final Rectangle SHIP;
	
	public Ship(int x, int y) {
		SHIP = new Rectangle(x,y,SHIP_WIDTH,SHIP_HEIGHT);
	}
	
	
	public boolean wasHit() {
		return false;
	}
	
	@Override
	public Rectangle getHitBox() {
		return null;
	}

	@Override
	public void handleCollision(Collidable collidable) {
	}

	@Override
	public double getXCoordinate() {
		return 0;
	}

	@Override
	public double getYCoordinate() {
		return 0;
	}

	@Override
	public Rectangle getSelf() {
		return null;
	}
	
}
