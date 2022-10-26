package levels;

import java.util.ArrayList;

import javafx.scene.paint.Paint;
import things.Ball;
import things.Brick;
import things.Collidable;
import things.Drawable;
import things.Movable;
import things.Paddle;


/**
 * This is the basic breakout level without power bricks
 * Any commented out lines are there to prevent errors due to the fact the other classes aren't done
 * @author Lilly Purrington
 *
 */
public class BreakoutLevel extends Level {
	

	public static final int BRICK_ROWS = 4;
	public static final int BRICK_COLUMNS = 20;

	
	private ArrayList<Drawable> drawables;
	private ArrayList<Movable> movables;
	private ArrayList<Collidable> collidables;
	private Paddle paddle;
	private Brick[] myBricks;
	private Ball myBall;

	

	//How far down the paddle will start
	private double paddleYPositionFactor = .75;
	
	
	public BreakoutLevel(int width, int height, Paint background) {
		initialSetup(width,height);
		
		super.setupGame(width,height, background, drawables, paddle);
	}
	
	private void initialSetup(int width, int height) {
		paddle = new Paddle(width / 2, (int)(height * paddleYPositionFactor));
		myBricks = initilizeBricks(BRICK_ROWS, BRICK_COLUMNS, 0, 0);
		myBall = new Ball();
		
		drawables = new ArrayList<Drawable>();
		movables = new ArrayList<Movable>();
		collidables = new ArrayList<Collidable>();
		
//		drawables.add(paddle);
//		drawables.add(myBall);
		movables.add(myBall);
		collidables.add(paddle);
		collidables.add(myBall);
		
		for (Brick brick : myBricks) {
//			drawables.add(brick);
		}
		
	}
	
	
	@Override
	//This is mainly just checking collisions every frame and reacting to collisions
	public int run() {
		
		super.genericRun(movables, collidables);
		
		checkWallCollisions();
		
		if (checkWin(myBricks)) {
			return Level.WIN_CODE;
		}else if (checkLose()) {
			return Level.END_CODE;
		}
		
		return Level.CONTINUE_CODE;
	}


	//Checks if the ball has hit a wall
	private void checkWallCollisions() {
		if (myBall.getYCoordinate() < 0) {
			myBall.changeCourse(true);
		}
		if (myBall.getXCoordinate() < 0 || myBall.getXCoordinate() > myScene.getWidth()) {
			myBall.changeCourse(false);
		}
	}



	private boolean checkLose() {
		return (myBall.getYCoordinate() > myScene.getHeight());
	}



	public void remake(int score) {
		initialSetup((int) myScene.getWidth(), (int) myScene.getHeight());
		
		super.setupGame((int) myScene.getWidth(), (int) myScene.getHeight(), myScene.getFill(), drawables, paddle);
		setScore(score);
	}
	

}
