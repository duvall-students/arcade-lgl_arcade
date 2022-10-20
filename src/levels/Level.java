package levels;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Paint;
import things.Brick;
import things.Collidable;
import things.Drawable;
import things.Movable;
import ui.CollisionChecker;

public abstract class Level {

	public static final int END_CODE = -1;
	public static final int CONTINUE_CODE = 0;
	public static final int WIN_CODE = 1;
	
	
	protected Scene myScene;
	private Group root;
    private int score;

    
	//Returns the relevent code (either win, continue, or end)
	public abstract int run();
	
	//remakes the level while carrying over the score
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

		myScene = new Scene(root,width,height);
		myScene.setFill(background);
	}
	
    public Scene getScene() {
		return myScene;
	}
    
    public int getScore() {
		return score;
	}
	
	public boolean checkWin(Brick[] myBricks) {
		boolean allDestroyed = true;
		
		for (Brick brick : myBricks) {
			if (brick.getXCoordinate() != Brick.REMOVAL_LOCATION) {
				allDestroyed = false;
			}
		}

		return allDestroyed;
	}
	
	protected void setScore(int score) {
		this.score = score;
	}
    
    /* refactoring
	//Sets up where all the bricks and the power bricks are
	public Brick[] initilizeBricks(int brickRows, int brickColumns, int brickSize, PowerBrick powerBrick) {
		Brick[] myBricks = new Brick[brickRows * brickColumns];
		for(int row = 0; row < brickRows; row++) {
			for (int col = 0; col < brickColumns; col ++) {
				int y = row * brickSize;
				int x = col * brickSize;
				if (x == powerBrick.getXCoordinate() && y == powerBrick.getYCoordinate()) {
					myBricks[row*brickColumns + col] = powerBrick;

				}else {
					Brick brick = new Brick(x,y,brickSize,brickSize);
					myBricks[row*brickColumns + col] = brick;
				}
			}
		}
		return myBricks;
	}
	
	
	
	//Destroys a brick
	private void powerUp(Brick[] myBricks) {
		for (int i = 0; i < bricksDestroyedByPowerBrick; i++) {
			destroyRandomBrick(myBricks);
			score++;
		}
	}
	
	private void destroyRandomBrick(Brick[] myBricks) {
		ArrayList<Brick> bricksLeft = new ArrayList<Brick>();
		for (Brick currentBrick : myBricks) {
			if (currentBrick.getXCoordinate() != Brick.REMOVAL_LOCATION) {
				bricksLeft.add(currentBrick);
			}
		}
		Random rand = new Random();
		int destroy = rand.nextInt(bricksLeft.size());
		bricksLeft.get(destroy).remove();
	}	
	
	public void collidedWithBrick(Brick collidedBrick, Brick[] myBricks) {
		score++;
		
		if (myBall.getXCoordinate() < collidedBrick.getXCoordinate() || myBall.getXCoordinate() > collidedBrick.getXCoordinate() + collidedBrick.getRectangle().getWidth()){
			myBall.changeCourse(false);
		}else{
			myBall.changeCourse(true);
		}
		
		if (collidedBrick.getClass() == PowerBrick.class) {
			powerUp(myBricks);
		}
		collidedBrick.remove();
	}
	
	public Paddle getPaddle() {
		return myPaddle;
	}
	
	public Group getRoot() {
		return root;
	}
	
	public Ball getBall() {
		return myBall;
	}
	
	public void updateScore() {
		currentScore.setText("Current Score: " + score);
	}
	
	public PowerBrick createRandomPowerBrick(int brickSize, int maxX, int maxY) {
		Random rand = new Random();
		
		//These get a random number that is within the max values but is still on the same grid as the bricks
		int x = rand.nextInt(maxX/brickSize) * brickSize;
		int y = rand.nextInt(maxY/brickSize) * brickSize;
		
		return new PowerBrick(x,y,brickSize, brickSize);
	}

	
	*/
	
}
