package things;

import javafx.geometry.Point2D;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import ui.GameView;

public abstract class Player implements Collidable, Drawable  {

public abstract double getXcoordinate();
	
public abstract double getYcoordinate();
	
	public abstract Rectangle getSelf();
	
	
	
}
