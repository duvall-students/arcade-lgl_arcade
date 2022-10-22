package testing;

import static org.junit.Assert.*;

/**
 * This is testing the collision logic
 * Will add more when more classes are finished
 * @author Lilly Purrington
 */

import org.junit.Test;

import ui.CollisionChecker;

public class CollisionTesting {

	
	@Test
	public void basicCollisionTest() {
		TestCollider primary = new TestCollider(0,0,100,100);
		TestCollider secondary = new TestCollider(50,50,10,10);
		assertTrue(CollisionChecker.checkCollision(primary, secondary));
	}
}
