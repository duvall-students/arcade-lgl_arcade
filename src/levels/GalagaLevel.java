package levels;

import javafx.scene.paint.Paint;
import things.Collidable;
import things.Drawable;
import things.Movable;

/**
 * This is the basic Galaga Level
 * @author Lilly Purrington
 *
 */

public class GalagaLevel extends Level {

	private Drawable[] drawables;
	private Movable[] movables;
	private Collidable[] collidables;	
	
	public GalagaLevel(int width, int height, Paint background) {
		super.setupGame(width,height, background, drawables);
	}

	@Override
	public int run() {
		super.genericRun(movables, collidables);

		return 0;
	}
	
	@Override
	public void remake(int score) {
		//Remake player, collidables, and movables
		
		super.setupGame((int) getScene().getWidth(),(int) getScene().getHeight(), getScene().getFill(), drawables);
		setScore(score);
	}

	

}
