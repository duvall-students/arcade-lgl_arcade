package things;
import java.util.Random;

import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;

/*
 * Brick Class
 * Creates a Brick object and
 * details to be used by gameView
 */

public class Brick {
	
	private Paint brickColor = setRandomColor();
	private Rectangle brick;
	public static final int REMOVAL_LOCATION = -5000;
	
	
	public Brick(int positionX, int positionY, int width, int height) {
		
		brick = new Rectangle(width, height, brickColor);
	    brick.setFill(brickColor);
	    brick.setX(positionX);
	    brick.setY(positionY);
	}
	
	public Rectangle getRectangle() {
		return brick;
	}
	public Paint getColor() {
		return brickColor;
	}
	public double getXCoordinate() {
		return brick.getX();
	}
	public double getYCoordinate() {
		return brick.getY();
	}
	private Color setRandomColor() {
		Random rand = new Random();
		return Color.color(rand.nextFloat(), rand.nextFloat(), rand.nextFloat());
	}
	
	public void remove() {
		brick.setX(REMOVAL_LOCATION);
	}

}