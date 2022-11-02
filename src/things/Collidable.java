package things;

import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

/**
 * This is used to group all the colliding things
 * getHitBox returns a rectangle b/c those are easiest to compare
 * @author Lilly Purrington
 *
 */

public interface Collidable {
	
	public static final int REMOVAL_LOCATION = -5000;
	
	public Shape getHitBox();
	
	public void handleCollision(Collidable collidable);


}
