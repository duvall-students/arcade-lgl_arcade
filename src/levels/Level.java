package levels;

import io.FileReader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Paint;
import javafx.scene.text.Text;
import things.Collidable;
import things.Drawable;
import things.Movable;
import ui.CollisionChecker;


/**
 * This is the superclass that provides functionality to the levels
 * @author Lilly Purrington
 *
 */
public abstract class Level {

	public static final int END_CODE = -1;
	public static final int CONTINUE_CODE = 0;
	public static final int WIN_CODE = 1;
	
	
	protected Scene myScene;
	private Group root;
    private int score;
    private FileReader fileReader = new FileReader();
    private int highScoreOffset = 40;
    private int scoreOffset = 50;
    private Text currentScore;


    
	//Returns the relevant code (either win, continue, or end)
	public abstract int run();
	
	//Re-makes the level while carrying over the score
	public abstract void remake(int score);
	
	public void genericRun(Movable[] movables, Collidable[] collidables) {
		for(Movable m : movables) {
			m.move();
		}
		
		for (int i = 0; i < collidables.length-1; i++) {
			for (int j = i+1; j < collidables.length; j++) {
				if(CollisionChecker.checkCollision(collidables[i], collidables[j])) {
					collidables[i].handleCollision(collidables[j]);
				}
			}
		}
	}
    
	
	
    protected void setupGame(int width, int height, Paint background, Drawable[] drawables){
		root = new Group();
		
		for (Drawable d : drawables) {
			root.getChildren().add(d.getSelf());
		}

		int highScore = fileReader.getAllScores().get(0);
		
		Text highScoreText = new Text(width/2,height-highScoreOffset,"High Score: " + highScore);
		currentScore = new Text(width/2,height-scoreOffset,"Current Score: " + score);
		root.getChildren().add(highScoreText);
		root.getChildren().add(currentScore);
		
		myScene = new Scene(root,width,height);
		myScene.setFill(background);
	}
	
    public Scene getScene() {
		return myScene;
	}
    
    public int getScore() {
		return score;
	}
	
    /* Can't add until enemy class is created (not my job)
	public boolean checkWin(Enemy[] myEnemies) {
		boolean allDestroyed = true;
		
		for (Enemy enemy : myEnemies) {
			if (!enemy.checkIfRemoved()) {
				allDestroyed = false;
			}
		}

		return allDestroyed;
	}
	*/
	
	protected void setScore(int score) {
		this.score = score;
	}
	
	public void updateScore() {
		currentScore.setText("Current Score: " + score);
	}

	/* Waiting on other people (though still needs some work from me anyway)
	//Sets up where all the enemies are
	public Enemy[] initilizeEnemies(int enemyRows, int enemyColumns, int enemySize, int rowSpacer, int columnSpacer) {
		Enemy[] myEnemies = new Enemy[enemyRows * enemyColumns];
		for(int row = 0; row < enemyRows; row++) {
			for (int col = 0; col < enemyColumns; col ++) {
				int y = row * enemySize;
				int x = col * enemySize;
				Enemy brick = new Enemy(x,y,enemySize,enemySize);
				myEnemies[row*enemyColumns + col] = brick;
			}
		}
		return myEnemies;
	}
	*/
	
}
