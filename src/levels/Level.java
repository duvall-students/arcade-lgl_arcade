package levels;

import java.util.ArrayList;

import io.FileReader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Paint;
import javafx.scene.text.Text;
import things.Brick;
import things.Collidable;
import things.Drawable;
import things.Enemy;
import things.Movable;
import things.Player;
import things.Target;
import ui.CollisionChecker;


/**
 * This is the superclass that provides functionality to the levels
 * Any commented out lines are there to prevent errors due to the fact the other classes aren't done
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
	
    protected abstract boolean checkLose();
    
	protected abstract void initialSetup(int width, int height, ArrayList<Drawable> drawables,ArrayList<Movable> movables, ArrayList<Collidable> collidables);


	
	public int genericRun(ArrayList<Movable> movables, ArrayList<Collidable> collidables, Target[] targets) {
		for(Movable m : movables) {
			m.move();
		}
		
		for (int i = 0; i < collidables.size()-1; i++) {
			for (int j = i+1; j < collidables.size(); j++) {
				if(CollisionChecker.checkCollision(collidables.get(i), collidables.get(j))) {
					collidables.get(i).handleCollision(collidables.get(j));
					collidables.get(j).handleCollision(collidables.get(i));
				}
			}
		}
		
		updateScore();
		
		if (checkWin(targets)) {
			return Level.WIN_CODE;
		}else if (checkLose()) {
			return Level.END_CODE;
		}
		
		return Level.CONTINUE_CODE;
	}
    
	
	

	protected void setupGame(int width, int height, Paint background, ArrayList<Drawable> drawables, Player player){
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

	//	myScene.setOnKeyPressed(e -> player.handleKeyInput(e.getCode()));
	}
	
    public Scene getScene() {
		return myScene;
	}
    
    public int getScore() {
		return score;
	}
	

	public boolean checkWin(Target[] myTargets) {
		boolean allDestroyed = true;
		
		for (Target target : myTargets) {
			if (!target.checkIfRemoved()) {
				allDestroyed = false;
			}
		}

		return allDestroyed;
	}

	
	protected void setScore(int score) {
		this.score = score;
	}
	
	public void updateScore() {
		currentScore.setText("Current Score: " + score);
	}
	
	
	//I know it is bad security but I need the brick class to be able to access it when bricks are destroyed
	public void incrimentScore() {
		score++;
	}

	//Sets up where all the bricks are
	//The spacer variable is how far apart the bricks should be
	//I need to figure out how to combine this with initilizeEnemies
	public Brick[] initilizeBricks(int brickRows, int brickColumns, int columnSpacer, int rowSpacer, int screenWidth) {
		int brickSize = (int) ((screenWidth/brickColumns) - columnSpacer);
		Brick[] myBricks = new Brick[brickRows * brickColumns];
		for(int row = 0; row < brickRows; row++) {
			for (int col = 0; col < brickColumns; col ++) {
				int x = col * brickSize + col * columnSpacer;
				int y = row * brickSize + row * rowSpacer;
				Brick brick = new Brick(x,y,brickSize,brickSize);
				myBricks[row*brickColumns + col] = brick;				
			}
		}
		return myBricks;
	}
	
	//Sets up where all the enemies are
	//The spacer variable is how far apart the bricks should be
	//I need to figure out how to combine this with initilizeEnemies
	public Enemy[] initilizeEnemies(int enemyRows, int enemyColumns, int columnSpacer, int rowSpacer, int screenWidth) {
		int enemySize = (int) ((screenWidth/enemyColumns) - columnSpacer);
		Enemy[] myEnemies = new Enemy[enemyRows * enemyColumns];
		for(int row = 0; row < enemyRows; row++) {
			for (int col = 0; col < enemyColumns; col ++) {
				int x = col * enemySize + col * columnSpacer;
				int y = row * enemySize + row * rowSpacer;
				Enemy enemy = new Enemy(x,y,enemySize,enemySize);
				myEnemies[row*enemyColumns + col] = enemy;				
			}
		}
		return myEnemies;
	}
	
	
}
