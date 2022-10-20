package things;

import javafx.scene.shape.Shape;

/**
 * This is used to group all the things that are on screen.
 * getSelf returns Shape because that is what is needed in javaFX
 * @author Lilly Purrington
 *
 */

public interface Drawable {

	public Shape getSelf();

}
