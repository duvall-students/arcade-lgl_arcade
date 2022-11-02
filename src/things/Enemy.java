package things;

import javafx.geometry.Point2D;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import ui.GameView;
/*
 * Enemy Class to create and move enemies
 * 
 * @author Luke Freudenthal
 * 
 */
public class Enemy extends Target implements Movable, Drawable {

	Rectangle enemy;
	
	
	private double xVelocity = 1;
	private double yVelocity = 0;
	private Point2D myVelocity;
	private int ticker;
	
	public static final int REMOVAL_LOCATION = -5000;
	
	public Enemy(int positionX, int positionY, int width, int height) {
		enemy = new Rectangle(width, height, Color.BLACK);
		enemy.setX(positionX);
		enemy.setY(positionY);
		myVelocity = new Point2D(xVelocity, yVelocity);
	}
	
	//Moves enemy left and right, depending on velocity
	//Implement ticks for movement along Y axis
	@Override
	public void move() {
		ticker++;
		enemy.setX(enemy.getX()+myVelocity.getX());
		if(ticker % 300 == 0) {
			enemy.setY(enemy.getY() + 25);
		}
	}
	
	//Included to possibly handle bouncing on the walls
	//Still need to determine movement on the Y-axis
	public void changeCourse(boolean isHorizontalBounce) {
		if(isHorizontalBounce) {
			myVelocity = new Point2D(-myVelocity.getX(), myVelocity.getY());
		}
	}
	
	//Uses CollisionCheck to determine contact between two shapes
	@Override
	public void handleCollision(Collidable collidable) {
		remove();

	}

	//Checks location of the enemy to determine if removed
	@Override
	public boolean checkIfRemoved() {
		return enemy.getX() == REMOVAL_LOCATION;
	}
	
	// GETTERS
	
	@Override
	public double getX() {
		return enemy.getX();
	}

	@Override
	public double getY() {
		return enemy.getY();
	}

	@Override
	public Rectangle getSelf() {
		return enemy;
	}
	
	@Override
	public Rectangle getHitBox() {
		return new Rectangle(enemy.getX(), enemy.getY(), enemy.getWidth(), enemy.getHeight());
	}
	
	// SETTERS
	
	@Override
	public void remove() {
		enemy.setX(REMOVAL_LOCATION);
	}
}
