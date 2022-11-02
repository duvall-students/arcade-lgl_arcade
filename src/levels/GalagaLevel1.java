package levels;

import java.util.ArrayList;
import javafx.scene.paint.Paint;
import things.Collidable;
import things.Drawable;
import things.Enemy;
import things.Movable;
import things.Ship;

/**
 * The basic galaga Level
 * Some code commented out b/c relevant classes are not complete
 * @author Lilly Purrington
 */

public class GalagaLevel1 extends GalagaLevel{

	private Ship ship;
	private Enemy[] myEnemies;
	
	
	private double shipYPositionFactor = .75;
	
	public GalagaLevel1(int width, int height, Paint background) {
		super(width, height, background);
	}

	@Override
	protected void initialSetup(int width, int height, ArrayList<Drawable> drawables, ArrayList<Movable> movables,
			ArrayList<Collidable> collidables) {
		ship = new Ship(width / 2, (int)(height * shipYPositionFactor));
		myEnemies = initilizeEnemies(ENEMY_ROWS, ENEMY_COLUMNS, 5, 5, width);
		
		drawables.add(ship);
		collidables.add(ship);
		
		for (Enemy enemy : myEnemies) {
			drawables.add(enemy);
			movables.add(enemy);
		}			
	}

	@Override
	protected Ship getShip() {
		return ship;
	}

	@Override
	protected Enemy[] getEnemies() {
		return myEnemies;
	}	
}
