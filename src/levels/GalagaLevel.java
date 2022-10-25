package levels;

import java.util.ArrayList;

import javafx.scene.paint.Paint;
import things.Collidable;
import things.Drawable;
import things.Movable;
import things.Ship;

/**
 * This is the basic Galaga Level
 * @author Lilly Purrington
 *
 */

public class GalagaLevel extends Level {

	private ArrayList<Drawable> drawables;
	private ArrayList<Movable> movables;
	private ArrayList<Collidable> collidables;
	private Ship ship;
	
	
	
	public GalagaLevel(int width, int height, Paint background) {
		drawables = new ArrayList<Drawable>();
		movables = new ArrayList<Movable>();
		collidables = new ArrayList<Collidable>();
		
		super.setupGame(width,height, background, drawables, ship);
	}

	@Override
	public int run() {
		super.genericRun(movables, collidables);

		return 0;
	}
	
	@Override
	public void remake(int score) {
		//Remake player, collidables, and movables
		
		super.setupGame((int) getScene().getWidth(),(int) getScene().getHeight(), getScene().getFill(), drawables, ship);
		setScore(score);
	}

	

}
