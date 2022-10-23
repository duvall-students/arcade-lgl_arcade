package testing;

import javafx.scene.shape.Rectangle;
import things.Collidable;

/**
 * A class used to test the collidable interface
 * @author Lilly Purrington
 *
 */

public class TestCollider implements Collidable{

	private Rectangle rectangle;
	public TestCollider(int x, int y, int width, int height) {
		rectangle = new Rectangle(x,y,width,height);
	}
	
	public Rectangle getHitBox() {
		return new Rectangle(rectangle.getX(),rectangle.getY(),rectangle.getWidth(),rectangle.getHeight());
	}

	public void handleCollision(Collidable collidable) {
		
	}

}
