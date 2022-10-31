package things;

import javafx.geometry.Point2D;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import ui.GameView;

public abstract class Projectile implements Collidable, Movable, Drawable  {

	public abstract void move();
	
	public abstract Rectangle getHitBox();
	
	public abstract double getXCoordinate();
	
	public abstract double getYCoordinate();
	
	public abstract Rectangle getSelf();
	
}
