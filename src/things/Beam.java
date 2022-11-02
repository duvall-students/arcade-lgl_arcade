package things;

import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;

public class Beam extends Projectile {

	private final Paint BEAM_COLOR = Color.BLACK;

	public static final int BEAM_WIDTH = 10;
	public static final int BEAM_HEIGHT = 50;
	public static final int BEAM_SPEED = 100;
	private final Rectangle beam;
	
	
	public Beam(int x, int y) {
		beam = new Rectangle(x,y,BEAM_WIDTH,BEAM_HEIGHT);
	}
	
	@Override
	public Rectangle getHitBox() {
		return null;
	}

	@Override
	public void handleCollision(Collidable collidable) {
	}

	@Override
	public void move() {
	}


	@Override
	public double getXCoordinate() {
		return beam.getX();
	}


	@Override
	public double getYCoordinate() {
		return beam.getY();
	}


	@Override
	public Rectangle getSelf() {
		return beam;
	}
}
