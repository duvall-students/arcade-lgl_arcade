package ui;

import things.Collidable;

/**
 * Checks for collisions
 * @author Lilly Purrington
 *
 */

public class CollisionChecker {
	
	public static boolean checkCollision(Collidable primary, Collidable secondary) {
		return primary.getHitBox().intersects(secondary.getHitBox().getBoundsInLocal());
	}

}
