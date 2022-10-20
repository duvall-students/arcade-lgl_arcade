package things;
import javafx.geometry.Point2D;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import ui.GameView;

/*
 * Ball Class
 * Creates a Ball object to be 
 * incorporated into gameView Class
 * (Methods and variables were used from
 *  Animation lab and have been 
 *  altered/added to for this project)
 */

public class Ball {

	public static final Paint BALL_COLOR = Color.RED;
	public static final int BALL_RADIUS = 10;
	public static final int BALL_SPEED = 60;
	private boolean firstBounce = true;
	private double xVelocity = 0;
	private double yVelocity = 2;
    private Point2D myVelocity;
    Circle ball;
	
	public Ball() {
		ball = new Circle();
	    ball.setRadius(BALL_RADIUS);
	    ball.setCenterX(GameView.SIZE/2);
	    ball.setCenterY(GameView.SIZE/2);
	    ball.setFill(BALL_COLOR);
	    myVelocity = new Point2D(xVelocity, yVelocity);
	}
	
	
	public Circle getCircle() {
		return ball;
	}
	
	
	/*
	 * Getters for X and Y Coordinates 
	 */
	public double getXCoordinate() {
		return ball.getCenterX();
	}
	public double getYCoordinate() {

		return ball.getCenterY();
	}
	
	
	/*
	 * Change the direction of the ball after a bounce
	 * is determined to be horizontal or vertical
	 */
	public void changeCourse(boolean isHorizontalBounce) {
		if(isHorizontalBounce) {
			myVelocity = new Point2D(-myVelocity.getX(), myVelocity.getY());
		} else {
			myVelocity = new Point2D(myVelocity.getX(), -myVelocity.getY());
			/*
			 *  After the first bounce of the ball,
			 *  add a positive or negative velocity to the X direction
			 */
			if(firstBounce) {
				myVelocity = new Point2D(myVelocity.getX() + positiveOrNegative(), myVelocity.getY());
				firstBounce = false;
			}
		}
	}
	
	
	// Main move method
    public void move () {
        ball.setCenterX(ball.getCenterX()+myVelocity.getX());
        ball.setCenterY(ball.getCenterY()+myVelocity.getY());
    }
    

    // changeCourse helper method
    private double positiveOrNegative() {
    	if(Math.random() > 0.5) {
    		return 2;
    	} else {
    		return -2;
    	}
    }
}