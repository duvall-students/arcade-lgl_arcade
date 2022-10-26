package things;

import javafx.scene.shape.Rectangle;

public abstract class Target implements Collidable, Drawable {

	//Returns the bounds of the respective target
	public abstract Rectangle getHitBox();
	
	//Removes the specified target
	public abstract void remove();
	
	//Checks if the given target has been removed
	public abstract boolean checkIfRemoved();
	
	public abstract double getX();
	
	public abstract double getY();

}
