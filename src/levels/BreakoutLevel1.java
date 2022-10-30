package levels;

import java.util.ArrayList;
import javafx.scene.paint.Paint;
import things.Ball;
import things.Brick;
import things.Collidable;
import things.Paddle;
import things.Drawable;
import things.Movable;

/**
 * This is the basic Breakout level
 * Some stuff is commented out b/c relevant classes are incomplete
 * @author Lilly Purrington
 */

public class BreakoutLevel1 extends BreakoutLevel{

	
	private Paddle paddle;
	private Brick[] myBricks;
	private Ball myBall;

	//How far down the paddle will start
	private double paddleYPositionFactor = .75;
	
	public BreakoutLevel1(int width, int height, Paint background) {
		super(width, height, background);
	}
	

	@Override
	protected void initialSetup(int width, int height, ArrayList<Drawable> drawables, ArrayList<Movable> movables,
			ArrayList<Collidable> collidables) {
		paddle = new Paddle(width / 2, (int)(height * paddleYPositionFactor));
		myBricks = initilizeBricks(BRICK_ROWS, BRICK_COLUMNS, 1, 1, width);
		myBall = new Ball();
	
		
//		drawables.add(paddle);
//		drawables.add(myBall);
		movables.add(myBall);
		collidables.add(paddle);
		collidables.add(myBall);
		
		for (Brick brick : myBricks) {
			drawables.add(brick);
		}
				
	}


	@Override
	protected Paddle getPaddle() {
		return paddle;
	}


	@Override
	protected Ball getBall() {
		return myBall;
	}


	@Override
	protected Brick[] getBricks() {
		return myBricks; 
	}

}
