package ui;

import things.Collidable;

/**
 * Checks for and handles collisions
 * @author lillypurrington
 *
 */

public class CollisionHandler {
	
	public static boolean checkCollision(Collidable primary, Collidable secondary) {
		return primary.getHitBox().intersects(secondary.getHitBox().getBoundsInLocal());
	}
}
