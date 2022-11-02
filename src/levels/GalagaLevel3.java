package levels;

import java.util.ArrayList;

import javafx.scene.paint.Paint;
import things.Collidable;
import things.Drawable;
import things.Enemy;
import things.GalagaPowerUp;
import things.Movable;
import things.Ship;

/*
 * Third level of Galaga
 * Arcade Game
 * @author Luke Freudenthal
 * 
 */

public class GalagaLevel3 extends GalagaLevel {

	private Ship ship;
	private Enemy[] myEnemies;
	private GalagaPowerUp powerUp;
	
	
	private double shipYPositionFactor = .75;
	
	public GalagaLevel3(int width, int height, Paint background) {
		super(width, height, background);
	}

	@Override
	protected Ship getShip() {
		//return ship (ship class is not made)
		return null;
	}

	@Override
	protected Enemy[] getEnemies() {
		return myEnemies;
	}

	@Override
	protected void initialSetup(int width, int height, ArrayList<Drawable> drawables, ArrayList<Movable> movables,
		ArrayList<Collidable> collidables) {
		//	ship = new Ship(width / 2, (int)(height * shipYPositionFactor));
		myEnemies = initilizeEnemies(ENEMY_ROWS, ENEMY_COLUMNS, 5, 5, width);
	
		//	drawables.add(ship);
		collidables.add(ship);
		
		powerUp = new GalagaPowerUp(width / 2, height / 2);
		
		drawables.add(powerUp);
		collidables.add(powerUp);
		
		for (Enemy enemy : myEnemies) {
			drawables.add(enemy);
			movables.add(enemy);
		}
	}
	
	// Power up method TBD



}
