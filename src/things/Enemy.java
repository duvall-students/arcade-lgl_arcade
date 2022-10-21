package things;

import javafx.scene.shape.Rectangle;
/*
 * Enemy Class to create and move enemies
 * 
 * @author Luke Freudenthal
 * 
 */
public class Enemy extends Target implements Movable {

	public void move() {
		
	}
	
	@Override
	public void handleCollision(Collidable collidable) {
		// TODO Auto-generated method stub

	}

	@Override
	public Rectangle getHitBox() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void remove(Rectangle target) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean checkIfRemoved(Rectangle target) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getX() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getY() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Rectangle getSelf() {
		// TODO Auto-generated method stub
		return null;
	}

}
