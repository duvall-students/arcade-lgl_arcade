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
 * These are the basics for a breakout level
 * @author Lilly Purrington
 */

public abstract class BreakoutLevel extends Level {
	

	public static final int BRICK_ROWS = 4;
	public static final int BRICK_COLUMNS = 20;

	
	private ArrayList<Drawable> drawables;
	private ArrayList<Movable> movables;
	private ArrayList<Collidable> collidables;

	

	
	public BreakoutLevel(int width, int height, Paint background) {
		drawables = new ArrayList<Drawable>();
		movables = new ArrayList<Movable>();
		collidables = new ArrayList<Collidable>();
		
		initialSetup(width,height, drawables, movables, collidables);
		
		super.setupGame(width,height, background, drawables, getPaddle());
	}
	
		
	
	protected abstract Paddle getPaddle();
	
	protected abstract Ball getBall();
	
	protected abstract Brick[] getBricks();



	@Override
	//This is mainly just checking collisions every frame and reacting to collisions
	public int run() {
		
		checkWallCollisions();

		return super.genericRun(movables, collidables, getBricks());
		
	}


	//Checks if the ball has hit a wall
	private void checkWallCollisions() {
		if (getBall().getYCoordinate() < 0) {
			getBall().changeCourse(true);
		}
		if (getBall().getXCoordinate() < 0 || getBall().getXCoordinate() > myScene.getWidth()) {
			getBall().changeCourse(false);
		}
	}


	@Override
	protected boolean checkLose() {
		return (getBall().getYCoordinate() > myScene.getHeight());
	}



	public void remake(int score) {
		initialSetup((int) myScene.getWidth(), (int) myScene.getHeight(), drawables, movables, collidables);
		
		super.setupGame((int) myScene.getWidth(), (int) myScene.getHeight(), myScene.getFill(), drawables, getPaddle());
		setScore(score);
	}
	

}
