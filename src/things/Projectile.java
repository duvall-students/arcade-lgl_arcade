package things;

import javafx.geometry.Point2D;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import ui.GameView;

public abstract class Projectile implements Collidable, Drawable, Movable  {

	public abstract void move();
	
	public abstract Rectangle getHitBox();
	
	public abstract double getXCoordinate();
	
	public abstract double getYCoordinate();
	
	public abstract Shape getSelf();
}