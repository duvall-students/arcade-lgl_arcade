package testing;

import javafx.scene.shape.Rectangle;
import things.Collidable;

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
