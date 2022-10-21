package things;

import javafx.scene.shape.Rectangle;

public abstract class Target implements Collidable {

	//Returns the bounds of the respective target
	public abstract Rectangle getHitBox();
	
	//Removes the specified target
	public abstract void remove(Rectangle target);
	
	//Checks if the given target has been removed
	public abstract boolean checkIfRemoved(Rectangle target);
	
	public abstract int getX();
	
	public abstract int getY();
	
	public abstract Rectangle getSelf();

}
