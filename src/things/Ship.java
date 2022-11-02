package things;

import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

public class Ship extends Player {

	@Override
	public Rectangle getHitBox() {
		return null;
	}

	@Override
	public void handleCollision(Collidable collidable) {
		
	}

	@Override
	public double getXCoordinate() {
		return 0;
	}

	@Override
	public double getYCoordinate() {
		return 0;
	}

	@Override
	public Shape getSelf() {
		return null;
	}
	
}
