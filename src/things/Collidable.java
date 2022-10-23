package things;

import javafx.scene.shape.Rectangle;

/**
 * This is used to group all the colliding things
 * getHitBox returns a rectangle b/c those are easiest to compare
 * @author Lilly Purrington
 *
 */

public interface Collidable {
	
	public Rectangle getHitBox();
	
	public void handleCollision(Collidable collidable);


}
