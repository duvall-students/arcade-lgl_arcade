package things;

import javafx.geometry.Point2D;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

// Power Up class for the Galaga Arcade Game
// @author Luke Freudenthal

public class GalagaPowerUp extends Target implements Movable {
	
	private Rectangle powerUp;
	private Point2D myVelocity;
	
	private int powerUpSize = 5;
	private int ticker;
	
	public static final int POWER_UP_REMOVAL_LOCATION = 5000;

	public GalagaPowerUp(int positionX, int positionY) {
		powerUp = new Rectangle(powerUpSize, powerUpSize);
		powerUp.setFill(Color.ALICEBLUE);
		powerUp.setX(positionX);
		powerUp.setY(positionY);
		myVelocity = new Point2D(0, 1);
		createPowerUp();
	}
	
	private void activatePowerUp() {
		
	}
	
	@Override
	public void move() {
		ticker++;
		powerUp.setX(powerUp.getX()+myVelocity.getX());
		if(ticker % 200 == 0) {
			powerUp.setY(powerUp.getY() - 25);
		}
	}

	@Override
	public void handleCollision(Collidable collidable) {
		activatePowerUp();
		remove();
	}

	@Override
	public Shape getSelf() {
		return powerUp;
	}

	@Override
	public Rectangle getHitBox() {
		return new Rectangle(powerUp.getX(), powerUp.getY());
	}

	@Override
	public void remove() {
		powerUp.setX(POWER_UP_REMOVAL_LOCATION);
	}

	@Override
	public boolean checkIfRemoved() {
		return powerUp.getX() == POWER_UP_REMOVAL_LOCATION;
	}

	@Override
	public double getX() {
		return powerUp.getX();
	}

	@Override
	public double getY() {
		return powerUp.getY();
	}
	
	public void createPowerUp() {
		if(ticker % 1000 == 0) {
			getSelf();
		}
	}

}
