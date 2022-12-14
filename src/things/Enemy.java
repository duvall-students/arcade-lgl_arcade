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
		// Moves enemy down every 300 ticks
		if(ticker % 300 == 0) {
			enemy.setY(enemy.getY() + 25);
		}
		// Contains enemy within screen bounds
		if(enemy.getX() > GameView.SIZE || enemy.getX() < 0) {
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
