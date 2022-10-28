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

public abstract class GalagaLevel extends Level {
	
	public static final int ENEMY_ROWS = 4;
	public static final int ENEMY_COLUMNS = 20;

	private ArrayList<Drawable> drawables;
	private ArrayList<Movable> movables;
	private ArrayList<Collidable> collidables;

	
	public GalagaLevel(int width, int height, Paint background) {
		drawables = new ArrayList<Drawable>();
		movables = new ArrayList<Movable>();
		collidables = new ArrayList<Collidable>();
		
		initialSetup(width,height, drawables, movables, collidables);
		
		super.setupGame(width,height, background, drawables, getShip());
		
		getScene().setOnKeyPressed(e -> this.handleKeyInput(e.getCode()));
	}


	protected abstract Ship getShip();
	protected abstract Enemy[] getEnemies();
	

	@Override
	public int run() {
		return super.genericRun(movables, collidables, getEnemies());
	}
	
	@Override
	protected boolean checkLose() {
	//	return ship.wasHit();
		return false;
	}



	@Override
	public void remake(int score) {
		initialSetup((int) myScene.getWidth(), (int) myScene.getHeight(), drawables, movables, collidables);
		
		super.setupGame((int) getScene().getWidth(),(int) getScene().getHeight(), getScene().getFill(), drawables, getShip());
		setScore(score);
	}

	private void handleKeyInput(KeyCode code) {
		if (code.equals(KeyCode.UP)) {
		//	Beam fired = new Beam(ship.getXcoordinate(),ship.getYcoordinate());
		//	drawables.add(fired);
		//	movables.add(fired);
		//	collidables.add(fired);
			super.setupGame((int) getScene().getWidth(),(int) getScene().getHeight(), getScene().getFill(), drawables, getShip());
		}
	}
	

}
