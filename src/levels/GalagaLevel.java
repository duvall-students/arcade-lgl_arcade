package levels;

import java.util.ArrayList;

import javafx.scene.input.KeyCode;
import javafx.scene.paint.Paint;
import things.Beam;
import things.Collidable;
import things.Drawable;
import things.Enemy;
import things.Movable;
import things.Ship;

/**
 * This is the basic Galaga Level
 * @author Lilly Purrington
 *
 */

public class GalagaLevel extends Level {
	
	public static final int ENEMY_ROWS = 4;
	public static final int ENEMY_COLUMNS = 20;

	private ArrayList<Drawable> drawables;
	private ArrayList<Movable> movables;
	private ArrayList<Collidable> collidables;
	private Ship ship;
	private Enemy[] myEnemies;
	
	
	private double shipYPositionFactor = .75;

	
	
	public GalagaLevel(int width, int height, Paint background) {
		initialSetup(width,height);
		
		super.setupGame(width,height, background, drawables, ship);
		
		getScene().setOnKeyPressed(e -> this.handleKeyInput(e.getCode()));
	}
	
	private void initialSetup(int width, int height) {
	//	ship = new Ship(width / 2, (int)(height * shipYPositionFactor));
		myEnemies = initilizeEnemies(ENEMY_ROWS, ENEMY_COLUMNS, 5, 5, width);
		
		drawables = new ArrayList<Drawable>();
		movables = new ArrayList<Movable>();
		collidables = new ArrayList<Collidable>();
		
//		drawables.add(ship);
		collidables.add(ship);
		
		for (Enemy enemy : myEnemies) {
			drawables.add(enemy);
			movables.add(enemy);
		}	
	}
		

	

	@Override
	public int run() {
		return super.genericRun(movables, collidables, myEnemies);
	}
	
	@Override
	protected boolean checkLose() {
	//	return ship.wasHit();
		return false;
	}



	@Override
	public void remake(int score) {
		initialSetup((int) myScene.getWidth(), (int) myScene.getHeight());
		
		super.setupGame((int) getScene().getWidth(),(int) getScene().getHeight(), getScene().getFill(), drawables, ship);
		setScore(score);
	}

	private void handleKeyInput(KeyCode code) {
		if (code.equals(KeyCode.UP)) {
		//	Beam fired = new Beam(ship.getXcoordinate(),ship.getYcoordinate());
		//	drawables.add(fired);
		//	movables.add(fired);
		//	collidables.add(fired);
			super.setupGame((int) getScene().getWidth(),(int) getScene().getHeight(), getScene().getFill(), drawables, ship);
		}
	}
	

}
