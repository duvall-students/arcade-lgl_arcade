package things;

import javafx.scene.shape.Rectangle;

public class Beam extends Projectile {

	@Override
	public Rectangle getHitBox() {
		return null;
	}

	@Override
	public void handleCollision(Collidable collidable) {
	}

	@Override
	public void move() {
	}

	
}
