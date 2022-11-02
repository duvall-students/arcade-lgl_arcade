package things;

import javafx.geometry.Point2D;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import ui.GameView;

public abstract class Player implements Collidable, Drawable  {

	public abstract double getXCoordinate();

	public abstract double getYCoordinate();

	public abstract Shape getSelf();

	public abstract void remove();

	public abstract void handleKeyInput(KeyCode code);
}
