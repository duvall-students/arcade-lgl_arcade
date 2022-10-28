package ui;

import io.FileRecord;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;
import javafx.util.Duration;
import levels.BreakoutLevel1;
import levels.GalagaLevel1;
import levels.Level;

/**
 * This handles running the levels and choosing between them
 * All of this code is from the breakout project
 * I tried to make main it's own class but it threw errors at me
 * @author Lilly Purrington
 *
 */



public class GameView extends Application {
	
	public static final Paint BACKGROUND = Color.AZURE;
	public static final int SIZE = 400;
	public static final String TITLE = "Arcade";
	public static final int FRAMES_PER_SECOND = 60;
    public static final int MILLISECOND_DELAY = 1000 / FRAMES_PER_SECOND;
    public static final double SECOND_DELAY = 1.0 / FRAMES_PER_SECOND;
    
    private FileRecord fileRecord = new FileRecord();
    private Level[] levels = {new GalagaLevel1(SIZE,SIZE,BACKGROUND), new BreakoutLevel1(SIZE,SIZE,BACKGROUND)};
    private int currentLevel = 0;
    private int score;
    
    public static void main(String[] args) {
    	launch(args);
    }
    
	@Override
	public void start(Stage stage){
		
		stage.setScene(levels[currentLevel].getScene());
        stage.setTitle(TITLE);
        stage.show();
        
        KeyFrame frame = new KeyFrame(Duration.millis(MILLISECOND_DELAY), e -> step(SECOND_DELAY, stage));
        Timeline animation = new Timeline();
        animation.setCycleCount(Timeline.INDEFINITE);
        animation.getKeyFrames().add(frame);
        animation.play();
		
	}
	
	public void step(double elapsedTime, Stage stage) {
		//Sometimes levels will change scenes on their own
		stage.setScene(levels[currentLevel].getScene());

		int outputCode = levels[currentLevel].run();
		
		if (outputCode == Level.END_CODE) {
			fileRecord.addScore(levels[currentLevel].getScore());
			Platform.exit();
		}else if (outputCode == Level.WIN_CODE) {
			score = levels[currentLevel].getScore();
			nextLevel(stage);
		}
	}
	
	private void nextLevel(Stage stage) {
		currentLevel = (currentLevel + 1) % levels.length;
		levels[currentLevel].remake(score);
		stage.setScene(levels[currentLevel].getScene());
        stage.show();
	}
	
}
