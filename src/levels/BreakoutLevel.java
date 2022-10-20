package levels;

import javafx.scene.paint.Paint;
import things.Brick;
import things.Drawable;
import ui.GameView;

public class BreakoutLevel extends Level {
	

	public static final int BRICK_ROWS = 4;
	public static final int BRICK_COLUMNS = 20;
	public static final int BRICK_SIZE = GameView.SIZE / BRICK_COLUMNS;

	
	private Brick[] myBricks;
	private Drawable[] drawables;

	
	public BreakoutLevel(int width, int height, Paint background) {		
		super.setupGame(width,height, background, drawables);
	}
	
	
	
	//This is mainly just checking collisions every frame and reacting to collisions
	public int run() {
		//getBall().move();
		
		//there is probably a better way than a big if else chain but I can't think of it right now
		
		/* Rewriting
		Brick collidedBrick = CollisionChecker.checkBrickCollision(myBricks, getBall());
		if (collidedBrick != null) {
			collidedWithBrick(collidedBrick, myBricks);
		}else if (CollisionChecker.checkPaddleCollision(getPaddle(), getBall()) || Collision.checkTopWallCollision(getBall())) {
			getBall().changeCourse(false);
		}else if(CollisionChecker.checkHorizontalWallCollision(getBall())) {
			getBall().changeCourse(true);
		}else if (CollisionChecker.checkBottomWallCollision(getBall())) {
			return Level.END_CODE;
		}
		*/
		
		//updateScore();
		
		if (checkWin(myBricks)) {
			return Level.WIN_CODE;
		}
		
		
		return Level.CONTINUE_CODE;
	}


	public void remake(int score) {
		super.setupGame((int) myScene.getWidth(), (int) myScene.getHeight(), myScene.getFill(), drawables);
		setScore(score);
	}
	

}
