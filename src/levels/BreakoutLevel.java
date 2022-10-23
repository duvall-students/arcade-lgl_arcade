package levels;

import javafx.scene.paint.Paint;
import things.Collidable;
import things.Drawable;
import things.Movable;


/**
 * This is the basic breakout level without power bricks
 * @author Lilly Purrington
 *
 */
public class BreakoutLevel extends Level {
	

	public static final int BRICK_ROWS = 4;
	public static final int BRICK_COLUMNS = 20;

	
	private Drawable[] drawables;
	private Movable[] movables;
	private Collidable[] collidables;

	
	public BreakoutLevel(int width, int height, Paint background) {
		super.setupGame(width,height, background, drawables);
	}
	
	
	
	@Override
	//This is mainly just checking collisions every frame and reacting to collisions
	public int run() {
		
		super.genericRun(movables, collidables);
		
		return 0;
	}


	public void remake(int score) {
		super.setupGame((int) myScene.getWidth(), (int) myScene.getHeight(), myScene.getFill(), drawables);
		setScore(score);
	}
	

}
