package testing;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import javafx.scene.paint.Color;
import levels.BreakoutLevel;
import levels.BreakoutLevel1;
import levels.GalagaLevel;
import levels.GalagaLevel1;
import levels.Level;
import things.Brick;
import things.Collidable;
import things.Movable;


/**
 * This is testing the functions of the levels
 * @author Lilly Purrington
 *
 */

public class LevelTesting {
	
	@Test
	public void basicBuildTest() {
		new BreakoutLevel1(300,300,Color.AZURE);
		new GalagaLevel1(300,300,Color.AZURE);
	}
	
	@Test
	public void testBreakoutWinCondition() {
		BreakoutLevel breakoutLevel = new BreakoutLevel1(300,300,Color.AZURE);
		
		Brick[] bricks = breakoutLevel.initilizeBricks(20,4,0,0,300);
		for (Brick brick : bricks) {
			brick.remove();
		}
		assertTrue(breakoutLevel.checkWin(bricks));
	}
	
	@Test
	public void testRemakeLevel() {
		BreakoutLevel breakoutLevel = new BreakoutLevel1(300,300,Color.AZURE);
		GalagaLevel galagaLevel = new GalagaLevel1(300,300,Color.AZURE);
		
		breakoutLevel.incrimentScore();
		galagaLevel.incrimentScore();
		
		breakoutLevel.remake(breakoutLevel.getScore());
		galagaLevel.remake(galagaLevel.getScore());
		
		assertTrue(breakoutLevel.getScore() == 1);
		assertTrue(galagaLevel.getScore() == 1);
	}
	
	@Test
	public void testGenericRunContinue() {
		BreakoutLevel breakoutLevel = new BreakoutLevel1(300,300,Color.AZURE);
		
		Brick[] bricks = breakoutLevel.initilizeBricks(20,4,0,0,300);
		assertTrue(breakoutLevel.genericRun(new ArrayList<Movable>(), new ArrayList<Collidable>(), bricks) == Level.CONTINUE_CODE);
		
	}
	
	@Test
	public void testGenericRunWin() {
		BreakoutLevel breakoutLevel = new BreakoutLevel1(300,300,Color.AZURE);
		
		Brick[] bricks = breakoutLevel.initilizeBricks(20,4,0,0,300);
		for (Brick brick : bricks) {
			brick.remove();
		}
		
		assertTrue(breakoutLevel.genericRun(new ArrayList<Movable>(), new ArrayList<Collidable>(), bricks) == Level.WIN_CODE);
	}
}
