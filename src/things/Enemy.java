package things;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
/*
 * Enemy Class to create and move enemies
 * 
 * @author Luke Freudenthal
 * 
 */
public class Enemy extends Target implements Movable {

	private Rectangle enemy;
	public static final int REMOVAL_LOCATION = -5000;
	
	public Enemy(int positionX, int positionY, int width, int height) {
		enemy = new Rectangle(width, height, Color.BLACK);
		enemy.setX(positionX);
		enemy.setY(positionY);
	}
	
	public void move() {
		
	}
	
	@Override
	public void handleCollision(Collidable collidable) {
		// TODO Auto-generated method stub

	}

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
		return enemy;
	}
	
	// SETTERS
	
	@Override
	public void remove() {
		enemy.setX(REMOVAL_LOCATION);
	}
	

}
