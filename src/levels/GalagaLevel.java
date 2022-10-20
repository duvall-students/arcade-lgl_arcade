package levels;

import javafx.scene.paint.Paint;
import things.Drawable;

public class GalagaLevel extends Level {

	private Drawable[] drawables;
	
	
	public GalagaLevel(int width, int height, Paint background) {
		super.setupGame(width,height, background, drawables);
	}

	@Override
	public int run() {
		
		return 0;
	}
	
	@Override
	public void remake(int score) {
		//Remake player, collidables, and movables
		
		super.setupGame((int) getScene().getWidth(),(int) getScene().getHeight(), getScene().getFill(), drawables);
		setScore(score);
	}

	

}
