package things;

import javafx.geometry.Point2D;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

public class Beam extends Projectile {

	private final Paint BEAM_COLOR = Color.BLACK;

	public static final int BEAM_WIDTH = 10;
	public static final int BEAM_HEIGHT = 50;
	public static final int BEAM_SPEED = 100;
	private double xVelocity = 0;
	private double yVelocity = 10;
	private Point2D myVelocity;
	private final Rectangle BEAM;
	
	public static final int REMOVAL_LOCATION = -5000;
	
	public Beam(int x, int y) {
		BEAM = new Rectangle(x,y,BEAM_WIDTH,BEAM_HEIGHT);
		myVelocity = new Point2D(xVelocity, yVelocity);
	}
	
	@Override
	public Rectangle getHitBox() {
		return new Rectangle(BEAM.getX(), BEAM.getY(), BEAM.getWidth(), BEAM.getHeight());
	}

	@Override
	public void move() {
		BEAM.setX(BEAM.getX()+myVelocity.getX());
		BEAM.setY(BEAM.getY()+myVelocity.getY());
	}

	@Override
	public double getXCoordinate() {
		return BEAM.getX();
	}

	@Override
	public double getYCoordinate() {
		return BEAM.getY();
	}

	@Override
	public Rectangle getSelf() {
		return BEAM;
	}
	
	@Override
	public void handleCollision(Collidable collidable) {
		remove();
	}

	@Override
	public void remove() {
		BEAM.setX(REMOVAL_LOCATION);
	}
}
