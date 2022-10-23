package things;
import java.util.Random;

import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;

/*
 * Brick Class
 * Creates a Brick object and
 * details to be used by gameView
 * @author Luke Freudenthal
 * 
 */

public class Brick extends Target {
	
	private Paint brickColor = setRandomColor();
	private Rectangle brick;
	public static final int REMOVAL_LOCATION = -5000;
	
	
	public Brick(int positionX, int positionY, int width, int height) {
		
		brick = new Rectangle(width, height, brickColor);
	    brick.setFill(brickColor);
	    brick.setX(positionX);
	    brick.setY(positionY);
	}

	@Override
	public void handleCollision(Collidable collidable) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean checkIfRemoved() {
		return brick.getX() == REMOVAL_LOCATION;
	}
	
	// GETTERS
	
	@Override
	public Rectangle getHitBox() {
		return brick;
	}
	
	public Paint getColor() {
		return brickColor;
	}
	
	@Override
	public double getX() {
		return brick.getX();
	}
	
	@Override
	public double getY() {
		return brick.getY();
	}
	
	@Override
	public Rectangle getSelf() {
		return brick;
	}
	
	// SETTERS
	
	private Color setRandomColor() {
		Random rand = new Random();
		return Color.color(rand.nextFloat(), rand.nextFloat(), rand.nextFloat());
	}
	
	@Override
	public void remove() {
		brick.setX(REMOVAL_LOCATION);
	}
	
	

}