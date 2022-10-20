package things;

import javafx.scene.shape.Rectangle;

public interface Collidable {
	
	public Rectangle getHitBox();
	
	public void handleCollision(Collidable collidable);


}
