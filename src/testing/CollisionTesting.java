package testing;

import static org.junit.Assert.*;
import org.junit.Test;
import javafx.scene.paint.Color;
import levels.BreakoutLevel1;
import things.Brick;
import ui.CollisionChecker;

/**
 * This is testing the collision logic
 * Will add more when more classes are finished
 * @author Lilly Purrington
 */

public class CollisionTesting {

	
	@Test
	public void basicCollisionTest() {
		TestCollider primary = new TestCollider(0,0,100,100);
		TestCollider secondary = new TestCollider(50,50,10,10);
		assertTrue(CollisionChecker.checkCollision(primary, secondary));
	}
	
	@Test 
	public void targetInitilizationTest() {
		Brick[] bricks = new BreakoutLevel1(300, 300, Color.AZURE).initilizeBricks(20, 4, 1, 1,300);
		
		for (int i = 0; i < bricks.length-1; i++) {
			for (int j = i+1; j < bricks.length; j++) {
				assertFalse(CollisionChecker.checkCollision(bricks[i], bricks[j]));
			}
		}
	}
}
