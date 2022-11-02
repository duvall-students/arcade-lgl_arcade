package things;

import javafx.geometry.Point2D;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import ui.GameView;

/*
 * Ball Class
 * Creates a Ball object to be 
 * incorporated into gameView Class
 * (Methods and variables were used from
 *  Animation lab and have been 
 *  altered/added to for this project)
 */

public class Ball extends Projectile {

	public static final Paint BALL_COLOR = Color.RED;
	public static final int BALL_RADIUS = 10;
	public static final int BALL_SPEED = 60;
	private boolean firstBounce = true;
	private double xVelocity = 0;
	private double yVelocity = 2;
	private Point2D myVelocity;
	Circle BALL;
	
	public static final int REMOVAL_LOCATION = -5000;

	public Ball() {
		BALL = new Circle();
		BALL.setRadius(BALL_RADIUS);
		BALL.setCenterX(GameView.SIZE/2);
		BALL.setCenterY(GameView.SIZE/2);
		BALL.setFill(BALL_COLOR);
		myVelocity = new Point2D(xVelocity, yVelocity);
	}

	public Circle getCircle() {
		return BALL;
	}

	// Change the direction of the ball after a bounce is determined to be horizontal or vertical
	public void changeCourse(boolean isHorizontalBounce) {
		if(isHorizontalBounce) {
			myVelocity = new Point2D(-myVelocity.getX(), myVelocity.getY());
		} 
		else {
			myVelocity = new Point2D(myVelocity.getX(), -myVelocity.getY());

			// After the first bounce of the ball, add a positive or negative velocity to the X direction
			if(firstBounce) {
				myVelocity = new Point2D(myVelocity.getX() + positiveOrNegative(), myVelocity.getY());
				firstBounce = false;
			}
		}
	}

	// changeCourse helper method
	private double positiveOrNegative() {
		if(Math.random() > 0.5) {
			return 2;
		} 
		else {
			return -2;
		}
	}
	
	// Getters for X and Y Coordinates 
	@Override
	public double getXCoordinate() {
		return BALL.getCenterX();
	}

	@Override
	public double getYCoordinate() {
		return BALL.getCenterY();
	}
	
	// Main move method
	@Override
	public void move() {
		BALL.setCenterX(BALL.getCenterX()+myVelocity.getX());
		BALL.setCenterY(BALL.getCenterY()+myVelocity.getY());
	}

	@Override
	public Circle getHitBox() {
		return new Circle(BALL_RADIUS);
	}

	@Override
	public Circle getSelf() {
		return BALL;
	}

	@Override
	public void handleCollision(Collidable collidable) {
		remove();
	}
	
	@Override
	public void remove() {
		BALL.setCenterX(REMOVAL_LOCATION);
	}

}